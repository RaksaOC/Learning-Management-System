package main.java.com.lms.managers.studentSide;

import entities.Student;
import main.AppSession;
import main.DatabaseConnection;
import org.json.JSONArray;
import org.json.JSONObject;
import ui.UI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class AssignmentsManager {
    private Student student;
    private Connection conn;

    public AssignmentsManager() {
        AppSession session = AppSession.getInstance();
        this.student = session.getStudent();
        this.conn = DatabaseConnection.getInstance().getConnection();
    }

    // ========================================
    // SQL-RELATED METHODS
    // ========================================

    public void manageSubmitAssignment(String sub_attachment) {
        String query = "UPDATE progress_assignment pa " +
                "JOIN progress p on pa.progress_id = p.id " +
                "SET pa.sub_attachment = ? " +
                "WHERE p.student_id = ? AND pa.assignment_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, sub_attachment);
            statement.setString(2, student.getId());
            statement.setString(3, AppSession.getInstance().getSelectedAssignment());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Map<String, String> getAllAssignments() {
        Map<String, String> id_name_classroom = new HashMap<>();
        String query = "SELECT CONCAT(a.id, ' - ', a.title) AS id_name, " +
                "p.classroom_id as class_id " +
                "FROM progress_assignment as pa " +
                "JOIN progress AS p " +
                "ON pa.progress_id = p.id " +
                "JOIN assignment AS a " +
                "ON pa.assignment_id = a.id " +
                "WHERE p.student_id = ?";
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

    public boolean isAssignmentGraded() {
        String query = "SELECT status FROM progress_assignment pa " +
                "JOIN progress p ON pa.progress_id = p.id " +
                "WHERE pa.assignment_id = ? AND p.student_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, AppSession.getInstance().getSelectedAssignment());
            statement.setString(2, AppSession.getInstance().getStudent().getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                if (rs.getString("status").equals("inactive")) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Double getAssignmentGrade() {
        String query = "SELECT pa.score as score FROM progress_assignment pa " +
                "JOIN progress p ON pa.progress_id = p.id " +
                "WHERE pa.assignment_id = ? AND p.student_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, AppSession.getInstance().getSelectedAssignment());
            statement.setString(2, AppSession.getInstance().getStudent().getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                if (rs.getString("score") != null) {
                    return (rs.getDouble("score"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> getClassroomAssignments() {
        ArrayList<String> assignments = new ArrayList<>();
        String query = "SELECT CONCAT(a.id, ' - ', a.title) AS id_name " +
                "FROM progress_assignment AS pa " +
                "JOIN progress AS p ON pa.progress_id = p.id " +
                "JOIN assignment AS a ON pa.assignment_id = a.id " +
                "WHERE p.classroom_id = ? AND p.student_id = ?";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, AppSession.getInstance().getSelectedClassroom());
            statement.setString(2, AppSession.getInstance().getStudent().getId());
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                assignments.add(rs.getString("id_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return assignments;
    }

    public String getAssignmentTitle() {
        System.out.println("Assignment ID in second page: " + AppSession.getInstance().getSelectedAssignment());
        String query = "SELECT title FROM assignment WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, AppSession.getInstance().getSelectedAssignment());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return rs.getString("title");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getAssignmentDeadline() {
        String query = "SELECT deadline FROM assignment WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, AppSession.getInstance().getSelectedAssignment());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return rs.getString("deadline");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getAssignmentRef() {
        String query = "SELECT ref_attachment FROM assignment WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, AppSession.getInstance().getSelectedAssignment());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return rs.getString("ref_attachment");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getAssignmentDescription(){
        String query = "SELECT description FROM assignment WHERE id = ?";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, AppSession.getInstance().getSelectedAssignment());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return rs.getString("description");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getPrevAssignmentRef() {
        String query = "SELECT sub_attachment FROM progress_assignment pa" +
                " JOIN progress p ON pa.progress_id = p.id " +
                "WHERE p.student_id = ? AND pa.assignment_id = ?";

        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, AppSession.getInstance().getStudent().getId());
            statement.setString(2, AppSession.getInstance().getSelectedAssignment());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return rs.getString("sub_attachment");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


//    // TODO: sql equivalent methods goes here, method name should have the same name but with Sql at the end. Ex: manageDoQuiz -> manageDoQuizSql
//
//    public JSONArray getAssignmentSql (String classroomId) {
//        JSONArray assignments = new JSONArray();
//        String sql = "Select id, title, description, deadline, status FROM assignments " +
//                "WHERE classroom_id = ?";
//
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setString(1, classroomId);;
//            ResultSet rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                JSONObject assignment = new JSONObject();
//                assignment.put("id", rs.getString("id"));
//                assignment.put("title", rs.getString("title"));
//                assignment.put("description", rs.getString("description"));
//                assignment.put("deadline" , rs.getString("deadline"));
//                assignment.put("status", rs.getString("status"));
//                assignments.put(assignment);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return assignments;
//    }
//
//    // Get details of a specific assignment
//    public JSONObject getAssignmentDetailsSql(String assignmentId) {
//        JSONObject assignment = new JSONObject();
//        String sql = "SELECT id, title, description, deadline, status FROM assignments WHERE id = ?";
//
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setString(1, assignmentId);
//            ResultSet rs = stmt.executeQuery();
//
//            if (rs.next()) {
//                assignment.put("id", rs.getString("id"));
//                assignment.put("title", rs.getString("title"));
//                assignment.put("description", rs.getString("description"));
//                assignment.put("deadline", rs.getString("deadline"));
//                assignment.put("status", rs.getString("status"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return assignment;
//    }
//
//    // Save or update an assignment submission
//    public void saveSubmissionSql(String studentId, String assignmentId, String classroomId, String submissionText) {
//        String sql = "INSERT INTO submissions (student_id, assignment_id, classroom_id, submission_text, status, timestamp) VALUES (?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE submission_text = ?, status = ?, timestamp = ?";
//
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//
//            stmt.setString(1, studentId);
//            stmt.setString(2, assignmentId);
//            stmt.setString(3, classroomId);
//            stmt.setString(4, submissionText);
//            stmt.setString(5, "submitted");
//            stmt.setTimestamp(6, timestamp);
//            stmt.setString(7, submissionText);
//            stmt.setString(8, "resubmitted");
//            stmt.setTimestamp(9, timestamp);
//
//            stmt.executeUpdate();
//            System.out.println("Assignment submitted successfully!");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    // View all submitted assignments for a student
//    public void viewSubmittedAssignmentsSql(String studentId) {
//        String sql = "SELECT assignment_id, status, timestamp FROM submissions WHERE student_id = ?";
//
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setString(1, studentId);
//            ResultSet rs = stmt.executeQuery();
//
//            System.out.println("\nYour Submitted Assignments:");
//            while (rs.next()) {
//                System.out.println("Assignment ID: " + rs.getString("assignment_id") +
//                        ", Status: " + rs.getString("status") +
//                        ", Submitted on: " + rs.getTimestamp("timestamp"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//
//    // ========================================
//    // JSON-RELATED METHODS
//    // ========================================
//
//    // Load all classrooms from classroom.json
//    public JSONArray loadClassroom() {
//        try {
//            String filePath = "shared/data/classroom.json";
//            String contents = new String(Files.readAllBytes(Paths.get(filePath)));
//
//            return new JSONArray(contents);
//        } catch (IOException e) {
//            System.err.println("Error loading classrooms: " + e.getMessage());
//            return new JSONArray();  // Return empty array instead of null
//        }
//    }
//
//    public JSONArray getAssignments(String classroomId) {
//        JSONArray allClass = loadClassroom(); // Load classrooms
//        // Loop through the classrooms to find the matching classroom ID
//        for (int i = 0; i < allClass.length(); i++) {
//            JSONObject classToEdit = allClass.getJSONObject(i);
//
//            // Check if the classroom ID matches the selected classroomId
//            if (classToEdit.getString("id").equals(classroomId)) {
//                // If assignments exist, return them
//                JSONArray assignments = classToEdit.optJSONArray("assignments");
//                if (assignments != null && assignments.length() > 0) {
//                    return assignments;
//                }
//            }
//        }
//        return new JSONArray(); // Return empty array if no assignments are found
//    }
//
//    // Display all titles and allow the user to select an assignment by ID
//    public String selectAssignmentTitle(String classroomId) {
//        JSONArray allAssignments = getAssignments(classroomId); // Get filtered assignments
//
//        if (allAssignments.length() == 0) {
//            System.out.println("No assignments available for this classroom.");
//            return null; // Return null if no assignments
//        }
//
//        System.out.println("\nAvailable Assignments:");
//        for (int i = 0; i < allAssignments.length(); i++) {
//            JSONObject assignment = allAssignments.getJSONObject(i);
//            System.out.println(assignment.getString("id") + " - " + assignment.getString("title")); // Show ID & title
//        }
//

    /// /        return Menu.prompt("Enter Assignment ID to select: ");
//        return "";
//    }

    // To get each Assignment details after selected
//    public JSONObject getAssignmentDetails(String classroomId, String assignmentId) {
//        JSONArray allAssignments = getAssignments(classroomId); // Get all assignments for the classroom
//
//        for (int i = 0; i < allAssignments.length(); i++) {
//            JSONObject assignment = allAssignments.getJSONObject(i);
//            if (assignment.getString("id").equals(assignmentId)) {
//                return assignment; // Return the found assignment
//            }
//        }
//        return null; // Return null if the assignment isn't found
//    }

    // Display assignment details
    public void displayAssignmentDetails(JSONObject assignment) {
        System.out.println("\n===== Assignment Details =====");
        System.out.println("Title: " + assignment.getString("title"));
        System.out.println("Description: " + assignment.getString("description"));
        System.out.println("Deadline: " +
                assignment.getJSONObject("deadline").getString("date") + " " +
                assignment.getJSONObject("deadline").getString("time"));
        System.out.println("Status: " + assignment.getString("status"));
        System.out.println("==============================\n");
    }

    // Allow students to write/edit their assignment
    public void editAssignment(String studentId, String assignmentId, String classroomId) {
        System.out.println("Editing Assignment: " + assignmentId);

        // Check if the student has an existing submission
        JSONArray submissions = loadSubmissions();
        JSONObject existingSubmission = null;

        for (int i = 0; i < submissions.length(); i++) {
            JSONObject submission = submissions.getJSONObject(i);
            if (submission.getString("studentId").equals(studentId) &&
                    submission.getString("assignmentId").equals(assignmentId)) {
                existingSubmission = submission;
                break;
            }
        }

        if (existingSubmission != null) {
            System.out.println("Your previous submission:");
            System.out.println(existingSubmission.getString("submissionText"));
        } else {
            System.out.println("No previous submission found. Starting a new submission.");
        }

        // Prompt for new submission content
//        String updatedWork = Menu.prompt("Enter your updated assignment answer: ");
//        saveSubmission(studentId, assignmentId, classroomId, updatedWork);
    }

    // Save or update assignment submission
    public void saveSubmission(String studentId, String assignmentId, String classroomId, String submissionText) {
        try {
            String filePath = "shared/data/progress.json";
            JSONArray submissions = loadSubmissions();

            // Check if the student already submitted this assignment
            JSONObject existingSubmission = null;
            for (int i = 0; i < submissions.length(); i++) {
                JSONObject submission = submissions.getJSONObject(i);
                if (submission.getString("studentId").equals(studentId) &&
                        submission.getString("assignmentId").equals(assignmentId)) {
                    existingSubmission = submission;
                    break;
                }
            }

            if (existingSubmission != null) {
                existingSubmission.put("submissionText", submissionText);
                existingSubmission.put("status", "resubmitted");
                existingSubmission.put("timestamp", System.currentTimeMillis());
                System.out.println("Assignment resubmitted successfully!");
            } else {
                JSONObject newSubmission = new JSONObject();
                newSubmission.put("studentId", studentId);
                newSubmission.put("assignmentId", assignmentId);
                newSubmission.put("classroomId", classroomId);
                newSubmission.put("submissionText", submissionText);
                newSubmission.put("status", "submitted");
                newSubmission.put("timestamp", System.currentTimeMillis());

                submissions.put(newSubmission);
                System.out.println("Assignment submitted successfully!");
            }

            // Write back to the file
            Files.write(Paths.get(filePath), submissions.toString(4).getBytes());
        } catch (IOException e) {
            System.err.println("Error saving submission: " + e.getMessage());
        }
    }

    // Load all submissions from progress.json
    private JSONArray loadSubmissions() {
        try {
            String filePath = "shared/data/progress.json";
            String contents = new String(Files.readAllBytes(Paths.get(filePath)));
            return new JSONArray(contents);
        } catch (IOException e) {
            return new JSONArray(); // Return empty array if file is missing
        }
    }

    private String formatTimestamp(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date(timestamp));
    }

    //    View Submitted assignments
    public void viewSubmittedAssignments(String studentId) {
        JSONArray submissions = loadSubmissions();
        boolean found = false;
        System.out.println("\nYour Submitted Assignments:");
        for (int i = 0; i < submissions.length(); i++) {
            JSONObject submission = submissions.getJSONObject(i);

            if (submission.getString("studentId").trim().equals(studentId.trim())) {  // Trim for safety
                found = true;

                // Trim assignmentId to avoid space issues
                String assignmentId = submission.getString("assignmentId").trim();

                // Convert timestamp to readable date format
                String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                        .format(new Date(submission.getLong("timestamp")));

                System.out.println("Assignment ID: " + assignmentId +
                        ", Status: " + submission.getString("status") +
                        ", Submitted on: " + formattedDate);
            }
        }
        if (!found) {
            System.out.println("No assignments submitted yet.");
        }
    }

    public void viewGradesAndComments(String studentId) {
//        JSONArray feedback =
    }

//    public HashMap<String, String> getAllAssignments(){
//        JSONObject progress = student.getProgress();
//
//        ArrayList<String> progressIds = new ArrayList<>();
//        Iterator<String> iterator = progress.keys();
//        while (iterator.hasNext()) {
//            String key = iterator.next();
//            progressIds.add(progress.getString(key));
//        }
//        JSONArray studentProgress = getAllRelatedStudentProgress(progressIds);
//
//        HashMap<String, String> assignments = new HashMap<>();
//        for (int i = 0; i < studentProgress.length(); i++) {
//            for (int j = 0; j < studentProgress.getJSONObject(i).getJSONArray("assignments").length(); j++) {
//                assignments.put(studentProgress.getJSONObject(i).getJSONArray("assignments").getString(j), studentProgress.getJSONObject(i).getString("classroomId"));
//            }
//        }
//        return assignments;
//    }

    // Rasa Front end related functions -----------------------------------------------------------------------------------------------

    private JSONArray getAllRelatedStudentProgress(List<String> progressIds) {
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