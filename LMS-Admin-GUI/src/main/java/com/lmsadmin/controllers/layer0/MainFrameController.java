package main.java.com.lmsadmin.controllers.layer0;

import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import main.SceneManager;

import java.util.Optional;

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
    }
    @FXML
    private void navigateToDashboard() {
//        dashboardLink.setStyle("-fx-background-color: #6A84AC");
        SceneManager.setScene("dashboard");
    }
    @FXML
    private void navigateToManageStudent() {
//        manageStudentLink.setStyle("-fx-background-color: #6A84AC");
        SceneManager.setScene("manageStudent");
    }
    @FXML
    private void navigateToManageTeacher() {
        SceneManager.setScene("manageTeacher");
    }
    @FXML
    private void navigateToManageDepartment() {
        SceneManager.setScene("manageDepartment");
    }
    @FXML
    private void navigateToManageSpecialization() {
        SceneManager.setScene("manageSpecialization");
    }
    @FXML
    private void navigateToManageGeneration() {
        SceneManager.setScene("manageGeneration");
    }
    @FXML
    private void navigateToManageGroup() {
        SceneManager.setScene("manageGroup");
    }
    @FXML
    private void navigateToManageCourse() {
        SceneManager.setScene("manageCourse");
    }
    @FXML
    private void navigateToManageClassroom() {
        SceneManager.setScene("manageClassroom");
    }
    @FXML
    private void navigateToManageAdmin() {
        SceneManager.setScene("manageAdmin");
    }

    @FXML
    protected boolean isConfirmed(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to make these changes?");
        Optional<ButtonType> result = alert.showAndWait();
        return result.get() == ButtonType.OK;
    }

    @FXML
    protected void loadSuccess(String sceneToReturnTo){
        SceneManager.setScene("success"); // Show success screen
        PauseTransition delay = new PauseTransition(Duration.seconds(2)); // 2-second delay
        delay.setOnFinished(ev -> {
            SceneManager.setScene(sceneToReturnTo); // Return to addAdmin scene
        });

        delay.play(); // Start the delay
    }
}
