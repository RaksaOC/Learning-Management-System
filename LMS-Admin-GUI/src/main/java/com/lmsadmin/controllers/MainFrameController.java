package main.java.com.lmsadmin.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main.SceneController;

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
        SceneController.setScene("home");
        System.out.println("On page home");
    }
    @FXML
    private void navigateToDashboard() {
//        dashboardLink.setStyle("-fx-background-color: #6A84AC");
        SceneController.setScene("dashboard");
        System.out.println("On page dashboard");
    }
    @FXML
    private void navigateToManageStudent() {
//        manageStudentLink.setStyle("-fx-background-color: #6A84AC");
        SceneController.setScene("manageStudent");
        System.out.println("On page manageStudent");
    }
    @FXML
    private void navigateToManageTeacher() {
        SceneController.setScene("manageTeacher");
        System.out.println("On page manageTeacher");
    }
    @FXML
    private void navigateToManageDepartment() {
        SceneController.setScene("manageDepartment");
        System.out.println("On page manageDepartment");
    }
    @FXML
    private void navigateToManageSpecialization() {
        SceneController.setScene("manageSpecialization");
        System.out.println("On page manageSpecialization");
    }
    @FXML
    private void navigateToManageGeneration() {
        SceneController.setScene("manageGeneration");
        System.out.println("On page manageGeneration");
    }
    @FXML
    private void navigateToManageGroup() {
        SceneController.setScene("manageGroup");
        System.out.println("On page manageGroup");
    }
    @FXML
    private void navigateToManageCourse() {
        SceneController.setScene("manageCourse");
        System.out.println("On page manageCourse");
    }
    @FXML
    private void navigateToManageClassroom() {
        SceneController.setScene("manageClassroom");
        System.out.println("On page manageClassroom");
    }
    @FXML
    private void navigateToManageAdmin() {
        SceneController.setScene("manageAdmin");
        System.out.println("On page manageAdmin");
    }
}
