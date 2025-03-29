package main.java.com.lmsAdmin.controllers.layer2.specializationActionController;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import main.SceneManager;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageSpecializationManager;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditSpecializationManager;

public class DeleteSpecializationController extends MainFrameController {
    @FXML
    private ComboBox<String> idComboBox;
    @FXML
    private Button deleteButton;

    private String selectedLongId;

    public void initialize() {
        idComboBox.getItems().addAll(new EditSpecializationManager().loadIdsAndName());
    }


    @FXML
    private void handleDelete(MouseEvent event) {
        ManageSpecializationManager manageSpecializationManager = new ManageSpecializationManager();
        selectedLongId = idComboBox.getSelectionModel().getSelectedItem();
        if (manageSpecializationManager.isSpecializationDeletable(extractId(selectedLongId))) {

            if (isConfirmed()) {
                manageSpecializationManager.manageDeleteSpecialization(extractId(selectedLongId));

                loadSuccess("deleteSpecialization");
                SceneManager.refreshScenes();
                clearDetails();
            } else {
                clearDetails();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Cannot delete specialization");
            alert.showAndWait();
        }
    }

    private void clearDetails() {
        idComboBox.getSelectionModel().clearSelection();
    }
}