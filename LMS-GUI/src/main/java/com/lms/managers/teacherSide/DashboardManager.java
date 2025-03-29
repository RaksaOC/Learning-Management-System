package main.java.com.lms.managers.teacherSide;

import entities.Student;
import entities.Teacher;
import main.AppSession;
import main.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DashboardManager {
    private Connection conn = DatabaseConnection.getInstance().getConnection();
    private Teacher teacher = AppSession.getInstance().getTeacher();

    public int getNumOfAssignmentsCreated() {
        String query = "SELECT count(*) " +
                "FROM classroom_assignment as ca " +
                "join classroom as c " +
                "on ca.class_id = c.id " +
                "where c.teacher_id = ?";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, teacher.getId());

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

    public int getNumOfClassrooms() {
        String query = "SELECT COUNT(*) FROM classroom WHERE teacher_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, teacher.getId());
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

    public int getNumOfQuizzesCreated() {
        String query = "SELECT count(*) " +
                "FROM classroom_quiz as cq " +
                "join classroom as c " +
                "on cq.class_id = c.id " +
                "where c.teacher_id = ?";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, teacher.getId());

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

    public int getNumOfAssignmentsGraded(){
        String query = "SELECT COUNT(*) FROM progress_assignment as pa " +
                "JOIN progress as p " +
                "ON pa.progress_id = p.id " +
                "JOIN classroom AS c " +
                "ON p.classroom_id = c.id " +
                "JOIN teacher as t " +
                "ON c.teacher_id = t.id " +
                "WHERE pa.status = 'inactive' AND c.teacher_id = ?";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, teacher.getId());
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
}