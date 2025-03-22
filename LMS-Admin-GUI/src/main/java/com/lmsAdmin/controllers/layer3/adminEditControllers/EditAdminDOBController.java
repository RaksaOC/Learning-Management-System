package main.java.com.lmsAdmin.controllers.layer3.adminEditControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.SceneManager;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditAdminManager;

public class EditAdminDOBController extends MainFrameController {
    EditAdminManager idLoader = new EditAdminManager();
    EditAdminManager manager;

    @FXML
    private ComboBox<String> idComboBox;
    @FXML
    private TextField curDOBTextField;
    @FXML
    private DatePicker newDOBDatePicker;
    @FXML
    private Button editButton;

    @FXML
    private void initialize() {
        editButton.setDisable(true);
        idComboBox.getItems().addAll(idLoader.loadIdsAndName());
        idComboBox.setOnAction(event -> {
            manager = new EditAdminManager(extractId(idComboBox.getSelectionModel().getSelectedItem()));
            curDOBTextField.setText(manager.getOldDob());
            newDOBDatePicker.setDisable(false);
        });
    }
    @FXML
    private void handleEdit(MouseEvent event) {
        if (isConfirmed()) {
            manager.manageEditDOB(newDOBDatePicker.getValue().toString());
            loadSuccess("editAdminDOB");
            SceneManager.refreshScenes();
            clearFields();
        }
    }

    private void clearFields() {
        idComboBox.getSelectionModel().clearSelection();
        curDOBTextField.setText("");
        newDOBDatePicker.setDisable(true);
    }


}