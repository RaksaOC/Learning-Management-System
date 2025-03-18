package main.java.com.lmsAdmin.managers.layer3.edit_entity_manager;

import main.DatabaseConnection;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EditCourseManager extends EditEntityManager {
    private Connection conn = DatabaseConnection.getInstance().getConnection();

    public EditCourseManager(String courseID) {
        super(courseID);
        setFilePath("shared/data/university.json");
        setIdToEdit(courseID); // entuty id to search for is the old groupID
        loadEntityDataToEdit();
    }

    public EditCourseManager() {
        super();
        setFilePath("shared/data/university.json");
        loadEntityDataToEdit();

    }

    public void manageEditIdSql(String newID) {
        String query = "UPDATE course SET id=? WHERE id=?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, newID);
            statement.setString(2, idToEdit);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void manageEditNameSql(String newName) {
        String query = "UPDATE course SET name=? WHERE id=?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, newName);
            statement.setString(2, idToEdit);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void manageEditId(String newID) {
        this.entityDataToEdit.put("id", newID);
        super.saveEntityData();
    }

    public void manageEditName(String newName) {
        this.entityDataToEdit.put("name", newName);
        super.saveEntityData();
    }

    public String getOldID(){
        return entityDataToEdit.getString("id");
    }

    public String getOldIdSql() {
        String query = "SELECT id FROM course WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getOldNameSql() {
        String query = "SELECT name FROM course WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> loadIds() {
        ArrayList<String> ids = new ArrayList<>();
        for(int i = 0 ; i < entityData_Arr.length(); i++){
            ids.add(entityData_Arr.getJSONObject(i).getString("id"));
        }
        return ids;
    }

    @Override
    public void loadEntityDataToEdit() {
        try {
            this.content = new String(Files.readAllBytes(Paths.get(this.filePath)));
            this.entityData_Obj = new JSONObject(content);
            this.entityData_Arr = entityData_Obj.getJSONArray("courses");
            if (idToEdit != null) { // check for empty contructor where id doesnt exist for optimization
                for (int i = 0; i < this.entityData_Arr.length(); i++) {
                    if (entityData_Arr.getJSONObject(i).getString("id").equals(this.idToEdit)) {
                        this.entityDataToEdit = entityData_Arr.getJSONObject(i);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> loadIdsAndName(){
        ArrayList<String> idsAndName = new ArrayList<>();
        String getCoursesQuery = "SELECT id, name FROM course";
        try(PreparedStatement statement = conn.prepareStatement(getCoursesQuery)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                idsAndName.add(id + " - " + name);
                // sort by name
                Collections.sort(idsAndName, Comparator.comparing(s -> s.substring(s.indexOf("-") + 2)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return idsAndName;
    }






}