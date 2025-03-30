package main.java.com.lms.managers.teacherSide;

import main.AppSession;
import main.DatabaseConnection;
import org.json.JSONArray;
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

        String query2 = "INSERT INTO classroom_assignment(class_id, assignment_id) VALUES (?,?)";
        try (PreparedStatement statement = conn.prepareStatement(query2)) {
            statement.setString(1, AppSession.getInstance().getSelectedClassroom());
            statement.setString(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
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

    public void manageEditAssignmentSql(String newTitle, String newDescription, String newDeadline, String newRef_attachment) {
        String query = "UPDATE assignment SET title = ?, description = ?, deadline = ?, ref_attachment = ? WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, newTitle);
            statement.setString(2, newDescription);
            statement.setDate(3, Date.valueOf(newDeadline));
            statement.setString(4, newRef_attachment);
            statement.setString(5, AppSession.getInstance().getSelectedAssignment());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void manageDeleteAssignmentSql() {
        String query = "UPDATE assignment SET status = ? WHERE id = ?";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, "inactive"); // Set status
            statement.setString(2, AppSession.getInstance().getSelectedAssignment()); // Bind ID parameter
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String query2 = "DELETE FROM classroom_assignment WHERE assignment_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query2)) {
            statement.setString(1, AppSession.getInstance().getSelectedAssignment());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query3 = "DELETE FROM progress_assignment WHERE assignment_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query3)) {
            statement.setString(1, AppSession.getInstance().getSelectedAssignment());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getAssignmentTitle() {
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

    public String getAssignmentDescription() {
        String query = "SELECT description FROM assignment WHERE id = ?";
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

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, AppSession.getInstance().getStudent().getId());
            statement.setString(2, AppSession.getInstance().getSelectedAssignment());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return rs.getString("sub_attachment");
            }
        } catch (SQLException e) {
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

    public void manageGradeAssignmentSql(Double score) {
        String progressId = "";
        String getStudentProgressId = "SELECT p.id as id FROM progress p " +
                "WHERE p.student_id = ? AND p.classroom_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(getStudentProgressId)) {
            statement.setString(1, AppSession.getInstance().getStudent().getId());
            statement.setString(2, AppSession.getInstance().getSelectedClassroom());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                progressId = rs.getString("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("student progress id to grade: " + progressId);

        String query = "UPDATE progress_assignment SET score = ?, status = 'inactive' WHERE progress_id = ? AND assignment_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setDouble(1, score);
            System.out.println("Assignment ID to grade: " + AppSession.getInstance().getSelectedAssignment());
            statement.setString(2, progressId);
            statement.setString(3, AppSession.getInstance().getSelectedAssignment());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isAssignmentSubmitted() {
        String query = "SELECT sub_attachment FROM progress_assignment pa " +
                "JOIN progress p ON pa.progress_id = p.id " +
                "WHERE pa.assignment_id = ? AND p.student_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, AppSession.getInstance().getSelectedAssignment());
            statement.setString(2, AppSession.getInstance().getStudent().getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                if (rs.getString("sub_attachment") != null) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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

    public String getStudentSubAttachment() {
        String query = "SELECT sub_attachment FROM progress_assignment pa " +
                "JOIN progress p ON pa.progress_id = p.id " +
                "WHERE pa.assignment_id = ? AND p.student_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, AppSession.getInstance().getSelectedAssignment());
            statement.setString(2, AppSession.getInstance().getStudent().getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                if (rs.getString("sub_attachment") != null) {
                    return rs.getString("sub_attachment");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}