package utils.manager.edit_entity_manager;

import org.json.JSONArray;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EditAdminManager extends EditEntityManager {

    // interface requrements
//    void setFilePath(String filePath);
//
//    void getEntityData();
    // void setEntityID();
//    String getOldName();
//    String getOldPhone();
//    String getOldEmail();
//    void getOldPassword();
//    boolean isEntityIDExist();

    public EditAdminManager(String idToEdit) {
        super(idToEdit);
        setEntityID(idToEdit);
        setFilePath("shared/data/admin.json");
        getEntityData();
    }

    @Override
    public void setEntityID(String id) {
        this.entityID = id;
    }

    @Override
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void getEntityData() {
        try {
            this.content = new String(Files.readAllBytes(Paths.get(this.filePath)));
            this.entityData = new JSONArray(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveEntityData() {
        try(FileWriter writer = new FileWriter(filePath)){
            writer.write(entityData.toString(4));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    ;

    @Override
    public String getOldName() {
        for (int i = 0; i < entityData.length(); i++) {
            if (entityData.getJSONObject(i).getString("id").equals(entityID)) {
                return entityData.getJSONObject(i).getString("name");
            }
        }
        return "";
    }

    ;

    @Override
    public String getOldPhone() {
        for (int i = 0; i < entityData.length(); i++) {
            if (entityData.getJSONObject(i).getString("id").equals(entityID)) {
                return entityData.getJSONObject(i).getString("phoneNumber");
            }
        }
        return "";
    }

    ;

    @Override
    public String getOldEmail() {
        for (int i = 0; i < entityData.length(); i++) {
            if (entityData.getJSONObject(i).getString("id").equals(entityID)) {
                return entityData.getJSONObject(i).getString("email");
            }
        }
        return "";
    }

    ;

    @Override
    public String getOldPassword() {
        for (int i = 0; i < entityData.length(); i++) {
            if (entityData.getJSONObject(i).getString("id").equals(entityID)) {
                return entityData.getJSONObject(i).getString("password");
            }
        }
        return "";
    }

    @Override
    public boolean isEntityIDExist(String id) {
        int adminLength = entityData.length();
        int idNumber = Integer.parseInt(id.substring(1, id.length()));
        if ((idNumber <= adminLength) && id.charAt(0) == 'A') return true;
        else return false;
    }

    @Override
    public void setNewName(String newName) {
        for (int i = 0; i < entityData.length(); i++) {
            if (entityData.getJSONObject(i).getString("id").equals(entityID)) {
                entityData.getJSONObject(i).put("name", newName);
            }
        }
        saveEntityData();
        System.out.println("Edited successfully");
    }

    @Override
    public void setNewPhone(String newPhone) {
        for (int i = 0; i < entityData.length(); i++) {
            if (entityData.getJSONObject(i).getString("id").equals(entityID)) {
                entityData.getJSONObject(i).put("phoneNumber", newPhone);
            }
        }
        saveEntityData();
        System.out.println("Edited successfully");
    }

    @Override
    public void setNewEmail(String newEmail) {
        for (int i = 0; i < entityData.length(); i++) {
            if (entityData.getJSONObject(i).getString("id").equals(entityID)) {
                entityData.getJSONObject(i).put("email", newEmail);
            }
        }
        saveEntityData();
        System.out.println("Edited successfully");
    }

    @Override
    public void setNewPassword(String newPassword) {
        for (int i = 0; i < entityData.length(); i++) {
            if (entityData.getJSONObject(i).getString("id").equals(entityID)) {
                entityData.getJSONObject(i).put("password", newPassword);
            }
        }
        saveEntityData();
        System.out.println("Edited successfully");
    }
}