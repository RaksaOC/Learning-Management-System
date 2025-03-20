package main.java.com.lmsAdmin.managers.layer3.edit_entity_manager;

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

    public EditAdminManager(String idToEdit) {
        super(idToEdit);
        setIdToEdit(idToEdit);
    }

    public EditAdminManager() {
        super();
    }

    // Field Editing ---------------------------------------------------------------

    public void manageEditDOB(String newDob) {
        String query = "UPDATE admin SET dob=? WHERE id=?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, newDob);
            statement.setString(2, idToEdit);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void manageEditName(String fName, String lName) {
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

    public void manageEditEmail(String newEmail) {
        String query = "UPDATE admin SET email=? WHERE id=?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, newEmail);
            statement.setString(2, idToEdit);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void manageEditGender(String newGender) {
        String query = "UPDATE admin SET gender=? WHERE id=?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, newGender);
            statement.setString(2, idToEdit);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void manageEditPhone(String newPhone) {
        String query = "UPDATE admin SET phone_number=? WHERE id=?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, newPhone);
            statement.setString(2, idToEdit);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void manageEditPassword(String newPas) {
        String query = "UPDATE admin SET password=? WHERE id=?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, Hasher.hash(newPas)); // Hashing the password before updating
            statement.setString(2, idToEdit);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //  ------------------------------------------------------------------------------------------------

    public ArrayList<String> loadIdsAndName() {
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

    // get current fields -------------------------------------------------------------------------------

    public String getOldFirstName() {
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

    public String getOldLastName() {
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

    public String getOldDob() {
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

    public String getOldName() {
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

    public String getOldEmail() {
        String query = "SELECT email FROM admin WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("email");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getOldGender() {
        String query = "SELECT gender FROM admin WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("gender");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getOldPhone() {
        String query = "SELECT phone_number FROM admin WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("phone_number");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // ---------------------------------------------------------------------------------------------------------

    public boolean isOldPasswordMatched(String oldPassword) {
        String query = "SELECT password FROM admin WHERE id = ?";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getString("password").equals(oldPassword);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}