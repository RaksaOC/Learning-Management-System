package main.java.com.lmsAdmin.controllers.layer2.generationActionController;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
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
        ManageGenerationManager manageGenerationManager = new ManageGenerationManager();
        String n = this.name.getText();
        String ID = this.id.getText();
        JSONObject newEntity = new JSONObject();
        newEntity.put("name", n);
        newEntity.put("id", ID);
        manageGenerationManager.manageAddEntity(newEntity);
        System.out.println("Generation added successfully");

        SceneManager.setScene("success");
        PauseTransition delay = new PauseTransition(Duration.seconds(2));
        delay.setOnFinished(ev -> {
            SceneManager.setScene("addGeneration");
            resetAllFields();
        });

        delay.play();
    }
    private void resetAllFields() {
        name.clear();
        id.clear();
    }
}