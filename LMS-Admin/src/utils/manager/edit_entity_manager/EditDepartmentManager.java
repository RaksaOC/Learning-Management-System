package utils.manager.edit_entity_manager;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EditDepartmentManager extends EditEntityManager {

    JSONArray departments;

    public EditDepartmentManager(String idToEdit) {
        super(idToEdit);
        setFilePath("shared/data/university.json");
        setEntityID(idToEdit);
        getEntityData();

    }

    public void setNewID(String newID) {
        this.entityDataToEdit.put("id", newID);
        saveEntityData();
    }

    public String getOldID() {
        return entityDataToEdit.getString("id");
    }

    @Override
    public void getEntityData() {
        try {
            this.content = new String(Files.readAllBytes(Paths.get(this.filePath)));
            this.entityData_Obj = new JSONObject(content);
            this.departments = this.entityData_Obj.getJSONArray("departments");
            for (int i = 0; i < departments.length(); i++) {
                if (departments.getJSONObject(i).getString("id").equals(entityID)) {
                    this.entityDataToEdit = departments.getJSONObject(i);
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
                if (departments.getJSONObject(i).getString("id").equals(entityID)) {
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