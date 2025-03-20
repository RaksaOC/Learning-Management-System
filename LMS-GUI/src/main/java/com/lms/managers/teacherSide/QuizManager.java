package main.java.com.lms.managers.teacherSide;

import main.AppSession;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class QuizManager extends ClassroomContentManager{
    private String classIdToEdit = AppSession.getInstance().getSelectedClassroom();

    // TO CHANGE: later
    public QuizManager(String classIdToEdit) {
        super(classIdToEdit);
    }

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