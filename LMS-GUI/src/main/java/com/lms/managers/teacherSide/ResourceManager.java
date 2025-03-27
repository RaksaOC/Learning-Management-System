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

    private void manageEditMaterialSql(String id, String title, String description, String deadline, String ref_attachment) {
        // Check if the assignment ID exists
        String checkQuery = "SELECT COUNT(*) FROM material WHERE id = ?";
        try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
            checkStmt.setString(1, id);
            checkStmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        // Update the assignment
        String query = "UPDATE material SET title = ?, description = ?, deadline = ?, ref_attachment = ? WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, title);
            statement.setString(2, description);
            statement.setString(3, deadline);
            statement.setString(4, ref_attachment);
            statement.setString(5, id); // Ensure ID is set in the WHERE clause
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void manageDeleteMaterialSql(String id) {
        String query = "UPDATE material SET status = ? WHERE id = ?";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, "inactive"); // Set status
            statement.setString(2, id); // Bind ID parameter
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(); // Replace with a logger in production
        }
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