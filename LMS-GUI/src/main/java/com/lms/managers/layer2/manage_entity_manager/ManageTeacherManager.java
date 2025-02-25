package main.java.com.lms.managers.layer2.manage_entity_manager;

import org.json.JSONArray;
import org.json.JSONObject;

public class ManageTeacherManager extends ManageEntityManager {
    public ManageTeacherManager() {
        setEntityFilePath("shared/data/teacher.json");
        loadEntity();
        this.baseID = "T0000";
    }

    public boolean isTeacherIdExist(String teacherId) {
        for (int i = 0; i < entityData_Arr.length(); i++) {
            if (entityData_Arr.getJSONObject(i).getString("id").equals(teacherId)) {
                return true;
            }
        }
        return false;
    }

    public JSONObject getDetails(String id) {
        for (int i = 0; i < entityData_Arr.length(); i++){
            if(entityData_Arr.getJSONObject(i).getString("id").equals(id)){
                return entityData_Arr.getJSONObject(i);
            }
        }
        return null;
    }

    public JSONArray getAllDetails(){
        return entityData_Arr;
    }


}