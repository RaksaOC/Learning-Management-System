package main.java.com.lms.managers.studentSide;

import entities.Student;
import main.AppSession;
import main.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DashboardManager {
    private Connection conn = DatabaseConnection.getInstance().getConnection();
    private Student student = AppSession.getInstance().getStudent();

    public int getNumOfAssignments() {
        String query = "SELECT count(*) " +
                "FROM assignment as a " +
                "join progress_assignment as pa " +
                "on a.id = pa.assignment_id AND pa.status = 'inactive' " +
                "JOIN progress as p " +
                "on pa.progress_id = p.id " +
                "where p.student_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, student.getId());

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getNumOfCourses() {
        String query = "SELECT COUNT(*) " +
                "FROM progress AS p " +
                "JOIN classroom as c " +
                "ON p.classroom_id = c.id " +
                "WHERE p.student_id = ? AND c.status = 'inactive' ";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, student.getId());
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getNumOfQuizzes() {
        String query = "SELECT count(*) " +
                "FROM quiz as a " +
                "join progress_quiz as pq " +
                "on a.id = pq.quiz_id AND pq.status = 'inactive' " +
                "JOIN progress as p " +
                "on pq.progress_id = p.id " +
                "where p.student_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, student.getId());

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}