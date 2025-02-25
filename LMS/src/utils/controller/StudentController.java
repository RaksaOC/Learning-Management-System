package utils.controller;

import entities.Student;
import entities.Teacher;
import ui.UI;
import utils.manager.ClassroomManager;
import utils.manager.StudentManager;
import utils.menu.Menu;

import java.util.Scanner;

public class StudentController {
    Student student;
    String indexOfClass;
    public StudentController(Student s) {
//                              ^
//            takes in the student object from the authentication controller
        this.student = s;
    }
    public StudentController(Student student ,String indexOfClass) {
        this.indexOfClass  = indexOfClass;
    }

    public String selectClassroom(){
        StudentManager studentManager = new StudentManager(student);
        System.out.println(studentManager.printClassrooms(student.getClassrooms()));
        String choice = Menu.prompt("Select a Classroom: ");
        return Integer.toString(Integer.parseInt(choice) - 1);
    }
    public void submitAssignment(){
        // handles the actions of submitting an assignment
        // getting input like link to the finished work of the student

//        Scanner sc = new Scanner(System.in);
//        System.out.println("link ");
//
//        // submitted
//        assignment  = student.getAssingment();
//        assingment.add(newAssignment);
//
//        StudentManager studentManager = new StudentManager(student);
//        studentManager.manageViewAssignment();

        // call to manager to manage the submission of the assignment (write to file (to where....))

        // example use:
        // String assignmentLInk = sc.nextLine();
        // manager.manageSubmitAssignment(assignmentLink)
    }

    public void viewAssignment(){
        // works like the submit assignment just call to manager to read the file that contains the assignment
        // the controller can take the raw json data from the manager and organize it to look pretty

        // example:
        // JSONArray assignments = manager.manageViewAssignment();
        // logic to make the the data look nice i.e. into a table...

    }

    public void viewProfile(){
        StudentManager studentManager = new StudentManager(student);
        String profileDetails = studentManager.manageViewProfile();
        System.out.println(UI.TextColor.addColor((profileDetails), UI.TextColor.BLUE));
        // works the same

        // example:
        // JSONArray profile = manager.manageViewProfile();
        // logic to make the data look nice i.e. into a table...
    }

//    public String selectProgress() {
//        StudentManager studentManager = new StudentManager(student);
//        System.out.println(studentManager.printClassrooms(student.getProgress()));
//        String choice = Menu.prompt("Select a Progress: ");
//        return Integer.toString(Integer.parseInt(choice) - 1);
//    }

    public void viewClassroom(){
        StudentManager studentManager = new StudentManager(student);
        String classDetails = studentManager.manageViewClassroom();
        System.out.println(UI.TextColor.addColor((classDetails), UI.TextColor.BLUE));
    }

    public void doQuiz(){
        ClassroomController classroomController = new ClassroomController(indexOfClass);
        classroomController.goToDoQuiz();
    }


    // more methods/functionalities to be added

    // helper methods goes here




}