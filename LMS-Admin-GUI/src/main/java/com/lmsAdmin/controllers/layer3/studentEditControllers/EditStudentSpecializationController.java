package main.java.com.lmsAdmin.controllers.layer3.studentEditControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditSpecializationManager;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditStudentManager;

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
        idComboBox.getItems().addAll(idLoader.loadIdsAndNameJSON());
        curTextField.setDisable(true);
        newComboBox.setDisable(true);
        manager = new EditStudentManager(idComboBox.getValue());
        idComboBox.setOnAction(event -> {
            curTextField.setText(manager.getOldSpecializationSql());
            EditSpecializationManager speManager = new EditSpecializationManager();
            newComboBox.getItems().addAll(speManager.loadIdsAndNameJSON());
            newComboBox.setDisable(false);
        });
    }

    @FXML
    public void handleEdit(){
        manager.manageEditSpecialization(newComboBox.getSelectionModel().getSelectedItem());
        manager.manageEditSpecializationSql(newComboBox.getSelectionModel().getSelectedItem());
        loadSuccess("editStudentSpecialization");
        clearFields();
    }

    private void clearFields(){
        curTextField.setText("");
        newComboBox.getSelectionModel().clearSelection();
        idComboBox.getSelectionModel().clearSelection();
    }
}