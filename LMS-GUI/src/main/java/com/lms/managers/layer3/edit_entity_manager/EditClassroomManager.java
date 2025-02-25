package main.java.com.lms.managers.layer3.edit_entity_manager;

import java.util.ArrayList;

public class EditClassroomManager extends EditEntityManager {
    public EditClassroomManager(String classroomID) {
        super(classroomID);
        setFilePath("shared/data/classroom.json");
        setIdToEdit(classroomID); // entuty id to search for is the old groupID
        loadEntityDataToEdit();
    }

    public EditClassroomManager() {
        super();
        setFilePath("shared/data/classroom.json");
        loadEntityDataToEdit();
    }

    public void manageEditId(String newID) {
        this.entityDataToEdit.put("id", newID);
        super.saveEntityData();
    }

    public ArrayList<String> loadIds() {
        ArrayList<String> ids = new ArrayList<>();
        for(int i = 0 ; i < entityData_Arr.length(); i++){
            ids.add(entityData_Arr.getJSONObject(i).getString("id"));
        }
        return ids;
    }

    public String getOldID(){
        return entityDataToEdit.getString("id");
    }


}