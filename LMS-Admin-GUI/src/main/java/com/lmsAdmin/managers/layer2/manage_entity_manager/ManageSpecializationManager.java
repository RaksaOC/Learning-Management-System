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
import java.util.HashMap;
import java.util.Map;

public class ManageSpecializationManager extends ManageEntityManager {
    private Connection conn = DatabaseConnection.getInstance().getConnection();
    private JSONArray specializations;

    public ManageSpecializationManager() {
        super();
        setEntityFilePath("shared/data/university.json");
        loadEntity();
    }

    public void manageAddEntitySql(
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

    public void manageDeleteEntitySql(String id){
        String query = "UPDATE specialization SET status = ? WHERE id = ?";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, "inactive");
            statement.setString(2, id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ObservableList<Map<String, String>> getAllDetailsSql(){
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

    public Map<String, String> getDetailsSql(String id){
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

    public void manageAddEntity(String dep_id, JSONObject newSpecialization) {
        getSpecializations(dep_id);
        newSpecialization.put("status", "active");
        newSpecialization.put("generations", new JSONArray());
        specializations.put(newSpecialization);
        saveEntity();
    }

    public void manageDeleteEntity(String dep_id, String spec_id) {
        getSpecializations(dep_id);
        for (int i = 0; i < specializations.length(); i++) {
            if (specializations.getJSONObject(i).getString("id").equals(spec_id)) {
                specializations.getJSONObject(i).put("status", "inactive");
                break;
            }
        }
        saveEntity();
    }

    public void manageDeleteEntity(String spec_id) {
        JSONArray departments = entityData_Obj.getJSONArray("departments");
        for (int i = 0; i < departments.length(); i++) {
            for (int j = 0; j < departments.getJSONObject(i).getJSONArray("specializations").length(); j++) {
                if (departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getString("id").equals(spec_id)) {
                    departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).put("status", "inactive");
                    return;
                }
            }
        }
    }

    public void manageViewEntity(String dep_id) {
        getSpecializations(dep_id);
        System.out.println(specializations.toString(4));
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

    private void getSpecializations(String dep_id) {
        JSONArray departments = entityData_Obj.getJSONArray("departments");
        for (int i = 0; i < departments.length(); i++) {
            if (departments.getJSONObject(i).getString("id").equals(dep_id)) {
                specializations = departments.getJSONObject(i).getJSONArray("specializations");
                break;
            }
        }
    }

    public boolean isSpecializationExist(String spec_id) {
        JSONArray departments = entityData_Obj.getJSONArray("departments");
        for (int i = 0; i < departments.length(); i++) {
            JSONArray specializations = departments.getJSONObject(i).getJSONArray("specializations");
            for (int j = 0; j < specializations.length(); j++) {
                if (specializations.getJSONObject(j).getString("id").equals(spec_id)) {
                    return true;
                }
            }
        }
        return false;
    }

    public JSONObject getDetails(String specId) {
        JSONArray departments = entityData_Obj.getJSONArray("departments");
        for (int i = 0; i < departments.length(); i++) {
            JSONArray specializations = departments.getJSONObject(i).getJSONArray("specializations");
            for (int j = 0; j < specializations.length(); j++) {
                if (specializations.getJSONObject(j).getString("id").equals(specId)) {
                    return specializations.getJSONObject(j);
                }
            }
        }
        return null;
    }

    public JSONArray getAllDetails(){
        JSONArray spec = new JSONArray();
        JSONArray departments = entityData_Obj.getJSONArray("departments");
        for (int i = 0; i < departments.length(); i++) {
            JSONArray specializations = departments.getJSONObject(i).getJSONArray("specializations");
            for (int j = 0; j < specializations.length(); j++) {
                spec.put(specializations.getJSONObject(j));
            }
        }
        return spec;
    }
}