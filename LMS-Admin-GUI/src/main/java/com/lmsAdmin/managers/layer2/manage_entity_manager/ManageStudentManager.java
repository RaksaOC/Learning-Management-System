package main.java.com.lmsAdmin.managers.layer2.manage_entity_manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lib.Hasher;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ManageStudentManager extends ManageEntityManager {

    public ManageStudentManager() {
        this.baseID = "S000000";
    }

    public void manageAddStudent(String first_name,
                                 String last_name,
                                 String gender,
                                 String dob,
                                 String phone_number,
                                 String email,
                                 String password,
                                 String commune,
                                 String district,
                                 String province,
                                 String status,
                                 String created_at,
                                 String last_login,
                                 String department_id,
                                 String specialization_id,
                                 String generation_id,
                                 String guardian_first_name,
                                 String guardian_last_name,
                                 String guardian_phone_number,
                                 String guardian_gender) {
        String query = "INSERT INTO student (id, first_name, last_name, gender, dob, phone_number, email, password, commune, district, province, status, " +
                "created_at, last_login, department_id, specialization_id, generation_id, " +
                "guardian_first_name, guardian_last_name, guardian_phone_number, guardian_gender) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, generateNewID("student"));
            statement.setString(2, first_name);
            statement.setString(3, last_name);
            statement.setString(4, gender);
            statement.setString(5, dob);
            statement.setString(6, phone_number);
            statement.setString(7, email);
            statement.setString(8, Hasher.hash(password));
            statement.setString(9, commune);
            statement.setString(10, district);
            statement.setString(11, province);
            statement.setString(12, status);
            statement.setTimestamp(13, Timestamp.valueOf(created_at));
            statement.setNull(14, java.sql.Types.TIMESTAMP);
            statement.setString(15, department_id);
            statement.setString(16, specialization_id);
            statement.setString(17, generation_id);
            statement.setString(18, guardian_first_name);
            statement.setString(19, guardian_last_name);
            statement.setString(20, guardian_phone_number);
            statement.setString(21, guardian_gender);

            statement.executeUpdate();
            System.out.println("Student added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void manageDeleteStudent(String id) {
        System.out.println("id to delete: " + id);
        String query = "UPDATE student SET status = ? WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, "inactive");
            statement.setString(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Map<String, String>> getAllStudentDetails() {
        ObservableList<Map<String, String>> data = FXCollections.observableArrayList();
        String query = "SELECT * FROM student";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Map<String, String> map = new HashMap<>();
                map.put("id", rs.getString("id"));
                map.put("first_name", rs.getString("first_name"));
                map.put("last_name", rs.getString("last_name"));
                map.put("gender", rs.getString("gender"));
                map.put("dob", rs.getString("dob"));
                map.put("phone_number", rs.getString("phone_number"));
                map.put("email", rs.getString("email"));
                map.put("password", rs.getString("password"));
                map.put("commune", rs.getString("commune"));
                map.put("district", rs.getString("district"));
                map.put("province", rs.getString("province"));
                map.put("status", rs.getString("status"));
                map.put("created_at", rs.getString("created_at"));
                map.put("last_login", rs.getString("last_login"));
                map.put("department_id", rs.getString("department_id"));
                map.put("specialization_id", rs.getString("specialization_id"));
                map.put("generation_id", rs.getString("generation_id"));
                map.put("guardian_first_name", rs.getString("guardian_first_name"));
                map.put("guardian_last_name", rs.getString("guardian_last_name"));
                map.put("guardian_phone_number", rs.getString("guardian_phone_number"));
                map.put("guardian_gender", rs.getString("guardian_gender"));
                data.add(map);
            }
            return data;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public Map<String, String> getStudentDetails(String id) {
        String query = "SELECT * FROM student WHERE id = ?";
        Map<String, String> map = new HashMap<>();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                map.put("id", rs.getString("id"));
                map.put("first_name", rs.getString("first_name"));
                map.put("last_name", rs.getString("last_name"));
                map.put("gender", rs.getString("gender"));
                map.put("dob", rs.getString("dob"));
                map.put("phone_number", rs.getString("phone_number"));
                map.put("email", rs.getString("email"));
                map.put("password", rs.getString("password"));
                map.put("commune", rs.getString("commune"));
                map.put("district", rs.getString("district"));
                map.put("province", rs.getString("province"));
                map.put("status", rs.getString("status"));
                map.put("created_at", rs.getString("created_at"));
                map.put("last_login", rs.getString("last_login"));
                map.put("department_id", rs.getString("department_id"));
                map.put("specialization_id", rs.getString("specialization_id"));
                map.put("generation_id", rs.getString("generation_id"));
                map.put("guardian_first_name", rs.getString("guardian_first_name"));
                map.put("guardian_last_name", rs.getString("guardian_last_name"));
                map.put("guardian_phone_number", rs.getString("guardian_phone_number"));
                map.put("guardian_gender", rs.getString("guardian_gender"));
            }
            return map;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    public boolean isEmailTaken(String email) {
        String query = "SELECT * FROM student WHERE email = ?";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            return rs.next();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
