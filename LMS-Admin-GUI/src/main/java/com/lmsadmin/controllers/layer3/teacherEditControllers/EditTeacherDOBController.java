package main.java.com.lmsadmin.controllers.layer3.teacherEditControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.java.com.lmsadmin.controllers.layer0.MainFrameController;
import main.java.com.lmsadmin.managers.edit_entity_manager.EditAdminManager;
import main.java.com.lmsadmin.managers.edit_entity_manager.EditTeacherManager;

public class EditTeacherDOBController extends MainFrameController {
    EditTeacherManager idLoader = new EditTeacherManager();
    EditTeacherManager manager;

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
            manager = new EditTeacherManager(idComboBox.getValue());
            curDOBTextField.setText(manager.getOldDOB());
            newDOBDatePicker.setDisable(false);
        });
    }
    @FXML
    private void handleEdit(MouseEvent event) {
        manager.manageEditDOB(newDOBDatePicker.getValue().toString());
        loadSuccess("editTeacherDOB");
        clearFields();
    }

    private void clearFields() {
        idComboBox.getSelectionModel().clearSelection();
        curDOBTextField.setText("");
        newDOBDatePicker.setDisable(true);
    }


}