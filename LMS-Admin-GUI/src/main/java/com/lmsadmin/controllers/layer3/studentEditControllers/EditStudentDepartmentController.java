package main.java.com.lmsadmin.controllers.layer3.studentEditControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import main.java.com.lmsadmin.controllers.layer0.MainFrameController;
import main.java.com.lmsadmin.managers.edit_entity_manager.EditDepartmentManager;
import main.java.com.lmsadmin.managers.edit_entity_manager.EditStudentManager;

public class EditStudentDepartmentController extends MainFrameController {
    EditStudentManager idLoader = new EditStudentManager();
    EditStudentManager manager;
    @FXML
    ComboBox<String> idComboBox;
    @FXML
    TextField curTextField;
    @FXML
    ComboBox <String> newComboBox;
    @FXML
    Button editButton;

    @FXML
    public void initialize() {
        idComboBox.getItems().addAll(idLoader.loadIds());
        curTextField.setDisable(true);
        newComboBox.setDisable(true);
        manager = new EditStudentManager(idComboBox.getValue());
        idComboBox.setOnAction(event -> {
            curTextField.setText(manager.getOldDepartment());
            EditDepartmentManager depManager = new EditDepartmentManager();
            newComboBox.getItems().addAll(depManager.loadIds());
            newComboBox.setDisable(false);
        });
    }

    @FXML
    public void handleEdit(){
        manager.manageEditDepartment(newComboBox.getSelectionModel().getSelectedItem());
        loadSuccess("editStudentDepartment");
        clearFields();
    }

    private void clearFields(){
        curTextField.setText("");
        newComboBox.getSelectionModel().clearSelection();
        idComboBox.getSelectionModel().clearSelection();
    }
}