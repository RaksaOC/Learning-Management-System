package utils.manager.edit_entity_manager;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EditGroupManager extends EditEntityManager {
    // entityID = old ID
    public EditGroupManager(String groupID) {
        //                           ^
        //                   old Group id for noe
        super(groupID);
        setFilePath("shared/data/university.json");
        setEntityID(groupID); // entuty id to search for is the old groupID
        getEntityData();
    }

    public void setNewID(String newID) {
        this.entityDataToEdit.put("id", newID);
        this.saveEntityData();
    }

    public void getEntityData() {
        try {
            this.content = new String(Files.readAllBytes(Paths.get(this.filePath)));
            this.entityData_Obj = new JSONObject(content);
            JSONArray departments = this.entityData_Obj.getJSONArray("departments");

            for (int i = 0; i < departments.length(); i++) {
                JSONArray specializations = departments.getJSONObject(i).getJSONArray("specializations");
                for (int j = 0; j < specializations.length(); j++) {
                    JSONArray generations = specializations.getJSONObject(j).getJSONArray("generations");
                    for (int k = 0; k < generations.length(); k++) {
                        JSONArray groups = generations.getJSONObject(k).getJSONArray("groups");
                        for (int l = 0; l < groups.length(); l++) {
                            JSONObject group = groups.getJSONObject(l);
                            if (group.getString("id").equals(entityID)) {
                                this.entityDataToEdit = group;
                            }
                        }
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
            JSONArray departments = entityData_Obj.getJSONArray("departments");

            for (int i = 0; i < departments.length(); i++) {
                for (int j = 0; j < departments.getJSONObject(i).getJSONArray("specializations").length(); j++) {
                    for (int k = 0; k < departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").length(); k++) {
                        for (int l = 0; l < departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").length(); l++) {
                            if (departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").getJSONObject(l).getString("id").equals(entityID)) {
                                departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").put(l, entityDataToEdit);
                            }
                        }
                    }
                }
            }

            // Save updated departments back to main object
            entityData_Obj.put("departments", departments);

            // Write JSON back to file
            writer.write(entityData_Obj.toString(4));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}