package main.java.com.lms.controllers.layer3.adminEditControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.java.com.lms.controllers.layer0.MainFrameController;
import main.java.com.lms.managers.layer3.edit_entity_manager.EditAdminManager;

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
        idComboBox.getItems().addAll(idLoader.loadIds());
        idComboBox.setOnAction(event -> {
            manager = new EditAdminManager(idComboBox.getValue());
            curDOBTextField.setText(manager.getOldDOB());
            newDOBDatePicker.setDisable(false);
        });
    }
    @FXML
    private void handleEdit(MouseEvent event) {
        manager.manageEditDOB(newDOBDatePicker.getValue().toString());
        loadSuccess("editAdminDOB");
        clearFields();
    }

    private void clearFields() {
        idComboBox.getSelectionModel().clearSelection();
        curDOBTextField.setText("");
        newDOBDatePicker.setDisable(true);
    }


}