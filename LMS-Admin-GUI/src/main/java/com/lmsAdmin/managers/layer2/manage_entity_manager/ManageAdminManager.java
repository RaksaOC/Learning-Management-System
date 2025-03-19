
package main.java.com.lmsAdmin.managers.layer2.manage_entity_manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import main.DatabaseConnection;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ManageAdminManager extends ManageEntityManager {
    private final Connection conn = DatabaseConnection.getInstance().getConnection();

    public ManageAdminManager() {
        setEntityFilePath("shared/data/admin.json");
        loadEntity();
        this.baseID = "A000";
    }

    public void manageAddEntitySQL(String first_name,
                                   String last_name,
                                   String created_at,
                                   String last_login,
                                   String password,
                                   String phone_number,
                                   String gender,
                                   String dob,
                                   String email,
                                   String status) {


        String addAdminQuery = "INSERT INTO admin (id, first_name, last_name, created_at, last_login, password, " +
                "phone_number, gender, dob, email, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(addAdminQuery)) {
            stmt.setString(1, generateNewID());
            stmt.setString(2, first_name);
            stmt.setString(3, last_name);
            stmt.setTimestamp(4, Timestamp.valueOf(created_at)); // Convert string to Timestamp
            stmt.setNull(5, java.sql.Types.TIMESTAMP);
            stmt.setString(6, password);
            stmt.setString(7, phone_number);
            stmt.setString(8, gender);
            stmt.setString(9, dob);
            stmt.setString(10, email);
            stmt.setString(11, status);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Entity added successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void manageDeleteEntitySQL(String idToDelete) {
        String deleteAdminQuery = "UPDATE admin SET status = ? WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(deleteAdminQuery)) {
            statement.setString(1, "inactive");
            statement.setString(2, idToDelete);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Entity deleted successfully with sql!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Map<String, String>> getAllDetailsSQL(){
        ObservableList<Map<String, String>> data = FXCollections.observableArrayList();
        String viewAdminQuery = "SELECT * FROM admin";

        try (PreparedStatement stmt = conn.prepareStatement(viewAdminQuery)) {
            ResultSet resultSet = stmt.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                Map<String, String> row = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);  // Get column name
                    row.put(columnName, resultSet.getString(i));    // Map column name to value
                }
                data.add(row);  // Add the map (row) to the list
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }


    public JSONObject getDetails(String id) {
        for (int i = 0; i < entityData_Arr.length(); i++) {
            if (entityData_Arr.getJSONObject(i).getString("id").equals(id)) {
                return entityData_Arr.getJSONObject(i);
            }
        }
        return null;
    }

    public Map<String, String> getDetailsSQL(String id) {
        Map<String, String> data = new HashMap<>();

        String getAdminQuery = "SELECT * FROM admin WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(getAdminQuery)) {
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    data.put(metaData.getColumnName(i), resultSet.getString(i));
                }
            }
            return data;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public JSONArray getAllDetails() {
        return entityData_Arr;
    }


}