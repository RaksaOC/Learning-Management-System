package main.java.com.lms.managers.teacherSide;

import main.AppSession;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TeacherQuizManager extends ClassroomContentManager {
    public TeacherQuizManager(String classIdToEdit) {
        super(classIdToEdit);
    }

    public void manageAddQuizSql(String title, String description, ArrayList<Map<String, Object>> quizList, String status) {
        ArrayList<String> titles = new ArrayList<>();
        ArrayList<ArrayList<Map<String, Object>>> choicesList = new ArrayList<>();
        String quizID = generateNewID("quiz", "Q0000");

        for (Map<String, Object> quiz : quizList) {
            titles.add((String) quiz.get("title"));
            choicesList.add((ArrayList<Map<String, Object>>) quiz.get("choices"));
        }
        insertToQuiz(quizID, title, description, status);
        for (int i = 0; i < quizList.size(); i++) {
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
        String progressIdQuery = "SELECT id FROM progress WHERE classroom_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(progressIdQuery)) {
            statement.setString(1, classIdToEdit);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                progressId = rs.getString("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        insertToProgressQuiz(progressId, quizID, null);
        System.out.println("Inserted into Progress Table");
        insertToClassroomQuiz(this.classIdToEdit, quizID);
        System.out.println("finished");
    }

    public void manageEditQuizSql(String title, String description, ArrayList<Map<String, Object>> quizList) {
        manageDeleteQuizSql();
        manageAddQuizSql(title, description, quizList, "active");
    }


    //edit quiz section
    public void manageEditQuiz(ArrayList<Map<String, Object>> quizInfoToEdit, String quizID, String title, String description) {
        String quarry = "UPDATE quiz SET title=?, description=? WHERE id=?";
        try (PreparedStatement statement = conn.prepareStatement(quarry)) {
            statement.setString(1, title);
            statement.setString(2, description);
            statement.setString(3, quizID);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        ArrayList<String> questionFromEditData = new ArrayList<>();
        for (Map<String, Object> question : quizInfoToEdit) {
            questionFromEditData.add((String) question.get("title"));
        }

        // Step 1: Get ordered list of question IDs
        ArrayList<String> ids = new ArrayList<>();
        String fetchQuery = "SELECT id FROM question WHERE quiz_id = ? ORDER BY id";

        try (PreparedStatement fetchStatement = conn.prepareStatement(fetchQuery)) {
            fetchStatement.setString(1, quizID);
            ResultSet rs = fetchStatement.executeQuery();
            while (rs.next()) {
                ids.add(rs.getString("id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Step 2: Update questions using the fetched IDs
        for (int i = 0; i < ids.size(); i++) {
            String updateQuery = "UPDATE question SET title = ? WHERE id = ?";
            try (PreparedStatement updateStatement = conn.prepareStatement(updateQuery)) {
                updateStatement.setString(1, questionFromEditData.get(i));
                updateStatement.setString(2, ids.get(i));
                updateStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        // Step 3: Update the choice table
        String fetchChoicesQuery = "SELECT id, question_id FROM choice WHERE question_id = ? ORDER BY id";

        for (Map<String, Object> question : quizInfoToEdit) {
            ArrayList<String> questionChoiceIDs = new ArrayList<>(); // Clear the list for each question
            String questionID = ""; // Get the question ID

            // Get questionID (you may need a different method to fetch questionID)
            String fetchQuestionIDQuery = "SELECT id FROM question WHERE title = ? AND quiz_id = ?";
            try (PreparedStatement fetchQuestionIDStmt = conn.prepareStatement(fetchQuestionIDQuery)) {
                fetchQuestionIDStmt.setString(1, (String) question.get("title"));
                fetchQuestionIDStmt.setString(2, quizID);
                ResultSet rs = fetchQuestionIDStmt.executeQuery();
                if (rs.next()) {
                    questionID = rs.getString("id");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            // Fetch choice IDs for this question
            try (PreparedStatement fetchChoicesStmt = conn.prepareStatement(fetchChoicesQuery)) {
                fetchChoicesStmt.setString(1, questionID);
                ResultSet choiceRS = fetchChoicesStmt.executeQuery();
                while (choiceRS.next()) {
                    questionChoiceIDs.add(choiceRS.getString("id"));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            // Step 4: Update choices
            ArrayList<Map<String, Object>> questionChoices = (ArrayList<Map<String, Object>>) question.get("choices");
            for (int i = 0; i < questionChoices.size(); i++) {
                Map<String, Object> choice = questionChoices.get(i);
                String choiceText = (String) choice.get("choice_text");
                Boolean isCorrect = (Boolean) choice.get("isCorrect");
                String choiceID = questionChoiceIDs.get(i);  // Use the specific list of choice IDs for this question

                String updateChoiceQuery = "UPDATE choice SET choice_text = ?, isCorrect = ? WHERE id = ?";
                try (PreparedStatement updateChoiceStmt = conn.prepareStatement(updateChoiceQuery)) {
                    updateChoiceStmt.setString(1, choiceText);
                    updateChoiceStmt.setBoolean(2, isCorrect);
                    updateChoiceStmt.setString(3, choiceID);
                    updateChoiceStmt.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

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

    public ArrayList<Map<String, String>> getAllStudentsAndScore() {
        String query = "SELECT s.id as id, CONCAT(s.first_name, ' ' , s.last_name) AS name, pq.score as score FROM student as s " +
                "JOIN progress as p ON p.student_id = s.id " +
                "JOIN progress_quiz as pq ON pq.progress_id = p.id " +
                "WHERE pq.quiz_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


//    public ArrayList<Map<String, String>> getQuizIDTitleAndDescriptionFromSqlToChooseToEdit() {
//        String quarry = "select * from quiz";
//        ArrayList<Map<String, String>> quizInfoList = new ArrayList<>();
//        try (PreparedStatement statement = conn.prepareStatement(quarry)) {
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()) {
//                Map<String, String> quizInfo = new HashMap<>();
//                quizInfo.put("id", rs.getString("id"));
//                quizInfo.put("title", rs.getString("title"));
//                quizInfo.put("description", rs.getString("description"));
//                quizInfoList.add(quizInfo);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return quizInfoList;
//    }

    public ArrayList<Map<String, Object>> getQuizQuestionAndChoice() {
        ArrayList<Map<String, Object>> questionsAndItsChoicesList = new ArrayList<>();
        String questionQuery = "select title, id from question where quiz_id=?";
        ArrayList<String> questionList = new ArrayList<>();
        ArrayList<String> idList = new ArrayList<>();

        try (PreparedStatement statement = conn.prepareStatement(questionQuery)) {
            statement.setString(1, AppSession.getInstance().getSelectedQuiz());
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

    //
    public void manageDeleteQuizSql() {
        String deleteClassroomQuizQuarry = "delete from classroom_quiz where quiz_id= ?";
        try (PreparedStatement statement = conn.prepareStatement(deleteClassroomQuizQuarry)) {
            statement.setString(1, AppSession.getInstance().getSelectedQuiz());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String deleteQuiz = "update quiz set status= ? WHERE id=?";
        try (PreparedStatement statement = conn.prepareStatement(deleteQuiz)) {
            statement.setString(1, "inactive");
            statement.setString(2, AppSession.getInstance().getSelectedQuiz());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String deleteProgressQuery = "delete from progress_quiz where quiz_id=?";
        try(PreparedStatement statement = conn.prepareStatement(deleteProgressQuery)){
            statement.setString(1, AppSession.getInstance().getSelectedQuiz());
            statement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertToQuiz(String id, String title, String description, String status) {
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

    private void insertToQuestion(String id, String quiz_id, String title) {
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

    private void insertToChoice(String id, String question_id, String choice_text, Boolean isCorrect) {
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

    private void insertToProgressQuiz(String progress_id, String quiz_id, Double score) {
        String query = "INSERT INTO progress_quiz (progress_id, quiz_id, score, status) " +
                "SELECT id, ?, NULL, 'active' FROM progress WHERE classroom_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, quiz_id); // Set quiz_id for all matched progress rows
            statement.setString(2, AppSession.getInstance().getSelectedClassroom()); // Filter by selected classroom
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertToClassroomQuiz(String classIdToEdit, String quiz_id) {
        String quarry = "INSERT INTO classroom_quiz (class_id, quiz_id) VALUES ( ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(quarry)) {
            statement.setString(1, classIdToEdit);
            statement.setString(2, quiz_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String generateNewID(String tableName, String baseID) {
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

    public ArrayList<String> getClassroomQuizzesSql() {
        ArrayList<String> quizzes = new ArrayList<>();

        String query = "SELECT CONCAT(q.id, ' - ', q.title) AS id_name " +
                "FROM classroom_quiz AS cq " +
                "JOIN quiz AS q ON cq.quiz_id = q.id " +
                "WHERE cq.class_id = ?";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, AppSession.getInstance().getSelectedClassroom());
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                quizzes.add(rs.getString("id_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quizzes;
    }
}