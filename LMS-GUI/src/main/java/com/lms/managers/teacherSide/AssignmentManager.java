package main.java.com.lms.managers.teacherSide;

import main.AppSession;
import main.DatabaseConnection;import org.json.JSONArray;
import org.json.JSONObject;

import javax.xml.crypto.Data;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;

public class AssignmentManager extends ClassroomContentManager {

    public AssignmentManager(String classId) {
        super(classId);
    }

    // ========================================
    // SQL-RELATED METHODS
    // ========================================

    // TODO: sql equivalent methods goes here, method name should have the same name but with Sql at the end. Ex: manageDoQuiz -> manageDoQuizSql

    private Connection conn = DatabaseConnection.getInstance().getConnection();

    public void manageAddAssignmentSql(String title, String description, String deadline, String ref_attachment) {
        String query = "INSERT INTO assignment (id, title, description, deadline, status, ref_attachment) VALUES (?,?,?,?,?,?)";
        String id = generateAssignmentIdSql("A0000");
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, id);
            statement.setString(2, title);
            statement.setString(3, description);
            statement.setDate(4, Date.valueOf(deadline));
            statement.setString(5, "active");
            statement.setString(6, ref_attachment);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String query2= "INSERT INTO classroom_assignment(class_id, assignment_id) VALUES (?,?)";
        try(PreparedStatement statement = conn.prepareStatement(query2)){
            statement.setString(1, AppSession.getInstance().getSelectedClassroom());
            statement.setString(2, id);
            statement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }

        String query3 = "INSERT INTO progress_assignment (progress_id, assignment_id, score, sub_attachment, status) " +
                "SELECT id, ?, ?, ?, ? FROM progress WHERE classroom_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query3)) {
            statement.setString(1, id); // assignment_id
            statement.setNull(2, Types.DECIMAL); // score (nullable)
            statement.setNull(3, Types.VARCHAR); // sub_attachment (nullable)
            statement.setString(4, "active"); // status
            statement.setString(5, AppSession.getInstance().getSelectedClassroom()); // classroom_id for WHERE clause
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void manageEditAssignmentSql(String id, String title, String description, String deadline, String ref_attachment) {
        // Check if the assignment ID exists
        String checkQuery = "SELECT COUNT(*) FROM assignment WHERE id = ?";
        try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
            checkStmt.setString(1, id);
            checkStmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        // Update the assignment
        String query = "UPDATE assignment SET title = ?, description = ?, deadline = ?, ref_attachment = ? WHERE id = ?";
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


    public void manageDeleteAssignmentSql(String id) {
        String query = "UPDATE assignment SET status = ? WHERE id = ?";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, "inactive"); // Set status
            statement.setString(2, id); // Bind ID parameter
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(); // Replace with a logger in production
        }
    }

    public String getAssignmentTitle(){
        String query = "SELECT title FROM assignment WHERE id = ?";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, AppSession.getInstance().getSelectedAssignment());
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                return rs.getString("title");
            }
        }catch (SQLException e) {
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

    private String generateAssignmentIdSql(String baseId) {
        String query = "SELECT count(*) FROM assignment";
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

    public ArrayList<String> getClassroomAssignmentsSql() {
        ArrayList<String> assignments = new ArrayList<>();
        // No need to check for teacherID cuz already done that at showing the teacher's classroom so we got the class_id alr
        String query = "SELECT CONCAT(a.id, ' - ', a.title) AS id_name " +
                "FROM classroom_assignment AS ca " +
                "JOIN assignment AS a ON ca.assignment_id = a.id " +
                "WHERE ca.class_id = ?";


    // TODO: this is for grading. need to improve with name
//        String query = "SELECT CONCAT(a.id, ' - ', a.title) AS id_name " +
//                "FROM progress_assignment AS pa " +
//                "JOIN progress AS p ON pa.progress_id = p.id " +
//                "JOIN assignment AS a ON pa.assignment_id = a.id " +
//                "JOIN classroom AS c ON p.classroom_id = c.id " +
//                "WHERE p.classroom_id = ? AND c.teacher_id = ?";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, AppSession.getInstance().getSelectedClassroom());
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                assignments.add(rs.getString("id_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return assignments;
    }
































    // ========================================
    // JSON-RELATED METHODS
    // ========================================

    public void manageAddAssignment(String title, String description, String date, String time) {
//        String title = Menu.prompt("Enter Assignment Title: ");
//        String description = Menu.prompt("Enter Assignment Description: ");
//        String date = Menu.prompt("Enter a Date for Deadline (YYYY-MM-DD):");
//        String time = Menu.prompt("Enter a Time for Deadline (hh:mm AM/PM): ");
        JSONObject deadline = new JSONObject();
        deadline.put("date", date);
        deadline.put("time", time);
        JSONObject newAssignment = new JSONObject();
        String assignmentId = idGenerator(getClassroomAssignments(), "A000");
        newAssignment.put("id", assignmentId);
        newAssignment.put("title", title);
        newAssignment.put("description", description);
        newAssignment.put("deadline", deadline);
        newAssignment.put("status", "active");
        // TODO: add reference material which can be optional
        JSONArray allClassroom = loadClassroom();
        saveAssignments(newAssignment, title); // saves to classroom
        // handles saving to progress
        for (int i = 0; i < allClassroom.length(); i++) {
            if (getClassroomId().equals(allClassroom.getJSONObject(i).getString("id"))) {
                for (int j = 0; i < allClassroom.getJSONObject(i).getJSONArray("students").length(); j++) {
                    assignmentToProgress(allClassroom.getJSONObject(i).getJSONArray("students").getString(j), assignmentId, "(Ongoing)", "", "");
                }
            }
        }
    }

    public void manageEditAssignment(int titleId, String newTitle, String newDescription, String newDate, String newTime) {
//        int titleId = Integer.parseInt(selectAssignmentTitle()) - 1; // hold title selection
        JSONArray allAssignments = getClassroomAssignments();
        //handles inactive assignment
        for (int i = 0; i < allAssignments.length(); i++) {
            if (i == titleId) {
                if (allAssignments.getJSONObject(i).getString("status").equals("inactive")) {
                    titleId++;
                }
            }
        }

        // editing process
        for (int i = 0; i < allAssignments.length(); i++) {
            if (i == titleId) {
                // print previous info
                JSONObject assignmentToEdit = allAssignments.getJSONObject(i);
                System.out.println("Title: " + assignmentToEdit.getString("title"));
                System.out.println("Description: " + assignmentToEdit.getString("description"));
                JSONObject assignmentDeadline = assignmentToEdit.getJSONObject("deadline");
                System.out.println("Deadline: " + assignmentDeadline.getString("date") + " | " + assignmentDeadline.getString("time"));
                // takes new info
//                String newTitle = Menu.prompt("Enter a new Title (if not leave empty): ");
                if (!newTitle.isEmpty()) {
                    assignmentToEdit.put("title", newTitle);
                }
//                String newDescription = Menu.prompt("Enter a new Description (if not leave empty):");
                if (!newDescription.isEmpty()) {
                    assignmentToEdit.put("description", newDescription);
                }
//                String newDate = Menu.prompt("Enter a new Deadline Date (YYYY-MM-DD) (if not leave empty): ");
                if (!newDate.isEmpty()) {
                    assignmentDeadline.put("date", newDate);
                }
//                String newTime = Menu.prompt("Enter a new Deadline Time (HH:MM) (if not leave empty): ");
                if (!newTime.isEmpty()) {
                    assignmentDeadline.put("time", newTime);
                }
                allAssignments.put(i, assignmentToEdit); // ensure it saves into correct index
                saveAssignments(assignmentToEdit, assignmentToEdit.getString("id"));
                break;
            }
        }
    }

    public void manageDeleteAssignment(int titleId) {
//        int titleId = Integer.parseInt(selectAssignmentTitle()) - 1; // hold title selection
        JSONArray allClassroomAssignments = getClassroomAssignments();
        // handles inactive assignment
        for (int i = 0; i < allClassroomAssignments.length(); i++) {
            if (i == titleId) {
                if (allClassroomAssignments.getJSONObject(i).getString("status").equals("inactive")) {
                    titleId++;
                }
            }
        }
        // updates classroomAssignment
        for (int i = 0; i < allClassroomAssignments.length(); i++) {
            if (i == titleId) {
                JSONObject assignmentToEdit = allClassroomAssignments.getJSONObject(i);
                assignmentToEdit.put("status", "inactive");
                allClassroomAssignments.put(i, assignmentToEdit); // ensure it saves into correct index
                saveAssignments(assignmentToEdit, assignmentToEdit.getString("id"));
                break;
            }
        }
        // updates progressAssignment
        JSONArray allProgress = loadProgress();
        for (int i = 0; i < allProgress.length(); i++) {
            if (getClassroomId().equals(allProgress.getJSONObject(i).getString("classroomId"))) {
                for (int j = 0; j < allProgress.getJSONObject(i).getJSONArray("assignments").length(); j++) {
                    if (j == titleId) {
                        allProgress.getJSONObject(i).getJSONArray("assignments").getJSONObject(j).put("status", "inactive");
                        saveProgresses(allProgress);
                        break;
                    }
                }
            }
        }
    }

    public void manageGradeAssignment(int selectedAssignment, int selectedStudent, String grade, String feedback) {
        JSONArray allProgress = loadProgress();
//        int selectedAssignment = Integer.parseInt(selectAssignmentTitle()) - 1; // hold the selected assignment's index
//        int selectedStudent = Integer.parseInt(selectStudentToGrade()) - 1; // hold the selected student's index
//        String grade = Menu.prompt("Grade the student Assignment (0 - 100): ");
//        String feedback = "";
//        feedback = Menu.prompt("Enter feedback (if not leave empty):");
        // handles inactive assignment
        JSONArray allProgressAssignment = getProgressAssignments();
        for (int i = 0; i < allProgressAssignment.length(); i++) {
            if (i == selectedAssignment) {
                if (allProgressAssignment.getJSONObject(i).getString("status").equals("inactive")) {
                    selectedAssignment++;
                }
            }
        }
        // updates progress
        for (int i = 0; i < allProgress.length(); i++) {
            if (i == selectedStudent) {
                String studentId = allProgress.getJSONObject(i).getString("studentId");
                for (int j = 0; j < allProgress.getJSONObject(i).getJSONArray("assignments").length(); j++) {
                    if (j == selectedAssignment) {
                        String assignmentId = allProgress.getJSONObject(i).getJSONArray("assignments").getJSONObject(j).getString("id");
                        assignmentToProgress(assignmentId, studentId, "(Graded)", grade, feedback);
                        break;
                    }
                }
            }
        }
    }

    // get a specific classroomId id Ex: "GEN10-CS-SE-G1-OOP"
//    private String getClassroomId() {
//        int indexOfClass = Integer.parseInt(classIdToEdit);
//        JSONArray allClass = loadClassroom();
//        for (int i = 0; i < allClass.length(); i++) {
//            if (i == indexOfClass) {
//                JSONObject classToEdit = allClass.getJSONObject(i);
//                return classToEdit.getString("id");
//            }
//        }
//        return null;
//    }

    // get only assignments from classroom.json
    private JSONArray getClassroomAssignments() {
//        int indexOfClass = Integer.parseInt(classIdToEdit);
        JSONArray allClass = loadClassroom();
        for (int i = 0; i < allClass.length(); i++) {
            if (allClass.getJSONObject(i).getString("id").equals(classIdToEdit)) {
                JSONObject classToEdit = allClass.getJSONObject(i);
                JSONArray assignments = classToEdit.optJSONArray("assignments");
                return assignments;
            }
        }
        return null;
    }

    // get only assignments from progress.json
    private JSONArray getProgressAssignments() {
        String selectedClassroomId = getClassroomId();
        JSONArray allProgress = loadProgress();
        for (int i = 0; i < allProgress.length(); i++) {
            if (selectedClassroomId.equals(allProgress.getJSONObject(i).getString("classroomId"))) {
                return allProgress.getJSONObject(i).getJSONArray("assignments");
            }
        }
        return null;
    }

    // check & save only the assignment into the correct index
    private void saveAssignments(JSONObject newAssignment, String assignmentId) {
        // TODO: Need to change this to add assignment ID to the classroom
//        int indexOfClass = Integer.parseInt(classIdToEdit);
        JSONArray allClass = loadClassroom();
        for (int i = 0; i < allClass.length(); i++) {
            if (allClass.getJSONObject(i).getString("id").equals(classIdToEdit)) {
                JSONObject classToEdit = allClass.getJSONObject(i);
                JSONArray assignments = classToEdit.getJSONArray("assignments");
                if (assignments == null) {
                    assignments = new JSONArray();
                }
                boolean found = false;
                for (int j = 0; j < assignments.length(); j++) {
                    // needs to compare id instead
                    if (assignmentId.equals(assignments.getJSONObject(j).getString("id"))) {
                        assignments.put(j, newAssignment); // save into the correct index
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    assignments.put(newAssignment); // create new one
                }
                classToEdit.put("assignments", assignments);
                allClass.put(i, classToEdit);
                saveClassrooms(allClass);
                break;
            }
        }
    }

    // assigns only the assignment to progress
    private void assignmentToProgress(String assignmentId, String studentId, String pending, String grade, String feedback) {
        String classroomId = getClassroomId();
        JSONArray progresses = loadProgress();
        for (int i = 0; i < progresses.length(); i++) {
            if (classroomId.equals(progresses.getJSONObject(i).getString("classroomId")) && studentId.equals(progresses.getJSONObject(i).getString("studentId"))) {
                boolean found = false;
                for (int j = 0; j < progresses.getJSONObject(i).getJSONArray("assignments").length(); j++) {
                    if (assignmentId.equals(progresses.getJSONObject(i).getJSONArray("assignments").getJSONObject(j).getString("id"))) {
                        progresses.getJSONObject(i).getJSONArray("assignments").getJSONObject(j).put("pending", pending);
                        progresses.getJSONObject(i).getJSONArray("assignments").getJSONObject(j).put("grade", grade);
                        progresses.getJSONObject(i).getJSONArray("assignments").getJSONObject(j).put("feedback", feedback);
                        progresses.getJSONObject(i).getJSONArray("assignments").getJSONObject(j).put("status", "active");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    JSONObject newAssignment = new JSONObject();
                    newAssignment.put("id", assignmentId);
                    newAssignment.put("pending", pending);
                    newAssignment.put("grade", grade);
                    newAssignment.put("feedback", feedback);
                    newAssignment.put("status", "active");
                    progresses.getJSONObject(i).getJSONArray("assignments").put(newAssignment);
                }
            }
        }
        saveProgresses(progresses);
    }

    // save all classrooms
    private void saveClassrooms(JSONArray allClass) {
        try (FileWriter file = new FileWriter("shared/data/classroom.json")) {
            file.write(allClass.toString(4)); // Pretty-print with 4 spaces
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // save all progresses
    private void saveProgresses(JSONArray allProgress) {
        try (FileWriter file = new FileWriter("shared/data/progress.json")) {
            file.write(allProgress.toString(4)); // Pretty-print with 4 spaces
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private JSONArray loadClassroom() {
        try {
            String contents = new String(Files.readAllBytes(Paths.get("shared/data/classroom.json")));
            JSONArray allClass = new JSONArray(contents);
            return allClass;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // load all students
    private JSONArray loadStudent() {
        try {
            String contents = new String(Files.readAllBytes(Paths.get("shared/data/student.json")));
            JSONArray allStudents = new JSONArray(contents);
            return allStudents;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // load all progresses
    private JSONArray loadProgress() {
        try {
            String contents = new String(Files.readAllBytes(Paths.get("shared/data/progress.json")));
            JSONArray allprogress = new JSONArray(contents);
            return allprogress;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


//    private String idGenerator(JSONArray objects, String baseId) { // baseId receives Ex: "A000"
//        String numberPart = baseId.replaceAll("[^0-9]", ""); // extract number part "000"
//        int numberLength = numberPart.length();
//        int nextIdNumber;
//        if (objects != null) {
//            nextIdNumber = objects.length() + 1; // find next available id
//        } else {
//            nextIdNumber = 1;
//        }
//        String formattedNumber = String.format("%0" + numberLength + "d", nextIdNumber); // %03d
//        String prefixChar = baseId.replaceAll("[0-9]", ""); // extract the non-numeric part "A"
//        return prefixChar + formattedNumber;
//    }
}