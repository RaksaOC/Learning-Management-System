package main.java.com.lmsAdmin.controllers.layer2.generationActionController;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import main.SceneManager;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageGenerationManager;
import org.json.JSONObject;

public class AddGenerationController extends MainFrameController {
    @FXML
    private TextField name;
    @FXML
    private TextField id;
    @FXML
    private Button addButton;

    @FXML
    private void handleAdd(MouseEvent event) {
        ManageGenerationManager manager = new ManageGenerationManager();
        if (!manager.isGenerationIdTaken(id.getText())) {
            if (isConfirmed()) {
                manager.manageAddGeneration(
                        id.getText(),
                        name.getText(),
                        "active"
                );
                loadSuccess("addGeneration");
                SceneManager.refreshScenes();
                resetAllFields();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("This id already exists");
            alert.showAndWait();
        }
    }
    
    private void resetAllFields() {
        name.clear();
        id.clear();
    }
}