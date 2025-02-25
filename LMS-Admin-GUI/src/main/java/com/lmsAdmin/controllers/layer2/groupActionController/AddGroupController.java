package main.java.com.lmsAdmin.controllers.layer2.groupActionController;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import main.SceneManager;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageGroupManager;
import org.json.JSONObject;

public class AddGroupController extends MainFrameController {
    @FXML
    private ComboBox generation;
    @FXML
    private ComboBox department;
    @FXML
    private ComboBox specialization;
    @FXML
    private TextField groupId;
    @FXML
    private Button addButton;

    @FXML
    private void handleAdd(MouseEvent event) {
        String groupId = this.groupId.getText();
        String gen = this.generation.getSelectionModel().getSelectedItem().toString();
        String dep = this.department.getSelectionModel().getSelectedItem().toString(); // not used for manager rn maybe has other use
        String spec = this.specialization.getSelectionModel().getSelectedItem().toString();

        JSONObject newGroup = new JSONObject();
        newGroup.put("id", groupId);
        ManageGroupManager manageGroupManager = new ManageGroupManager();
        manageGroupManager.manageAddEntity(spec, gen, newGroup);
        System.out.println("Group added successfully");

        SceneManager.setScene("success");
        PauseTransition delay = new PauseTransition(Duration.seconds(2));
        delay.setOnFinished(ev -> {
            SceneManager.setScene("addGroup");
            resetAllFields();
        });

        delay.play();
    }

    private void resetAllFields() {
        this.groupId.clear();
        this.generation.getSelectionModel().clearSelection();
        this.department.getSelectionModel().clearSelection();
        this.specialization.getSelectionModel().clearSelection();
    }
}