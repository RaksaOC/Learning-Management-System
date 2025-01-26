package utils.manager.manage_entity_manager;

import org.json.JSONArray;
import org.json.JSONObject;

// this controller only handles add, delete and view
// for editing refer to the edit_entity_manager/controller


interface ManageEntityManagerInterface {
    void manageAddEntity(JSONObject obj);

    void manageDeleteEntity(String id);

    void manageViewEntity();

    void loadEntity();

    void saveEntity();

    void setEntityFilePath(String filePath);
}

public abstract class ManageEntityManager implements ManageEntityManagerInterface {
    protected String content;
    protected JSONArray entityData;
    protected String filePath;

    public ManageEntityManager() {
    }

    public abstract void manageAddEntity(JSONObject obj);

    public abstract void manageDeleteEntity(String id);

    public abstract void manageViewEntity();

    public abstract void setEntityFilePath(String filePath);

    public abstract void loadEntity();

    public abstract void saveEntity();

}