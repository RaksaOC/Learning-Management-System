package main.java.com.lms.managers.studentSide;

import entities.Student;
import main.AppSession;
import main.DatabaseConnection;

import java.math.BigDecimal;
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

//    public void submitAndCheckAnswer(ArrayList<Map<String, Object>> questionsAndChoices, ArrayList<Integer> answerList) {
//        ArrayList<ArrayList<Boolean>> answerToCheckWithStudentsAnswer = new ArrayList<>();
//
//        for (Map<String, Object> questionAndChoice : questionsAndChoices) {
//            // Get the choices (ArrayList of Maps)
//            ArrayList<Map<String, Object>> choices = (ArrayList<Map<String, Object>>) questionAndChoice.get("choices");
//
//            // Create a new list to store correct choices as boolean
//            ArrayList<Boolean> correctChoices = new ArrayList<>();
//
//            // Iterate through each choice and check if it's correct
//            for (Map<String, Object> choice : choices) {
//                // Extract the 'isCorrect' value
//                String isCorrectStr = (String) choice.get("isCorrect");
//
//                // Check if the value is '1' or 'true' and map it to a boolean
//                Boolean isCorrect = isCorrectStr != null && (isCorrectStr.equals("1") || isCorrectStr.equalsIgnoreCase("true"));
//                correctChoices.add(isCorrect);  // Add the isCorrect value to the list
//            }
//
//            // Add the list of correct choices to the final answer list
//            answerToCheckWithStudentsAnswer.add(correctChoices);
//        }
//        checkAnswerSql(answerToCheckWithStudentsAnswer, answerList, AppSession.getInstance().getSelectedQuiz());
//    }

//    private ArrayList<String> returnQuizSql() {
//        String progressQuery = "SELECT id FROM progress WHERE student_id = ?";
//        ArrayList<String> progressIDList = new ArrayList<>();
//
//        try (PreparedStatement statement = conn.prepareStatement(progressQuery)) {
//            statement.setString(1, AppSession.getInstance().getStudent().getId());
//            ResultSet rs = statement.executeQuery();
//
//            while (rs.next()) { // Fetch all progress IDs
//                progressIDList.add(rs.getString("id"));
//            }
//
//            if (progressIDList.isEmpty()) {
//                System.out.println("No progress found for student.");
//                return new ArrayList<>();
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return new ArrayList<>();
//        }
//
//        StringBuilder progressQuizQuery = new StringBuilder("SELECT quiz_id FROM progress_quiz WHERE status = 'active' AND progress_id IN (");
//
//        for (int i = 0; i < progressIDList.size(); i++) {
//            progressQuizQuery.append("?");
//            if (i < progressIDList.size() - 1) {
//                progressQuizQuery.append(", ");
//            }
//        }
//        progressQuizQuery.append(")");
//
//        ArrayList<String> quizzesFromSQL = new ArrayList<>();
//
//        try (PreparedStatement statement = conn.prepareStatement(progressQuizQuery.toString())) {
//            for (int i = 0; i < progressIDList.size(); i++) {
//                statement.setString(i + 1, progressIDList.get(i)); // Set each progress_id
//            }
//
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()) {
//                quizzesFromSQL.add(rs.getString("quiz_id"));
//            }
//
//            if (quizzesFromSQL.isEmpty()) {
//                System.out.println("No active quizzes found.");
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return quizzesFromSQL;
//    }

//    private ArrayList<Map<String, Object>> getQuestionsAndChoices() {
//        ArrayList<Map<String, Object>> questionsAndItsChoicesList = new ArrayList<>();
//        String questionQuery = "select title, id from question where quiz_id=?";
//        ArrayList<String> questionList = new ArrayList<>();
//        ArrayList<String> idList = new ArrayList<>();
//
//        try (PreparedStatement statement = conn.prepareStatement(questionQuery)) {
//            statement.setString(1, AppSession.getInstance().getSelectedQuiz());
//            ResultSet rs = statement.executeQuery();
//
//            while (rs.next()) {
//                questionList.add(rs.getString("title"));
//                idList.add(rs.getString("id"));
//            }
//
//            if (questionList.isEmpty() || idList.isEmpty()) {
//                System.out.println("No id and title");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        StringBuilder choiceQuery = new StringBuilder("SELECT question_id, choice_text, isCorrect FROM choice WHERE question_id IN (");
//        for (int i = 0; i < idList.size(); i++) {
//            choiceQuery.append("?");
//            if (i < idList.size() - 1) {
//                choiceQuery.append(", ");
//            }
//        }
//        choiceQuery.append(")");
//
//        ArrayList<ArrayList<Map<String, Object>>> choicesList = new ArrayList<>();
//        ArrayList<Map<String, Object>> choicesWithValue = new ArrayList<>();
//        String currentID = idList.get(0);  // Initialize currentID to the first element in the list
//
//        try (PreparedStatement statement = conn.prepareStatement(choiceQuery.toString())) {
//            for (int i = 0; i < idList.size(); i++) {
//                statement.setString(i + 1, idList.get(i)); // Set each question_id from the idList
//            }
//
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()) {
//                String questionID = rs.getString("question_id");
//
//                // If the current question ID has changed, we need to save the previous choices and reset the list
//                if (!currentID.equals(questionID)) {
//                    choicesList.add(new ArrayList<>(choicesWithValue));  // Add the collected choices for the previous question
//                    choicesWithValue.clear();  // Reset the choices list for the new question
//                    currentID = questionID;  // Update the current question ID
//                }
//
//                // Create a new map for each choice
//                Map<String, Object> choiceOrValue = new HashMap<>();
//                choiceOrValue.put("choice_text", rs.getString("choice_text"));
//                choiceOrValue.put("isCorrect", rs.getString("isCorrect"));
//
//                choicesWithValue.add(choiceOrValue);  // Add the choice to the current question's list
//            }
//
//            // Add the last question's choices after the loop ends
//            if (!choicesWithValue.isEmpty()) {
//                choicesList.add(new ArrayList<>(choicesWithValue));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        // Now, combine the question titles and choices into a final list of maps
//        for (int i = 0; i < questionList.size(); i++) {
//            Map<String, Object> qAndC = new HashMap<>();
//            qAndC.put("title", questionList.get(i));
//            qAndC.put("choices", choicesList.get(i));
//            questionsAndItsChoicesList.add(qAndC);
//        }
//
//        return questionsAndItsChoicesList;
//    }

    public ArrayList<Map<String, Object>> getQuestionsAndChoices() {
        ArrayList<Map<String, Object>> questionsAndChoicesList = new ArrayList<>();

        String query = """
                    SELECT q.id AS question_id, q.title, c.choice_text, c.isCorrect
                    FROM question q
                    JOIN choice c ON q.id = c.question_id
                    WHERE q.quiz_id = ?
                    ORDER BY q.id
                """;

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, AppSession.getInstance().getSelectedQuiz());
            ResultSet rs = statement.executeQuery();

            Map<String, Map<String, Object>> questionMap = new LinkedHashMap<>();

            while (rs.next()) {
                String questionId = rs.getString("question_id");
                String title = rs.getString("title");

                // If the question is not already in the map, add it
                questionMap.putIfAbsent(questionId, new HashMap<>(Map.of(
                        "title", title,
                        "choices", new ArrayList<Map<String, Object>>()
                )));

                // Add the choice to the corresponding question
                Map<String, Object> choice = new HashMap<>();
                choice.put("choice_text", rs.getString("choice_text"));
                choice.put("isCorrect", Integer.parseInt(rs.getString("isCorrect")));

                ((ArrayList<Map<String, Object>>) questionMap.get(questionId).get("choices")).add(choice);
            }

            questionsAndChoicesList.addAll(questionMap.values());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return questionsAndChoicesList;
    }

    public void manageSubmitQuiz(double score){
        String query = "UPDATE progress_quiz pq " +
                "JOIN progress p ON pq.progress_id = p.id " +
                "SET pq.score = ? " +
                "WHERE pq.quiz_id = ? AND p.student_id = ?";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setBigDecimal(1, BigDecimal.valueOf(score));
            statement.setString(2, AppSession.getInstance().getSelectedQuiz());
            statement.setString(3, AppSession.getInstance().getStudent().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public double getPrevScore(){
        String query = "SELECT pq.score FROM progress_quiz pq " +
                "JOIN progress p ON pq.progress_id = p.id " +
                "WHERE pq.quiz_id = ? AND p.student_id = ?";

        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, AppSession.getInstance().getSelectedQuiz());
            statement.setString(2, AppSession.getInstance().getStudent().getId());
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                return rs.getDouble("score");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }



//    private void checkAnswerSql(ArrayList<ArrayList<Boolean>> answerListToCheck, ArrayList<Integer> answerListFromStudent, String chosenQuizID) {
//        String quarry = "update progress_quiz set status='inactive', score=? where quiz_id=?";
//        double score = 0.00;
//        for (int i = 0; i < answerListFromStudent.size(); i++) {
//            if (answerListToCheck.get(i).get(answerListFromStudent.get(i) - 1)) {
//                score++;
//            }
//        }
//        System.out.println(score);
//        try (PreparedStatement statement = conn.prepareStatement(quarry)) {
//            statement.setDouble(1, score);
//            statement.setString(2, chosenQuizID);
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public Map<String, String> getAllUnfinishedQuizzes() {
        Map<String, String> id_name_classroom = new HashMap<>();
        String query = "SELECT CONCAT(q.id, ' - ' ,q.title) AS id_name, " +
                "p.classroom_id as class_id  " +
                "FROM progress_quiz as pq " +
                "JOIN progress AS p " +
                "ON pq.progress_id = p.id " +
                "JOIN quiz AS q " +
                "ON pq.quiz_id = q.id " +
                "WHERE p.student_id = ? AND pq.score IS NULL";
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

    public String getQuizTitle() {
        String query = "SELECT title FROM quiz WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, AppSession.getInstance().getSelectedQuiz());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return rs.getString("title");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getQuizDescription() {
        String query = "SELECT description FROM quiz WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, AppSession.getInstance().getSelectedQuiz());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return rs.getString("description");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }
}
