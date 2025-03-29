package main.java.com.lmsAdmin.controllers.layer2.generationActionController;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import main.SceneManager;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageGenerationManager;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditGenerationManager;

public class DeleteGenerationController extends MainFrameController{
    @FXML
    private ComboBox<String> idComboBox;

    @FXML
    private Button deleteButton;

    private String selectedLongId;

    public void initialize() {
        idComboBox.getItems().addAll(new EditGenerationManager().loadIdsAndName());
    }

    @FXML
    private void handleDelete(MouseEvent event) {
            ManageGenerationManager manageGenerationManager = new ManageGenerationManager();
        selectedLongId = idComboBox.getSelectionModel().getSelectedItem();
        if (manageGenerationManager.isGenerationDeletable(extractId(selectedLongId))) {
            if(isConfirmed()){
                manageGenerationManager.manageDeleteGeneration(extractId(selectedLongId));

                loadSuccess("deleteGeneration");
                SceneManager.refreshScenes();
                clearDetails();
            }
            else{
                clearDetails();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("You are not allowed to delete this generation");
            alert.showAndWait();
        }

    }

    private void clearDetails(){
        idComboBox.getSelectionModel().clearSelection();
    }
}