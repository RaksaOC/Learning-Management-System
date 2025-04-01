package main.java.com.lmsAdmin.managers.layer3.edit_entity_manager;

import main.DatabaseConnection;
import org.json.JSONObject;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EditTeacherManager extends EditEntityManager {

    public EditTeacherManager(String idToEdit) {
        super(idToEdit);
        setIdToEdit(idToEdit); // this is for getting the entityDataToEdit
    }

    public EditTeacherManager() {
    }

    public void manageEditDOB(String newDoB) {
        String query = "UPDATE teacher SET dob = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newDoB);
            stmt.setString(2, idToEdit);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void manageEditEmail(String newEmail) {
        String query = "UPDATE teacher SET email = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newEmail);
            stmt.setString(2, idToEdit);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void manageEditGender(String newGender) {
        String query = "UPDATE teacher SET gender = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newGender);
            stmt.setString(2, idToEdit);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void manageEditName(String firstName, String lastName) {
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

    public void manageEditPassword(String newPassword) {
        String query = "UPDATE teacher SET password = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newPassword);
            stmt.setString(2, idToEdit);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void manageEditPhone(String newPhone) {
        String query = "UPDATE teacher SET phone_number = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newPhone);
            stmt.setString(2, idToEdit);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> loadIdsAndName() {
        ArrayList<String> ids = new ArrayList<>();
        String query = "SELECT id, CONCAT(first_name, ' ', last_name ) as name FROM teacher";
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

    public String getOldPhone() {
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

    public String getOldEmail() {
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

    public String getOldGender() {
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

    public String getOldDOB() {
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

    public String getOldFirstName() {
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

    public String getOldLastName() {
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

    public boolean isOldPasswordMatched(String oldPassword) {
        String query = "SELECT password FROM teacher WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("password").equals(oldPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}