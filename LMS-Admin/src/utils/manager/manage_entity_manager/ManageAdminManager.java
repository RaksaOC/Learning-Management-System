
package utils.manager.manage_entity_manager;

import org.json.JSONObject;

public class ManageAdminManager extends ManageEntityManager {

    public ManageAdminManager() {
        setEntityFilePath("shared/data/admin.json");
        loadEntity();
        this.baseID = "A000";
    }

    // no unique manager functionalities
}