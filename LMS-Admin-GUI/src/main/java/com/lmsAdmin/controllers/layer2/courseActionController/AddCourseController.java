package main.java.com.lmsAdmin.controllers.layer2.courseActionController;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import main.SceneManager;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageCourseManager;
import org.json.JSONObject;

public class AddCourseController extends MainFrameController {
    @FXML
    public Button addButton;
    @FXML
    private TextField name;
    @FXML
    private TextField id;
    @FXML
    private ComboBox<String> credit;
    @FXML
    private ComboBox<String> level;
    @FXML
    private TextField description;

    public void initialize() {
        credit.getItems().clear();
        credit.getItems().addAll("1", "2", "3", "4", "5");
        level.getItems().clear();
        level.getItems().addAll("Undergraduate", "Postgraduate", "Doctorate");
    }

    @FXML
    private void handleAdd(MouseEvent event) {
        ManageCourseManager manageCourseManager = new ManageCourseManager();

        if (!manageCourseManager.isCourseIdTaken(id.getText())) {
            if (isConfirmed()) {
                manageCourseManager.manageAddCourse(
                        id.getText(),
                        name.getText(),
                        credit.getSelectionModel().getSelectedItem().toString().trim(),
                        level.getSelectionModel().getSelectedItem().toString().trim(),
                        description.getText(),
                        "active"
                );
                loadSuccess("addCourse");
                resetAllFields();
                SceneManager.refreshScenes();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Course ID already exists");
            alert.showAndWait();
        }
    }

    private void resetAllFields() {
        name.clear();
        id.clear();
        credit.getSelectionModel().clearSelection();
        level.getSelectionModel().clearSelection();
        description.clear();
    }
}