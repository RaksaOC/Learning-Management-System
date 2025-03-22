package main.java.com.lmsAdmin.managers.layer2.manage_entity_manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.DatabaseConnection;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ManageGroupManager extends ManageEntityManager {
    public ManageGroupManager() {
        super();
    }

    public void manageAddGroup(String id, String generation_id, String specialization_id, String status) {
        String query = "INSERT INTO student_group (id,generation_id, specialization_id, status) VALUES (?,?,?, ?)";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, id);
            statement.setString(2, generation_id);
            statement.setString(3, specialization_id);
            statement.setString(4, status);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void manageDeleteGroup(String id) {
        String query = "UPDATE student_group SET status = 'inactive' WHERE id = ?";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void manageAddStudentToGroup(String studentID, String groupID) {
        // TODO: check for adding inactive students to group
        String query = "UPDATE student SET group_id = ? WHERE id = ?";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, groupID);
            statement.setString(2, studentID);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ObservableList<Map<String, String>> getAllGroupDetails(){
        ObservableList<Map<String, String>> data= FXCollections.observableArrayList();
        Map<String, String> row;
        String query = "SELECT * FROM student_group";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                row = new HashMap<>();
                row.put("id", rs.getString("id"));
                row.put("generation_id", rs.getString("generation_id"));
                row.put("specialization_id", rs.getString("specialization_id"));
                row.put("status", rs.getString("status"));
                data.add(row);
            }
            return data;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return data;
    }

    public Map<String, String> getGroupDetails(String id) {
        Map<String, String> row = new HashMap<>();
        String query = "SELECT * FROM student_group WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                row.put("id", rs.getString("id"));
                row.put("generation_id", rs.getString("generation_id"));
                row.put("specialization_id", rs.getString("specialization_id"));
                row.put("status", rs.getString("status"));
            }
            return row;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return row;
    }

    public boolean isGroupIdTaken(String id) {
        String query = "SELECT 1 FROM groups WHERE id = ? LIMIT 1";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();  // Returns true if at least one row exists
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}