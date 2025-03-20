package main.java.com.lmsAdmin.managers.layer2.manage_entity_manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.DatabaseConnection;
import org.json.JSONArray;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ManageCourseManager extends ManageEntityManager{
    JSONArray courses;

    public ManageCourseManager() {
        super();
    }

    public void manageAddCourse(
            String id,
            String name,
            String credit,
            String level,
            String description,
            String status
    ){
        String addCourseQuery = "INSERT INTO course (id, name, credit, level, description, status) VALUES (?, ?, ?, ?, ?, ?)";
        try(PreparedStatement statement = conn.prepareStatement(addCourseQuery)){
            statement.setString(1, id);
            statement.setString(2, name);
            statement.setString(3, credit);
            statement.setString(4, level);
            statement.setString(5, description);
            statement.setString(6, status);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void manageDeleteCourse(String id) {
        String query = "UPDATE course SET status = ? WHERE id = ?";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, "inactive");
            statement.setString(2, id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

//    public boolean isCourseIdExist(String id) {
//        JSONArray courses = entityData_Obj.getJSONArray("courses");
//        for (int i = 0; i < courses.length(); i++) {
//            if (courses.getJSONObject(i).getString("id").equals(id)) {
//                return true;
//            }
//        }
//        return false;
//    }

    public ObservableList<Map<String, String>> getAllCourseDetails(){
        String query = "SELECT * FROM course";
        ObservableList<Map<String, String>> courses = FXCollections.observableArrayList();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Map<String, String> map = new HashMap<>();
                map.put("id", resultSet.getString("id"));
                map.put("name", resultSet.getString("name"));
                map.put("credit", resultSet.getString("credit"));
                map.put("level", resultSet.getString("level"));
                map.put("description", resultSet.getString("description"));
                map.put("status", resultSet.getString("status"));
                courses.add(map);
            }
            return courses;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<String, String> getCourseDetails(String id) {
        String query = "SELECT * FROM course WHERE id = ?";
        Map<String, String> details = new HashMap<>();
        try (PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                details.put("id", rs.getString("id"));
                details.put("name", rs.getString("name"));
                details.put("credit", rs.getString("credit"));
                details.put("level", rs.getString("level"));
                details.put("description", rs.getString("description"));
                details.put("status", rs.getString("status"));
            }
            return details;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}

