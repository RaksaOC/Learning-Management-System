package utils.manager.edit_entity_manager;

import org.json.JSONArray;

interface EditInterface{
    void setFilePath(String filePath);

    void getEntityData();
    void saveEntityData();

    void setEntityID(String entityID);
    String getOldName();
    String getOldPhone();
    String getOldEmail();
    String getOldPassword();
    boolean isEntityIDExist(String entityID);

    void setNewName(String newName);
    void setNewPhone(String newPhone);
    void setNewEmail(String newEmail);
    void setNewPassword(String newPassword);
}

public abstract class EditEntityManager implements EditInterface{
    protected String entityID;
    protected String content;
    protected JSONArray entityData;
    protected String filePath;

    public EditEntityManager(String id) {}

    public abstract void saveEntityData();

    public abstract void setFilePath(String filePath);
    public abstract void setEntityID(String entityID);
    public abstract void getEntityData();
    public abstract String getOldName();
    public abstract String getOldPhone();
    public abstract String getOldEmail();
    public abstract String getOldPassword();
    public abstract boolean isEntityIDExist(String entityID);

    public abstract void setNewName(String newName);
    public abstract void setNewPhone(String newPhone);
    public abstract void setNewEmail(String newEmail);
    public abstract void setNewPassword(String newPassword);
}