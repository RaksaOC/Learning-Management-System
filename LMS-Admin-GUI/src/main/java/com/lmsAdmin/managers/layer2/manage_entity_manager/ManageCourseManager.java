package main.java.com.lmsAdmin.managers.layer2.manage_entity_manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.DatabaseConnection;
import org.json.JSONArray;
import org.json.JSONObject;
import ui.UI;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ManageCourseManager extends ManageEntityManager{
    Connection conn = DatabaseConnection.getInstance().getConnection();
    JSONArray courses;

    public ManageCourseManager() {
        super();
        setEntityFilePath("shared/data/university.json");
        loadEntity();
        courses = entityData_Obj.getJSONArray("courses");
    }

    @Override
    public void manageAddEntity(JSONObject newCourse) {
        courses.put(newCourse);
        entityData_Obj.put("courses", courses);
        saveEntity();
    }

    public void manageAddEntitySql(
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

    @Override
    public void manageDeleteEntity(String id) {
        for (int i = 0; i < courses.length(); i++) {
            if (courses.getJSONObject(i).getString("id").equals(id)) {
                courses.getJSONObject(i).put("status", "inactive");
                break;
            }
        }
        saveEntity();
    }

    public void manageDeleteEntitySql(String id) {
        String query = "UPDATE course SET status = ? WHERE id = ?";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, "inactive");
            statement.setString(2, id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void manageViewEntity() {
        System.out.println("Printed departments");
        System.out.println(UI.TextColor.addColor(courses.toString(4), UI.TextColor.BLUE));
    }

    @Override
    public void loadEntity() {
        // override for the loading of entity because university is object not array
        try {
            content = new String(Files.readAllBytes(Paths.get(filePath)));
            entityData_Obj = new JSONObject(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveEntity() {
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(entityData_Obj.toString(4)); // Pretty-print with 4 spaces
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isCourseIdExist(String id) {
        JSONArray courses = entityData_Obj.getJSONArray("courses");
        for (int i = 0; i < courses.length(); i++) {
            if (courses.getJSONObject(i).getString("id").equals(id)) {
                return true;
            }
        }
        return false;
    }

    public ObservableList<Map<String, String>> getAllDetailsSql(){
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

    public Map<String, String> getDetailsSQL(String id) {
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

    public JSONObject getDetailsJSON(String id) {
        JSONArray courses = entityData_Obj.getJSONArray("courses");
        for (int i = 0; i < courses.length(); i++) {
            if (courses.getJSONObject(i).getString("id").equals(id)) {
                return courses.getJSONObject(i);
            }
        }
        return null;
    }

    public JSONArray getAllDetailsJSON(){
        return entityData_Obj.getJSONArray("courses");
    }
}

