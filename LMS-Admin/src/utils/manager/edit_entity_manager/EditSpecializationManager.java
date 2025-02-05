package utils.manager.edit_entity_manager;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EditSpecializationManager extends EditEntityManager {
    private JSONArray departments;
    private JSONArray specializations;
    private String depID;

    public EditSpecializationManager(String idToEdit) {
        super(idToEdit);
        setFilePath("shared/data/university.json");
        setEntityID(idToEdit);
        getEntityData();
    }

    public EditSpecializationManager(String dep_id, String spec_id) {
        super(dep_id);
        setFilePath("shared/data/university.json");
        // this for using to find the specific data, the specific specialization within the array of specializations
        setEntityID(spec_id);
        getEntityData(dep_id);
    }


    public void setNewID(String newID) {
        this.entityDataToEdit.put("id", newID);
        saveEntityData(depID);
    }

    public void setNewName(String newName) {
        this.entityDataToEdit.put("name", newName);
        saveEntityData(depID);
    }

    public String getOldID() {
        return entityDataToEdit.getString("id");
    }

    public void getEntityData(String dep_id) {
        this.depID = dep_id;
        try {
            this.content = new String(Files.readAllBytes(Paths.get(this.filePath)));
            this.entityData_Obj = new JSONObject(content);
            departments = this.entityData_Obj.getJSONArray("departments");

            for (int i = 0; i < departments.length(); i++) {
                if (departments.getJSONObject(i).getString("id").equals(this.depID)) {
                    specializations = departments.getJSONObject(i).getJSONArray("specializations");
                }
            }
            for (int i = 0; i < specializations.length(); i++) {
                // means traversing until we find the specific specialization (entityID)
                if (specializations.getJSONObject(i).getString("id").equals(entityID)) {
                    entityDataToEdit = specializations.getJSONObject(i);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveEntityData(String dep_id) {
        try (FileWriter writer = new FileWriter(filePath)) {
            // put the specific spec to the correct place
            for (int i = 0; i < specializations.length(); i++) {
                if (specializations.getJSONObject(i).getString("id").equals(entityID)) {
                    specializations.put(i, entityDataToEdit);
                    break;
                }
            }
            // put the hole spec to the correct department
            for (int i = 0; i < departments.length(); i++) {
                if (departments.getJSONObject(i).getString("id").equals(dep_id)) {
                    departments.getJSONObject(i).put("specializations", specializations);
                }
            }
            this.entityData_Obj.put("departments", departments);
            writer.write(entityData_Obj.toString(4));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    ;

    // No Uses

    @Override
    public String getOldPhone() {
        return null;
    }

    ;

    public String getOldEmail() {
        return null;
    }

    ;

    public String getOldPassword() {
        return null;
    }

    ;
}