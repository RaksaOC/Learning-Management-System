package main.java.com.lms.controllers.layer3.studentEditControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import main.java.com.lms.controllers.layer0.MainFrameController;
import main.java.com.lms.managers.layer3.edit_entity_manager.EditSpecializationManager;
import main.java.com.lms.managers.layer3.edit_entity_manager.EditStudentManager;

public class EditStudentSpecializationController extends MainFrameController {
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
            EditSpecializationManager speManager = new EditSpecializationManager();
            newComboBox.getItems().addAll(speManager.loadIds());
            newComboBox.setDisable(false);
        });
    }

    @FXML
    public void handleEdit(){
        manager.manageEditSpecialization(newComboBox.getSelectionModel().getSelectedItem());
        loadSuccess("editStudentSpecialization");
        clearFields();
    }

    private void clearFields(){
        curTextField.setText("");
        newComboBox.getSelectionModel().clearSelection();
        idComboBox.getSelectionModel().clearSelection();
    }
}