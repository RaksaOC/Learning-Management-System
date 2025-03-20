package main.java.com.lmsAdmin.managers.layer3.edit_entity_manager;

//interface EditInterface {
//    void setFilePath(String filePath);
//
//    void loadEntityDataToEdit();
//
//    void saveEntityData();
//
//    void setIdToEdit(String idToEdit);
//
//    String getOldName();
//
//    String getOldPhone();
//
//    String getOldEmail();
//
//    String getOldPassword();
//
//    boolean isEntityIDExist(String entityID);
//
//    void setNewName(JSONObject newName);
//
//    void setNewPhone(String newPhone);
//
//    void setNewEmail(String newEmail);
//
//    void setNewPassword(String newPassword);
//}

import main.DatabaseConnection;

import java.sql.Connection;

public class EditEntityManager{
    protected Connection conn = DatabaseConnection.getInstance().getConnection();
    protected String idToEdit;

    public EditEntityManager() {}
    public EditEntityManager(String id) {
    }

    public void setIdToEdit(String idToEdit) {
        this.idToEdit = idToEdit;
    }
}