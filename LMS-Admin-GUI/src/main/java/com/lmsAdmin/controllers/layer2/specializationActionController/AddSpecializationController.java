package main.java.com.lmsAdmin.controllers.layer2.specializationActionController;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import main.SceneManager;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageSpecializationManager;
import org.json.JSONObject;

public class AddSpecializationController extends MainFrameController {
    @FXML
    private ComboBox departmentId;
    @FXML
    private TextField name;
    @FXML
    private TextField id;
    @FXML
    private Button addButton;

    @FXML
    private void handleAdd(MouseEvent event) {
        String depId = departmentId.getSelectionModel().getSelectedItem().toString();
        String n = name.getText();
        String ID = id.getText();
        JSONObject newSpec = new JSONObject();
        newSpec.put("id", depId);
        newSpec.put("name", n);
        ManageSpecializationManager manageSpecializationManager = new ManageSpecializationManager();
        manageSpecializationManager.manageAddEntity(depId, newSpec);

        System.out.println("content added");
        System.out.println(n);
        System.out.println(ID);
        System.out.println(newSpec);

        System.out.println("content added successfully");

        SceneManager.setScene("success");
        PauseTransition delay = new PauseTransition(Duration.seconds(2));
        delay.setOnFinished(ev -> {
            SceneManager.setScene("addSpecialization");
            resetAllFields();
        });

        delay.play();
    }

    private void resetAllFields() {
        departmentId.getSelectionModel().clearSelection();
        name.clear();
        id.clear();
    }
}