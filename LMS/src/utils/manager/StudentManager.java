package utils.manager;

import entities.Student;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;
import utils.menu.Menu;

public class StudentManager {
    Student studentToEdit;

    public StudentManager(Student student){
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


    // Load all classrooms from classroom.json
    public JSONArray loadClassroom() {
        try {
            String filePath = "shared/data/classroom.json";
            String contents = new String(Files.readAllBytes(Paths.get(filePath)));

            return new JSONArray(contents);
        } catch (IOException e) {
            System.err.println("Error loading classrooms: " + e.getMessage());
            return new JSONArray();  // Return empty array instead of null
        }
    }

    public JSONArray getAssignments(String classroomId) {
        JSONArray allClass = loadClassroom(); // Load classrooms
        // Loop through the classrooms to find the matching classroom ID
        for (int i = 0; i < allClass.length(); i++) {
            JSONObject classToEdit = allClass.getJSONObject(i);

            // Check if the classroom ID matches the selected classroomId
            if (classToEdit.getString("id").equals(classroomId)) {
                // If assignments exist, return them
                JSONArray assignments = classToEdit.optJSONArray("assignments");
                if (assignments != null && assignments.length() > 0) {
                    return assignments;
                }
            }
        }
        return new JSONArray(); // Return empty array if no assignments are found
    }

    // Display all titles and allow the user to select an assignment by ID
    public String selectAssignmentTitle(String classroomId) {
        JSONArray allAssignments = getAssignments(classroomId); // Get filtered assignments

        if (allAssignments.length() == 0) {
            System.out.println("No assignments available for this classroom.");
            return null; // Return null if no assignments
        }

        System.out.println("\nAvailable Assignments:");
        for (int i = 0; i < allAssignments.length(); i++) {
            JSONObject assignment = allAssignments.getJSONObject(i);
            System.out.println(assignment.getString("id") + " - " + assignment.getString("title")); // Show ID & title
        }

        return Menu.prompt("Enter Assignment ID to select: ");
    }

    // To get each Assignment details after selected
    public JSONObject getAssignmentDetails(String classroomId, String assignmentId) {
        JSONArray allAssignments = getAssignments(classroomId); // Get all assignments for the classroom

        for (int i = 0; i < allAssignments.length(); i++) {
            JSONObject assignment = allAssignments.getJSONObject(i);
            if (assignment.getString("id").equals(assignmentId)) {
                return assignment; // Return the found assignment
            }
        }
        return null; // Return null if the assignment isn't found
    }

    // Display assignment details
    public void displayAssignmentDetails(JSONObject assignment) {
        System.out.println("\n===== Assignment Details =====");
        System.out.println("Title: " + assignment.getString("title"));
        System.out.println("Description: " + assignment.getString("description"));
        System.out.println("Deadline: " +
                assignment.getJSONObject("deadline").getString("date") + " " +
                assignment.getJSONObject("deadline").getString("time"));
        System.out.println("Status: " + assignment.getString("status"));
        System.out.println("==============================\n");
    }

    // Allow students to write/edit their assignment
    public void editAssignment(String studentId, String assignmentId, String classroomId) {
        System.out.println("Editing Assignment: " + assignmentId);

        // Check if the student has an existing submission
        JSONArray submissions = loadSubmissions();
        JSONObject existingSubmission = null;

        for (int i = 0; i < submissions.length(); i++) {
            JSONObject submission = submissions.getJSONObject(i);
            if (submission.getString("studentId").equals(studentId) &&
                    submission.getString("assignmentId").equals(assignmentId)) {
                existingSubmission = submission;
                break;
            }
        }

        if (existingSubmission != null) {
            System.out.println("Your previous submission:");
            System.out.println(existingSubmission.getString("submissionText"));
        } else {
            System.out.println("No previous submission found. Starting a new submission.");
        }

        // Prompt for new submission content
        String updatedWork = Menu.prompt("Enter your updated assignment answer: ");
        saveSubmission(studentId, assignmentId, classroomId, updatedWork);
    }

    // Save or update assignment submission
    public void saveSubmission(String studentId, String assignmentId, String classroomId, String submissionText) {
        try {
            String filePath = "shared/data/progress.json";
            JSONArray submissions = loadSubmissions();

            // Check if the student already submitted this assignment
            JSONObject existingSubmission = null;
            for (int i = 0; i < submissions.length(); i++) {
                JSONObject submission = submissions.getJSONObject(i);
                if (submission.getString("studentId").equals(studentId) &&
                        submission.getString("assignmentId").equals(assignmentId)) {
                    existingSubmission = submission;
                    break;
                }
            }

            if (existingSubmission != null) {
                existingSubmission.put("submissionText", submissionText);
                existingSubmission.put("status", "resubmitted");
                existingSubmission.put("timestamp", System.currentTimeMillis());
                System.out.println("Assignment resubmitted successfully!");
            } else {
                JSONObject newSubmission = new JSONObject();
                newSubmission.put("studentId", studentId);
                newSubmission.put("assignmentId", assignmentId);
                newSubmission.put("classroomId", classroomId);
                newSubmission.put("submissionText", submissionText);
                newSubmission.put("status", "submitted");
                newSubmission.put("timestamp", System.currentTimeMillis());

                submissions.put(newSubmission);
                System.out.println("Assignment submitted successfully!");
            }

            // Write back to the file
            Files.write(Paths.get(filePath), submissions.toString(4).getBytes());
        } catch (IOException e) {
            System.err.println("Error saving submission: " + e.getMessage());
        }
    }

    // Load all submissions from progress.json
    private JSONArray loadSubmissions() {
        try {
            String filePath = "shared/data/progress.json";
            String contents = new String(Files.readAllBytes(Paths.get(filePath)));
            return new JSONArray(contents);
        } catch (IOException e) {
            return new JSONArray(); // Return empty array if file is missing
        }
    }

    private String formatTimestamp(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date(timestamp));
    }

    //    View Submitted assignments
    public void viewSubmittedAssignments(String studentId) {
        JSONArray submissions = loadSubmissions();
        boolean found = false;
        System.out.println("\nYour Submitted Assignments:");
        for (int i = 0; i < submissions.length(); i++) {
            JSONObject submission = submissions.getJSONObject(i);

            if (submission.getString("studentId").trim().equals(studentId.trim())) {  // Trim for safety
                found = true;

                // Trim assignmentId to avoid space issues
                String assignmentId = submission.getString("assignmentId").trim();

                // Convert timestamp to readable date format
                String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                        .format(new Date(submission.getLong("timestamp")));

                System.out.println("Assignment ID: " + assignmentId +
                        ", Status: " + submission.getString("status") +
                        ", Submitted on: " + formattedDate);
            }
        }
        if (!found) {
            System.out.println("No assignments submitted yet.");
        }
    }

    public void viewGradesAndComments(String studentId){
//        JSONArray feedback =
    }

//  Part of Resource
    // Load resources from file
    public JSONArray loadResource() {
        try {
            String filePath = "shared/data/resource.json";
            String contents = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray resources = new JSONArray(contents);
            return resources;
        } catch (IOException e) {
            System.err.println("Error loading resource: " + e.getMessage());
            return new JSONArray();  // Return empty array instead of null
        }
    }

    public void displayResourcesByWeek(String classroomId) {
        JSONArray allClasses = loadResource(); // Load all resources

        if (allClasses.length() == 0) {
            System.out.println("No resources available.");
            return;
        }

        System.out.println("\nAvailable Resource Weeks:");

        for (int i = 0; i < allClasses.length(); i++) {
            JSONObject classroom = allClasses.getJSONObject(i);

            // Ensure classroomId matches
            if (classroom.has("classroomId") && classroom.getString("classroomId").equals(classroomId)) {
                JSONArray resources = classroom.getJSONArray("resources"); // Get resources array

                for (int j = 0; j < resources.length(); j++) {
                    JSONObject resource = resources.getJSONObject(j);

                    // Check if resourceId exists before accessing it
                    if (resource.has("resourceId")) {
                        System.out.println((j + 1) + ". " + resource.getString("resourceId"));
                    } else {
                        System.out.println("Warning: A resource is missing 'resourceId'. Skipping...");
                    }
                }
            }
        }

        // Select a week
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter Resource Week ID to view contents: ");
        String selectedWeekId = scanner.nextLine().trim();

        // Display resources for selected week
        displayContentsByWeek(classroomId, selectedWeekId);
    }


    public void displayContentsByWeek(String classroomId, String selectedWeekId) {
        JSONArray allClasses = loadResource(); // Load all resources

        for (int i = 0; i < allClasses.length(); i++) {
            JSONObject classroom = allClasses.getJSONObject(i);

            // Check if classroomId matches
            if (classroom.has("classroomId") && classroom.getString("classroomId").equals(classroomId)) {
                JSONArray resources = classroom.getJSONArray("resources"); // Get resources array

                for (int j = 0; j < resources.length(); j++) {
                    JSONObject resource = resources.getJSONObject(j);

                    // Check if resourceId exists and matches the selected week
                    if (resource.has("resourceId") && resource.getString("resourceId").equals(selectedWeekId)) {
                        JSONArray contents = resource.getJSONArray("contents");

                        if (contents.length() == 0) {
                            System.out.println("No resources found for " + selectedWeekId);
                            return;
                        }

                        System.out.println("\nContents for " + selectedWeekId + ":");
                        for (int k = 0; k < contents.length(); k++) {
                            JSONObject content = contents.getJSONObject(k);
                            System.out.println((k + 1) + ". " + content.getString("title") + " (ID: " + content.getString("id") + ")");
                        }

                        // Allow user to select a resource to view details
                        Scanner scanner = new Scanner(System.in);
                        System.out.print("\nEnter Resource ID to view details: ");
                        String selectedResourceId = scanner.nextLine().trim();

                        // Display details of the selected resource
                        for (int k = 0; k < contents.length(); k++) {
                            JSONObject content = contents.getJSONObject(k);
                            if (content.getString("id").equals(selectedResourceId)) {
                                System.out.println("\nTitle: " + content.getString("title"));
                                System.out.println("Description: " + content.getString("description"));
                                System.out.println("Attachment: " + content.getString("attachment"));
                                return;
                            }
                        }

                        System.out.println("Invalid Resource ID. Returning to menu...");
                        return;
                    }
                }

                System.out.println("Invalid Week ID. Please try again.");
                return;
            }
        }

        System.out.println("Classroom ID not found.");
    }


    //    2. View profile side
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

}