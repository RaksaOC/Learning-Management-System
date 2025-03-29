package main.java.com.lms.managers.teacherSide;

import main.AppSession;
import main.DatabaseConnection;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;

public class ResourceManager extends ClassroomContentManager {
    private Connection conn = DatabaseConnection.getInstance().getConnection();

    public ResourceManager(String classIdToEdit) {
        super(classIdToEdit);
    }

    // ========================================
    // SQL-RELATED METHODS
    // ========================================

    // TODO: sql equivalent methods goes here, method name should have the same name but with Sql at the end. Ex: manageDoQuiz -> manageDoQuizSql

    public void manageAddMaterial(String title, String description, String ref_attachment) {
        // Insert into material table
        String query = "INSERT INTO material (id, title, description, status, ref_attachment) VALUES (?, ?, ?, ?, ?)";
        String id = generateMaterialIdSql("R0000");
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, id);
            statement.setString(2, title);
            statement.setString(3, description);
            statement.setString(4, "active");
            statement.setString(5, ref_attachment);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

// Insert into classroom_material (associating material with a classroom)
        String query2 = "INSERT INTO classroom_material (class_id, material_id) VALUES (?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(query2)) {
            statement.setString(1, AppSession.getInstance().getSelectedClassroom());
            statement.setString(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

// Insert into progress_material for students in the selected classroom
        String query3 = "INSERT INTO progress_material (progress_id, material_id, status) " +
                "SELECT id, ?, 'active' FROM progress WHERE classroom_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query3)) {
            statement.setString(1, id); // material_id
            statement.setString(2, AppSession.getInstance().getSelectedClassroom()); // classroom_id for WHERE clause
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void manageEditMaterialSql(String newTitle, String newDescription, String ref_attachment) {
        String query = "UPDATE material SET title = ?, description = ?, ref_attachment = ? WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, newTitle);
            statement.setString(2, newDescription);
            statement.setString(3, ref_attachment);
            statement.setString(4, AppSession.getInstance().getSelectedResources());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void manageDeleteMaterialSql() {
        String query = "UPDATE material SET status = ? WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, "inactive"); // Set status
            statement.setString(2, AppSession.getInstance().getSelectedResources());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(); // Replace with a logger in production
        }

        String query2 = "DELETE FROM classroom_material WHERE material_id = ?";
        try(PreparedStatement statement = conn.prepareStatement(query2)){
            statement.setString(1, AppSession.getInstance().getSelectedResources());
            statement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }

        String query3 = "DELETE FROM progress_material WHERE progress_id = ?";
        try(PreparedStatement statement = conn.prepareStatement(query3)){
            statement.setString(1, AppSession.getInstance().getSelectedResources());
            statement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getResourceTitle() {
        String query = "SELECT title FROM material WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, AppSession.getInstance().getSelectedResources());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("title");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getResourceDescription() {
        String query = "SELECT description FROM material WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, AppSession.getInstance().getSelectedAssignment());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return rs.getString("description");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getRef() {
        String query = "SELECT m.ref_attachment FROM material as m WHERE m.id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, AppSession.getInstance().getSelectedResources());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return rs.getString("ref_attachment");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String generateMaterialIdSql(String baseId) {
        String query = "SELECT count(*) FROM material";
        int objects = 0; // Default to 0 if query fails
        try (PreparedStatement statement = conn.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                objects = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        objects++; // Increment to get the next available ID
        // Extract number part (e.g., "000" from "A000")
        String numberPart = baseId.replaceAll("[^0-9]", "");
        int numberLength = numberPart.length();
        // Format number with leading zeros
        String formattedNumber = String.format("%0" + numberLength + "d", objects);
        // Extract the prefix (non-numeric part, e.g., "A" from "A000")
        String prefixChar = baseId.replaceAll("[0-9]", "");
        return prefixChar + formattedNumber;
    }

    public ArrayList<String> getClassroomMaterialsSql() {
        ArrayList<String> materials = new ArrayList<>();
        String query = "SELECT CONCAT(m.id, ' - ', m.title) AS id_name " +
                "FROM classroom_material AS cm " +
                "JOIN material AS m ON cm.material_id = m.id " +
                "WHERE cm.class_id = ?";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, AppSession.getInstance().getSelectedClassroom());
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                materials.add(rs.getString("id_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return materials;
    }

    // ========================================
    // JSON-RELATED METHODS
    // ========================================
    // load all resource

    private JSONArray loadResource() {
        try {
            String contents = new String(Files.readAllBytes(Paths.get("shared/data/resource.json")));
            JSONArray allResource = new JSONArray(contents);
            return allResource;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Resource Manager
    public void manageAddResource(int selectedWeek, String title, String description) {
//        int selectedWeek = Integer.parseInt(selectWeek()) - 1;
//        String title = Menu.prompt("Enter Resource Title: ");
//        String description = Menu.prompt("Enter Resource Description: ");

        JSONArray resources = new JSONArray();
        JSONObject resourceObject = new JSONObject();
        String resourceId = idGenerator(loadResource(), "R0000");
        resourceObject.put("resourceId", resourceId);
        resourceObject.put("status", "active");
        JSONArray allWeekResource = new JSONArray();
        JSONObject week = new JSONObject();
        String weekId = idGenerator(loadResource(), "Week00");
        week.put("id", weekId);
        JSONArray contents = new JSONArray();
        JSONObject content = new JSONObject();
        JSONArray weekResources = getAllResource();
        JSONArray aWeekContents = null;
        for (int i = 0; i < weekResources.length(); i++) {
            if (i == selectedWeek) {
                aWeekContents = weekResources.getJSONObject(i).getJSONArray("contents");
                break;
            }
        }
        String contentId = idGenerator(aWeekContents, "C0000");
        content.put("id", contentId);
        content.put("title", title);
        content.put("description", description);
        content.put("status", "active");

    }

    public void manageEditResource() {

    }

    public void manageDeleteResource() {

    }

    public void manageViewResource() {

    }

    // display each week and select and input
//    private String selectWeek() {
//        for (int i = 0; i < 10; i++) {
//            System.out.println("Week0" + i+1);
//        }
//        return Menu.prompt("Select a Week: ");
//    }

    // get Resource array (all weeks) from resource.json only
    private JSONArray getAllResource() {
        JSONArray allResource = loadResource();
        String classroomId = getClassroomId();
        for (int i = 0; i < allResource.length(); i++) {
            if (classroomId.equals(allResource.getJSONObject(i).getString("classroomId"))) {
                return allResource.getJSONObject(i).getJSONArray("resources");
            }
        }
        return null;
    }
}