package main.java.com.lmsAdmin.controllers.layer2.specializationActionController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageSpecializationManager;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditSpecializationManager;

public class DeleteSpecializationController extends MainFrameController{
    @FXML
    private ComboBox<String> idComboBox;
    @FXML
    private Button deleteButton;

    private String selectedId;

    public void initialize() {
        idComboBox.getItems().addAll(new EditSpecializationManager().loadIdsAndNameSql());
    }


    @FXML
    private void handleDelete(MouseEvent event) {
        selectedId = idComboBox.getSelectionModel().getSelectedItem().toString().substring(0, idComboBox.getSelectionModel().getSelectedItem().toString().indexOf(" "));
        handleDeleteJSON();
        handleDeleteSql();
    }

    private void handleDeleteJSON(){
        if(isConfirmed()){
            ManageSpecializationManager manageSpecializationManager = new ManageSpecializationManager();
            manageSpecializationManager.manageDeleteEntity(selectedId);

            loadSuccess("deleteSpecialization");
            clearDetails();
        }
        else{
            clearDetails();
        }
    }

    private void handleDeleteSql(){
        if(isConfirmed()){
            ManageSpecializationManager manageSpecializationManager = new ManageSpecializationManager();
            manageSpecializationManager.manageDeleteEntitySql(selectedId);

            loadSuccess("deleteSpecialization");
            clearDetails();
        }
        else{
            clearDetails();
        }
    }

    private void clearDetails(){
        idComboBox.getSelectionModel().clearSelection();
    }
}