package main.java.com.lms.managers.studentSide;

import entities.Student;
import main.AppSession;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class QuizzesManager {
    private Student student;
    public QuizzesManager() {
        AppSession session = AppSession.getInstance();
        this.student = session.getStudent();
    }

    public void manageDoQuiz(int quizIndex, String[] answers, String classID) {
        Map<String, Object> getQuizFromFile = returnQuiz(quizIndex, classID);
        if (getQuizFromFile == null) {
            System.out.println("You have done all the quizzes");
            return;
        }
        checkAnswer(getQuizFromFile, answers);
        System.out.println("The score is: " + getQuizScore("S000001"));
    }

    private Map<String, Object> returnQuiz(int quizIndex, String classID) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("shared/data/progress.json")));
            JSONArray contentToEdit = new JSONArray(content);
            ArrayList<String> quizzesID = new ArrayList<>();
            String quizIdToReturn = "";
            if (!content.isEmpty()) {
                for (int i = 0; i < contentToEdit.length(); i++) {
                    if (contentToEdit.getJSONObject(i).getString("classroomId").equals(classID)) {
                        for (int j = 0; j < contentToEdit.getJSONObject(i).getJSONArray("quizzes").length(); j++) {
                            if (contentToEdit.getJSONObject(i).getJSONArray("quizzes").getJSONObject(j).getInt("score") == -1) {
                                quizzesID.add(contentToEdit.getJSONObject(i).getJSONArray("quizzes").getJSONObject(j).getString("id"));
                            }
                        }
                    }
                }
                if (quizzesID == null) {
                    return null;
                }
                try {
                    String contentQuiz = new String(Files.readAllBytes(Paths.get("shared/data/quiz.json")));
                    JSONArray questions = null;
                    JSONArray jsonContent = new JSONArray(contentQuiz);
                    int index = 0;
                    for (int i = 0; i < jsonContent.length(); i++) {
                        if (jsonContent.getJSONObject(i).getString("id").equals(quizzesID.get(index))) {
                            index++;
                            JSONObject quiz = jsonContent.getJSONObject(i);
                            if (quiz.getString("id").equals(quizzesID.get(quizIndex - 1))) {
                                quizIdToReturn = quizzesID.get(quizIndex - 1);
                                questions = quiz.getJSONArray("questions");
                            }
                            System.out.println("------------------------------------------------------");
                            System.out.println("Id: " + quiz.getString("id"));
                            System.out.println("Title: " + quiz.getString("title"));
                            System.out.println("------------------------------------------------------");
                        }
                    }
                    Map<String, Object> result = new HashMap<>();
                    result.put("questions", questions);
                    result.put("Id", quizIdToReturn);
                    return result;
                } catch (IOException e) {
                    System.err.println("Error while parsing: quiz.json");
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.err.println("Error while parsing: progress.json");
            e.printStackTrace();
        }
        return null;
    }

    public int getQuizScore(String studentID) {
        int score = 0;
        try {
            String contentQuiz = new String(Files.readAllBytes(Paths.get("shared/data/progress.json")));
            if (!contentQuiz.isEmpty()) {
                JSONArray content = new JSONArray(contentQuiz);
                for (int i = 0; i < content.length(); i++) {
                    if (content.getJSONObject(i).getString("studentId").equals(studentID)) {
                        for (int j = 0; j < content.getJSONObject(i).getJSONArray("quizzes").length(); j++) {
                            if (content.getJSONObject(i).getJSONArray("quizzes").getJSONObject(j).getInt("score") != -1) {
                                score += content.getJSONObject(i).getJSONArray("quizzes").getJSONObject(j).getInt("score");
                            }
                        }
                    }
                }
            }
            return score;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }


    private void checkAnswer(Map<String, Object> questionsAndID, String[] answers) {
        int result = 0;
        Object questionsObject = questionsAndID.get("questions");
        JSONArray questions;

        if (questionsObject instanceof JSONArray) {
            questions = (JSONArray) questionsObject;
        } else if (questionsObject instanceof String) {
            try {
                questions = new JSONArray((String) questionsObject);
            } catch (Exception e) {
                System.err.println("Error: 'questions' is not a valid JSON string.");
                e.printStackTrace();
                return;
            }
        } else {
            System.err.println("Error: 'questions' is not a JSONArray or a String.");
            return;
        }

        String ID = (String) questionsAndID.get("Id");
        for (int i = 0; i < questions.length(); i++) {
            if (answers[i].equals(questions.getJSONObject(i).getString("answer"))) {
                result++;
            }
        }
        try {
            String contentQuiz = new String(Files.readAllBytes(Paths.get("shared/data/progress.json")));
            if (!contentQuiz.isEmpty()) {
                JSONArray content = new JSONArray(contentQuiz);
                for (int i = 0; i < content.length(); i++) {
                    if (content.getJSONObject(i).getString("classroomId").equals("GEN10-CS-SE-G1-OOP"))
                        for (int j = 0; j < content.getJSONObject(i).getJSONArray("quizzes").length(); j++) {
                            if (content.getJSONObject(i).getJSONArray("quizzes").getJSONObject(j).getString("id").equals(ID)) {
                                content.getJSONObject(i).getJSONArray("quizzes").getJSONObject(j).put("score", result);
                                try (FileWriter file = new FileWriter("shared/data/progress.json")) {
                                    file.write(content.toString(4));
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                                break;
                            }
                        }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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