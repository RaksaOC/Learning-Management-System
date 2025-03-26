package main.java.com.lmsAdmin.managers.layer1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.DatabaseConnection;
import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DashboardManager {
    private Connection conn = DatabaseConnection.getInstance().getConnection();

    public int getNumberOfStudents() {
        String query = "SELECT COUNT(*) FROM student";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getInt(1);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public int getNumberOfCourses() {
        String query = "SELECT COUNT(*) FROM course";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getInt(1);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public int getNumberOfTeachers() {
        String query = "SELECT COUNT(*) FROM teacher";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getInt(1);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public int getNumberOfClassrooms(){
        String query = "SELECT COUNT(*) FROM classroom";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getInt(1);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public ObservableList<Map<String, String>> getStudentHistory(){
        String query = "SELECT * FROM student_history";
        ObservableList<Map<String, String>> data = FXCollections.observableArrayList();
        try(PreparedStatement statement = conn.prepareStatement(query)){
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Map<String, String> map = new HashMap<>();
                map.put("student_id", rs.getString("student_id"));
                map.put("time", rs.getString("time"));
                map.put("last_action", rs.getString("last_action"));
                data.add(map);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return data;
    }

    public ObservableList<Map<String, String>> getTeacherHistory(){
        String query = "SELECT * FROM teacher_history";
        ObservableList<Map<String, String>> data = FXCollections.observableArrayList();
        try(PreparedStatement statement = conn.prepareStatement(query)){
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Map<String, String> map = new HashMap<>();
                map.put("teacher_id", rs.getString("teacher_id"));
                map.put("time", rs.getString("time"));
                map.put("last_action", rs.getString("last_action"));
                data.add(map);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return data;
    }

    public ObservableList<Map<String, String>> getActiveClassrooms(){
        String query = "SELECT * FROM classroom WHERE status = 'active'";
        ObservableList<Map<String, String>> data = FXCollections.observableArrayList();
        try(PreparedStatement statement = conn.prepareStatement(query)){
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Map<String, String> map = new HashMap<>();
                map.put("id", rs.getString("id"));
                map.put("teacher_id", rs.getString("teacher_id"));
                map.put("course_id", rs.getString("course_id"));
                map.put("group_id", rs.getString("group_id"));
                data.add(map);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return data;
    }
//    private final String studentFilePath = "shared/data/student.json";
//    private final String teacherFilePath = "shared/data/teacher.json";
//    private final String classroomFilePath = "shared/data/classroom.json";
//    private final String historyFilePath = "shared/data/history.json";
//    private final String uniFilePath = "shared/data/university.json";
//
//    private String content;
//
//    public int getNumberOfStudents() {
//        try{
//            content = new String(Files.readAllBytes(Paths.get(studentFilePath)));
//            JSONArray students = new JSONArray(content);
//            return students.length();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return 0;
//    }
//    public int getNumberOfTeachers() {
//        try{
//            content = new String(Files.readAllBytes(Paths.get(teacherFilePath)));
//            JSONArray teachers = new JSONArray(content);
//            return teachers.length();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return 0;
//    }
//    public int getNumberOfCourses() {
//        try{
//            content = new String(Files.readAllBytes(Paths.get(uniFilePath)));
//            JSONObject uni = new JSONObject(content);
//            JSONArray courses = new JSONArray(uni.getJSONArray("courses"));
//            return courses.length();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return 0;
//    }
//    public int getNumberOfClassrooms() {
//        try{
//            content = new String(Files.readAllBytes(Paths.get(classroomFilePath)));
//            JSONArray classrooms = new JSONArray(content);
//            return classrooms.length();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return 0;
//    }
//    public JSONArray getTeachersHistory(){
//        try{
//            content = new String(Files.readAllBytes(Paths.get(historyFilePath)));
//            JSONObject history = new JSONObject(content);
//            return new JSONArray(history.getJSONArray("teacher"));
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }
//    public JSONArray getStudentsHistory(){
//        try{
//            content = new String(Files.readAllBytes(Paths.get(historyFilePath)));
//            JSONObject history = new JSONObject(content);
//            return new JSONArray(history.getJSONArray("student"));
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }
//    public JSONArray getActiveClassrooms(){
//        try{
//            content = new String(Files.readAllBytes(Paths.get(classroomFilePath)));
//            JSONArray classrooms = new JSONArray(content);
//            JSONArray activeClassrooms = new JSONArray();
//            for(int i = 0; i < classrooms.length(); i++){
//                if (classrooms.getJSONObject(i).getString("status").equals("active")){
//                    activeClassrooms.put(classrooms.getJSONObject(i));
//                }
//            }
//            return activeClassrooms;
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }

}
