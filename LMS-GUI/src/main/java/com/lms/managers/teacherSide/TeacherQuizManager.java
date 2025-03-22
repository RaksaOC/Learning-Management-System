package main.java.com.lms.managers.teacherSide;

import main.DatabaseConnection;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PipedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TeacherQuizManager extends ClassroomContentManager {
    private static final Connection conn= DatabaseConnection.getInstance().getConnection();
    public TeacherQuizManager(String classIdToEdit) {
        super(classIdToEdit);
    }
    // ========================================
    // SQL-RELATED METHODS
    // ========================================

    // TODO: sql equivalent methods goes here, method name should have the same name but with Sql at the end. Ex: manageDoQuiz -> manageDoQuizSql
    public void manageAddQuizSql(String title, String description, ArrayList<Map<String, Object>> quizList, String status){
        ArrayList<String> titles=new ArrayList<>();
        ArrayList<ArrayList<Map<String, Object>>> choicesList=new ArrayList<>();
        String quizID= generateNewID("quiz", "Q0000");

        for(Map<String, Object> quiz:quizList){
            titles.add((String) quiz.get("title"));
            choicesList.add((ArrayList<Map<String, Object>>) quiz.get("choices"));
        }
        insertToQuiz(quizID, title, description, status);
        for(int i=0;i<quizList.size();i++){
            String questionID= generateNewID("question", "QU0000");
            String choice_text="";
            boolean isCorrect=false;
            ArrayList<Map<String, Object>> currentChoiceList=choicesList.get(i);
            insertToQuestion(questionID, quizID, titles.get(i));
            for(int j=0;j<currentChoiceList.size();j++){
                String choiceID= generateNewID("choice", "CH0000");
                choice_text=(String) currentChoiceList.get(j).get("choice_text");
                isCorrect= (boolean) currentChoiceList.get(j).get("isCorrect");
                insertToChoice(choiceID, questionID, choice_text, isCorrect);
            }
        }
        insertToProgressQuiz("P0001", quizID, 0.00);
        insertToClassroomQuiz(this.classIdToEdit, quizID);
        System.out.println("finished");
    }

    public void manageEditQuizSql(){

    }

    public void manageDeleteQuizSql(){

    }

    public void manageViewQuiz(){

    }

    private static void insertToQuiz(String id, String title, String description, String status){
        String quarry = "INSERT INTO quiz (id, title, description, status) VALUES ( ?, ?, ?, ?)";
        try(PreparedStatement statement = conn.prepareStatement(quarry)){
            statement.setString(1, id);
            statement.setString(2, title);
            statement.setString(3, description);
            statement.setString(4, status);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static void insertToQuestion(String id, String quiz_id, String title){
        String quarry = "INSERT INTO question (id, quiz_id, title) VALUES ( ?, ?, ?)";
        try(PreparedStatement statement = conn.prepareStatement(quarry)){
            statement.setString(1, id);
            statement.setString(2, quiz_id);
            statement.setString(3, title);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static void insertToChoice(String id, String question_id, String choice_text, Boolean isCorrect){
        String quarry = "INSERT INTO choice (id, question_id, choice_text, isCorrect) VALUES ( ?, ?, ?, ?)";
        try(PreparedStatement statement = conn.prepareStatement(quarry)){
            statement.setString(1, id);
            statement.setString(2, question_id);
            statement.setString(3, choice_text);
            statement.setBoolean(4, isCorrect);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static void insertToProgressQuiz(String progress_id, String quiz_id, double score){
        String quarry = "INSERT INTO progress_quiz (progress_id, quiz_id, score) VALUES (?, ?, ?)";
        try(PreparedStatement statement = conn.prepareStatement(quarry)){
            statement.setString(1, progress_id);
            statement.setString(2, quiz_id);
            statement.setDouble(3, score);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    private static void insertToClassroomQuiz(String classIdToEdit,String quiz_id){
        String quarry = "INSERT INTO classroom_quiz (class_id, quiz_id) VALUES ( ?, ?)";
        try(PreparedStatement statement = conn.prepareStatement(quarry)){
            statement.setString(1, classIdToEdit);
            statement.setString(2, quiz_id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }



    protected String generateNewID(String tableName, String baseID) {
        try {
            // Query to get the count of rows in the table
            String query = "SELECT COUNT(id) as last_id FROM " + tableName;
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            // Initialize the new ID as 1 if no rows are found
            int newID = 1;
            if (rs.next()) {
                newID = rs.getInt("last_id") + 1;  // Increment last_id for the new ID
            }

            // Convert the new ID to a string and calculate how many digits it has
            String newID_String = String.valueOf(newID);

            // Calculate how many characters of the baseID need to be replaced
            int start = baseID.length() - newID_String.length();

            // Create a StringBuilder to modify the base ID
            StringBuilder baseIDBuilder = new StringBuilder(baseID);

            // Replace the numeric part of baseID with the new ID
            for (int i = start, j = 0; i < baseID.length(); i++, j++) {
                if (j < newID_String.length()) {
                    baseIDBuilder.setCharAt(i, newID_String.charAt(j)); // Replace characters
                }
            }

            // Return the newly generated ID
            return baseIDBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }













































    // ========================================
    // JSON-RELATED METHODS
    // ========================================

    public void manageAddQuizz(String classroomID, String title, String createdBy, JSONArray questions) {
        String id = "Q0000";
        try {
            String content = new String(Files.readAllBytes(Paths.get("shared/data/quiz.json")));
            JSONArray quizWriteToFile = new JSONArray(content);
            if (!quizWriteToFile.isEmpty()) {
                String getIDToUpdate = quizWriteToFile.getJSONObject(quizWriteToFile.length() - 1).getString("id");
                int updateID = Integer.parseInt(getIDToUpdate.substring(1)) + 1;
                id = "Q" + String.format("%04d", updateID);
            }
            JSONObject quiz = new JSONObject();
            quiz.put("id", id);
            quiz.put("title", title);
            quiz.put("createdBy", createdBy);
            quiz.put("questions", questions);
            quizWriteToFile.put(quiz);
            try (FileWriter file = new FileWriter("shared/data/quiz.json")) {
                file.write(quizWriteToFile.toString(4));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String content = new String(Files.readAllBytes(Paths.get("shared/data/classroom.json")));
            JSONArray contentToEdit = new JSONArray(content);
            if (!content.isEmpty()) {
                for (int i = 0; i < contentToEdit.length(); i++) {
                    if (contentToEdit.getJSONObject(i).getString("id").equals(classroomID)) {
                        contentToEdit.getJSONObject(i).getJSONArray("quizzes").put(id);
                    }
                }
            }
            try (FileWriter file = new FileWriter("shared/data/classroom.json")) {
                file.write(contentToEdit.toString(4));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String content = new String(Files.readAllBytes(Paths.get("shared/data/progress.json")));
            JSONArray contentToEdit = new JSONArray(content);
            if (!contentToEdit.isEmpty()) {
                for (int i = 0; i < contentToEdit.length(); i++) {
                    if (contentToEdit.getJSONObject(i).getString("classroomId").equals(classroomID)) {
                        JSONObject quizToPut = new JSONObject();
                        quizToPut.put("id", id);
                        quizToPut.put("score", -1);
                        contentToEdit.getJSONObject(i).getJSONArray("quizzes").put(quizToPut);
                    }
                }
            }
            try (FileWriter file = new FileWriter("shared/data/progress.json")) {
                file.write(contentToEdit.toString(4));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void manageEditQuizz(String title, JSONArray questionJson, String id) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("shared/data/quiz.json")));
            JSONArray contentArray = new JSONArray(content);
            if (!contentArray.isEmpty()) {
                for (int i = 0; i < contentArray.length(); i++) {
                    if (contentArray.getJSONObject(i).getString("id").equals(id)) {
                        contentArray.getJSONObject(i).put("title", title);
                        contentArray.getJSONObject(i).put("questions", questionJson);
                        try (FileWriter file = new FileWriter("shared/data/quiz.json")) {
                            file.write(contentArray.toString(4));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void manageDeleteQuizz(String idToDelete, String classID) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("shared/data/quiz.json")));
            JSONArray quizWriteToFile = new JSONArray(content);
            if (!quizWriteToFile.isEmpty()) {
                for (int i = 0; i < quizWriteToFile.length(); i++) {
                    if (quizWriteToFile.getJSONObject(i).getString("id").equals(idToDelete)) {
                        quizWriteToFile.remove(i);
                    }
                }
            }

            try (FileWriter file = new FileWriter("shared/data/quiz.json")) {
                file.write(quizWriteToFile.toString(4));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String content = new String(Files.readAllBytes(Paths.get("shared/data/classroom.json")));
            JSONArray contentToEdit = new JSONArray(content);
            if (!content.isEmpty()) {
                for (int i = 0; i < contentToEdit.length(); i++) {
                    if (contentToEdit.getJSONObject(i).getString("id").equals(classID)) {
                        for (int j = 0; j < contentToEdit.getJSONObject(i).getJSONArray("quizzes").length(); j++) {
                            if (contentToEdit.getJSONObject(i).getJSONArray("quizzes").getString(j).equals(idToDelete)) {
                                contentToEdit.getJSONObject(i).getJSONArray("quizzes").remove(j);
                                break;
                            }
                        }
                    }
                }
            }

            try (FileWriter file = new FileWriter("shared/data/classroom.json")) {
                file.write(contentToEdit.toString(4));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String content = new String(Files.readAllBytes(Paths.get("shared/data/progress.json")));
            JSONArray contentToEdit = new JSONArray(content);
            if (!content.isEmpty()) {
                for (int i = 0; i < contentToEdit.length(); i++) {
                    if (contentToEdit.getJSONObject(i).getString("id").equals(classID)) {
                        for (int j = 0; j < contentToEdit.getJSONObject(i).getJSONArray("quizzes").length(); j++) {
                            if (contentToEdit.getJSONObject(i).getJSONArray("quizzes").getString(j).equals(idToDelete)) {
                                contentToEdit.getJSONObject(i).getJSONArray("quizzes").remove(j);
                                break;
                            }
                        }
                    }
                }
            }
            try (FileWriter file = new FileWriter("shared/data/progress.json")) {
                file.write(contentToEdit.toString(4));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void manageViewQuizz(String id) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("shared/data/quiz.json")));
            JSONArray jsonContent = new JSONArray(content);
            if (id.isEmpty()) {
                for (int i = 0; i < jsonContent.length(); i++) {
                    JSONObject quiz = jsonContent.getJSONObject(i);
                    JSONArray questions = quiz.getJSONArray("questions");
                    System.out.println("------------------------------------------------------");
                    System.out.println("Id: " + quiz.getString("id"));
                    System.out.println("Title: " + quiz.getString("title"));
                    System.out.println("Created by: " + quiz.getString("createdBy"));
                    for (int j = 0; j < questions.length(); j++) {
                        JSONObject question = (questions.getJSONObject(j));
                        JSONArray choices = (question.getJSONArray("choices"));
                        System.out.println("Question " + (j + 1) + ": " + question.getString("questionTitle"));
                        System.out.println("choices: ");
                        for (int k = 0; k < choices.length(); k++) {
                            System.out.println((k + 1) + ". " + choices.getString(k));
                        }
                        System.out.println("Answer: " + question.getString("answer"));
                    }
                    System.out.println("------------------------------------------------------");
                }
            } else {
                for (int i = 0; i < jsonContent.length(); i++) {
                    if (jsonContent.getJSONObject(i).getString("id").equals(id)) {
                        JSONObject quiz = jsonContent.getJSONObject(i);
                        JSONArray questions = quiz.getJSONArray("questions");
                        System.out.println("------------------------------------------------------");
                        System.out.println("Id: " + quiz.getString("id"));
                        System.out.println("Title: " + quiz.getString("title"));
                        System.out.println("Created by: " + quiz.getString("createdBy"));
                        for (int j = 0; j < questions.length(); j++) {
                            JSONObject question = (questions.getJSONObject(j));
                            JSONArray choices = (question.getJSONArray("choices"));
                            System.out.println("Question " + (j + 1) + ": " + question.getString("questionTitle"));
                            System.out.println("choices: ");
                            for (int k = 0; k < choices.length(); k++) {
                                System.out.println((k + 1) + ". " + choices.getString(k));
                            }
                            System.out.println("Answer: " + question.getString("answer"));
                        }
                        System.out.println("------------------------------------------------------");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}