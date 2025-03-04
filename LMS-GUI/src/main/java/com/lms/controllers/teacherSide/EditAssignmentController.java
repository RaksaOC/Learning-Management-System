package main.java.com.lms.controllers.teacherSide;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import main.SceneManager;

public class EditAssignmentController {
    @FXML
    private ImageView backButton;

    // TODO: assign data to text fields and handle actions
    @FXML
    private TextField curAssignmentName;
    @FXML
    private TextField curAssignmentDescription;
    @FXML
    private TextField newAssignmentName;
    @FXML
    private TextField newAssignmentDescription;
    @FXML
    private Button editButton;

    public void initialize() {
        backButton.setOnMouseClicked(event -> {
            SceneManager.setCenterView("assignmentView");
        });
    }
}