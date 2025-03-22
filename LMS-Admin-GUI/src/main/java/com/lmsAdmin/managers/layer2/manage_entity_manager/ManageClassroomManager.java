package main.java.com.lmsAdmin.managers.layer2.manage_entity_manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.DatabaseConnection;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ManageClassroomManager extends ManageEntityManager {
    private Connection conn = DatabaseConnection.getInstance().getConnection();
    private String classroomId;

    public void manageAddClassroom(String id,
                                   String teacher_id,
                                   String course_id,
                                   String group_id,
                                   String status) {
        classroomId = id;
        insertIntoClassroom(id, teacher_id, course_id, group_id, status);
        ArrayList<String> studentIds = getStudentIdsInGroup(group_id);
        insertIntoProgress(studentIds);
    }

    public void manageDeleteClassroom(String id) {
        // TODO: add cannot delete logic
        String query = "UPDATE classroom SET status = 'inactive' WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Map<String, String>> getAllClassroomDetails() {
        String query = "SELECT * FROM classroom";
        ObservableList<Map<String, String>> data = FXCollections.observableArrayList();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Map<String, String> map = new HashMap<>();
                map.put("id", resultSet.getString("id"));
                map.put("teacher_id", resultSet.getString("teacher_id"));
                map.put("course_id", resultSet.getString("course_id"));
                map.put("group_id", resultSet.getString("group_id"));
                map.put("status", resultSet.getString("status"));
                data.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public Map<String, String> getClassroomDetails(String id) {
        String query = "SELECT * FROM classroom WHERE id = ?";
        Map<String, String> map = new HashMap<>();
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                map.put("id", resultSet.getString("id"));
                map.put("teacher_id", resultSet.getString("teacher_id"));
                map.put("course_id", resultSet.getString("course_id"));
                map.put("group_id", resultSet.getString("group_id"));
                map.put("status", resultSet.getString("status"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return map;
    }

    public boolean isClassroomIdTaken(String classroomId) {
        String query = "SELECT 1 FROM classroom WHERE id = ? LIMIT 1";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, classroomId);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    private void insertIntoClassroom(String id, String teacher_id, String course_id, String group_id, String status) {
        String query = "INSERT INTO classroom (id, teacher_id, course_id, group_id, status) VALUES(?,?,?,?,?)";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, id);
            statement.setString(2, teacher_id);
            statement.setString(3, course_id);
            statement.setString(4, group_id);
            statement.setString(5, status);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<String> getStudentIdsInGroup(String group_id) {
        ArrayList<String> studentIds = new ArrayList<>();
        String query2 = "SELECT id FROM student WHERE group_id = ?";
        try(PreparedStatement statement = conn.prepareStatement(query2)){
            statement.setString(1, group_id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                studentIds.add(rs.getString(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return studentIds;
    }

    private void insertIntoProgress(ArrayList<String> studentIds) {
        int numOfStudents = studentIds.size();
        String query = "INSERT INTO progress (id, student_id, classroom_id) VALUES (?, ?, ?)";
        for (int i = 0; i < numOfStudents; i++) {
            try(PreparedStatement statement = conn.prepareStatement(query)){
                statement.setString(1, generateNewID("progress"));
                statement.setString(2, studentIds.get(i));
                statement.setString(3, classroomId);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}