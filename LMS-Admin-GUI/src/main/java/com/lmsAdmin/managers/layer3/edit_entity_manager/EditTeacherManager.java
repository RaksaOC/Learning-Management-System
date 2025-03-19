package main.java.com.lmsAdmin.managers.layer3.edit_entity_manager;

import main.DatabaseConnection;
import org.json.JSONObject;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EditTeacherManager extends EditEntityManager {
    private Connection conn = DatabaseConnection.getInstance().getConnection();

    public EditTeacherManager(String idToEdit) {
        super(idToEdit);
        setFilePath("shared/data/teacher.json");
        this.baseId = "T000000";
        setIdToEdit(idToEdit); // this is for getting the entityDataToEdit
        loadEntityDataToEdit();
    }

    public EditTeacherManager() {
        setFilePath("shared/data/teacher.json");
        this.baseId = "T000000";
        setIdToEdit("T000000");
        loadEntityDataToEdit();
    }

    public String getOldPhoneSql(){
        String query = "SELECT phone_number FROM teacher WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, idToEdit);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("phone_number");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getOldEmailSql(){
        String query = "SELECT email FROM teacher WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, idToEdit);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("email");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getOldGenderSql() {
        String query = "SELECT gender FROM teacher WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, idToEdit);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("gender");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getOldDOBSql() {
        String query = "SELECT dob FROM teacher WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, idToEdit);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("dob");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getOldFirstNameSql() {
        String query = "SELECT first_name FROM teacher WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, idToEdit);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("first_name");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getOldLastNameSql() {
        String query = "SELECT last_name FROM teacher WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, idToEdit);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("last_name");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public String getOldGender() {
        return this.entityDataToEdit.getString("gender");
    }

    public String getOldDOB() {
        return this.entityDataToEdit.getString("dob");
    }

    public String getOldFirstName() {
        return this.entityDataToEdit.getJSONObject("name").getString("firstname");
    }

    public String getOldLastName() {
        return this.entityDataToEdit.getJSONObject("name").getString("lastname");
    }


    public void manageEditDOBSql(String newDoB) {
        String query = "UPDATE teacher SET dob = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newDoB);
            stmt.setString(2, idToEdit);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void manageEditEmailSql(String newEmail) {
        String query = "UPDATE teacher SET email = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newEmail);
            stmt.setString(2, idToEdit);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void manageEditGenderSql(String newGender) {
        String query = "UPDATE teacher SET gender = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newGender);
            stmt.setString(2, idToEdit);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void manageEditNameSql(String firstName, String lastName) {
        String query = "UPDATE teacher SET first_name = ?, last_name = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, idToEdit);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void manageEditPasswordSql(String newPassword) {
        String query = "UPDATE teacher SET password = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newPassword);
            stmt.setString(2, idToEdit);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void manageEditPhoneSql(String newPhone) {
        String query = "UPDATE teacher SET phone_number = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newPhone);
            stmt.setString(2, idToEdit);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void manageEditDOB(String newDoB) {
        this.entityDataToEdit.put("dob", newDoB);
        saveEntityData();
    }

    public void manageEditEmail(String newEmail) {
        this.entityDataToEdit.put("email", newEmail);
        saveEntityData();
    }

    public void manageEditGender(String newGender) {
        this.entityDataToEdit.put("gender", newGender);
        saveEntityData();
    }

    public void manageEditName(String firstName, String lastName) {
        JSONObject newName = new JSONObject();
        newName.put("firstname", firstName);
        newName.put("lastname", lastName);

        this.entityDataToEdit.put("name", newName);
    }

    public boolean isOldPasswordMatched(String oldPassword) {
        return this.entityDataToEdit.getString("password").equals(oldPassword);
    }

    public void manageEditPassword(String newPassword) {
        this.entityDataToEdit.put("password", newPassword);
        saveEntityData();
    }

    public void manageEditPhone(String newPhone) {
        this.entityDataToEdit.put("phone", newPhone);
        saveEntityData();
    }

    public ArrayList<String> loadIdsAndNameJSON() {
        ArrayList<String> ids = new ArrayList<>();
        for (int i = 0; i < entityData_Arr.length(); i++) {
            ids.add(entityData_Arr.getJSONObject(i).getString("id") + entityData_Arr.getJSONObject(i).getJSONObject("name").getString("firstName") + entityData_Arr.getJSONObject(i).getJSONObject("name").getString("lastName"));
        }
        return ids;
    }

    public ArrayList<String> loadIdsAndNameSql() {
        ArrayList<String> ids = new ArrayList<>();
        String query = "SELECT id, CONCAT(first_name, last_name ) as name FROM teacher";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                ids.add(rs.getString("id") + " - " + rs.getString("name"));
            }
            return ids;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}