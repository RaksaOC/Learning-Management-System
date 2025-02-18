
package main.java.com.lmsadmin.managers.manage_entity_manager;

import org.json.JSONObject;

public class ManageAdminManager extends ManageEntityManager {

    public ManageAdminManager() {
        setEntityFilePath("shared/data/admin.json");
        loadEntity();
        this.baseID = "A000";
    }

    public JSONObject getAdminDetails(String id) {
        for (int i = 0; i < entityData.length(); i++){
            if(entityData.getJSONObject(i).getString("id").equals(id)){
                return entityData.getJSONObject(i);
            }
        }
        return null;
    }

}