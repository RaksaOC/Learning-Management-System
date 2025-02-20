package main.java.com.lmsadmin.managers.manage_entity_manager;

import org.json.JSONArray;
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
        entityData_Arr.put(newObj);
        saveEntity();
    }

    public JSONObject getDetails(String id) {
        for (int i = 0; i < entityData_Arr.length(); i++){
            if(entityData_Arr.getJSONObject(i).getString("id").equals(id)){
                return entityData_Arr.getJSONObject(i);
            }
        }
        return null;
    }

    public JSONArray getAllDetails() {
        return entityData_Arr;
    }
}
