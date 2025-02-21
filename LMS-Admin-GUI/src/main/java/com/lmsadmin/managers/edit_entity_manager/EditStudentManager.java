package main.java.com.lmsadmin.managers.edit_entity_manager;

import org.json.JSONObject;

public class EditStudentManager extends EditEntityManager {

    public EditStudentManager(String idToEdit) {
        super(idToEdit);
        setFilePath("shared/data/student.json");
        this.baseId = "S000000";
        setIdToEdit(idToEdit);
        loadEntityDataToEdit();
    }

    public String getOldAddress() {
        JSONObject oldAddress = this.entityDataToEdit.getJSONObject("address");
        return "District: " + oldAddress.getString("district") + "Province: " + oldAddress.getString("province");
    }

    public String getOldGender() {
        return this.entityDataToEdit.getString("gender");
    }

    public String getOldDoB() {
        return this.entityDataToEdit.getString("dob");
    }

    public String getOldDepartment() {
        return this.entityDataToEdit.getString("department");
    }

    public String getOldSpecialization() {
        return this.entityDataToEdit.getString("specialization");
    }

    public String getOldGuardian() {
        JSONObject guardian = this.entityDataToEdit.getJSONObject("guardian");
        return "Guardian: " + guardian.getString("name") + "Gender: " + guardian.getString("gender") + "Phone: " + guardian.getString("phone");
    }

    public void setNewAddress(JSONObject newAddress) {
        this.entityDataToEdit.put("address", newAddress);
        saveEntityData();
    }

    public void setNewGender(String newGender) {
        this.entityDataToEdit.put("gender", newGender);
        saveEntityData();
    }

    public void setNewDoB(String newDoB) {
        this.entityDataToEdit.put("dob", newDoB);
        saveEntityData();
    }

    public void setNewDepartment(String newDepartment) {
        this.entityDataToEdit.put("department", newDepartment);
        saveEntityData();
    }

    public void setNewSpecialization(String newSpecialization) {
        this.entityDataToEdit.put("specialization", newSpecialization);
        saveEntityData();
    }

    public void setNewGuardian(JSONObject newGuardian) {
        this.entityDataToEdit.put("guardian", newGuardian);
        saveEntityData();
    }
}