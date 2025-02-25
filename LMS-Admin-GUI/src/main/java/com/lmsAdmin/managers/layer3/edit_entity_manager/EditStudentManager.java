package main.java.com.lmsAdmin.managers.layer3.edit_entity_manager;

import org.json.JSONObject;

import java.util.ArrayList;

public class EditStudentManager extends EditEntityManager {

    public EditStudentManager(String idToEdit) {
        super(idToEdit);
        setFilePath("shared/data/student.json");
        this.baseId = "S000000";
        setIdToEdit(idToEdit);
        loadEntityDataToEdit();
    }

    public EditStudentManager() {
        setFilePath("shared/data/student.json");
        this.baseId = "S000000";
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

    public String getOldFirstName() {
        return this.entityDataToEdit.getJSONObject("name").getString("firstname");
    }

    public String getOldLastName() {
        return this.entityDataToEdit.getJSONObject("name").getString("lastname");
    }

    public String getOldGuardianFirstName() {
        return this.entityDataToEdit.getJSONObject("guardian").getJSONObject("name").getString("firstName");
    }

    public String getOldGuardianLastName() {
        return this.entityDataToEdit.getJSONObject("guardian").getJSONObject("name").getString("lastName");
    }

    public String getOldGuardianGender() {
        return this.entityDataToEdit.getJSONObject("guardian").getString("gender");
    }

    public String getOldGuardianPhone() {
        return this.entityDataToEdit.getJSONObject("guardian").getString("phone");
    }

    public void manageEditAddress(JSONObject newAddress) {
        this.entityDataToEdit.put("address", newAddress);
        saveEntityData();
    }

    public void manageEditGender(String newGender) {
        this.entityDataToEdit.put("gender", newGender);
        saveEntityData();
    }

    public void manageEditDOB(String newDoB) {
        this.entityDataToEdit.put("dob", newDoB);
        saveEntityData();
    }

    public void manageEditDepartment(String newDepartment) {
        this.entityDataToEdit.put("department", newDepartment);
        saveEntityData();
    }

    public void manageEditName(JSONObject newName) {
        this.entityDataToEdit.put("name", newName);
        saveEntityData();
    }

    public void manageEditPhone(String newPhone) {
        this.entityDataToEdit.put("phoneNumber", newPhone);
        saveEntityData();
    }

    public void manageEditPassword(String newPassword) {
        this.entityDataToEdit.put("password", newPassword);
        saveEntityData();
    }

    public void manageEditSpecialization(String newSpecialization) {
        this.entityDataToEdit.put("specialization", newSpecialization);
        saveEntityData();
    }

    public void manageEditGuardian(JSONObject newGuardian) {
        this.entityDataToEdit.put("guardian", newGuardian);
        saveEntityData();
    }

    public boolean isOldPasswordMatched(String oldPassword) {
        return this.entityDataToEdit.getString("password").equals(oldPassword);
    }

    public ArrayList<String> loadIds() {
        ArrayList<String> ids = new ArrayList<>();
        for (int i = 0; i < this.entityData_Arr.length(); i++) {
            ids.add(this.entityData_Arr.getJSONObject(i).getString("id"));
        }
        return ids;
    }

    public String getOldCommune() {
        return this.entityDataToEdit.getJSONObject("address").getString("commune");
    }

    public String getOldDistrict() {
        return this.entityDataToEdit.getJSONObject("address").getString("district");
    }

    public String getOldProvince() {
        return this.entityDataToEdit.getJSONObject("address").getString("province");
    }
}