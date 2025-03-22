package main.java.com.lmsAdmin.managers.layer3.edit_entity_manager;

import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EditDepartmentManager extends EditEntityManager {

    public EditDepartmentManager(String idToEdit) {
        super(idToEdit);
        setIdToEdit(idToEdit);
    }

    public EditDepartmentManager() {
    }

    public String getOldId() {
        String query = "SELECT id FROM department WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getOldName() {
        String query = "SELECT name FROM department WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void manageEditId(String newID) {
        String query = "UPDATE department SET id=? WHERE id=?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, newID);
            statement.setString(2, idToEdit);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void manageEditName(String newName) {
        String query = "UPDATE department SET name=? WHERE id=?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, newName);
            statement.setString(2, idToEdit);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> loadIdsAndName() {
        ArrayList<String> idsAndName = new ArrayList<>();
        String query = "SELECT id, name FROM department";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.execute();
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                idsAndName.add(resultSet.getString("id") + " - " + resultSet.getString("name"));
            }
            Collections.sort(idsAndName, Comparator.comparing(s -> s.substring(s.indexOf("-" ) + 2)));
            return idsAndName;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idsAndName;
    }
}