package main.java.com.lmsAdmin.managers.layer3.edit_entity_manager;

import javafx.scene.control.TableView;
import lib.Hasher;
import main.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EditAdminManager extends EditEntityManager {
    Connection conn = DatabaseConnection.getInstance().getConnection();

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

    public void manageEditDOB(String newDob) {
        entityDataToEdit.put("dob", newDob);
        saveEntityData();
    }

    public void manageEditEmail(String newEmail) {
        entityDataToEdit.put("email", newEmail);
        saveEntityData();
    }

    public void manageEditGender(String newGender) {
        entityDataToEdit.put("gender", newGender);
        saveEntityData();
    }

    public void manageEditName(String fName, String lName) {
        entityDataToEdit.getJSONObject("name").put("fName", fName);
        entityDataToEdit.getJSONObject("name").put("lName", lName);
        saveEntityData();
    }

    public boolean isOldPasswordMatched(String oldPas) {
        return entityDataToEdit.getString("password").equals(Hasher.hash(oldPas));
    }

    public void manageEditPassword(String newPas) {
        entityDataToEdit.put("password", Hasher.hash(newPas));
    }

    public void manageEditPhone(String newPhone) {
        entityDataToEdit.put("phone", newPhone);
    }


    // -------------------------------------------------------------------------------------------------------------

    // Get Old Data ------------------------------------------------------------------------------------------------
    public String getOldDOB() {
        return entityDataToEdit.getString("dob");
    }

    public String getOldGender() {
        return entityDataToEdit.getString("gender");
    }

    public String getOldEmail() {
        return entityDataToEdit.getString("email");
    }

    public String getOldFirstName() {
        return entityDataToEdit.getJSONObject("name").getString("firstName");
    }

    public String getOldLastName() {
        return entityDataToEdit.getJSONObject("name").getString("lastName");
    }

    public String getOldPhone() {
        return entityDataToEdit.getString("phoneNumber");
    }

    //  ------------------------------------------------------------------------------------------------

    // Load ID ------------------------------------------------------------------------------------------------
    public ArrayList<String> loadIdsAndNameJSON() {
        ArrayList<String> ids = new ArrayList<>();
        for (int i = 0; i < entityData_Arr.length(); i++) {
            ids.add(entityData_Arr.getJSONObject(i).getString("id") + " - " + entityData_Arr.getJSONObject(i).getJSONObject("name").getString("firstName") + entityData_Arr.getJSONObject(i).getJSONObject("name").getString("lastName"));
        }
        return ids;
    }

    public ArrayList<String> loadIdsAndNameSQL() {
        ArrayList<String> idsAndName = new ArrayList<>();

        String getIdsAndNameQuery = "SELECT id, CONCAT(first_name, last_name) as name FROM admin";
        try (PreparedStatement statement = conn.prepareStatement(getIdsAndNameQuery)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                idsAndName.add(id + " - " + name);
                // sort by name
                Collections.sort(idsAndName, Comparator.comparing(s -> s.substring(s.indexOf("-") + 2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idsAndName;
    }

    // ---------------------------------------------------------------------------------------------------------

}