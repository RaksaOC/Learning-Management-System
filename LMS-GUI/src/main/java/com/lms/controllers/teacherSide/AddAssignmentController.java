package main.java.com.lms.controllers.teacherSide;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import main.AppSession;
import main.SceneManager;
import main.java.com.lms.managers.teacherSide.ClassroomContentManager;

public class AddAssignmentController {
    @FXML
    private ImageView backButton;

    @FXML
    private TextField assignmentTitle;
    @FXML
    private TextArea assignmentDescription;
    @FXML
    private DatePicker assignmentDueDate;
    @FXML
    private TextField assignmentDueTime;

    @FXML
    private VBox referenceMaterialVBox;
    @FXML
    private Button addReferenceMaterial;
    @FXML
    private Button finishButton;

    public void initialize() {
        backButton.setOnMouseClicked(event -> {
            SceneManager.setCenterView("teacherClassroomContents");
        });
        finishButton.setOnMouseClicked(event -> {
            if (!(assignmentTitle.getText().isEmpty() && assignmentDescription.getText().isEmpty() && assignmentDueDate.getValue() == null && assignmentDueTime.getText().isEmpty())) {
                ClassroomContentManager classroomContentManager = new ClassroomContentManager(AppSession.getInstance().getSelectedClassroom());
                String title = assignmentTitle.getText();
                String description = assignmentDescription.getText();
                String dueDate = assignmentDueDate.getValue().toString();
                String dueTime = assignmentDueTime.getText();
                // TODO: add reference material

                classroomContentManager.manageAddAssignment(title, description, dueDate, dueTime);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all the fields");
                alert.showAndWait();
            }
        });
        addReferenceMaterial.setOnMouseClicked(event -> {
            // TODO: add logic to fill in the reference material VBOX
        });
    }
}