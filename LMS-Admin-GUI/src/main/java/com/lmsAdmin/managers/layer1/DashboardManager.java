package main.java.com.lmsAdmin.managers.layer1;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class DashboardManager {
    private final String studentFilePath = "shared/data/student.json";
    private final String teacherFilePath = "shared/data/teacher.json";
    private final String classroomFilePath = "shared/data/classroom.json";
    private final String historyFilePath = "shared/data/history.json";
    private final String uniFilePath = "shared/data/university.json";

    private String content;

    public int getNumberOfStudents() {
        try{
            content = new String(Files.readAllBytes(Paths.get(studentFilePath)));
            JSONArray students = new JSONArray(content);
            return students.length();
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    public int getNumberOfTeachers() {
        try{
            content = new String(Files.readAllBytes(Paths.get(teacherFilePath)));
            JSONArray teachers = new JSONArray(content);
            return teachers.length();
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    public int getNumberOfCourses() {
        try{
            content = new String(Files.readAllBytes(Paths.get(uniFilePath)));
            JSONObject uni = new JSONObject(content);
            JSONArray courses = new JSONArray(uni.getJSONArray("courses"));
            return courses.length();
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    public int getNumberOfClassrooms() {
        try{
            content = new String(Files.readAllBytes(Paths.get(classroomFilePath)));
            JSONArray classrooms = new JSONArray(content);
            return classrooms.length();
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    public JSONArray getTeachersHistory(){
        try{
            content = new String(Files.readAllBytes(Paths.get(historyFilePath)));
            JSONObject history = new JSONObject(content);
            return new JSONArray(history.getJSONArray("teacher"));
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public JSONArray getStudentsHistory(){
        try{
            content = new String(Files.readAllBytes(Paths.get(historyFilePath)));
            JSONObject history = new JSONObject(content);
            return new JSONArray(history.getJSONArray("student"));
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public JSONArray getActiveClassrooms(){
        try{
            content = new String(Files.readAllBytes(Paths.get(classroomFilePath)));
            JSONArray classrooms = new JSONArray(content);
            JSONArray activeClassrooms = new JSONArray();
            for(int i = 0; i < classrooms.length(); i++){
                if (classrooms.getJSONObject(i).getString("status").equals("active")){
                    activeClassrooms.put(classrooms.getJSONObject(i));
                }
            }
            return activeClassrooms;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
