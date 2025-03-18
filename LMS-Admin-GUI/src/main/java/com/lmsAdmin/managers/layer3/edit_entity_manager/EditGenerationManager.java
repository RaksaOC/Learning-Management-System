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

public class EditGenerationManager extends EditEntityManager {
    // idToEdit = oldID;
    // idToEdit = oldID
    private Connection conn = DatabaseConnection.getInstance().getConnection();
    public EditGenerationManager(String idToEdit) {
        super(idToEdit);
        setFilePath("shared/data/university.json");
        setIdToEdit(idToEdit);
        this.loadEntityDataToEdit();
    }

    public EditGenerationManager() {
        setFilePath("shared/data/university.json");
        setIdToEdit("");
        this.loadEntityDataToEdit();
    }

    public void manageEditId(String newId) {
        JSONArray department = entityData_Obj.getJSONArray("departments");
        for (int i = 0; i < department.length(); i++) {
            for (int j = 0; j < department.getJSONObject(i).getJSONArray("specializations").length(); j++) {
                for (int k = 0; k < department.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").length(); k++) {
                    if (department.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getString("id").equals(idToEdit)) {
                        department.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).put("id", newId);
                    }
                }
            }
        }
        entityData_Obj.put("department", department);
        saveEntityData();
    }

    public void manageEditName(String newName) {
        JSONArray department = entityData_Obj.getJSONArray("departments");
        for (int i = 0; i < department.length(); i++) {
            for (int j = 0; j < department.getJSONObject(i).getJSONArray("specializations").length(); j++) {
                for (int k = 0; k < department.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").length(); k++) {
                    if (department.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getString("name").equals(idToEdit)) {
                        department.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).put("name", newName);
                    }
                }
            }
        }
        entityData_Obj.put("department", department);
        saveEntityData();
    }

    public ArrayList<String> loadIdsAndNameJSON() {
        ArrayList<String> idsAndName= new ArrayList<>();
//        JSONArray department = entityData_Obj.getJSONArray("departments");
//        for (int i = 0; i < department.length(); i++) {
//            JSONArray specializations = department.getJSONObject(i).getJSONArray("specializations");
//            for (int j = 0; j < specializations.length(); j++) {
//                JSONArray generations = specializations.getJSONObject(j).getJSONArray("generations");
//                for (int k = 0; k < generations.length(); k++) {
//                    idsAndName.add(generations.getJSONObject(k).getString("id") + " - " + generations.getJSONObject(k).getString("name"));
//                }
//            }
//        }
        return idsAndName;
    }

    public ArrayList<String> loadIdsAndNameSql() {
        ArrayList<String> idsAndName= new ArrayList<>();
        String query = "select id, name from generation";
        try(PreparedStatement statement = (conn.prepareStatement(query))){
            statement.execute();
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                idsAndName.add(resultSet.getString("id") + " - " + resultSet.getString("name"));
            }
            return idsAndName;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return idsAndName;
    }

    public void loadEntityDataToEdit() {
        try {
            this.content = new String(Files.readAllBytes(Paths.get(this.filePath)));
            this.entityData_Obj = new JSONObject(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveEntityData() {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(entityData_Obj.toString(4));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    ;
}