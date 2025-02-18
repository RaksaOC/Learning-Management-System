package main.java.com.lmsadmin.managers.manage_entity_manager;

import org.json.JSONObject;

public class ManageStudentManager extends ManageEntityManager {
    public ManageStudentManager() {
        setEntityFilePath("shared/data/student.json");
        loadEntity();
        this.baseID = "S000000";
    }

    @Override
    public void manageAddEntity(JSONObject newObj) {
        newObj.put("id", generateNewID());
        newObj.put("progress", new JSONObject()); // adds an empty json object
        entityData.put(newObj);
        saveEntity();
    }

    public JSONObject getDetails(String id) {
        for (int i = 0; i < entityData.length(); i++){
            if(entityData.getJSONObject(i).getString("id").equals(id)){
                return entityData.getJSONObject(i);
            }
        }
        return null;
    }
}
