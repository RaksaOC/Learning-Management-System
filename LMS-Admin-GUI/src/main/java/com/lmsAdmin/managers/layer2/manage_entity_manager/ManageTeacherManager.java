package main.java.com.lmsAdmin.managers.layer2.manage_entity_manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ManageTeacherManager extends ManageEntityManager {

    public ManageTeacherManager() {
        this.baseID = "T0000";
    }

    public void manageAddTeacher(
            String first_name,
            String last_name,
            String gender,
            String dob,
            String phone_number,
            String email,
            String status,
            String created_at,
            String last_login,
            String password
    ) {
        String query = "INSERT INTO teacher (id, first_name, last_name, gender, dob, phone_number, email, status, created_at, last_login, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, generateNewID("teacher"));
            statement.setString(2, first_name);
            statement.setString(3, last_name);
            statement.setString(4, gender);
            statement.setString(5, dob);
            statement.setString(6, phone_number);
            statement.setString(7, email);
            statement.setString(8, status);
            statement.setTimestamp(9, Timestamp.valueOf(created_at));
            statement.setNull(10, java.sql.Types.TIMESTAMP);
            statement.setString(11, password);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void manageDeleteTeacher(String id) {
        String query = "UPDATE teacher SET status = ? WHERE id = ?";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, "inactive");
            statement.setString(2, id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ObservableList<Map<String, String>> getAllTeacherDetails(){
        String query = "SELECT * FROM teacher";
        ObservableList<Map<String, String>> data = FXCollections.observableArrayList();
        try(PreparedStatement statement = conn.prepareStatement(query)){
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Map<String, String> map = new HashMap<>();
                map.put("id", rs.getString("id"));
                map.put("first_name", rs.getString("first_name"));
                map.put("last_name", rs.getString("last_name"));
                map.put("gender", rs.getString("gender"));
                map.put("dob", rs.getString("dob"));
                map.put("phone_number", rs.getString("phone_number"));
                map.put("email", rs.getString("email"));
                map.put("status", rs.getString("status"));
                map.put("created_at", rs.getString("created_at"));
                map.put("last_login", rs.getString("last_login"));
                data.add(map);
            }
            return data;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return data;
    }

    public Map<String, String> getTeacherDetails(String id) {
        Map<String, String> map = new HashMap<>();
        String query = "SELECT * FROM teacher WHERE id = ?";
        try(PreparedStatement statement= conn.prepareStatement(query)){
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                map.put("id", rs.getString("id"));
                map.put("first_name", rs.getString("first_name"));
                map.put("last_name", rs.getString("last_name"));
                map.put("gender", rs.getString("gender"));
                map.put("dob", rs.getString("dob"));
                map.put("phone_number", rs.getString("phone_number"));
                map.put("email", rs.getString("email"));
                map.put("status", rs.getString("status"));
                map.put("created_at", rs.getString("created_at"));
                map.put("last_login", rs.getString("last_login"));
            }
            return map;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}