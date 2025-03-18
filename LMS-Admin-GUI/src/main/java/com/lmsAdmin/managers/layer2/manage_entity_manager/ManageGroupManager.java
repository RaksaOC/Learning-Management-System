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
    private Connection conn = DatabaseConnection.getInstance().getConnection();
    public ManageGroupManager() {
        super();
        setEntityFilePath("shared/data/university.json");
        loadEntity();
    }

    public void manageAddEntity(String specID, String genID, JSONObject newObj) {
        JSONArray departments = entityData_Obj.getJSONArray("departments");
        newObj.put("students", new JSONArray());
        newObj.put("status", "active");
        newObj.put("classrooms", new JSONArray());

        beginLoop:
        for (int i = 0; i < departments.length(); i++) {
            for (int j = 0; i < departments.getJSONObject(i).getJSONArray("specializations").length(); i++) {
                if (specID.equals(departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getString("id"))) {
                    for (int k = 0; k < departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").length(); k++) {
                        if (departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getString("id").equals(genID)) {
                            departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").put(newObj);
                            break beginLoop;
                        }
                    }
                }
            }
        }
        entityData_Obj.put("departments", departments);
        saveEntity();
    }

    public void manageAddEntitySql(String id, String generation_id, String specialization_id, String status) {
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

    public void manageDeleteEntitySql(String id) {
        String query = "UPDATE student_group SET status = 'inactive' WHERE id = ?";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void manageAddStudentToGroupSql(String studentID, String groupID) {
        String query = "UPDATE student SET group_id = ? WHERE id = ?";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, groupID);
            statement.setString(2, studentID);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ObservableList<Map<String, String>> getAllDetailsSql(){
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

    public Map<String, String> getDetailsSql(String id) {
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

    public void manageDeleteEntity(String groupID) {
        JSONArray departments = entityData_Obj.getJSONArray("departments");
        beginLoop:
        for (int i = 0; i < departments.length(); i++) {
            for (int j = 0; i < departments.getJSONObject(i).getJSONArray("specializations").length(); i++) {
                for (int k = 0; k < departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").length(); k++) {
                    for (int l = 0; l < departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").length(); l++) {
                        if (departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").getJSONObject(l).getString("id").equals(groupID)) {
                            departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").getJSONObject(l).put("status", "inactive");
                            break beginLoop;
                        }
                    }
                }
            }
        }
        entityData_Obj.put("departments", departments);
        saveEntity();
    }

    public void manageViewEntity() {
        JSONArray departments = entityData_Obj.getJSONArray("departments");
//        for (int i = 0; i < departments.length(); i++) {
//            for (int j = 0; i < departments.getJSONObject(i).getJSONArray("specializations").length(); i++) {
//                for (int k = 0; k < departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").length(); k++) {
//                    for(int l = 0; l < departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").length(); l++) {
//                        if(departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").getJSONObject(l).getString("id").equals(groupID)) {
//                            System.out.println(departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").getJSONObject(l).toString(4));
//                        }
//                    }
//                }
//            }
//        }
        for (int i = 0; i < departments.length(); i++) {
            for (int j = 0; j < departments.getJSONObject(i).getJSONArray("specializations").length(); j++) {
                for (int k = 0; k < departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").length(); k++) {
                    for (int l = 0; l < departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").length(); l++) {
                        System.out.println(departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").toString(4));
                    }
                }
            }
        }
    }

    public void manageAddStudentToGroup(String groupID, ArrayList<String> studentIDs) {
        JSONArray departments = entityData_Obj.getJSONArray("departments");
        beginLoop:
        for (int i = 0; i < departments.length(); i++) {
            for (int j = 0; j < departments.getJSONObject(i).getJSONArray("specializations").length(); j++) {
                for (int k = 0; k < departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").length(); k++) {
                    for (int l = 0; l < departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").length(); l++) {
                        if (departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").getJSONObject(l).getString("id").equals(groupID)) {
                            for (int m = 0; m < studentIDs.size(); m++) {
                                departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").getJSONObject(l).getJSONArray("students").put(studentIDs.get(m));
                            }
                            break beginLoop;
                        }
                    }
                }
            }
        }
        entityData_Obj.put("departments", departments);
        saveEntity();
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

    public boolean isGroupIDExist(String groupID) {
        JSONArray departments = entityData_Obj.getJSONArray("departments");
        for (int i = 0; i < departments.length(); i++) {
            JSONArray specializations = departments.getJSONObject(i).getJSONArray("specializations");
            for (int j = 0; j < specializations.length(); j++) {
                JSONArray generations = specializations.getJSONObject(j).getJSONArray("generations");
                for (int k = 0; k < generations.length(); k++) {
                    JSONArray groups = generations.getJSONObject(k).getJSONArray("groups");
                    for (int l = 0; l < groups.length(); l++) {
                        if (groups.getJSONObject(l).getString("id").equals(groupID)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public JSONObject getDetails(String groupID) {
        JSONArray departments = entityData_Obj.getJSONArray("departments");
        for (int i = 0; i < departments.length(); i++) {
            JSONArray specializations = departments.getJSONObject(i).getJSONArray("specializations");
            for (int j = 0; j < specializations.length(); j++) {
                JSONArray generations = specializations.getJSONObject(j).getJSONArray("generations");
                for (int k = 0; k < generations.length(); k++) {
                    JSONArray groups = generations.getJSONObject(k).getJSONArray("groups");
                    for (int l = 0; l < groups.length(); l++) {
                        if (groups.getJSONObject(l).getString("id").equals(groupID)) {
                            return groups.getJSONObject(l);
                        }
                    }
                }
            }
        }
        return null;
    }

    public JSONArray getAllDetails(){
        JSONArray gps = new JSONArray();
        JSONArray departments = entityData_Obj.getJSONArray("departments");
        for (int i = 0; i < departments.length(); i++) {
            JSONArray specializations = departments.getJSONObject(i).getJSONArray("specializations");
            for (int j = 0; j < specializations.length(); j++) {
                JSONArray generations = specializations.getJSONObject(j).getJSONArray("generations");
                for (int k = 0; k < generations.length(); k++) {
                    JSONArray groups = generations.getJSONObject(k).getJSONArray("groups");
                    for (int l = 0; l < groups.length(); l++) {
                        gps.put(groups.getJSONObject(l));
                    }
                }

            }
        }
        return gps;
    }


}