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

public class QuizzesManager {
    private Student student;
    public QuizzesManager() {
        AppSession session = AppSession.getInstance();
        this.student = session.getStudent();
    }

    public HashMap<String, String> getAllQuizzes(){
        JSONObject progress = student.getProgress();

        ArrayList<String> progressIds = new ArrayList<>();
        Iterator<String> iterator = progress.keys();
        while (iterator.hasNext()) {
            String key = iterator.next();
            progressIds.add(progress.getString(key));
        }
        JSONArray studentProgress = getAllStudentProgress(progressIds);
        HashMap<String, String> allQuizzes = new HashMap<>();
        for (int i = 0; i < studentProgress.length(); i++) {
            for (int j = 0; j < studentProgress.getJSONObject(i).getJSONArray("quizzes").length(); j++) {
                allQuizzes.put(studentProgress.getJSONObject(i).getJSONArray("quizzes").getString(j), studentProgress.getJSONObject(i).getString("classroomId"));
            }
        }

        return allQuizzes;
    }

    private JSONArray getAllStudentProgress(List<String> progressIds){
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