package utils.controller;

import entities.Student;
import entities.Teacher;
import org.json.JSONArray;
import org.json.JSONObject;
import ui.UI;
import utils.manager.StudentManager;
import utils.menu.Menu;
import utils.controller.ClassroomController;

import java.util.Scanner;

public class StudentController {
    Student student;
    String indexOfClass;
    public StudentController(Student s) {
//                              ^
//            takes in the student object from the authentication controller
        this.student = s;
    }

    public String selectClassroom(){
        StudentManager studentManager = new StudentManager(student);
        System.out.println(studentManager.printClassrooms(student.getClassrooms()));
        String choice = Menu.prompt("Select a Classroom ID: ");
        JSONArray classrooms = student.getClassrooms();
        for(int i =0; i < classrooms.length(); i++){
            if(classrooms.getString(i).equals(choice)){
                return  choice;
            }
        }
        return selectClassroom();
    }

    public String selectProgress() {
        StudentManager studentManager = new StudentManager(student);
        System.out.println(studentManager.printProgress(student.getProgress()));
        JSONObject progressData = student.getProgress(); // Get student's progress object
        System.out.println("\nAvailable Progress:");
        for (String key : progressData.keySet()) { // Loop through progress keys
            String progressId = progressData.getString(key);
            System.out.println(key + ": " + progressId); // Output {group: progressId}
        }
        return Menu.prompt("Enter Progress ID to select: "); // Ask user to enter Progress ID (e.g., P000001)
    }


    // Assignment Controller
    public void handleViewAssignment(String classroomId) {
        StudentManager studentManager = new StudentManager(student);
        // Step 1: Get the assignment ID selected by the user
        String assignmentId = studentManager.selectAssignmentTitle(classroomId);
        if (assignmentId == null) {
            System.out.println("No assignment selected.");
            return;
        }
        // Step 2: Retrieve the assignment details
        JSONObject assignment = studentManager.getAssignmentDetails(classroomId, assignmentId);
        // Step 3: Display the assignment details
        if (assignment != null) {
            studentManager.displayAssignmentDetails(assignment);
        } else {
            System.out.println("Assignment not found.");
        }
    }

    public void handleDoAssignment(String classroomId) {
        StudentManager studentManager = new StudentManager(student);
        String assignmentId = studentManager.selectAssignmentTitle(classroomId);

        if (assignmentId != null) {
            studentManager.editAssignment(student.getId(), assignmentId, classroomId);
        }
    }

    public void handleViewSubmittedAssignment(){
        StudentManager studentManager = new StudentManager(student);
        studentManager.viewSubmittedAssignments(student.getId());
    }

    public void handleViewGradeAndComments(){

    }

//    Part of Resource
    public void handleViewResource(String classroomId) {
        StudentManager studentManager = new StudentManager(student);
        studentManager.displayResourcesByWeek(classroomId);
    }

    //    View Profile method
    public void viewProfile(){
        StudentManager studentManager = new StudentManager(student);
        String profileDetails = studentManager.manageViewProfile();
        System.out.println(UI.TextColor.addColor((profileDetails), UI.TextColor.BLUE));
        // works the same

        // example:
        // JSONArray profile = manager.manageViewProfile();
        // logic to make the data look nice i.e. into a table...
    }


}