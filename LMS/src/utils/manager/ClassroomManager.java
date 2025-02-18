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

    // void manageAddQuizz(String title, String createdBy, JSONArray questions);

    void manageEditQuizz();

//    void manageDeleteQuizz(String id);

    void manageViewQuizz();


}

public class ClassroomManager implements classroomManagementInterface{

    private final String classIdToEdit;

    public ClassroomManager (String ClassIdToEdit) {
        this.classIdToEdit = ClassIdToEdit; // this holds only the user's input
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
        String assignmentId = idGenerator(getAssignments(), "A000");
        newAssignment.put("id", assignmentId);
        newAssignment.put("title", title);
        newAssignment.put("description", description);
        newAssignment.put("deadline", deadline);
        newAssignment.put("status", "active");
        assignmentToProgress(assignmentId);
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
                saveAssignments(assignmentToEdit, assignmentToEdit.getString("id"));
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
                saveAssignments(assignmentToEdit, assignmentToEdit.getString("id"));
                break;
            }
        }
    }

    public void manageGradeAssignment() {
        int assignmentIndex = Integer.parseInt(selectAssignmentTitle()) - 1; // holds an Assignment's index from user input
        JSONArray allAssignments = getAssignments();
        // get the specific assignment ID
        String assignmentId = "";
        for (int i = 0; i < allAssignments.length(); i++) {
            if (i == assignmentIndex) {
                assignmentId = allAssignments.getJSONObject(i).getString("id");
                break;
            }
        }
        String classroomId = getclassroomId();
        JSONArray progresses = loadProgress();
        for (int i = 0; i < progresses.length(); i++) {
            if (classroomId.equals(progresses.getJSONObject(i).getString("classroomId"))) {
                boolean isAssignmentId = false;
                for (int j = 0; j < progresses.getJSONObject(i).getJSONArray("assignments").length(); j++) {
                    if (assignmentId.equals(progresses.getJSONObject(i).getJSONArray("assignments").getJSONObject(j).getString("id"))) {
                        progresses.getJSONObject(i).getJSONArray("assignments").getJSONObject(j).put("Grade", "");
                        isAssignmentId = true;
                        break;
                    }
                }
                if (!isAssignmentId) {

                }
            }

        }
    }

    public void manageCommentStudentAssignment() {

    }

    public void manageViewStudentAssignment() {

    }

    public void manageViewAllStudentAssignment() {

    }

    // get a specific classroomId id Ex: "GEN10-CS-SE-G1-OOP"
    private String getclassroomId() {
        int indexOfClass = Integer.parseInt(classIdToEdit);
        JSONArray allClass = loadClassroom();
        for (int i = 0; i < allClass.length(); i++) {
            if (i == indexOfClass) {
                JSONObject classToEdit = allClass.getJSONObject(i);
                return classToEdit.getString("id");
            }
        }
        return null;
    }

    // get only assignment JSONArray
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


    // display only assignment titles and select an input
    private String selectAssignmentTitle() {
        JSONArray allAssignments = getAssignments();
        for (int i = 0; i < allAssignments.length(); i++) {
            JSONObject assignment = allAssignments.getJSONObject(i);
            System.out.println(assignment.getString("title"));
        }
        return Menu.prompt("Select an Assignment: ");
    }

    // check & save only the assignment into the correct index
    private void saveAssignments(JSONObject newAssignment, String assignmentId) {
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
                    if (assignmentId.equals(assignments.getJSONObject(j).getString("id"))) {
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

    // assigns only the assignment to progress
    private void  assignmentToProgress(String assignmentId) {
        String classroomId = getclassroomId();
        JSONArray progresses = loadProgress();
        for (int i = 0; i < progresses.length(); i++) {
            if (classroomId.equals(progresses.getJSONObject(i).getString("classroomId"))){
                boolean found = false;
                for (int j = 0; j < progresses.getJSONObject(i).getJSONArray("assignments").length(); j++) {
                    if (assignmentId.equals(progresses.getJSONObject(i).getJSONArray("assignments").getJSONObject(j).getString("id"))){
                        progresses.getJSONObject(i).getJSONArray("assignments").getJSONObject(j).put("pending", "Ongoing");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    JSONObject newAssignment = new JSONObject();
                    newAssignment.put("id", assignmentId);
                    newAssignment.put("pending", "Ongoing");
                    progresses.getJSONObject(i).getJSONArray("assignments").put(newAssignment);
                }
            }
        }
        saveProgresses(progresses);
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

    public void manageGradeQuizz(){

    }

    public void manageDeleteQuizz() {

    }

    public void manageViewQuizz() {

    }

    // save all classrooms
    private void saveClassrooms(JSONArray allClass) {
        try (FileWriter file = new FileWriter("shared/data/classroom.json")) {
            file.write(allClass.toString(4)); // Pretty-print with 4 spaces
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // save all progresses
    private void saveProgresses(JSONArray allProgress) {
        try (FileWriter file = new FileWriter("shared/data/progress.json")) {
            file.write(allProgress.toString(4)); // Pretty-print with 4 spaces
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // load all classrooms
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

    // load all students
    private JSONArray loadStudent() {
        try {
            String contents = new String(Files.readAllBytes(Paths.get("shared/data/student.json")));
            JSONArray allStudents = new JSONArray(contents);
            return allStudents;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // load all progresses
    private JSONArray loadProgress() {
        try {
            String contents = new String(Files.readAllBytes(Paths.get("shared/data/progress.json")));
            JSONArray allprogress = new JSONArray(contents);
            return allprogress;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String idGenerator(JSONArray objects, String baseId) { // baseId receives Ex: "A000"
        String numberPart = baseId.replaceAll("[^0-9]", ""); // extract number part "000"
        int numberLength = numberPart.length();
        int nextIdNumber = objects.length() + 1; // find next available id
        String formattedNumber = String.format("%0" + numberLength + "d", nextIdNumber); // %03d
        String prefixChar = baseId.replaceAll("[0-9]", ""); // extract the non-numeric part "A"
        return prefixChar + formattedNumber;
    }
}
