package main.java.com.lms.managers.studentSide;

import entities.Student;
import main.AppSession;
import main.DatabaseConnection;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class QuizzesManager {
    private static final Connection conn = DatabaseConnection.getInstance().getConnection();
    private Student student;

    public QuizzesManager() {
        AppSession session = AppSession.getInstance();
        this.student = session.getStudent();
    }

    // ========================================
    // SQL-RELATED METHODS (TO BE IMPLEMENTED)
    // ========================================

    // TODO: sql equivalent methods goes here, method name should have the same name but with Sql at the end. Ex: manageDoQuiz -> manageDoQuizSql


    public ArrayList<ArrayList<Map<String, String>>> manageDisplayQuizSql(String studentID) {
        ArrayList<String> quizzesIDFromSQL = returnQuizSql(studentID);
        ArrayList<ArrayList<Map<String, String>>> titleAndDescriptionList = returnTitleAndDescriptionForStudentToChoose(quizzesIDFromSQL);
        return titleAndDescriptionList;
    }

//    public ArrayList<Map<String, Object>> displayChosenQuiz(String chosenQuizID, String studentID){
//        ArrayList<Map<String, Object>> questionsAndChoices = returnQuestionsAndItsChoices(chosenQuizID); // this one returns the questions based on the quiz that the student chose. each question has its choices
//        return questionsAndChoices;
//    }

    public void submitAndCheckAnswer( ArrayList<Map<String, Object>> questionsAndChoices, String chosenQuizID, ArrayList<Integer> answerList){
        ArrayList<ArrayList<Boolean>> answerToCheckWithStudentsAnswer = new ArrayList<>();

        for (Map<String, Object> questionAndChoice : questionsAndChoices) {
            // Get the choices (ArrayList of Maps)
            ArrayList<Map<String, Object>> choices = (ArrayList<Map<String, Object>>) questionAndChoice.get("choices");

            // Create a new list to store correct choices as boolean
            ArrayList<Boolean> correctChoices = new ArrayList<>();

            // Iterate through each choice and check if it's correct
            for (Map<String, Object> choice : choices) {
                // Extract the 'isCorrect' value
                String isCorrectStr = (String) choice.get("isCorrect");

                // Check if the value is '1' or 'true' and map it to a boolean
                Boolean isCorrect = isCorrectStr != null && (isCorrectStr.equals("1") || isCorrectStr.equalsIgnoreCase("true"));
                correctChoices.add(isCorrect);  // Add the isCorrect value to the list
            }

            // Add the list of correct choices to the final answer list
            answerToCheckWithStudentsAnswer.add(correctChoices);
        }
        checkAnswerSql(answerToCheckWithStudentsAnswer, answerList, chosenQuizID);
    }

    private ArrayList<String> returnQuizSql(String studentID) {
        String progressQuery = "SELECT id FROM progress WHERE student_id = ?";
        ArrayList<String> progressIDList = new ArrayList<>();

        try (PreparedStatement statement = conn.prepareStatement(progressQuery)) {
            statement.setString(1, studentID);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) { // Fetch all progress IDs
                progressIDList.add(rs.getString("id"));
            }

            if (progressIDList.isEmpty()) {
                System.out.println("No progress found for student.");
                return new ArrayList<>();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

        // ✅ Construct dynamic SQL query for multiple progress_ids
        StringBuilder progressQuizQuery = new StringBuilder("SELECT quiz_id FROM progress_quiz WHERE status = 'active' AND progress_id IN (");

        // Dynamically add '?' placeholders
        for (int i = 0; i < progressIDList.size(); i++) {
            progressQuizQuery.append("?");
            if (i < progressIDList.size() - 1) {
                progressQuizQuery.append(", ");
            }
        }
        progressQuizQuery.append(")");

        ArrayList<String> quizzesFromSQL = new ArrayList<>();

        try (PreparedStatement statement = conn.prepareStatement(progressQuizQuery.toString())) {
            for (int i = 0; i < progressIDList.size(); i++) {
                statement.setString(i + 1, progressIDList.get(i)); // Set each progress_id
            }

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                quizzesFromSQL.add(rs.getString("quiz_id"));
            }

            if (quizzesFromSQL.isEmpty()) {
                System.out.println("No active quizzes found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quizzesFromSQL;
    }

    private ArrayList<ArrayList<Map<String, String>>> returnTitleAndDescriptionForStudentToChoose(ArrayList<String> quizIDList) {
        ArrayList<ArrayList<Map<String, String>>> titleAndDescriptionList = new ArrayList<>();
        StringBuilder quizQuery = new StringBuilder("SELECT title, description FROM quiz WHERE id IN (");
        for (int i = 0; i < quizIDList.size(); i++) {
            quizQuery.append("?");
            if (i < quizIDList.size() - 1) {
                quizQuery.append(", ");
            }
        }
        quizQuery.append(")");

        try (PreparedStatement statement = conn.prepareStatement(quizQuery.toString())) {
            for (int i = 0; i < quizIDList.size(); i++) {
                statement.setString(i + 1, quizIDList.get(i)); // Set each progress_id
            }
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Map<String, String> titleOrDescription = new HashMap<>();
                ArrayList<Map<String, String>> titleAndDescription = new ArrayList<>();
                titleOrDescription.put("title", rs.getString("title"));
                titleOrDescription.put("description", rs.getString("description"));
                titleAndDescription.add(titleOrDescription);
                titleAndDescriptionList.add(titleAndDescription);
            }

            if (titleAndDescriptionList.isEmpty()) {
                System.out.println("No data from title and description");
            } else {
                return titleAndDescriptionList;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList<Map<String, Object>> returnQuestionsAndChoices(String chosenQuizID) {
        ArrayList<Map<String, Object>> questionsAndItsChoicesList = new ArrayList<>();
        String questionQuery = "select title, id from question where quiz_id=?";
        ArrayList<String> questionList = new ArrayList<>();
        ArrayList<String> idList = new ArrayList<>();

        try (PreparedStatement statement = conn.prepareStatement(questionQuery)) {
            statement.setString(1, chosenQuizID);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                questionList.add(rs.getString("title"));
                idList.add(rs.getString("id"));
            }

            if (questionList.isEmpty() || idList.isEmpty()) {
                System.out.println("No id and title");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        StringBuilder choiceQuery = new StringBuilder("SELECT question_id, choice_text, isCorrect FROM choice WHERE question_id IN (");
        for (int i = 0; i < idList.size(); i++) {
            choiceQuery.append("?");
            if (i < idList.size() - 1) {
                choiceQuery.append(", ");
            }
        }
        choiceQuery.append(")");

        ArrayList<ArrayList<Map<String, Object>>> choicesList = new ArrayList<>();
        ArrayList<Map<String, Object>> choicesWithValue = new ArrayList<>();
        String currentID = idList.get(0);  // Initialize currentID to the first element in the list

        try (PreparedStatement statement = conn.prepareStatement(choiceQuery.toString())) {
            for (int i = 0; i < idList.size(); i++) {
                statement.setString(i + 1, idList.get(i)); // Set each question_id from the idList
            }

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String questionID = rs.getString("question_id");

                // If the current question ID has changed, we need to save the previous choices and reset the list
                if (!currentID.equals(questionID)) {
                    choicesList.add(new ArrayList<>(choicesWithValue));  // Add the collected choices for the previous question
                    choicesWithValue.clear();  // Reset the choices list for the new question
                    currentID = questionID;  // Update the current question ID
                }

                // Create a new map for each choice
                Map<String, Object> choiceOrValue = new HashMap<>();
                choiceOrValue.put("choice_text", rs.getString("choice_text"));
                choiceOrValue.put("isCorrect", rs.getString("isCorrect"));

                choicesWithValue.add(choiceOrValue);  // Add the choice to the current question's list
            }

            // Add the last question's choices after the loop ends
            if (!choicesWithValue.isEmpty()) {
                choicesList.add(new ArrayList<>(choicesWithValue));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Now, combine the question titles and choices into a final list of maps
        for (int i = 0; i < questionList.size(); i++) {
            Map<String, Object> qAndC = new HashMap<>();
            qAndC.put("title", questionList.get(i));
            qAndC.put("choices", choicesList.get(i));
            questionsAndItsChoicesList.add(qAndC);
        }

        return questionsAndItsChoicesList;
    }

    private void checkAnswerSql( ArrayList<ArrayList<Boolean>> answerListToCheck, ArrayList<Integer> answerListFromStudent, String chosenQuizID) {
        String quarry = "update progress_quiz set status='inactive', score=? where quiz_id=?";
        double score=0.00;
        for (int i = 0; i < answerListFromStudent.size(); i++) {
            if(answerListToCheck.get(i).get(answerListFromStudent.get(i)-1)){
                score++;
            }
        }
        System.out.println(score);
        try(PreparedStatement statement = conn.prepareStatement(quarry)){
            statement.setDouble(1, score);
            statement.setString(2, chosenQuizID);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }




    // ========================================
    // JSON-RELATED METHODS
    // ========================================

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

    public Map<String, String> getAllQuizzes() {
        Map<String, String> id_name_classroom = new HashMap<>();
        String query = "SELECT CONCAT(q.id, ' - ' ,q.title) AS id_name, " +
                "p.classroom_id as class_id  " +
                "FROM progress_quiz as pq " +
                "JOIN progress AS p " +
                "ON pq.progress_id = p.id " +
                "JOIN quiz AS q " +
                "ON pq.quiz_id = q.id " +
                "WHERE p.student_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, AppSession.getInstance().getStudent().getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                id_name_classroom.put(rs.getString("id_name"), rs.getString("class_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id_name_classroom;
    }

    public ArrayList<String> getClassroomQuizzes() {
        ArrayList<String> quizzes = new ArrayList<>();
        String query = "SELECT CONCAT(q.id, ' - ', q.title) AS id_name " +
                "FROM progress_quiz AS pq " +
                "JOIN progress AS p ON pq.progress_id = p.id " +
                "JOIN quiz AS q ON pq.quiz_id = q.id " +
                "WHERE p.classroom_id = ? AND p.student_id = ?";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, AppSession.getInstance().getSelectedClassroom());
            statement.setString(2, AppSession.getInstance().getStudent().getId());
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                quizzes.add(rs.getString("id_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quizzes;
    }

    public String getQuizTitle(){
        String query = "SELECT title FROM quiz WHERE id = ?";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, AppSession.getInstance().getSelectedQuiz());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return rs.getString("title");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return "";
    }

    public String getQuizDescription(){
        String query = "SELECT description FROM quiz WHERE id = ?";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, AppSession.getInstance().getSelectedQuiz());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return rs.getString("description");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return "";
    }

    public ArrayList<Map<String, String>> getAllStudentsAndScore(){
        String query = "SELECT s.id as id, CONCAT(s.first_name, ' ' , s.last_name) AS name, pq.score as score FROM student as s " +
                "JOIN progress as p ON p.student_id = s.id " +
                "JOIN progress_quiz as pq ON pq.progress_id = p.id " +
                "WHERE pq.quiz_id = ?";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, AppSession.getInstance().getSelectedQuiz());
            ResultSet rs = statement.executeQuery();
            ArrayList<Map<String, String>> quizzes = new ArrayList<>();
            while (rs.next()) {
                Map<String, String> quiz = new HashMap<>();
                quiz.put("id", rs.getString("id"));
                quiz.put("name", rs.getString("name"));
                quiz.put("score", rs.getString("score"));
                quizzes.add(quiz);
            }
            return quizzes;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    // Rasa Front end related functions -----------------------------------------------------------------------------------------------

    private JSONArray getAllStudentProgress(List<String> progressIds) {
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

    private JSONArray loadProgress() {
        try {
            String content = new String(Files.readAllBytes(Paths.get("shared/data/progress.json")));
            return new JSONArray(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
