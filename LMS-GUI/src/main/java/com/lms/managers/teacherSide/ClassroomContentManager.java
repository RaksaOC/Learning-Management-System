package main.java.com.lms.managers.teacherSide;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

//interface classroomManagementInterface {
//    void manageAddAssignment();
//
//    void manageEditAssignment();
//
//    void manageDeleteAssignment();
//
//    void manageGradeAssignment();
//
//    void manageAddResource();
//
//    void manageEditResource();
//
//    void manageDeleteResource();
//
//    void manageViewResource();
//
//    // void manageAddQuizz(String title, String createdBy, JSONArray questions);
//
//    void manageEditQuizz();
//

/// /    void manageDeleteQuizz(String id);
//
//    void manageViewQuizz();
//
//
//}

public class ClassroomContentManager {

    private final String classIdToEdit;

    public ClassroomContentManager(String ClassIdToEdit) {
        this.classIdToEdit = ClassIdToEdit; // this holds only the user's input
    }

    public void manageAddAssignment(String title, String description, String date, String time) {
//        String title = Menu.prompt("Enter Assignment Title: ");
//        String description = Menu.prompt("Enter Assignment Description: ");
//        String date = Menu.prompt("Enter a Date for Deadline (YYYY-MM-DD):");
//        String time = Menu.prompt("Enter a Time for Deadline (hh:mm AM/PM): ");
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
        // TODO: add reference material which can be optional
        JSONArray allClassroom = loadClassroom();
        saveAssignments(newAssignment, title); // saves to classroom
        // handles saving to progress
        for (int i = 0; i < allClassroom.length(); i++) {
            if (getClassroomId().equals(allClassroom.getJSONObject(i).getString("id"))) {
                for (int j = 0; i < allClassroom.getJSONObject(i).getJSONArray("students").length(); j++) {
                    assignmentToProgress(allClassroom.getJSONObject(i).getJSONArray("students").getString(j), assignmentId, "(Ongoing)", "", "");
                }
            }
        }
    }

    public void manageEditAssignment(int titleId, String newTitle, String newDescription, String newDate, String newTime) {
//        int titleId = Integer.parseInt(selectAssignmentTitle()) - 1; // hold title selection
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
//                String newTitle = Menu.prompt("Enter a new Title (if not leave empty): ");
                if (!newTitle.isEmpty()) {
                    assignmentToEdit.put("title", newTitle);
                }
//                String newDescription = Menu.prompt("Enter a new Description (if not leave empty):");
                if (!newDescription.isEmpty()) {
                    assignmentToEdit.put("description", newDescription);
                }
//                String newDate = Menu.prompt("Enter a new Deadline Date (YYYY-MM-DD) (if not leave empty): ");
                if (!newDate.isEmpty()) {
                    assignmentDeadline.put("date", newDate);
                }
//                String newTime = Menu.prompt("Enter a new Deadline Time (HH:MM) (if not leave empty): ");
                if (!newTime.isEmpty()) {
                    assignmentDeadline.put("time", newTime);
                }
                allAssignments.put(i, assignmentToEdit); // ensure it saves into correct index
                saveAssignments(assignmentToEdit, assignmentToEdit.getString("id"));
                break;
            }
        }
    }

    public void manageDeleteAssignment(int titleId) {
//        int titleId = Integer.parseInt(selectAssignmentTitle()) - 1; // hold title selection
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

    public void manageGradeAssignment(int selectedAssignment, int selectedStudent, String grade, String feedback) {
        JSONArray allProgress = loadProgress();
//        int selectedAssignment = Integer.parseInt(selectAssignmentTitle()) - 1; // hold the selected assignment's index
//        int selectedStudent = Integer.parseInt(selectStudentToGrade()) - 1; // hold the selected student's index
//        String grade = Menu.prompt("Grade the student Assignment (0 - 100): ");
//        String feedback = "";
//        feedback = Menu.prompt("Enter feedback (if not leave empty):");
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
    // changed from private to protected
    protected String getClassroomId() {
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
//        int indexOfClass = Integer.parseInt(classIdToEdit);
        JSONArray allClass = loadClassroom();
        for (int i = 0; i < allClass.length(); i++) {
            if (allClass.getJSONObject(i).getString("id").equals(classIdToEdit)) {
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
//    private String selectAssignmentTitle() {
//        JSONArray allAssignments = getClassroomAssignments();
//        for (int i = 0; i < allAssignments.length(); i++) {
//            if (allAssignments.getJSONObject(i).getString("status").equals("active")) {
//                JSONObject assignment = allAssignments.getJSONObject(i);
//                System.out.println(assignment.getString("title"));
//            }
//        }
//        return Menu.prompt("Select an Assignment: ");
//    }

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
//    private String selectStudentToGrade() {
//        StringBuilder listStudentName = new StringBuilder();
//        JSONArray classroomStudentId = getClassroomStudents();
//        JSONArray allStudent = loadStudent();
//        int assignmentIndex = 0;
//        for (int i = 0; i < classroomStudentId.length(); i++) {
//            String cStudentId = classroomStudentId.getString(i);
//            for (int j = 0; j < allStudent.length(); j++) {
//                if (cStudentId.equals(allStudent.getJSONObject(j).getString("id"))) {
//                    listStudentName.append(allStudent.getJSONObject(i).getJSONObject("name").getString("firstName")).append(" ").append(allStudent.getJSONObject(i).getJSONObject("name").getString("lastName")).append(" | ") .append(pendingStatus(assignmentIndex)).append("\n");
//                    assignmentIndex++;
//                    break;
//                }
//            }
//        }
//        System.out.print(listStudentName);
//        return Menu.prompt("Select a Student: ");
//    }

    // check & save only the assignment into the correct index
    private void saveAssignments(JSONObject newAssignment, String assignmentId) {
        // TODO: Need to change this to add assignment ID to the classroom
//        int indexOfClass = Integer.parseInt(classIdToEdit);
        JSONArray allClass = loadClassroom();
        for (int i = 0; i < allClass.length(); i++) {
            if (allClass.getJSONObject(i).getString("id").equals(classIdToEdit)) {
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
    private void assignmentToProgress(String assignmentId, String studentId, String pending, String grade, String feedback) {
        String classroomId = getClassroomId();
        JSONArray progresses = loadProgress();
        for (int i = 0; i < progresses.length(); i++) {
            if (classroomId.equals(progresses.getJSONObject(i).getString("classroomId")) && studentId.equals(progresses.getJSONObject(i).getString("studentId"))) {
                boolean found = false;
                for (int j = 0; j < progresses.getJSONObject(i).getJSONArray("assignments").length(); j++) {
                    if (assignmentId.equals(progresses.getJSONObject(i).getJSONArray("assignments").getJSONObject(j).getString("id"))) {
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

    // Resource Manager
    public void manageAddResource(int selectedWeek, String title, String description) {
//        int selectedWeek = Integer.parseInt(selectWeek()) - 1;
//        String title = Menu.prompt("Enter Resource Title: ");
//        String description = Menu.prompt("Enter Resource Description: ");

        JSONArray resources = new JSONArray();
        JSONObject resourceObject = new JSONObject();
        String resourceId = idGenerator(loadResource(), "R0000");
        resourceObject.put("resourceId", resourceId);
        resourceObject.put("status", "active");
        JSONArray allWeekResource = new JSONArray();
        JSONObject week = new JSONObject();
        String weekId = idGenerator(loadResource(), "Week00");
        week.put("id", weekId);
        JSONArray contents = new JSONArray();
        JSONObject content = new JSONObject();
        JSONArray weekResources = getAllResource();
        JSONArray aWeekContents = null;
        for (int i = 0; i < weekResources.length(); i++) {
            if (i == selectedWeek) {
                aWeekContents = weekResources.getJSONObject(i).getJSONArray("contents");
                break;
            }
        }
        String contentId = idGenerator(aWeekContents, "C0000");
        content.put("id", contentId);
        content.put("title", title);
        content.put("description", description);
        content.put("status", "active");

    }

    public void manageEditResource() {

    }

    public void manageDeleteResource() {

    }

    public void manageViewResource() {

    }

    // display each week and select and input
//    private String selectWeek() {
//        for (int i = 0; i < 10; i++) {
//            System.out.println("Week0" + i+1);
//        }
//        return Menu.prompt("Select a Week: ");
//    }

    // get Resource array (all weeks) from resource.json only
    private JSONArray getAllResource() {
        JSONArray allResource = loadResource();
        String classroomId = getClassroomId();
        for (int i = 0; i < allResource.length(); i++) {
            if (classroomId.equals(allResource.getJSONObject(i).getString("classroomId"))) {
                return allResource.getJSONObject(i).getJSONArray("resources");
            }
        }
        return null;
    }

//    private void saveToResource() {
//        String classroomId = getClassroomId();
//        JSONArray allResource = loadResource();
//        for (int i = 0; i < allResource.length(); i++) {
//            if (classroomId.equals(allResource.getJSONObject(i).get))
//        }
//    }


    // Quizz Manager
    public void manageAddQuizz() {

    }

    public void manageEditQuizz() {

    }

    public void manageGradeQuizz() {

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

    // save all resource
    private void saveResource(JSONArray allResource) {
        try (FileWriter file = new FileWriter("shared/data/progress.json")) {
            file.write(allResource.toString(4)); // Pretty-print with 4 spaces
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // load all classrooms
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
    private JSONArray loadResource() {
        try {
            String contents = new String(Files.readAllBytes(Paths.get("shared/data/resource.json")));
            JSONArray allResource = new JSONArray(contents);
            return allResource;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // changed from private to protected cuz of inheritence

    protected String idGenerator(JSONArray objects, String baseId) { // baseId receives Ex: "A000"
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
