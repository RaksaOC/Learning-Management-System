package main.java.com.lms.controllers.teacherSide;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import main.SceneManager;

public class GradeAssignmentController {
    // TODO: make logic for clicking on the attachment item in the list (loop through the children of the VBOX)
    @FXML
    private ImageView backButton;
    @FXML
    private Text assignmentID;
    @FXML
    private Text assignmentName;
    @FXML
    private Text assignmentDueDate;
    @FXML
    private Text studentID;
    @FXML
    private Text studentName;
    @FXML
    private Text submitDate;
    @FXML
    private TextField scoreField;
    @FXML
    private TextArea feedbackTextArea;
    @FXML
    private Button finishButton;

    public void initialize() {
        backButton.setOnMouseClicked(event -> {
            SceneManager.setCenterView("assignmentView");
        });
    }
}