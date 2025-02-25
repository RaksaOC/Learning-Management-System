package main.java.com.lms.managers.layer2.manage_entity_manager;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
    protected JSONArray entityData_Arr;
    protected JSONObject entityData_Obj;
    protected String filePath;
    protected String baseID;

    public ManageEntityManager() {
    }

    public void manageAddEntity(JSONObject newObj) {
        newObj.put("id", generateNewID());
        entityData_Arr.put(newObj);
        saveEntity();
    }

    public void manageDeleteEntity(String idToDelete) {
        for (int i = 0; i < entityData_Arr.length(); i++) {
            if (entityData_Arr.getJSONObject(i).getString("id").equals(idToDelete)) {
                entityData_Arr.getJSONObject(i).put("status", "inactive");
            }
        }
        saveEntity();
    }

    public void manageViewEntity() {
        entityData_Arr.toString(4);
    }

    public void setEntityFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void loadEntity() {
        try {
            this.content = new String(Files.readAllBytes(Paths.get(filePath)));
            entityData_Arr = new JSONArray(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ;

    public void saveEntity() {
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(entityData_Arr.toString(4)); // Pretty-print with 4 spaces
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected String generateNewID() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray entityData = new JSONArray(content);

            int newID = entityData.length() + 1;
            String newID_String = newID + "";
            int start = baseID.length() - newID_String.length();

            StringBuilder baseIDBuilder = new StringBuilder(baseID); // Convert to StringBuilder
            StringBuilder newIDBuilder = new StringBuilder(newID_String);
            int j = 0;
            for (int i = start; i < baseID.length(); i++) {
                baseIDBuilder.setCharAt(i, newIDBuilder.charAt(j)); // Set the character at index i
                j++;
            }
            baseID = baseIDBuilder.toString(); // Convert back to string
            return baseID;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}