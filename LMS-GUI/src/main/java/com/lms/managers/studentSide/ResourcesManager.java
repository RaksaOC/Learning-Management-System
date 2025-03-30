package main.java.com.lms.managers.studentSide;

import entities.Student;
import main.AppSession;
import main.DatabaseConnection;

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

    public Map<String, String> getAllUnfinishedResources() {
        Map<String, String> id_name_classroom = new HashMap<>();
        String query = "SELECT CONCAT(m.id, ' - ', m.title) AS id_name, " +
                "p.classroom_id as class_id " +
                "FROM progress_material as pm " +
                "JOIN progress AS p " +
                "ON pm.progress_id = p.id " +
                "JOIN material AS m " +
                "ON pm.material_id = m.id " +
                "WHERE p.student_id = ?  AND pm.status = 'active' ";
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
}