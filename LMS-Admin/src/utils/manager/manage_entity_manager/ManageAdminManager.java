
package utils.manager.manage_entity_manager;
import org.json.JSONObject;
import org.json.JSONArray;
import ui.UI;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ManageAdminManager extends ManageEntityManager{

    public ManageAdminManager() {
        setEntityFilePath("shared/data/admin.json");
        loadEntity();
    }

    @Override
    public void setEntityFilePath(String path){
        this.filePath = path;
    }
    @Override
    public void manageAddEntity(JSONObject newAdmin) {
        newAdmin.put("id", generateNewID());
        entityData.put(newAdmin);
        saveEntity();
        System.out.println(UI.TextColor.addColor("\nAdded Successfully\n", UI.TextColor.GREEN));
    }

    @Override
    public void manageDeleteEntity(String idToDelete) {
        for (int i = 0; i < entityData.length(); i++) {
            if (entityData.getJSONObject(i).getString("id").equals(idToDelete)) {
                entityData.remove(i);
            }
        }
        saveEntity();
        System.out.println(UI.TextColor.addColor("\nDeleted Successfully\n", UI.TextColor.GREEN));
    }

    @Override
    public void manageViewEntity(){
        for (int i = 0; i < entityData.length(); i++) {
            JSONObject admin = entityData.getJSONObject(i);
            System.out.println(UI.TextColor.addColor(admin.toString(4), UI.TextColor.GREEN));
        }
    }

    // helper function
    private String generateNewID(){
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray entityData = new JSONArray(content);

            int newID = entityData.length() + 1;
            String newID_String = newID + "";
            String baseID = "A000";
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
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void loadEntity() {
        try{
            this.content = new String(Files.readAllBytes(Paths.get(filePath)));
            entityData = new JSONArray(content);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void saveEntity() {
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(entityData.toString(4)); // Pretty-print with 4 spaces
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}