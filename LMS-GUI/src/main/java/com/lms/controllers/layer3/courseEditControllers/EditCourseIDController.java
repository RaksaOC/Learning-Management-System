package main.java.com.lms.controllers.layer3.courseEditControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.java.com.lms.controllers.layer0.MainFrameController;
import main.java.com.lms.managers.layer3.edit_entity_manager.EditCourseManager;

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
        idComboBox.getItems().addAll(idLoader.loadIds());
        idComboBox.setOnAction(event -> {
            manager = new EditCourseManager(idComboBox.getValue());
            curTextField.setText(manager.getOldID());
            newTextField.setDisable(false);
        });
    }

    @FXML
    private void handleEdit(MouseEvent event) {
        manager.manageEditId(newTextField.getText());
        loadSuccess("editCourseID");
        clearFields();
    }

    private void clearFields() {
        idComboBox.getSelectionModel().clearSelection();
        curTextField.setText("");
        newTextField.setDisable(true);
    }
}