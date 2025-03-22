package main.java.com.lmsAdmin.controllers.layer3.courseEditControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.SceneManager;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditCourseManager;

public class EditCourseIDController extends MainFrameController {
    EditCourseManager idLoader = new EditCourseManager();
    EditCourseManager manager;

    @FXML
    private ComboBox<String> idComboBox;
    @FXML
    private TextField curTextField;
    @FXML
    private TextField newTextField;
    @FXML
    private Button editButton;

    @FXML
    private void initialize() {
        editButton.setDisable(true);
        idComboBox.getItems().addAll(idLoader.loadIdsAndName());
        idComboBox.setOnAction(event -> {
            manager = new EditCourseManager(extractId(idComboBox.getSelectionModel().getSelectedItem()));
            curTextField.setText(manager.getOldId());
            newTextField.setDisable(false);
        });
    }

    @FXML
    private void handleEdit(MouseEvent event) {
        if (isConfirmed()) {
            manager.manageEditId(newTextField.getText());
            loadSuccess("editCourseID");
            SceneManager.refreshScenes();
            clearFields();
        }
    }

    private void clearFields() {
        idComboBox.getSelectionModel().clearSelection();
        curTextField.setText("");
        newTextField.setDisable(true);
    }
}