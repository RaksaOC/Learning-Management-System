package utils.manager.edit_entity_manager;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EditGenerationManager extends EditEntityManager {
    // idToEdit = oldID;
    // entityID = oldID
    public EditGenerationManager(String idToEdit) {
        super(idToEdit);
        setFilePath("shared/data/university.json");
        setEntityID(idToEdit);
        getEntityData();
    }

    public void setNewID(String newId) {
        JSONArray department = entityData_Obj.getJSONArray("departments");
        for (int i = 0; i < department.length(); i++) {
            for(int j = 0; j < department.getJSONObject(i).getJSONArray("specializations").length(); j++) {
                for(int k = 0; k < department.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").length(); k++) {
                    if(department.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getString("id").equals(entityID)) {
                        department.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).put("id", newId);
                    }
                }
            }
        }
        entityData_Obj.put("department", department);
        saveEntityData();
    }

    public void getEntityData(){
        try {
            this.content = new String(Files.readAllBytes(Paths.get(this.filePath)));
            this.entityData_Obj = new JSONObject(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveEntityData(){
        try(FileWriter writer = new FileWriter(filePath)){
            writer.write(entityData_Obj.toString(4));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    };
}