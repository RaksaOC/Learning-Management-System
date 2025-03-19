package main.java.com.lmsAdmin.controllers.layer3.studentEditControllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditStudentManager;

public class EditStudentPasswordController extends MainFrameController {
    EditStudentManager idLoader = new EditStudentManager();
    EditStudentManager manager;

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
            manager = new EditStudentManager(idComboBox.getValue());
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
        manager.manageEditPasswordSql(newTextField.getText());
        loadSuccess("editStudentPassword");
        clearFields();
    }

    private void clearFields() {
        idComboBox.getSelectionModel().clearSelection();
        curTextField.setText("");
        newTextField.setDisable(true);
    }
}