package main.java.com.lms.managers.teacherSide;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TeacherQuizManager extends ClassroomContentManager {
    private static final Connection conn = DatabaseConnection.getInstance().getConnection();

    public TeacherQuizManager(String classIdToEdit) {
        super(classIdToEdit);
    }
    // ========================================
    // SQL-RELATED METHODS
    // ========================================

    // TODO: sql equivalent methods goes here, method name should have the same name but with Sql at the end. Ex: manageDoQuiz -> manageDoQuizSql

    public void manageAddQuizSql(String title, String description, ArrayList<Map<String, Object>> questionList, String status) {
        ArrayList<String> titles = new ArrayList<>();
        ArrayList<ArrayList<Map<String, Object>>> choicesList = new ArrayList<>();
        String quizID = generateNewID("quiz", "Q0000");

        for (Map<String, Object> question : questionList) {
            titles.add((String) question.get("title"));
            choicesList.add((ArrayList<Map<String, Object>>) question.get("choices"));
        }
        insertToQuiz(quizID, title, description, status);
        for (int i = 0; i < questionList.size(); i++) {
            String questionID = generateNewID("question", "QU0000");
            String choice_text = "";
            boolean isCorrect = false;
            ArrayList<Map<String, Object>> currentChoiceList = choicesList.get(i);
            insertToQuestion(questionID, quizID, titles.get(i));
            for (int j = 0; j < currentChoiceList.size(); j++) {
                String choiceID = generateNewID("choice", "CH0000");
                choice_text = (String) currentChoiceList.get(j).get("choice_text");
                isCorrect = (boolean) currentChoiceList.get(j).get("isCorrect");
                insertToChoice(choiceID, questionID, choice_text, isCorrect);
            }
        }
        String progressId = "";
        String progressIdQuery = "SELECT id FROM progress WHERE student_id = ? AND classroom_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(progressIdQuery)) {
            statement.setString(1, AppSession.getInstance().getStudent().getId());
            statement.setString(2, classIdToEdit);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                progressId = rs.getString("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        insertToProgressQuiz(progressId, quizID, null);
        insertToClassroomQuiz(this.classIdToEdit, quizID);
        System.out.println("finished");
    }

    public void manageEditQuizSql() {

    }

    public void manageDeleteQuizSql() {

    }

    public void manageViewQuiz() {

    }

    private ArrayList<Map<String, String>> returnQuizSql() {
        String progressQuery = "SELECT id, title, description FROM quiz";
        ArrayList<String> progressIDList = new ArrayList<>();

        try (PreparedStatement statement = conn.prepareStatement(progressQuery)) {
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

        return null;
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

    private ArrayList<Map<String, Object>> returnQuestionsAndItsChoices(String chosenQuizID) {
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

    private static void insertToQuiz(String id, String title, String description, String status) {
        String quarry = "INSERT INTO quiz (id, title, description, status) VALUES ( ?, ?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(quarry)) {
            statement.setString(1, id);
            statement.setString(2, title);
            statement.setString(3, description);
            statement.setString(4, status);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertToQuestion(String id, String quiz_id, String title) {
        String quarry = "INSERT INTO question (id, quiz_id, title) VALUES ( ?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(quarry)) {
            statement.setString(1, id);
            statement.setString(2, quiz_id);
            statement.setString(3, title);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertToChoice(String id, String question_id, String choice_text, Boolean isCorrect) {
        String quarry = "INSERT INTO choice (id, question_id, choice_text, isCorrect) VALUES ( ?, ?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(quarry)) {
            statement.setString(1, id);
            statement.setString(2, question_id);
            statement.setString(3, choice_text);
            statement.setBoolean(4, isCorrect);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertToProgressQuiz(String progress_id, String quiz_id, Double score) {
        String quarry = "INSERT INTO progress_quiz (progress_id, quiz_id, score) VALUES (?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(quarry)) {
            statement.setString(1, progress_id);
            statement.setString(2, quiz_id);
            statement.setDouble(3, score);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertToClassroomQuiz(String classIdToEdit, String quiz_id) {
        String quarry = "INSERT INTO classroom_quiz (class_id, quiz_id) VALUES ( ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(quarry)) {
            statement.setString(1, classIdToEdit);
            statement.setString(2, quiz_id);
            statement.executeUpdate();
        } catch (SQLException e) {
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

        public Map<String, String> getClassroomQuizzes(){
            Map<String, String> id_name_classroom = new HashMap<>();
            String query = "SELECT CONCAT(q.id, q.title) AS id_name, p.classroom_id as class_id  FROM progress_quiz as pq " +
                    "JOIN progress AS p " +
                    "ON pq.progress_id = p.id " +
                    "JOIN quiz AS q " +
                    "ON pq.quiz_id = q.id " +
                    "WHERE p.classroom_id = ? AND p.student_id = ? ";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                statement.setString(1, AppSession.getInstance().getSelectedClassroom());
                statement.setString(2, AppSession.getInstance().getStudent().getId());
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    id_name_classroom.put("id_name", rs.getString("id_name"));
                    id_name_classroom.put("class_id", rs.getString("class_id"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return id_name_classroom;
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