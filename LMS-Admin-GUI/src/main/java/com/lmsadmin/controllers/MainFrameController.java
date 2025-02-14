package main.java.com.lmsadmin.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main.SceneManager;

public class MainFrameController {

    // sideBar links
    @FXML
    private HBox homeLink;
    @FXML
    private HBox dashboardLink;
    @FXML
    private HBox manageStudentLink;
    @FXML
    private HBox manageTeacherLink;
    @FXML
    private HBox manageDepartmentLink;
    @FXML
    private HBox manageSpecializationLink;
    @FXML
    private HBox manageGenerationLink;
    @FXML
    private HBox manageGroupLink;
    @FXML
    private HBox manageCourseLink;
    @FXML
    private HBox manageClassroomLink;
    @FXML
    private HBox manageAdminLink;

    // home page big buttons
    @FXML
    private VBox homeButton;
    @FXML
    private VBox dashboardButton;
    @FXML
    private VBox manageStudentButton;
    @FXML
    private VBox manageTeacherButton;
    @FXML
    private VBox manageDepartmentButton;
    @FXML
    private VBox manageSpecializationButton;
    @FXML
    private VBox manageGenerationButton;
    @FXML
    private VBox manageGroupButton;
    @FXML
    private VBox manageCourseButton;
    @FXML
    private VBox manageClassroomButton;
    @FXML
    private VBox manageAdminButton;

    @FXML
    private void navigateToHome() {
        // [to check] why the color acting weird
//        homeLink.setStyle("-fx-background-color: #6A84AC");
        SceneManager.setScene("home");
        System.out.println("On page home");
    }
    @FXML
    private void navigateToDashboard() {
//        dashboardLink.setStyle("-fx-background-color: #6A84AC");
        SceneManager.setScene("dashboard");
        System.out.println("On page dashboard");
    }
    @FXML
    private void navigateToManageStudent() {
//        manageStudentLink.setStyle("-fx-background-color: #6A84AC");
        SceneManager.setScene("manageStudent");
        System.out.println("On page manageStudent");
    }
    @FXML
    private void navigateToManageTeacher() {
        SceneManager.setScene("manageTeacher");
        System.out.println("On page manageTeacher");
    }
    @FXML
    private void navigateToManageDepartment() {
        SceneManager.setScene("manageDepartment");
        System.out.println("On page manageDepartment");
    }
    @FXML
    private void navigateToManageSpecialization() {
        SceneManager.setScene("manageSpecialization");
        System.out.println("On page manageSpecialization");
    }
    @FXML
    private void navigateToManageGeneration() {
        SceneManager.setScene("manageGeneration");
        System.out.println("On page manageGeneration");
    }
    @FXML
    private void navigateToManageGroup() {
        SceneManager.setScene("manageGroup");
        System.out.println("On page manageGroup");
    }
    @FXML
    private void navigateToManageCourse() {
        SceneManager.setScene("manageCourse");
        System.out.println("On page manageCourse");
    }
    @FXML
    private void navigateToManageClassroom() {
        SceneManager.setScene("manageClassroom");
        System.out.println("On page manageClassroom");
    }
    @FXML
    private void navigateToManageAdmin() {
        SceneManager.setScene("manageAdmin");
        System.out.println("On page manageAdmin");
    }
}
