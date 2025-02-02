package utils.manager.edit_entity_manager;

public class EditTeacherManager extends EditEntityManager {
    public EditTeacherManager(String idToEdit) {
        super(idToEdit);
        setFilePath("shared/data/teacher.json");
        this.baseId = "T000000";
        setEntityID(idToEdit); // this is for getting the entityDataToEdit
        getEntityData();
    }

    public String getOldGender() {
        return this.entityDataToEdit.getString("gender");
    }

    public String getOldDoB() {
        return this.entityDataToEdit.getString("dob");
    }

    public void setNewGender(String newGender) {
        this.entityDataToEdit.put("gender", newGender);
        saveEntityData();
    }

    public void setNewDoB(String newDoB) {
        this.entityDataToEdit.put("dob", newDoB);
        saveEntityData();
    }
}