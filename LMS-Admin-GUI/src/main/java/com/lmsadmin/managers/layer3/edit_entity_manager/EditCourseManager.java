package main.java.com.lmsadmin.managers.layer3.edit_entity_manager;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class EditCourseManager extends EditEntityManager {
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






}