package main.java.com.lmsAdmin.managers.layer2.manage_entity_manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.JSONArray;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ManageSpecializationManager extends ManageEntityManager {
    private JSONArray specializations;

    public ManageSpecializationManager() {
        super();
    }

    public void manageAddSpecialization(
            String id,
            String department_id,
            String name,
            String status
    ){
        String query = "INSERT INTO specialization (id, department_id, name, status) VALUES (?, ?, ?, ?)";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, id);
            statement.setString(2, department_id);
            statement.setString(3, name);
            statement.setString(4, status);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void manageDeleteSpecialization(String id){
        // TODO: check if have students prevent deletion
        String query = "UPDATE specialization SET status = ? WHERE id = ?";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, "inactive");
            statement.setString(2, id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ObservableList<Map<String, String>> getAllSpecializationDetails(){
        ObservableList<Map<String, String>> data = FXCollections.observableArrayList();
        String query = "SELECT * FROM specialization";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Map<String, String> map = new HashMap<>();
                map.put("id", resultSet.getString("id"));
                map.put("department_id", resultSet.getString("department_id"));
                map.put("name", resultSet.getString("name"));
                map.put("status", resultSet.getString("status"));
                data.add(map);
            }
            return data;
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

    public Map<String, String> getSpecializationDetails(String id){
        Map<String, String> map = new HashMap<>();
        String query = "SELECT * FROM specialization WHERE id = ?";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                map.put(resultSet.getString("id"), resultSet.getString("id"));
                map.put(resultSet.getString("department_id"), resultSet.getString("department_id"));
                map.put(resultSet.getString("name"), resultSet.getString("name"));
                map.put(resultSet.getString("status"), resultSet.getString("status"));
            }
            return map;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    public boolean isSpecializationIdTaken(String id) {
        String query = "SELECT 1 FROM specialization WHERE id = ? LIMIT 1";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}