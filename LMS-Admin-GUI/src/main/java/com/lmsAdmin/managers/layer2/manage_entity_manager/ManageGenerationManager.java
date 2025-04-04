package main.java.com.lmsAdmin.managers.layer2.manage_entity_manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ManageGenerationManager extends ManageEntityManager {

    public ManageGenerationManager() {
        super();
    }

    public void manageAddGeneration(String id, String name, String status) {
        String query = "INSERT INTO generation(id, name, status) VALUES (?,?,?)";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, id);
            statement.setString(2, name);
            statement.setString(3, status);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void manageDeleteGeneration(String id) {
        // TODO: add deletion prevention logic
        String query = "UPDATE generation SET status = ? WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, "inactive");
            statement.setString(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Map<String, String>> getAllGenerationDetails() {
        ObservableList<Map<String, String>> data = FXCollections.observableArrayList();
        String query = "SELECT * FROM generation";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Map<String, String> map = new HashMap<>();
                map.put("id", rs.getString("id"));
                map.put("name", rs.getString("name"));
                map.put("status", rs.getString("status"));
                data.add(map);
            }
            return data;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public Map<String, String> getGenerationDetails(String id) {
        Map<String, String> map = new HashMap<>();
        String query = "SELECT * FROM generation WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                map.put("id", rs.getString("id"));
                map.put("name", rs.getString("name"));
                map.put("status", rs.getString("status"));
            }
            return map;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    public boolean isGenerationIdTaken(String id) {
        String query = "SELECT 1 FROM generation WHERE id = ? LIMIT 1";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();  // Returns true if at least one row exists
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isGenerationDeletable(String id) {
        String query = "SELECT COUNT(*) FROM student WHERE generation_id = ?";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1); // Get the count
                    return count == 0; // Deletable if no students exist
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Default to false in case of an exception
    }
}