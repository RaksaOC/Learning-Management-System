package main;

import entities.Student;
import entities.Teacher;
import entities.User;
import ui.UI;
import utils.controller.AuthenticationController;
import utils.controller.StudentController;
import utils.controller.TeacherController;
import utils.menu.Menu;

public class MainController {
    private User user;
    private Student student;
    private Teacher teacher;
    private String indexOfClass;

    public MainController() {
    }

    public void run() {
        while (true) {

            Menu menu = new Menu();
            String userType = menu.showUserTypeMenu();

            AuthenticationController authenticationController = new AuthenticationController();
            User authenticatedUser = authenticationController.authenticate(userType);
            this.user = authenticatedUser;

            if (user instanceof Student) {
                student = (Student) user;
                studentSide();
            } else {
                teacher = (Teacher) user;
                teacherSide();
            }
        }

    }

    public void studentSide() {
        System.out.println(UI.TextColor.addColor(UI.Banner.cadtLMS, UI.TextColor.YELLOW));
        Menu menu = new Menu();
        String choice = menu.showStudentSideMenu();
        while (true) {
            switch (choice) {
                case "1":
                    handleStudentViewClassroom();
                    break;
                case "2":
//                    handleStudentViewProfile();
                    break;
                case "3":
//                    handleStudentLogOut();
                    return;
                case "4":
//                    handleExit();
                    break;
                default:
                    break;
            }
            choice = menu.showStudentSideMenu();
        }
    }

    public void teacherSide() {
        System.out.println(UI.TextColor.addColor(UI.Banner.cadtLMS, UI.TextColor.YELLOW));
        Menu menu = new Menu();
        String choice = menu.showTeacherSideMenu();
        while (true) {
            switch (choice) {
                case "1":
                    handleTeacherViewClassroom();
                    break;
                case "2":
                    handleTeacherViewProfile();
                    break;
                case "3":
                    handleTeacherLogOut();
                    return;
                case "4":
                    handleExit();
                    break;
                default:
                    break;
            }
            choice = menu.showTeacherSideMenu();
        }
        // have some logic here to get the courses they teach to display
        // and then when clicked they can submit, view, edit.....

        // maybe changed later
    }

    private void handleStudentViewClassroom() {
        StudentController studentController = new StudentController(student);
        this.indexOfClass = studentController.selectClassroom();
        Menu menu = new Menu();
        String choice = menu.showStudentViewClassroom();
        while (true) {
            switch(choice) {
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "-b":
                    return;
                default:
                    break;
            }
            choice = menu.showStudentViewClassroom();
            }
        }

    private void handleStudentViewProfile() {
        StudentController studentController = new StudentController(student);
        studentController.viewProfile();
    }

    private void handleStudentLogOut() {
        AuthenticationController authenticationController = new AuthenticationController();
        authenticationController.logout("student");
    }


    private void handleTeacherViewClassroom() {
    }

    private void handleTeacherViewProfile() {
        TeacherController teacherController = new TeacherController(teacher);
        teacherController.viewProfile();
    }

    private void handleTeacherLogOut() {
        AuthenticationController authenticationController = new AuthenticationController();
        authenticationController.logout("teacher");
    }

    private void handleExit() {
        System.exit(0);
    }
}