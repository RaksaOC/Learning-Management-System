package main.java.com.lmsadmin.managers.layer3.edit_entity_manager;

import lib.Hasher;

import java.util.ArrayList;

public class EditAdminManager extends EditEntityManager {

    public EditAdminManager(String idToEdit) {
        super(idToEdit);
        setFilePath("shared/data/admin.json");
        this.baseId = "A000";
        setIdToEdit(idToEdit);
        loadEntityDataToEdit();
    }

    public EditAdminManager() {
        super();
        setFilePath("shared/data/admin.json");
        loadEntityDataToEdit(); // this would load the entire file too
    }

    // Make changes to file -------------------------------------------------------------------------

    public void manageEditDOB(String newDob){
        entityDataToEdit.put("dob", newDob);
        saveEntityData();
    }

    public void manageEditEmail(String newEmail){
        entityDataToEdit.put("email", newEmail);
        saveEntityData();
    }

    public void manageEditGender(String newGender){
        entityDataToEdit.put("gender", newGender);
        saveEntityData();
    }

    public void manageEditName(String fName, String lName){
        entityDataToEdit.getJSONObject("name").put("fName", fName);
        entityDataToEdit.getJSONObject("name").put("lName", lName);
        saveEntityData();
    }

    public boolean isOldPasswordMatched(String oldPas){
        return entityDataToEdit.getString("password").equals(Hasher.hash(oldPas));
    }

    public void manageEditPassword(String newPas){
        entityDataToEdit.put("password", Hasher.hash(newPas));
    }

    public void manageEditPhone(String newPhone){
        entityDataToEdit.put("phone", newPhone);
    }



    // -------------------------------------------------------------------------------------------------------------

    // Get Old Data ------------------------------------------------------------------------------------------------
    public String getOldDOB(){
        return entityDataToEdit.getString("dob");
    }

    public String getOldGender(){
        return entityDataToEdit.getString("gender");
    }

    public String getOldEmail(){
        return entityDataToEdit.getString("email");
    }

    public String getOldFirstName(){
        return entityDataToEdit.getJSONObject("name").getString("firstName");
    }
    public String getOldLastName(){
        return entityDataToEdit.getJSONObject("name").getString("lastName");
    }
    public String getOldPhone(){
        return entityDataToEdit.getString("phoneNumber");
    }

    //  ------------------------------------------------------------------------------------------------

    // Load ID ------------------------------------------------------------------------------------------------
    public ArrayList<String> loadIds(){
        ArrayList<String> ids = new ArrayList<>();
        for (int i = 0; i < entityData_Arr.length(); i++){
            ids.add(entityData_Arr.getJSONObject(i).getString("id"));
        }
        return ids;
    }
    // ---------------------------------------------------------------------------------------------------------

}