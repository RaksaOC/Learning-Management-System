package main.java.com.lmsAdmin.managers.layer2.manage_entity_manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.DatabaseConnection;
import org.json.JSONArray;
import org.json.JSONObject;
import ui.UI;

import javax.xml.crypto.Data;
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

public class ManageDepartmentManager extends ManageEntityManager {

    JSONArray departments;
    private Connection conn = DatabaseConnection.getInstance().getConnection();
    public ManageDepartmentManager() {
        super();
        setEntityFilePath("shared/data/university.json");
        loadEntity();
        departments = new JSONArray();
        departments = entityData_Obj.getJSONArray("departments");
    }

    // SQL methods

    public void manageAddEntitySql(String id, String name){
        String query = "INSERT INTO department(id, name, status) VALUES(?,?,?)";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, id);
            statement.setString(2, name);
            statement.setString(3, "active");
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void manageDeleteEntitySql(String id){
        String query = "UPDATE department SET status = ? WHERE id = ?";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, "inactive");
            statement.setString(2, id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ObservableList<Map<String, String>> getAllDetailsSql(){
        String query = "SELECT * FROM department";
        ObservableList<Map<String, String>> data = FXCollections.observableArrayList();
        try(PreparedStatement statement = conn.prepareStatement(query)){
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Map<String, String> map = new HashMap<>();
                map.put("id", rs.getString("id"));
                map.put("name", rs.getString("name"));
                map.put("status", rs.getString("status"));
                data.add(map);
            }
            return data;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public Map<String, String> getDetailsSql(String id){
        String query = "SELECT * FROM department WHERE id = ?";
        Map<String, String> map = new HashMap<>();
        try(PreparedStatement statement = conn.prepareStatement(query)){
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                map.put(id, rs.getString("id"));
                map.put(id, rs.getString("name"));
                map.put(id, rs.getString("status"));
            }
            return map;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    // JSON methods

    @Override
    public void manageAddEntity(JSONObject newDepartment) {
        newDepartment.put("specializations", new JSONArray());
        newDepartment.put("status", "active");
        departments.put(newDepartment);
        entityData_Obj.put("departments", departments);
        saveEntity();
    }

    @Override
    public void manageDeleteEntity(String id) {
        for (int i = 0; i < departments.length(); i++) {
            if (departments.getJSONObject(i).getString("id").equals(id)) {
                departments.getJSONObject(i).put("status", "inactive");
                break;
            }
        }
        saveEntity();
    }

    @Override
    public void manageViewEntity() {
        System.out.println("Printed departments");
        System.out.println(UI.TextColor.addColor(departments.toString(4), UI.TextColor.BLUE));
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

    // helper unique to department
    public boolean isDepartmentExist(String id) {
        for (int i = 0; i < departments.length(); i++) {
            if (departments.getJSONObject(i).getString("id").equals(id)) {
                return true;
            }
        }
        return false;
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

    public JSONObject getDetails(String id) {
        for (int i = 0; i < departments.length(); i++) {
            if (departments.getJSONObject(i).getString("id").equals(id)) {
                return departments.getJSONObject(i);
            }
        }
        return null;
    }

    public JSONArray getAllDetails(){
        return departments;
    }


}
