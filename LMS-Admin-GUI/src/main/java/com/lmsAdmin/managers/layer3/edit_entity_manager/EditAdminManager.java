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

    public String getOldFirstNameSql() {
        String query = "SELECT first_name FROM admin WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("first_name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getOldLastNameSql() {
        String query = "SELECT last_name FROM admin WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("last_name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public String getOldDobSql() {
        String query = "SELECT dob FROM admin WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("dob");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getOldNameSql() {
        String query = "SELECT CONCAT(first_name, last_name) AS name FROM admin WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  // Return null if no result
    }

    public String getOldEmailSql() {
        String query = "SELECT email FROM admin WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("email");  // Return the current email
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  // Return null if no result
    }

    public String getOldGenderSql() {
        String query = "SELECT gender FROM admin WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("gender");  // Return the current gender
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  // Return null if no result
    }

    public String getOldPhoneSql() {
        String query = "SELECT phone_number FROM admin WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("phone_number");  // Return the current phone number
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  // Return null if no result
    }

    public void manageEditDOBSql(String newDob) {
        String query = "UPDATE admin SET dob=? WHERE id=?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, newDob);
            statement.setString(2, idToEdit);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void manageEditNameSql(String fName, String lName) {
        String query = "UPDATE admin SET first_name=?, last_name=? WHERE id=?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, fName);
            statement.setString(2, lName);
            statement.setString(3, idToEdit);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void manageEditEmailSql(String newEmail) {
        String query = "UPDATE admin SET email=? WHERE id=?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, newEmail);
            statement.setString(2, idToEdit);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void manageEditGenderSql(String newGender) {
        String query = "UPDATE admin SET gender=? WHERE id=?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, newGender);
            statement.setString(2, idToEdit);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void manageEditPhoneSql(String newPhone) {
        String query = "UPDATE admin SET phone_number=? WHERE id=?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, newPhone);
            statement.setString(2, idToEdit);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void manageEditPasswordSql(String newPas) {
        String query = "UPDATE admin SET password=? WHERE id=?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, Hasher.hash(newPas)); // Hashing the password before updating
            statement.setString(2, idToEdit);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public boolean isOldPasswordMatchedSql(String oldPas) {
        String query = "SELECT password FROM admin WHERE id=?";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("password").equals(Hasher.hash(oldPas));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
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