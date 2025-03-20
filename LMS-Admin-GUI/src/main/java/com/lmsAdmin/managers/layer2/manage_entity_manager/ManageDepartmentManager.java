package main.java.com.lmsAdmin.managers.layer2.manage_entity_manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ManageDepartmentManager extends ManageEntityManager {

    public ManageDepartmentManager() {
        super();
    }

    public void manageAddDepartment(String id, String name){
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

    public void manageDeleteDepartment(String id){
        String query = "UPDATE department SET status = ? WHERE id = ?";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, "inactive");
            statement.setString(2, id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ObservableList<Map<String, String>> getAllDepartmentDetails(){
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

    public Map<String, String> getDepartmentDetails(String id){
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
}
