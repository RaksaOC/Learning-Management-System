package main.java.com.lms.managers.teacherSide;

import com.mysql.cj.jdbc.result.UpdatableResultSet;
import entities.Student;
import main.AppSession;
import main.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClassroomsManger {
    private Connection conn = DatabaseConnection.getInstance().getConnection();

    public ArrayList<String> getAllClassrooms(){
        ArrayList<String> classrooms = new ArrayList<>();
        String query = "SELECT id FROM classroom c " +
                "WHERE c.teacher_id = ?";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, AppSession.getInstance().getTeacher().getId());
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                classrooms.add(resultSet.getString(1));
            }
            return classrooms;
        }catch (Exception e){
            e.printStackTrace();
        }
        return classrooms;
    }

    public ArrayList<String> getAllStudentsInClassroom(){
        ArrayList<String> students = new ArrayList<>();
        String query = "SELECT CONCAT(s.id, ' - ', s.first_name, ' ', s.last_name) as name FROM student as s " +
                "JOIN progress as p " +
                "ON p.student_id = s.id " +
                "WHERE p.classroom_id = ?";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, AppSession.getInstance().getSelectedClassroom());
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                students.add(resultSet.getString("name"));
            }
            return students;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Map<String, String>> getAllStudentsDetailInClassroom() {
        ArrayList<Map<String, String>> students = new ArrayList<>();
        String query = "SELECT s.id, CONCAT(s.first_name, ' ', s.last_name) AS name FROM student s " +
                "JOIN progress p ON p.student_id = s.id " +
                "WHERE p.classroom_id = ?";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, AppSession.getInstance().getSelectedClassroom());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Map<String, String> map = new HashMap<>();
                map.put("id", resultSet.getString("id"));    // Correct key
                map.put("name", resultSet.getString("name"));// Correct key
                students.add(map);
            }

        } catch (Exception e) {
            System.err.println("Error fetching students for classroom: " + e.getMessage());
            e.printStackTrace();
        }

        return students;
    }


    public Student getStudentToGrade(String studentId){
        String query = "SELECT * FROM student WHERE id = ?";
        Student student = null;
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, studentId);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                student = new Student(
                        rs.getString("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("gender"),
                        rs.getString("dob"),
                        rs.getString("phone_number"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("commune"),
                        rs.getString("district"),
                        rs.getString("province"),
                        rs.getString("status"),
                        rs.getString("created_at"),
                        rs.getString("last_login"),
                        rs.getString("department_id"),
                        rs.getString("specialization_id"),
                        rs.getString("generation_id"),
                        rs.getString("group_id"),
                        rs.getString("guardian_first_name"),
                        rs.getString("guardian_last_name"),
                        rs.getString("guardian_phone_number"),
                        rs.getString("guardian_gender"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return student;
    }
}