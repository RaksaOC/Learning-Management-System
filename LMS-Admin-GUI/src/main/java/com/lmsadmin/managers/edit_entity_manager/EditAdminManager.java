package main.java.com.lmsadmin.managers.edit_entity_manager;

import java.util.ArrayList;

public class EditAdminManager extends EditEntityManager {

    public EditAdminManager(String idToEdit) {
        super(idToEdit);
        setFilePath("shared/data/admin.json");
        this.baseId = "A000";
        setIdToEdit(idToEdit);
        loadEntityDataToEdit();
    }

    public EditAdminManager() {
        super();
        setFilePath("shared/data/admin.json");
        loadEntityDataToEdit(); // this would load the entire file too
    }

    public void manageEditDOB(String newDob){

    }

    public String getOldDOB(){
        return entityDataToEdit.getString("dob");
    }

    public ArrayList<String> loadIds(){
        ArrayList<String> ids = new ArrayList<>();
        for (int i = 0; i < entityData_Arr.length(); i++){
            ids.add(entityData_Arr.getJSONObject(i).getString("id"));
        }
        return ids;
    }

}