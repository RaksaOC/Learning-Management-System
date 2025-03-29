package main.java.com.lms.managers.studentSide;

import entities.Student;
import main.AppSession;
import main.DatabaseConnection;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ResourcesManager {
    private Student student;
    private Connection conn;

    public ResourcesManager() {
        AppSession session = AppSession.getInstance();
        this.student = session.getStudent();
        this.conn = DatabaseConnection.getInstance().getConnection();
    }

    // ========================================
    // SQL-RELATED METHODS (TO BE IMPLEMENTED)
    // ========================================

    // TODO: sql equivalent methods goes here, method name should have the same name but with Sql at the end. Ex: manageDoQuiz -> manageDoQuizSql

    public void manageSubmitResource() {
        String query = "UPDATE progress_material pr " +
                "JOIN progress p ON pr.progress_id = p.id " +
                "SET pr.status = 'inactive' " +
                "WHERE p.student_id = ? and pr.material_id = ?";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, student.getId());
            statement.setString(2, AppSession.getInstance().getSelectedResources());
            statement.executeUpdate();
        } catch (SQLException e) {
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

    public Map<String, String> getAllResources() {
        Map<String, String> id_name_classroom = new HashMap<>();
        String query = "SELECT CONCAT(m.id, ' - ', m.title) AS id_name, " +
                "p.classroom_id as class_id " +
                "FROM progress_material as pm " +
                "JOIN progress AS p " +
                "ON pm.progress_id = p.id " +
                "JOIN material AS m " +
                "ON pm.material_id = m.id " +
                "WHERE p.student_id = ?  ";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, AppSession.getInstance().getStudent().getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                id_name_classroom.put(rs.getString("id_name"), rs.getString("class_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id_name_classroom;
    }

    public boolean isResourceSubmitted() {
        String query = "SELECT COUNT(*) AS count FROM progress_material AS pm " +
                "JOIN progress AS p ON pm.progress_id = p.id " +
                "WHERE p.student_id = ? AND pm.status = 'inactive'";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, AppSession.getInstance().getStudent().getId());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt("count") > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<String> getClassroomResources() {
        ArrayList<String> resources = new ArrayList<>();
        String query = "SELECT CONCAT(m.id, ' - ', m.title) AS id_name " +
                "FROM progress_material AS pm " +
                "JOIN progress AS p ON pm.progress_id = p.id " +
                "JOIN material AS m ON pm.material_id = m.id " +
                "WHERE p.classroom_id = ? AND p.student_id = ?";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, AppSession.getInstance().getSelectedClassroom());
            statement.setString(2, AppSession.getInstance().getStudent().getId());
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                resources.add(rs.getString("id_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resources;
    }


//    // Load resources from SQL database
//    public List<String> loadResourceSql(String classroomId) {
//        List<String> resourceWeeks = new ArrayList<>();
//        String query = "SELECT DISTINCT resourceWeek FROM resources WHERE classroomId = ?";
//
//        try (PreparedStatement stmt = connection.prepareStatement(query)) {
//            stmt.setString(1, classroomId);
//            ResultSet rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                resourceWeeks.add(rs.getString("resourceWeek"));
//            }
//        } catch (SQLException e) {
//            System.err.println("Error loading resources: " + e.getMessage());
//        }
//        return resourceWeeks;
//    }
//
//    public void displayResourcesByWeekSql(String classroomId) {
//        List<String> resourceWeeks = loadResourceSql(classroomId);
//
//        if (resourceWeeks.isEmpty()) {
//            System.out.println("No resources available.");
//            return;
//        }
//
//        System.out.println("\nAvailable Resource Weeks:");
//        for (int i = 0; i < resourceWeeks.size(); i++) {
//            System.out.println((i + 1) + ". " + resourceWeeks.get(i));
//        }
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("\nEnter Resource Week to view contents: ");
//        String selectedWeek = scanner.nextLine().trim();
//
//        displayContentsByWeekSql(classroomId, selectedWeek);
//    }
//
//    public void displayContentsByWeekSql(String classroomId, String selectedWeek) {
//        String query = "SELECT id, title, description, attachment FROM resources WHERE classroomId = ? AND resourceWeek = ?";
//
//        try (PreparedStatement stmt = connection.prepareStatement(query)) {
//            stmt.setString(1, classroomId);
//            stmt.setString(2, selectedWeek);
//            ResultSet rs = stmt.executeQuery();
//
//            if (!rs.isBeforeFirst()) {
//                System.out.println("No resources found for " + selectedWeek);
//                return;
//            }
//
//            System.out.println("\nContents for " + selectedWeek + ":");
//            while (rs.next()) {
//                System.out.println("ID: " + rs.getString("id") + " - " + rs.getString("title"));
//            }
//
//            Scanner scanner = new Scanner(System.in);
//            System.out.print("\nEnter Resource ID to view details: ");
//            String selectedResourceId = scanner.nextLine().trim();
//
//            displayResourceDetailsSql(selectedResourceId);
//        } catch (SQLException e) {
//            System.err.println("Error displaying contents: " + e.getMessage());
//        }
//    }
//
//    public void displayResourceDetailsSql(String resourceId) {
//        String query = "SELECT title, description, attachment FROM resources WHERE id = ?";
//
//        try (PreparedStatement stmt = connection.prepareStatement(query)) {
//            stmt.setString(1, resourceId);
//            ResultSet rs = stmt.executeQuery();
//
//            if (rs.next()) {
//                System.out.println("\nTitle: " + rs.getString("title"));
//                System.out.println("Description: " + rs.getString("description"));
//                System.out.println("Attachment: " + rs.getString("attachment"));
//            } else {
//                System.out.println("Resource not found.");
//            }
//        } catch (SQLException e) {
//            System.err.println("Error retrieving resource details: " + e.getMessage());
//        }
//    }

    // ========================================
    // JSON-RELATED METHODS
    // ========================================

    //  Part of Resource
    // Load resources from file
    public JSONArray loadResource() {
        try {
            String filePath = "shared/data/resource.json";
            String contents = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray resources = new JSONArray(contents);
            return resources;
        } catch (IOException e) {
            System.err.println("Error loading resource: " + e.getMessage());
            return new JSONArray();  // Return empty array instead of null
        }
    }

    public void displayResourcesByWeek(String classroomId) {
        JSONArray allClasses = loadResource(); // Load all resources

        if (allClasses.length() == 0) {
            System.out.println("No resources available.");
            return;
        }

        System.out.println("\nAvailable Resource Weeks:");

        for (int i = 0; i < allClasses.length(); i++) {
            JSONObject classroom = allClasses.getJSONObject(i);

            // Ensure classroomId matches
            if (classroom.has("classroomId") && classroom.getString("classroomId").equals(classroomId)) {
                JSONArray resources = classroom.getJSONArray("resources"); // Get resources array

                for (int j = 0; j < resources.length(); j++) {
                    JSONObject resource = resources.getJSONObject(j);

                    // Check if resourceId exists before accessing it
                    if (resource.has("resourceId")) {
                        System.out.println((j + 1) + ". " + resource.getString("resourceId"));
                    } else {
                        System.out.println("Warning: A resource is missing 'resourceId'. Skipping...");
                    }
                }
            }
        }

        // Select a week
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter Resource Week ID to view contents: ");
        String selectedWeekId = scanner.nextLine().trim();

        // Display resources for selected week
        displayContentsByWeek(classroomId, selectedWeekId);
    }


    public void displayContentsByWeek(String classroomId, String selectedWeekId) {
        JSONArray allClasses = loadResource(); // Load all resources

        for (int i = 0; i < allClasses.length(); i++) {
            JSONObject classroom = allClasses.getJSONObject(i);

            // Check if classroomId matches
            if (classroom.has("classroomId") && classroom.getString("classroomId").equals(classroomId)) {
                JSONArray resources = classroom.getJSONArray("resources"); // Get resources array

                for (int j = 0; j < resources.length(); j++) {
                    JSONObject resource = resources.getJSONObject(j);

                    // Check if resourceId exists and matches the selected week
                    if (resource.has("resourceId") && resource.getString("resourceId").equals(selectedWeekId)) {
                        JSONArray contents = resource.getJSONArray("contents");

                        if (contents.length() == 0) {
                            System.out.println("No resources found for " + selectedWeekId);
                            return;
                        }

                        System.out.println("\nContents for " + selectedWeekId + ":");
                        for (int k = 0; k < contents.length(); k++) {
                            JSONObject content = contents.getJSONObject(k);
                            System.out.println((k + 1) + ". " + content.getString("title") + " (ID: " + content.getString("id") + ")");
                        }

                        // Allow user to select a resource to view details
                        Scanner scanner = new Scanner(System.in);
                        System.out.print("\nEnter Resource ID to view details: ");
                        String selectedResourceId = scanner.nextLine().trim();

                        // Display details of the selected resource
                        for (int k = 0; k < contents.length(); k++) {
                            JSONObject content = contents.getJSONObject(k);
                            if (content.getString("id").equals(selectedResourceId)) {
                                System.out.println("\nTitle: " + content.getString("title"));
                                System.out.println("Description: " + content.getString("description"));
                                System.out.println("Attachment: " + content.getString("attachment"));
                                return;
                            }
                        }

                        System.out.println("Invalid Resource ID. Returning to menu...");
                        return;
                    }
                }

                System.out.println("Invalid Week ID. Please try again.");
                return;
            }
        }

        System.out.println("Classroom ID not found.");
    }

    // Rasa Front end related functions -----------------------------------------------------------------------------------------------

//    public HashMap<String, String> getAllResources() {
//        JSONObject progress = student.getProgress();
//
//        ArrayList<String> progressIds = new ArrayList<>();
//        Iterator<String> iterator = progress.keys();
//        while (iterator.hasNext()) {
//            String key = iterator.next();
//            progressIds.add(progress.getString(key));
//        }
//        JSONArray studentProgress = getAllStudentProgress(progressIds);
//        HashMap<String, String> allResources = new HashMap<>();
//        for (int i = 0; i < studentProgress.length(); i++) {
//            for (int j = 0; j < studentProgress.getJSONObject(i).getJSONArray("resources").length(); j++) {
//                allResources.put(studentProgress.getJSONObject(i).getJSONArray("resources").getString(j), studentProgress.getJSONObject(i).getString("classroomId"));
//            }
//        }
//        return allResources;
//    }

    private JSONArray getAllStudentProgress(List<String> progressIds) {
        JSONArray allProgress = loadProgress();
        JSONArray studentProgress = new JSONArray();
        for (int i = 0; i < progressIds.size(); i++) {
            for (int j = 0; j < allProgress.length(); j++) {
                if (progressIds.get(i).equals(allProgress.getJSONObject(j).getString("id"))) {
                    studentProgress.put(allProgress.getJSONObject(j));
                }
            }
        }
        return studentProgress;
    }

    private JSONArray loadProgress() {
        try {
            String content = new String(Files.readAllBytes(Paths.get("shared/data/progress.json")));
            return new JSONArray(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}