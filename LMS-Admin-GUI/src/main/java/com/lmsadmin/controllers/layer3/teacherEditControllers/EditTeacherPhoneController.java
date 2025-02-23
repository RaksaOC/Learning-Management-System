package main.java.com.lmsadmin.controllers.layer3.teacherEditControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.java.com.lmsadmin.controllers.layer0.MainFrameController;
import main.java.com.lmsadmin.managers.edit_entity_manager.EditAdminManager;
import main.java.com.lmsadmin.managers.edit_entity_manager.EditTeacherManager;

public class EditTeacherPhoneController extends MainFrameController {
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
        idComboBox.getItems().addAll(idLoader.loadIds());
        idComboBox.setOnAction(event -> {
            manager = new EditTeacherManager(idComboBox.getValue());
            curTextField.setText(manager.getOldPhone());
            newTextField.setDisable(false);
        });
    }

    @FXML
    private void handleEdit(MouseEvent event) {
        manager.manageEditPhone(newTextField.getText());
        loadSuccess("editTeacherPhoneNumber");
        clearFields();
    }

    private void clearFields() {
        idComboBox.getSelectionModel().clearSelection();
        curTextField.setText("");
        newTextField.setDisable(true);
    }
}