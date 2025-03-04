package main.java.com.lms.controllers.teacherSide;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.AppSession;
import main.SceneManager;

import java.util.Optional;

public class AssignmentViewController {
    @FXML
    private Text assignmentID; //-------------------|
    @FXML
    private Text assignmentName; //-----------------| --> TODO: fetch data and make these texts
    @FXML
    private Text assignmentDueDate; // -------------|
    @FXML
    private TextArea assignmentDescription; //  ----|
    @FXML
    private HBox referenceMaterial; // TODO: add method to be on click to go somewhere
    @FXML
    private ImageView backButton;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;
    @FXML
    private VBox studentsList; // TODO: from the manger generate HBOXes in this list
    @FXML
    private Button gradeButton; // TODO: add this button to a VBOX in studentsList and setCenterView to gradeAssignment and assign it to go to "gradeAssignment" centerView

    public void initialize() {
        backButton.setOnMouseClicked(event -> {
            SceneManager.setCenterView("teacherClassroomContents");
            AppSession.getInstance().setSelectedAssignment(null);
            AppSession.getInstance().setSelectedResources(null);
            AppSession.getInstance().setSelectedQuiz(null);
        });
        editButton.setOnMouseClicked(event -> {
            SceneManager.loadCenterView("editAssignment", "resources/com/lms/views/teacherSide/EditAssignment.fxml");
            SceneManager.setCenterView("editAssignment");
        });
        deleteButton.setOnMouseClicked(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Assignment");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to delete this assignment?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                AppSession.getInstance().setSelectedAssignment(null);
                SceneManager.setCenterView("teacherClassroomContents");
            }
        });
    }
}