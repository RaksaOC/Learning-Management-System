package main.java.com.lmsAdmin.managers.layer3.edit_entity_manager;

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
import java.util.Collections;
import java.util.Comparator;

public class EditDepartmentManager extends EditEntityManager {

    JSONArray departments;
    Connection conn = DatabaseConnection.getInstance().getConnection();

    public EditDepartmentManager(String idToEdit) {
        super(idToEdit);
        setFilePath("shared/data/university.json");
        setIdToEdit(idToEdit);
        loadEntityDataToEdit();
    }

    public EditDepartmentManager() {
        setFilePath("shared/data/university.json");
        setIdToEdit("");
        loadEntityDataToEdit();
    }

    public String getOldIdSql() {
        String query = "SELECT id FROM department WHERE id = ?";
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
        String query = "SELECT name FROM department WHERE id = ?";
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

    public void manageEditIdSql(String newID) {
        String query = "UPDATE department SET id=? WHERE id=?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, newID);
            statement.setString(2, idToEdit);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void manageEditNameSql(String newName) {
        String query = "UPDATE department SET name=? WHERE id=?";
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
        saveEntityData();
    }

    public void manageEditName(String newName) {
        this.entityDataToEdit.put("name", newName);
        saveEntityData();
    }

    public String getOldID() {
        return entityDataToEdit.getString("id");
    }

    public ArrayList<String> loadIdsAndNameJSON() {
        ArrayList<String> idsAndName = new ArrayList<>();
        for (int i = 0; i < departments.length(); i++) {
            idsAndName.add(departments.getJSONObject(i).getString("id") + " - " + departments.getJSONObject(i).getString("name"));
        }
        Collections.sort(idsAndName, Comparator.comparing(s -> s.substring(s.indexOf("-") + 2)));
        return idsAndName;
    }

    public ArrayList<String> loadIdsAndNameSql() {
        ArrayList<String> idsAndName = new ArrayList<>();
        String query = "SELECT id, name FROM department";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.execute();
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                idsAndName.add(resultSet.getString("id") + " - " + resultSet.getString("name"));
            }
            Collections.sort(idsAndName, Comparator.comparing(s -> s.substring(s.indexOf("-" ) + 2)));
            return idsAndName;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idsAndName;
    }

    @Override
    public void loadEntityDataToEdit() {
        try {
            this.content = new String(Files.readAllBytes(Paths.get(this.filePath)));
            this.entityData_Obj = new JSONObject(content);
            this.departments = this.entityData_Obj.getJSONArray("departments");
            if (!idToEdit.isEmpty()) {
                for (int i = 0; i < departments.length(); i++) {
                    if (departments.getJSONObject(i).getString("id").equals(idToEdit)) {
                        this.entityDataToEdit = departments.getJSONObject(i);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveEntityData() {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (int i = 0; i < departments.length(); i++) {
                if (departments.getJSONObject(i).getString("id").equals(idToEdit)) {
                    departments.put(i, entityDataToEdit);
                    break;
                }
            }
            this.entityData_Obj.put("departments", departments);
            writer.write(entityData_Obj.toString(4));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}