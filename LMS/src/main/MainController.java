package main;

import entities.Student;
import utils.controller.AuthenticationController;

import java.util.Scanner;

public class MainController {
    public MainController() {
    }

    public void run() {
        System.out.println("Starting LMS Application");
        System.out.println("1. Student");
        System.out.println("2. Teacher");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        String userType = "";
        switch (choice) {
            case "1":
                userType = "Student";
                break;
            case "2":
                userType = "Teacher";
                break;
            default:
                break;
        }
        AuthenticationController authenticationController = new AuthenticationController();
        Object obj = authenticationController.authenticate(userType);
        if(obj instanceof Student) {
            studentSide();
        }
        else{
            teacherSide();
        }
    }

    public void studentSide(){

        // have some logic here to get the courses to display
        // and then when clicked they can submit, view, edit.....

        // maybe changed later
    }

    public void teacherSide(){
        // have some logic here to get the courses they teach to display
        // and then when clicked they can submit, view, edit.....

        // maybe changed later
    }
}