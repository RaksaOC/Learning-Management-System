package main.java.com.lmsAdmin.controllers.layer3.studentEditControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditStudentManager;

public class EditStudentDOBController extends MainFrameController {
    EditStudentManager idLoader = new EditStudentManager();
    EditStudentManager manager;
    @FXML
    ComboBox<String> idComboBox;
    @FXML
    TextField curTextField;
    @FXML
    DatePicker newDatePicker;

    @FXML
    Button editButton;

    @FXML
    public void initialize() {
        idComboBox.getItems().addAll(idLoader.loadIdsAndNameJSON());
        curTextField.setDisable(true);
        newDatePicker.setDisable(true);
        manager = new EditStudentManager(idComboBox.getValue());
        idComboBox.setOnAction(event -> {
            curTextField.setText(manager.getOldDoBSql());
            newDatePicker.setDisable(false);
        });
    }

    @FXML
    public void handleEdit(){
        manager.manageEditDOB(newDatePicker.getValue().toString());
        manager.manageEditDoBSql(newDatePicker.getValue().toString());
        loadSuccess("editStudentDOB");
        clearFields();
    }

    private void clearFields(){
        curTextField.setText("");
        newDatePicker.setValue(null);
        idComboBox.getSelectionModel().clearSelection();
    }
}