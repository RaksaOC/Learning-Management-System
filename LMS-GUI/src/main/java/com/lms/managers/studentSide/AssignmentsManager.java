package main.java.com.lms.managers.studentSide;

import entities.Student;
import main.AppSession;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AssignmentsManager {
    private Student student;
    public AssignmentsManager() {
        AppSession session = AppSession.getInstance();
        this.student = session.getStudent();
    }

    // ========================================
    // SQL-RELATED METHODS
    // ========================================

    // TODO: sql equivalent methods goes here, method name should have the same name but with Sql at the end. Ex: manageDoQuiz -> manageDoQuizSql



























    // ========================================
    // JSON-RELATED METHODS
    // ========================================

    public HashMap<String, String> getAllAssignments(){
        JSONObject progress = student.getProgress();

        ArrayList<String> progressIds = new ArrayList<>();
        Iterator<String> iterator = progress.keys();
        while (iterator.hasNext()) {
            String key = iterator.next();
            progressIds.add(progress.getString(key));
        }
        JSONArray studentProgress = getAllRelatedStudentProgress(progressIds);

        HashMap<String, String> assignments = new HashMap<>();
        for (int i = 0; i < studentProgress.length(); i++) {
            for (int j = 0; j < studentProgress.getJSONObject(i).getJSONArray("assignments").length(); j++) {
                assignments.put(studentProgress.getJSONObject(i).getJSONArray("assignments").getString(j), studentProgress.getJSONObject(i).getString("classroomId"));
            }
        }
        return assignments;
    }

    private JSONArray getAllRelatedStudentProgress(List<String> progressIds){
        JSONArray allProgress = loadProgress();
        JSONArray studentProgress = new JSONArray();
        for (int i = 0; i < progressIds.size(); i++) {
            for (int j = 0; j < allProgress.length(); j++) {
                if (progressIds.get(i).equals(allProgress.getJSONObject(j).getString("id"))) {
                    studentProgress.put(allProgress.getJSONObject(j));
                }
            }
        }
        return studentProgress;
    }

    private JSONArray loadProgress(){
        try{
            String content = new String(Files.readAllBytes(Paths.get("shared/data/progress.json")));
            return new JSONArray(content);
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}