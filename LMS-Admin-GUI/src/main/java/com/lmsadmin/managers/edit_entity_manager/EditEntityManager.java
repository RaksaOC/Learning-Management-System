package main.java.com.lmsadmin.managers.edit_entity_manager;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

interface EditInterface {
    void setFilePath(String filePath);

    void loadEntityDataToEdit();

    void saveEntityData();

    void setIdToEdit(String idToEdit);

    String getOldName();

    String getOldPhone();

    String getOldEmail();

    String getOldPassword();

    boolean isEntityIDExist(String entityID);

    void setNewName(JSONObject newName);

    void setNewPhone(String newPhone);

    void setNewEmail(String newEmail);

    void setNewPassword(String newPassword);
}

public class EditEntityManager implements EditInterface {
    protected String idToEdit;
    protected String content;
    protected JSONArray entityData_Arr;
    protected JSONObject entityData_Obj;
    protected JSONObject entityDataToEdit;
    protected String filePath;
    // this is for checking the validity of entered id
    protected String baseId;

    public EditEntityManager() {}
    public EditEntityManager(String id) {
    }

    public String getOldName() {
        Object name = this.entityDataToEdit.get("name");
        if (name instanceof JSONObject) {
            JSONObject nameObj = (JSONObject) name;
            return "First Name: " + nameObj.getString("firstName") + "Last Name: " + nameObj.getString("lastName");
        } else {
            return name.toString();
        }
    }

    public String getOldPhone() {
        return entityDataToEdit.getString("phoneNumber");
    }

    public String getOldEmail() {
        return entityDataToEdit.getString("email");
    }


    public String getOldPassword() {
        return entityDataToEdit.getString("password");
    }


    public void setNewName(JSONObject newName) {
        this.entityDataToEdit.put("name", newName);
        saveEntityData();
    }

    public void setNewName(String newName) {
        this.entityDataToEdit.put("name", newName);
        saveEntityData();
    }

    public void setNewPhone(String newPhone) {
        entityDataToEdit.put("phoneNumber", newPhone);
        saveEntityData();
    }

    public void setNewEmail(String newEmail) {
        entityDataToEdit.put("email", newEmail);
        saveEntityData();
    }

    public void setNewPassword(String newPassword) {
        entityDataToEdit.put("password", newPassword);
        saveEntityData();
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setIdToEdit(String idToEdit) {
        this.idToEdit = idToEdit;
    }

    public void loadEntityDataToEdit() {
        try {
            this.content = new String(Files.readAllBytes(Paths.get(this.filePath)));
            this.entityData_Arr = new JSONArray(content);
            for (int i = 0; i < this.entityData_Arr.length(); i++) {
                if (entityData_Arr.getJSONObject(i).getString("id").equals(this.idToEdit)) {
                    this.entityDataToEdit = entityData_Arr.getJSONObject(i);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveEntityData() {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (int i = 0; i < entityData_Arr.length(); i++) {
                if (entityData_Arr.getJSONObject(i).getString("id").equals(idToEdit)) {
                    entityData_Arr.put(i, entityDataToEdit);
                    break;
                }
            }
            writer.write(entityData_Arr.toString(4));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isEntityIDExist(String id) {
        int length = entityData_Arr.length();
        int idNumber = Integer.parseInt(id.substring(1, id.length()));
        if ((idNumber <= length) && id.charAt(0) == baseId.charAt(0) && baseId.length() == id.length()) return true;
        else return false;
    }
}