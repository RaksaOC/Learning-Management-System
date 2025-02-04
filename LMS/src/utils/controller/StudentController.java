package utils.controller;

import entities.Student;
import utils.manager.StudentManager;

import java.util.Scanner;

public class StudentController {
    Student student;
    public StudentController(Student s) {
//                              ^
//            takes in the student object from the authentication controller

        this.student = s;
    }

    public void submitAssignment(){
        // handles the actions of submitting an assignment
        // getting input like link to the finished work of the student

        Scanner sc = new Scanner(System.in);
        System.out.println("link ");

        // submitted
        assignment  = student.getAssingment();
        assingment.add(newAssignment);

        StudentManager studentManager = new StudentManager(student);
        studentManager.manageViewAssignment();

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
        // works the same

        // example:
        // JSONArray profile = manager.manageViewProfile();
        // logic to make the data look nice i.e. into a table...
    }

    // more methods/functionalities to be added




    // helper methods goes here




}