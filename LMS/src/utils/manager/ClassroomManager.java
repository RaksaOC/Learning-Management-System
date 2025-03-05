package utils.manager;

import org.json.JSONArray;
import org.json.JSONMLParserConfiguration;
import org.json.JSONObject;
import utils.controller.ClassroomController;
import utils.menu.Menu;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
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
        String assignmentId = idGenerator(getClassroomAssignments(), "A000");
        newAssignment.put("id", assignmentId);
        newAssignment.put("title", title);
        newAssignment.put("description", description);
        newAssignment.put("deadline", deadline);
        newAssignment.put("status", "active");
        JSONArray allClassroom = loadClassroom();
        saveAssignments(newAssignment, title); // saves to classroom
        // handles saving to progress
        for (int i = 0; i < allClassroom.length(); i++) {
            if (getClassroomId().equals(allClassroom.getJSONObject(i).getString("id"))) {
                for (int j = 0; i < allClassroom.getJSONObject(i).getJSONArray("students").length(); j++) {
                    assignmentToProgress(allClassroom.getJSONObject(i).getJSONArray("students").getString(j) ,assignmentId, "(Ongoing)", "", "");
                }
            }
        }
    }

    public void manageEditAssignment() {
        int titleId = Integer.parseInt(selectAssignmentTitle()) - 1; // hold title selection
        JSONArray allAssignments = getClassroomAssignments();
        //handles inactive assignment
        for (int i = 0; i < allAssignments.length(); i++) {
            if (i == titleId) {
                if (allAssignments.getJSONObject(i).getString("status").equals("inactive")) {
                    titleId++;
                }
            }
        }
        // editing process
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
                String newTime = Menu.prompt("Enter a new Deadline Time (HH:MM) (if not leave empty): ");
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
        JSONArray allClassroomAssignments = getClassroomAssignments();
        // handles inactive assignment
        for (int i = 0; i < allClassroomAssignments.length(); i++) {
            if (i == titleId) {
                if (allClassroomAssignments.getJSONObject(i).getString("status").equals("inactive")) {
                    titleId++;
                }
            }
        }
        // updates classroomAssignment
        for (int i = 0; i < allClassroomAssignments.length(); i++) {
            if (i == titleId) {
                JSONObject assignmentToEdit = allClassroomAssignments.getJSONObject(i);
                assignmentToEdit.put("status", "inactive");
                allClassroomAssignments.put(i, assignmentToEdit); // ensure it saves into correct index
                saveAssignments(assignmentToEdit, assignmentToEdit.getString("id"));
                break;
            }
        }
        // updates progressAssignment
        JSONArray allProgress = loadProgress();
        for (int i = 0; i < allProgress.length(); i++) {
            if (getClassroomId().equals(allProgress.getJSONObject(i).getString("classroomId"))) {
                for (int j = 0; j < allProgress.getJSONObject(i).getJSONArray("assignments").length(); j++) {
                    if (j == titleId) {
                        allProgress.getJSONObject(i).getJSONArray("assignments").getJSONObject(j).put("status", "inactive");
                        saveProgresses(allProgress);
                        break;
                    }
                }
            }
        }
    }

    public void manageGradeAssignment() {
        JSONArray allProgress = loadProgress();
        int selectedAssignment = Integer.parseInt(selectAssignmentTitle()) - 1; // hold the selected assignment's index
        int selectedStudent = Integer.parseInt(selectStudentToGrade()) - 1; // hold the selected student's index
        String grade = Menu.prompt("Grade the student Assignment (0 - 100): ");
        String feedback = "";
        feedback = Menu.prompt("Enter feedback (if not leave empty):");
        // handles inactive assignment
        JSONArray allProgressAssignment = getProgressAssignments();
        for (int i = 0; i < allProgressAssignment.length(); i++) {
            if (i == selectedAssignment) {
                if (allProgressAssignment.getJSONObject(i).getString("status").equals("inactive")) {
                    selectedAssignment++;
                }
            }
        }
        // updates progress
        for (int i = 0; i < allProgress.length(); i++) {
            if (i == selectedStudent) {
                String studentId = allProgress.getJSONObject(i).getString("studentId");
                for (int j = 0; j < allProgress.getJSONObject(i).getJSONArray("assignments").length(); j++) {
                    if (j == selectedAssignment) {
                        String assignmentId = allProgress.getJSONObject(i).getJSONArray("assignments").getJSONObject(j).getString("id");
                        assignmentToProgress(assignmentId, studentId, "(Graded)", grade, feedback);
                        break;
                    }
                }
            }
        }
    }

    // get a specific classroomId id Ex: "GEN10-CS-SE-G1-OOP"
    private String getClassroomId() {
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

    // get only assignments from classroom.json
    private JSONArray getClassroomAssignments() {
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

    // get only assignments from progress.json
    private JSONArray getProgressAssignments() {
        String selectedClassroomId = getClassroomId();
        JSONArray allProgress = loadProgress();
        for (int i = 0; i < allProgress.length(); i++) {
            if (selectedClassroomId.equals(allProgress.getJSONObject(i).getString("classroomId"))) {
                return allProgress.getJSONObject(i).getJSONArray("assignments");
            }
        }
        return null;
    }


    // display only the assignment's titles from classroom and select an input
    private String selectAssignmentTitle() {
        JSONArray allAssignments = getClassroomAssignments();
        for (int i = 0; i < allAssignments.length(); i++) {
            if (allAssignments.getJSONObject(i).getString("status").equals("active")) {
                JSONObject assignment = allAssignments.getJSONObject(i);
                System.out.println(assignment.getString("title"));
            }
        }
        return Menu.prompt("Select an Assignment: ");
    }

    // get student Ids from classroom.json
    private JSONArray getClassroomStudents() {
        JSONArray allClassroom = loadClassroom();
        String classroomId = getClassroomId();
        for (int i = 0; i < allClassroom.length(); i++) {
            if (classroomId.equals(allClassroom.getJSONObject(i).getString("id"))) {
                return allClassroom.getJSONObject(i).getJSONArray("students");
            }
        }
        return null;
    }

    // get grade status from progress.json
    private String pendingStatus(int assignmentIndex) {
        JSONArray allProgressAssignment = getProgressAssignments();
        for (int i = 0; i < allProgressAssignment.length(); i++) {
            if (i == assignmentIndex) {
                return allProgressAssignment.getJSONObject(i).getString("pending");
            }
        }
        return "";
    }

    // display only the student names and select an input
    private String selectStudentToGrade() {
        StringBuilder listStudentName = new StringBuilder();
        JSONArray classroomStudentId = getClassroomStudents();
        JSONArray allStudent = loadStudent();
        int assignmentIndex = 0;
        for (int i = 0; i < classroomStudentId.length(); i++) {
            String cStudentId = classroomStudentId.getString(i);
            for (int j = 0; j < allStudent.length(); j++) {
                if (cStudentId.equals(allStudent.getJSONObject(j).getString("id"))) {
                    listStudentName.append(allStudent.getJSONObject(i).getJSONObject("name").getString("firstName")).append(" ").append(allStudent.getJSONObject(i).getJSONObject("name").getString("lastName")).append(" | ") .append(pendingStatus(assignmentIndex)).append("\n");
                    assignmentIndex++;
                    break;
                }
            }
        }
        System.out.print(listStudentName);
        return Menu.prompt("Select a Student: ");
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
    private void  assignmentToProgress(String assignmentId, String studentId, String pending, String grade, String feedback) {
        String classroomId = getClassroomId();
        JSONArray progresses = loadProgress();
        for (int i = 0; i < progresses.length(); i++) {
            if (classroomId.equals(progresses.getJSONObject(i).getString("classroomId")) && studentId.equals(progresses.getJSONObject(i).getString("studentId"))){
                boolean found = false;
                for (int j = 0; j < progresses.getJSONObject(i).getJSONArray("assignments").length(); j++) {
                    if (assignmentId.equals(progresses.getJSONObject(i).getJSONArray("assignments").getJSONObject(j).getString("id"))){
                        progresses.getJSONObject(i).getJSONArray("assignments").getJSONObject(j).put("pending", pending);
                        progresses.getJSONObject(i).getJSONArray("assignments").getJSONObject(j).put("grade", grade);
                        progresses.getJSONObject(i).getJSONArray("assignments").getJSONObject(j).put("feedback", feedback);
                        progresses.getJSONObject(i).getJSONArray("assignments").getJSONObject(j).put("status", "active");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    JSONObject newAssignment = new JSONObject();
                    newAssignment.put("id", assignmentId);
                    newAssignment.put("pending", pending);
                    newAssignment.put("grade", grade);
                    newAssignment.put("feedback", feedback);
                    newAssignment.put("status", "active");
                    progresses.getJSONObject(i).getJSONArray("assignments").put(newAssignment);
                }
            }
        }
        saveProgresses(progresses);
    }


// ---------------------------------------------------------------------------------------------------------------------------------------



    // Resource Manager
    public void manageAddResource() {
        int selectedWeek = Integer.parseInt(selectWeek()) - 1;
        String title = Menu.prompt("Enter Resource Title: ");
        String description = Menu.prompt("Enter Resource Description: ");
        String attachment = Menu.prompt("Enter Attachment: ");
        String newResourceId = "Week0" + (selectedWeek + 1);
        JSONObject resource = new JSONObject();
        resource.put("resourceId", newResourceId);
        JSONArray weekResources = getAllResource(newResourceId);
        String newContentId = idGenerator(weekResources, "R00000");
        JSONObject newResource = new JSONObject();
        newResource.put("id", newContentId);
        newResource.put("title", title);
        newResource.put("description", description);
        newResource.put("attachment", attachment);
        newResource.put("status", "active");
        JSONArray contents = new JSONArray();
        contents.put(newResource);
        resource.put("contents", contents);
        saveToResource(resource, newResource, newResourceId, newContentId); // save into resource.json
    }

    public void manageEditResource() {
        int selectedWeek = Integer.parseInt(selectWeek()) - 1; // hold selected week index
        int selectedTitle = Integer.parseInt(selectResourceTitle(selectedWeek)) - 1; // hold selected title index
        previousResourceInfo(selectedWeek, selectedTitle); // print the previous info
        // saving preparation
        JSONArray allResources = loadResource();
        JSONObject weekResources = new JSONObject();
        JSONObject resourceToEdit = new JSONObject();
        String resourceId = "";
        String contentId = "";
        for (int i = 0; i < allResources.length(); i++) {
            if (getClassroomId().equals(allResources.getJSONObject(i).getString("classroomId"))) {
                for (int j = 0; j < allResources.getJSONObject(i).getJSONArray("resources").length(); j++) {
                    if (j == selectedWeek) {
                        resourceId = allResources.getJSONObject(i).getJSONArray("resources").getJSONObject(j).getString("resourceId");
                        for (int k = 0; k < allResources.getJSONObject(i).getJSONArray("resources").getJSONObject(j).getJSONArray("contents").length(); k++) {
                            if (k == selectedTitle) {
                                contentId = allResources.getJSONObject(i).getJSONArray("resources").getJSONObject(j).getJSONArray("contents").getJSONObject(k).getString("id");
                                resourceToEdit = allResources.getJSONObject(i).getJSONArray("resources").getJSONObject(j).getJSONArray("contents").getJSONObject(k);
                                break;
                            }
                        }
                    }
                }
            }
        }
        // edit process
        String newTitle = Menu.prompt("Enter a new title (if not leave empty): ");
        if (!newTitle.isEmpty()) {
            resourceToEdit.put("title", newTitle);
        }
        String newDescription = Menu.prompt("Enter a new description (if not leave empty): ");
        if (!newDescription.isEmpty()) {
            resourceToEdit.put("description", newDescription);
        }
        String newAttachment = Menu.prompt("Enter a new attachment (if not leave empty): ");
        if (!newAttachment.isEmpty()) {
            resourceToEdit.put("attachment", newAttachment);
        }
        saveToResource(weekResources, resourceToEdit, resourceId, contentId); // save
    }

    public void manageDeleteResource() {
        int selectedWeek = Integer.parseInt(selectWeek()) - 1; // hold selected week index
        int selectedTitle = Integer.parseInt(selectResourceTitle(selectedWeek)) - 1; // hold selected title index
        // saving preparation
        JSONArray allResources = loadResource();
        JSONObject weekResources = new JSONObject();
        JSONObject resourceToEdit = new JSONObject();
        String resourceId = "";
        String contentId = "";
        for (int i = 0; i < allResources.length(); i++) {
            if (getClassroomId().equals(allResources.getJSONObject(i).getString("classroomId"))) {
                for (int j = 0; j < allResources.getJSONObject(i).getJSONArray("resources").length(); j++) {
                    if (j == selectedWeek) {
                        resourceId = allResources.getJSONObject(i).getJSONArray("resources").getJSONObject(j).getString("resourceId");
                        for (int k = 0; k < allResources.getJSONObject(i).getJSONArray("resources").getJSONObject(j).getJSONArray("contents").length(); k++) {
                            if (k == selectedTitle) {
                                contentId = allResources.getJSONObject(i).getJSONArray("resources").getJSONObject(j).getJSONArray("contents").getJSONObject(k).getString("id");
                                resourceToEdit = allResources.getJSONObject(i).getJSONArray("resources").getJSONObject(j).getJSONArray("contents").getJSONObject(k);
                                break;
                            }
                        }
                    }
                }
            }
        }
        resourceToEdit.put("status", "inactive"); // update status
        saveToResource(weekResources, resourceToEdit, resourceId, contentId); // save
    }

    public void manageViewResource() {
        JSONArray allResource = loadResource();
        for (int i = 0; i < allResource.length(); i++) {
            if (getClassroomId().equals(allResource.getJSONObject(i).getString("classroomId"))) {
                for (int j = 0; j < allResource.getJSONObject(i).getJSONArray("resources").length(); j++) {
                    System.out.println(allResource.getJSONObject(i).getJSONArray("resources").getJSONObject(j).getString("resourceId"));
                    for (int k = 0; k < allResource.getJSONObject(i).getJSONArray("resources").getJSONObject(j).getJSONArray("contents").length(); k++) {
                        System.out.println("    Title: " + allResource.getJSONObject(i).getJSONArray("resources").getJSONObject(j).getJSONArray("contents").getJSONObject(k).getString("title"));
                        System.out.println("    Description: " + allResource.getJSONObject(i).getJSONArray("resources").getJSONObject(j).getJSONArray("contents").getJSONObject(k).getString("description"));
                        System.out.println("    Attachment: " + allResource.getJSONObject(i).getJSONArray("resources").getJSONObject(j).getJSONArray("contents").getJSONObject(k).getString("attachment"));
                        System.out.println("-".repeat(200)); // separates each content
                    }
                }
            }
        }
    }

    // display each week and select and input
    private String selectWeek() {
        for (int i = 0; i < 10; i++) {
            System.out.print("Week");
            System.out.println(i+1);
        }
        return Menu.prompt("Select a Week: ");
    }

    // display all resource titles and select an input
    private String selectResourceTitle(int selectedWeek) {
        String classroomId = getClassroomId();
        JSONArray allResource = loadResource();
        int extraIndex = 0;
        for (int i = 0; i < allResource.length(); i++) {
            if (classroomId.equals(allResource.getJSONObject(i).getString("classroomId"))) {
                for (int j = 0; j < allResource.getJSONObject(i).getJSONArray("resources").length(); j++) {
                    if (j == selectedWeek) {
                        for (int k = 0; k < allResource.getJSONObject(i).getJSONArray("resources").getJSONObject(j).getJSONArray("contents").length(); k++) {
                            if (allResource.getJSONObject(i).getJSONArray("resources").getJSONObject(j).getJSONArray("contents").getJSONObject(k).getString("status").equals("active")) {
                                System.out.println(allResource.getJSONObject(i).getJSONArray("resources").getJSONObject(j).getJSONArray("contents").getJSONObject(k).getString("title"));
                            } else {
                                extraIndex++;
                            }
                        }
                    }
                }
            }
        }
        String selectedTitle = Menu.prompt("select a title: ");
        int finalIndex = Integer.parseInt(selectedTitle) + extraIndex;
        return Integer.toString(finalIndex);
    }

    //print previous info of a resource
    private void previousResourceInfo(int selectedWeek, int selectedTitle) {
        JSONArray allResource = loadResource();
        for (int i = 0; i < allResource.length(); i++) {
            if (getClassroomId().equals(allResource.getJSONObject(i).getString("classroomId"))) {
                for (int j = 0; j < allResource.getJSONObject(i).getJSONArray("resources").length(); j++) {
                    if (j == selectedWeek) {
                        for (int k = 0; k < allResource.getJSONObject(i).getJSONArray("resources").getJSONObject(j).getJSONArray("contents").length(); k++) {
                            if (k == selectedTitle) {
                                System.out.println(allResource.getJSONObject(i).getJSONArray("resources").getJSONObject(j).getJSONArray("contents").getJSONObject(k).getString("title"));
                                System.out.println(allResource.getJSONObject(i).getJSONArray("resources").getJSONObject(j).getJSONArray("contents").getJSONObject(k).getString("description"));
                                System.out.println(allResource.getJSONObject(i).getJSONArray("resources").getJSONObject(j).getJSONArray("contents").getJSONObject(k).getString("attachment"));
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    // get Resource array within a week from resource.json only
    private JSONArray getAllResource(String resourceId) {
        JSONArray allResource = loadResource();
        String classroomId = getClassroomId();
        for (int i = 0; i < allResource.length(); i++) {
            if (classroomId.equals(allResource.getJSONObject(i).getString("classroomId"))) {
                for (int j = 0; j < allResource.getJSONObject(i).getJSONArray("resources").length(); j++) {
                    if (resourceId.equals(allResource.getJSONObject(i).getJSONArray("resources").getJSONObject(j).getString("resourceId"))) {
                        return allResource.getJSONObject(i).getJSONArray("resources").getJSONObject(j).getJSONArray("contents");
                    }
                }
            }
        }
        return null;
    }

    private void saveToResource(JSONObject weekResources, JSONObject newResource, String resourceId, String contentId) {
        JSONArray allResource = loadResource();
        String classroomId = getClassroomId();
        boolean isClassroomIdFound = false;
        for (int i = 0; i < allResource.length(); i++) {
            if (classroomId.equals(allResource.getJSONObject(i).getString("classroomId"))) {
                isClassroomIdFound = true;
                boolean isResourceIdFound = false;
                for (int j = 0; j < allResource.getJSONObject(i).getJSONArray("resources").length(); j++) {
                    if (resourceId.equals(allResource.getJSONObject(i).getJSONArray("resources").getJSONObject(j).getString("resourceId"))) {
                        isResourceIdFound = true;
                        boolean isContentIdFound = false;
                        for (int k = 0; k < allResource.getJSONObject(i).getJSONArray("resources").getJSONObject(j).getJSONArray("contents").length(); k++) {
                            if (contentId.equals(allResource.getJSONObject(i).getJSONArray("resources").getJSONObject(j).getJSONArray("contents").getJSONObject(k).getString("id"))) {
                                allResource.getJSONObject(i).getJSONArray("resources").getJSONObject(j).getJSONArray("contents").put(k, newResource);
                                isContentIdFound = true;
                                break;
                            }
                        }
                        if (!isContentIdFound) {
                            allResource.getJSONObject(i).getJSONArray("resources").getJSONObject(j).getJSONArray("contents").put(newResource);
                        }
                    }
                }
                if (!isResourceIdFound) {
                    allResource.getJSONObject(i).getJSONArray("resources").put(weekResources);
                }
            }
        }
        if (!isClassroomIdFound) {
            JSONObject resourceObject = new JSONObject();
            resourceObject.put("classroomId", getClassroomId());
            JSONArray resources = new JSONArray();
            resources.put(weekResources);
            resourceObject.put("resources", resources);
            allResource.put(resourceObject);
        }
        saveResource(allResource);
    }



// --------------------------------------------------------------------------------------------------------------------------



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



// ----------------------------------------------------------------------------------------------------------------------------


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

    // save all resource
    private void saveResource(JSONArray allResource) {
        try (FileWriter file = new FileWriter("shared/data/resource.json")) {
            file.write(allResource.toString(4)); // Pretty-print with 4 spaces
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

    // load all resource
    private JSONArray loadResource(){
        try {
            String contents = new String(Files.readAllBytes(Paths.get("shared/data/resource.json")));
            JSONArray allResource = new JSONArray(contents);
            return allResource;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String idGenerator(JSONArray objects, String baseId) { // baseId receives Ex: "A000"
        String numberPart = baseId.replaceAll("[^0-9]", ""); // extract number part "000"
        int numberLength = numberPart.length();
        int nextIdNumber;
        if (objects != null) {
            nextIdNumber = objects.length() + 1; // find next available id
        } else {
            nextIdNumber = 1;
        }
        String formattedNumber = String.format("%0" + numberLength + "d", nextIdNumber); // %03d
        String prefixChar = baseId.replaceAll("[0-9]", ""); // extract the non-numeric part "A"
        return prefixChar + formattedNumber;
    }
}
