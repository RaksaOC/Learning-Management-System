package main.java.com.lmsAdmin.controllers.layer2.generationActionController;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageGenerationManager;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditGenerationManager;
import org.json.JSONArray;

public class DeleteGenerationController extends MainFrameController{
    @FXML
    private ComboBox<String> idComboBox;

    @FXML
    private Button deleteButton;

    private String selectedId;

    public void initialize() {
        idComboBox.getItems().addAll(new EditGenerationManager().loadIdsAndNameSql());
    }

    @FXML
    private void handleDelete(MouseEvent event) {
        handleDeleteSql();
        handleDeleteJSON();
    }

    private void handleDeleteSql(){
        selectedId = idComboBox.getSelectionModel().getSelectedItem().toString().substring(0, idComboBox.getSelectionModel().getSelectedItem().toString().indexOf(" "));
        if(isConfirmed()){
            ManageGenerationManager manageGenerationManager = new ManageGenerationManager();
            manageGenerationManager.manageDeleteEntitySql(selectedId);

            loadSuccess("deleteGeneration");
            clearDetails();
        }
        else{
            clearDetails();
        }
    }

    private void handleDeleteJSON(){
        if(isConfirmed()){
            ManageGenerationManager manageGenerationManager = new ManageGenerationManager();
            manageGenerationManager.manageDeleteEntity(selectedId);

            loadSuccess("deleteGeneration");
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