package main.java.com.lmsadmin.controllers.layer0;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
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

//    @FXML
//    protected void resetSceneTextFields(String sceneName) {
//        Scene scene = SceneManager.scenes.get(sceneName);
//        if (scene != null) {
//            BorderPane rootPane = (BorderPane) scene.getRoot();
//            Node centerNode = rootPane.getCenter(); // Get the center part
//
//            if (centerNode instanceof Pane) {
//                clearFields((Pane) centerNode);
//            }
//        }
//    }
//
//    private void clearFields(Pane parent) {
//        for (Node node : parent.getChildren()) {
//            if (node instanceof TextField) {
//                ((TextField) node).clear();
//            } else if (node instanceof TextArea) {
//                ((TextArea) node).clear();
//            } else if (node instanceof ComboBox) {
//                ((ComboBox<?>) node).setValue(null);
//            } else if (node instanceof DatePicker) {
//                ((DatePicker) node).setValue(null);
//            } else if (node instanceof Pane) {
//                clearFields((Pane) node); // Recursively clear fields in nested containers
//            }
//        }
//    }

//    @FXML
//    private void test() {
//
//        VBox vbox = (VBox) root.lookup("BorderPane > top > AnchorPane > AnchorPane > VBox");
//        if (vbox != null) {
//            if (vbox.getChildren().size() > 1) {  // Ensure there's a second child
//                Node node = vbox.getChildren().get(1);  // Get the second child
//                if (node instanceof Text textNode) {  // Ensure it's a Text element
//                    textNode.setText(newDate);  // Change the date
//                    System.out.println("Updated Date: " + newDate);
//                }
//            } else {
//                System.out.println("VBox does not have a second Text node!");
//            }
//        } else {
//            System.out.println("VBox not found!");
//        }
//    }
}
