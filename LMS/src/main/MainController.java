package main;

import entities.Student;
import entities.Teacher;
import entities.User;
import ui.UI;
import utils.controller.AuthenticationController;
import utils.controller.ClassroomController;
import utils.controller.StudentController;
import utils.controller.TeacherController;
import utils.menu.Menu;

import static java.awt.SystemColor.menu;

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
                case "-b":
                    return;
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
                case "-b":
                    return;
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
        TeacherController teacherController = new TeacherController(teacher);
        this.indexOfClass = teacherController.selectClassroom();
        Menu menu = new Menu();
            String choice = menu.showViewClassroomMenu();
        while (true) {
            switch(choice) {
                case "1":
                    showManageAssignment();
                    break;
                case "2":
                    showManageResources();
                    break;
                case "3":
                    showManageQuizzes();
                    break;
                case "-b":
                    return;
                default:
                    break;
            }
            choice = menu.showViewClassroomMenu();
        }
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

    public void showManageAssignment(){
        TeacherController teacherController = new TeacherController(teacher, indexOfClass);
        Menu menu = new Menu();
        String choice = menu.showManageAssignmentMenu();
        while (true) {
            switch (choice) {
                case "1":
                    teacherController.handleAddAssignment();
                    break;
                case "2":
                    teacherController.handleEditAssignment();
                    break;
                case "3":
                    teacherController.handleDeleteAssignment();
                    break;
                case "4":
                    teacherController.handleGradeStudentAssignment();
                    break;
                case "5":
                    teacherController.handleCommentStudentAssignment();
                    break;
                case "6":
                    teacherController.handleViewStudentAssignment();
                    break;
                case "7":
                    teacherController.handleViewAllStudentAssignment();
                    break;
                case "-b":
                    return;
                default:
                    break;
            }
            choice = menu.showManageAssignmentMenu();
        }
    }

    public void showManageResources(){
        TeacherController teacherController = new TeacherController(teacher, indexOfClass);
        Menu menu = new Menu();
        String choice = menu.showManageResourcesMenu();
        while (true) {
            switch (choice){
                case "1":
                    teacherController.handleAddResources();
                    break;
                case "2":
                    teacherController.handleEditResources();
                    break;
                case "3":
                    teacherController.handleDeleteResources();
                    break;
                case "4":
                    teacherController.handleViewResources();
                    break;
                case "-b":
                    return;
                default:
                    break;
            }
            choice = menu.showManageResourcesMenu();
        }
    }

    public void showManageQuizzes(){
        TeacherController teacherController = new TeacherController(teacher, indexOfClass);
        Menu menu = new Menu();
        String choice = menu.showManageQuizzesMenu();
        while (true) {
            switch (choice){
                case "1":
                    teacherController.handleAddQuizzes();
                    break;
                case "2":
                    teacherController.handleEditQuizzes();
                    break;
                case "3":
                    teacherController.handleDeleteQuizzes();
                    break;
                case "4":
                    teacherController.handleViewQuizzes();
                    break;
                case "-b":
                    return;
                default:
                    break;
            }
            choice = menu.showManageQuizzesMenu();
        }
    }
}