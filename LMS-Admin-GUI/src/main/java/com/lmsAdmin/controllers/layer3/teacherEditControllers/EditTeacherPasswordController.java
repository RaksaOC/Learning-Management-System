package main.java.com.lmsAdmin.controllers.layer3.teacherEditControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditTeacherManager;

public class EditTeacherPasswordController extends MainFrameController {
    EditTeacherManager idLoader = new EditTeacherManager();
    EditTeacherManager manager;

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
        idComboBox.getItems().addAll(idLoader.loadIdsAndNameJSON());
        idComboBox.setOnAction(event -> {
            manager = new EditTeacherManager(idComboBox.getValue());
            newTextField.setDisable(true);
            curTextField.textProperty().addListener((observable, oldValue, newValue) -> {
                if (manager.isOldPasswordMatched(newValue)) {
                    newTextField.setDisable(false);
                    editButton.setDisable(false);
                    curTextField.setStyle("-fx-border-color: green");
                }
                else{
                    editButton.setDisable(true);
                    curTextField.setStyle("-fx-border-color: red");
                }
            });
        });
    }

    @FXML
    private void handleEdit(MouseEvent event) {
        manager.manageEditPassword(newTextField.getText());
        loadSuccess("editTeacherPassword");
        clearFields();
    }

    private void clearFields() {
        idComboBox.getSelectionModel().clearSelection();
        curTextField.setText("");
        newTextField.setDisable(true);
    }
}