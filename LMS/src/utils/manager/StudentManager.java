package utils.manager;

import entities.Student;

import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import utils.menu.Menu;

public class StudentManager {
    Student studentToEdit;

    public StudentManager(Student student) {
        //                  ^
        //      the constructor takes in the student object to get the changed data in its fields to write back to file
        studentToEdit = student;
    }

    public String printClassrooms(JSONArray classroom){
        String allClass = "";
        for(int i = 0; i < classroom.length(); i ++){
            allClass += classroom.getString(i) + "\n" ;
        }
        return allClass;
    }

    public  String printProgress(JSONObject progress){
        String allProgress = "";
        for (String key : progress.keySet()){
            System.out.println(key);
        }
        return allProgress;
    }

    public String manageViewAssignment() {
        JSONArray studentAssignments = studentToEdit.getAssignments();
        if (studentAssignments.length() == 0) return "No assignments available.";

        // Step 1: Display only assignment titles
        StringBuilder assignmentList = new StringBuilder("\nAvailable Assignments:\n");
        for (int i = 0; i < studentAssignments.length(); i++) {
            JSONObject assignment = studentAssignments.getJSONObject(i);
            assignmentList.append(String.format("%d. %s\n", i + 1, assignment.getString("title")));
        }

        // Step 2: Prompt student to select an assignment
        int choice = Integer.parseInt(Menu.prompt(assignmentList + "\nSelect an assignment (enter number): "));

        if (choice < 1 || choice > studentAssignments.length()) {
            return "Invalid choice.";
        }

        // Step 3: Retrieve selected assignment details
        JSONObject selectedAssignment = studentAssignments.getJSONObject(choice - 1);

        // Step 4: Format assignment details nicely
         String assignment = String.format("""
                Assignment Details:
                -----------------------------------
                Title: %s
                Description: %s
                Deadline: %s %s
                Status: %s
                -----------------------------------
                """,
                selectedAssignment.getString("title"),
                selectedAssignment.getString("description"),
                selectedAssignment.getJSONObject("deadline").getString("date"),
                selectedAssignment.getJSONObject("deadline").getString("time"),
                selectedAssignment.getString("status")
        );return assignment;
    }

    public String manageViewProfile() {
        // print the student's info in a nice and formatted table/ interface
        String profile = String.format("""
                Student Table:
                ----------------
                Student status: %s
                ID: %s
                Name: %s
                Gender: %s
                Date of Birth: %s
                Email: %s
                Phone number: %s
                Address: %s
                Specialization: %s
                Department: %s
                Generation: %s
                -----------------
                """,
                studentToEdit.getStatus() ,studentToEdit.getId(), studentToEdit.getFullName(), studentToEdit.getGender(), studentToEdit.getDoB(),
                studentToEdit.getEmail(), studentToEdit.getPhone(), studentToEdit.getAddress(),studentToEdit.getSpecialization(),
                studentToEdit.getDepartment(), studentToEdit.getGeneration()
        );
        return profile;
    }

    public void addAssingment(){
        // student,assignmetn.add(newAssignment)
        // convert to json
        // write to file
    }

    public void changeName(String newName){

    }

    public String manageViewClassroom(){

        return null;
    }

}