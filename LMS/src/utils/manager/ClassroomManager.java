package utils.manager;

import org.json.JSONArray;
import org.json.JSONObject;
import utils.controller.ClassroomController;
import utils.menu.Menu;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

interface classroomManagementInterface {
    void manageAddAssignment();

    void manageEditAssignment();

    void manageDeleteAssignment();

    void manageGradeAssignment();

    void manageCommentStudentAssignment();

    void manageViewStudentAssignment();

    void manageViewAllStudentAssignment();

    void manageAddResource();


    void manageEditResource();


    void manageDeleteResource();


    void manageViewResource();

    void manageAddQuizz(String classroomID, String title, String createdBy, JSONArray questions);

    void manageEditQuizz(String title, JSONArray questionJson, String id);

    void manageDeleteQuizz(String id);

    void manageViewQuizz(String id);

    void manageDoQuiz(int quizIndex, String[] answers);

}

public class ClassroomManager implements classroomManagementInterface {
    private final String classIdToEdit;

    public ClassroomManager(String ClassIdToEdit) {
        this.classIdToEdit = ClassIdToEdit;
    }

    public void manageAddAssignment() {
        String title = Menu.prompt("Enter Assignment Title: ");
        String description = Menu.prompt("Enter Assignment Description: ");
        String date = Menu.prompt("Enter a Date for Deadline (YYYY-MM-DD):");
        String time = Menu.prompt("Enter a Time for Deadline (hh:mm AM/PM): ");
        JSONObject deadline = new JSONObject();
        deadline.put("date", date);
        deadline.put("time", time);
        JSONObject newAssignment = new JSONObject();
        newAssignment.put("title", title);
        newAssignment.put("description", description);
        newAssignment.put("deadline", deadline);
        newAssignment.put("status", "active");
        saveAssignments(newAssignment, title);
    }

    public void manageEditAssignment() {
        int titleId = Integer.parseInt(selectAssignmentTitle()) - 1; // hold title selection
        JSONArray allAssignments = getAssignments();
        for (int i = 0; i < allAssignments.length(); i++) {
            if (i == titleId) {
                // print previous info
                JSONObject assignmentToEdit = allAssignments.getJSONObject(i);
                System.out.println("Title: " + assignmentToEdit.getString("title"));
                System.out.println("Description: " + assignmentToEdit.getString("description"));
                JSONObject assignmentDeadline = assignmentToEdit.getJSONObject("deadline");
                System.out.println("Deadline: " + assignmentDeadline.getString("date") + " | " + assignmentDeadline.getString("time"));
                // takes new info
                String newTitle = Menu.prompt("Enter a new Title (if not leave empty): ");
                if (!newTitle.isEmpty()) {
                    assignmentToEdit.put("title", newTitle);
                }
                String newDescription = Menu.prompt("Enter a new Description (if not leave empty):");
                if (!newDescription.isEmpty()) {
                    assignmentToEdit.put("description", newDescription);
                }
                String newDate = Menu.prompt("Enter a new Deadline Date (YYYY-MM-DD) (if not leave empty): ");
                if (!newDate.isEmpty()) {
                    assignmentDeadline.put("date", newDate);
                }
                String newTime = Menu.prompt("Enter a new Deadline Time (hh:mm) (if not leave empty): ");
                if (!newTime.isEmpty()) {
                    assignmentDeadline.put("time", newTime);
                }
                allAssignments.put(i, assignmentToEdit); // ensure it saves into correct index
                saveAssignments(assignmentToEdit, assignmentToEdit.getString("title")); // needs to pass id instead
                break;
            }
        }
    }

    public void manageDeleteAssignment() {
        int titleId = Integer.parseInt(selectAssignmentTitle()) - 1; // hold title selection
        JSONArray allAssignments = getAssignments();
        for (int i = 0; i < allAssignments.length(); i++) {
            if (i == titleId) {
                JSONObject assignmentToEdit = allAssignments.getJSONObject(i);
                assignmentToEdit.put("status", "inactive");
                allAssignments.put(i, assignmentToEdit); // ensure it saves into correct index
                saveAssignments(assignmentToEdit, assignmentToEdit.getString("title"));
                break;
            }
        }
    }

    public void manageGradeAssignment() {

    }

    public void manageCommentStudentAssignment() {

    }

    public void manageViewStudentAssignment() {

    }

    public void manageViewAllStudentAssignment() {

    }

    // get assignments JSONArray
    private JSONArray getAssignments() {
        int indexOfClass = Integer.parseInt(classIdToEdit);
        JSONArray allClass = loadClassroom();
        for (int i = 0; i < allClass.length(); i++) {
            if (i == indexOfClass) {
                JSONObject classToEdit = allClass.getJSONObject(i);
                JSONArray assignments = classToEdit.optJSONArray("assignments");
                return assignments;
            }
        }
        return null;
    }


    // display all title and select an input
    private String selectAssignmentTitle() {
        JSONArray allAssignments = getAssignments();
        for (int i = 0; i < allAssignments.length(); i++) {
            JSONObject assignment = allAssignments.getJSONObject(i);
            System.out.println(assignment.getString("title"));
        }
        return Menu.prompt("Select an Assignment: ");
    }

    // save assignment into the correct index
    public void saveAssignments(JSONObject newAssignment, String titleToEdit) {
        int indexOfClass = Integer.parseInt(classIdToEdit);
        JSONArray allClass = loadClassroom();
        for (int i = 0; i < allClass.length(); i++) {
            if (i == indexOfClass) {
                JSONObject classToEdit = allClass.getJSONObject(i);
                JSONArray assignments = classToEdit.getJSONArray("assignments");
                if (assignments == null) {
                    assignments = new JSONArray();
                }
                boolean found = false;
                for (int j = 0; j < assignments.length(); j++) {
                    // needs to compare id instead
                    if (titleToEdit.equals(assignments.getJSONObject(j).getString("title"))) {
                        assignments.put(j, newAssignment); // save into the correct index
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    assignments.put(newAssignment); // create new one
                }
                classToEdit.put("assignments", assignments);
                allClass.put(i, classToEdit);
                saveClassrooms(allClass);
                break;
            }
        }
    }

    // Resource Manager
    public void manageAddResource() {

    }

    public void manageEditResource() {

    }

    public void manageDeleteResource() {

    }

    public void manageViewResource() {

    }


    // Quizz Manager
    public void manageAddQuizz(String classroomID, String title, String createdBy, JSONArray questions) {
        String id = "";
        try {
            String content = new String(Files.readAllBytes(Paths.get("shared/data/quiz.json")));
            JSONArray quizWriteToFile = new JSONArray(content);
            if (!content.isEmpty()) {
                quizWriteToFile = new JSONArray(content);
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
                        contentToEdit.getJSONObject(i).getJSONArray("quizzes").put(id);
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

    public void manageDeleteQuizz(String idToDelete) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("shared/data/quiz.json")));
            JSONArray contentToUpdateLater;
            JSONArray quizWriteToFile = new JSONArray();
            boolean isTheIDThere = false;
            if (!content.isEmpty()) {
                contentToUpdateLater = new JSONArray(content);
                for (int i = 0; i < contentToUpdateLater.length(); i++) {
                    if (!contentToUpdateLater.getJSONObject(i).getString("id").equals(idToDelete)) {
                        quizWriteToFile.put(contentToUpdateLater.getJSONObject(i));
                    } else {
                        isTheIDThere = true;
                    }
                }
            }
            if (!isTheIDThere) {
                System.out.println("The ID is not here");
                return;
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
                    for (int j = 0; j < contentToEdit.getJSONObject(i).getJSONArray("quizzes").length(); j++) {
                        if (contentToEdit.getJSONObject(i).getJSONArray("quizzes").getString(j).equals(idToDelete)) {
                            contentToEdit.getJSONObject(i).getJSONArray("quizzes").remove(j);
                            break;
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
                    for (int j = 0; j < contentToEdit.getJSONObject(i).getJSONArray("quizzes").length(); j++) {
                        if (contentToEdit.getJSONObject(i).getJSONArray("quizzes").getString(j).equals(idToDelete)) {
                            contentToEdit.getJSONObject(i).getJSONArray("quizzes").remove(j);
                            break;
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
            if (!content.isEmpty()) {
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
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // save every classroom
    private void saveClassrooms(JSONArray allClass) {
        try (FileWriter file = new FileWriter("shared/data/classroom.json")) {
            file.write(allClass.toString(4)); // Pretty-print with 4 spaces
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // load every classroom
    private JSONArray loadClassroom() {
        try {
            String contents = new String(Files.readAllBytes(Paths.get("shared/data/classroom.json")));
            JSONArray allClass = new JSONArray(contents);
            return allClass;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String idGenerator(String filepath) {
        try {
            File file = new File(filepath);
            JSONArray jsonArray = null;
            if (file.exists()) {
                String content = new String(Files.readAllBytes(Paths.get(filepath)));
                jsonArray = new JSONArray(content);
            } else {
                jsonArray = new JSONArray();
            }
            int nextIdNumber = jsonArray.length() + 1;
            return "A" + nextIdNumber;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void manageDoQuiz(int quizIndex, String[] answers) {
        JSONArray getQuizFromFile = returnQuiz(quizIndex);
        int result= checkAnswer(answers, getQuizFromFile);
        System.out.println(result);
    }

    private JSONArray returnQuiz(int quizIndex) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("shared/data/classroom.json")));
            JSONArray contentToEdit = new JSONArray(content);
            String[] quizzesID = null;
            if (!content.isEmpty()) {
                for (int i = 0; i < contentToEdit.length(); i++) {
                    if (contentToEdit.getJSONObject(i).getString("id").equals("GEN10-CS-SE-G1-OOP")) {
                        quizzesID = new String[contentToEdit.getJSONObject(i).getJSONArray("quizzes").length()];
                        for (int j = 0; j < contentToEdit.getJSONObject(i).getJSONArray("quizzes").length(); j++) {
                            quizzesID[j] = contentToEdit.getJSONObject(i).getJSONArray("quizzes").getString(j);
                        }
                    }
                }
                try {
                    String contentQuiz = new String(Files.readAllBytes(Paths.get("shared/data/quiz.json")));
                    JSONArray questions = null;
                    if (!contentQuiz.isEmpty()) {
                        JSONArray jsonContent = new JSONArray(contentQuiz);
                        int index = 0;
                        for (int i = 0; i < jsonContent.length(); i++) {
                            if (jsonContent.getJSONObject(i).getString("id").equals(quizzesID[index])) {
                                index++;
                                JSONObject quiz = jsonContent.getJSONObject(i);
                                if (quiz.getString("id").equals(quizzesID[quizIndex-1])) {

                                    questions = quiz.getJSONArray("questions");
                                }
                                System.out.println("------------------------------------------------------");
                                System.out.println("Id: " + quiz.getString("id"));
                                System.out.println("Title: " + quiz.getString("title"));

                                System.out.println("------------------------------------------------------");
                            }
                        }

                    }
                    return questions;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private int checkAnswer(String[] answers, JSONArray questions){
        int result=0;
        for(int i=0;i<questions.length();i++){
            if(answers[i].equals(questions.getJSONObject(i).getString("answer"))){
                result++;
            }
        }
        return result;
    }

}
