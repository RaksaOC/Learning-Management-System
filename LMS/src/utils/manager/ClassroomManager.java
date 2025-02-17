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
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ClassroomManager {
    private final String classIdToEdit;

    public ClassroomManager (String ClassIdToEdit) {
        this.classIdToEdit = ClassIdToEdit;
    }

    public void manageAddAssignment(){
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
                System.out.println("Description: " +assignmentToEdit.getString("description"));
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
    public void manageAddQuizz() {

    }

    public void manageEditQuizz() {

    }

    public void manageDeleteQuizz() {

    }

    public void manageViewQuizz() {

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
    private JSONArray loadClassroom(){
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

}
