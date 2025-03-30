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
    private final Student student;
    private final Connection conn;

    public AssignmentsManager() {
        AppSession session = AppSession.getInstance();
        this.student = session.getStudent();
        this.conn = DatabaseConnection.getInstance().getConnection();
    }

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
                "WHERE p.classroom_id = ? AND p.student_id = ? ";

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
}