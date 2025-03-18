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
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditDepartmentManager;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditGenerationManager;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditSpecializationManager;
import org.json.JSONObject;

public class AddGroupController extends MainFrameController {
    @FXML
    private ComboBox<String> generation;
    @FXML
    private ComboBox<String> specialization;
    @FXML
    private TextField groupId;
    @FXML
    private Button addButton;

    public void initialize() {
        generation.getItems().addAll(new EditGenerationManager().loadIdsAndNameSql());
        specialization.getItems().addAll(new EditSpecializationManager().loadIdsAndNameSql());
    }

    @FXML
    private void handleAdd(MouseEvent event) {
        handleAddSql();
        handleAddJSON();
    }
    @FXML
    private void handleAddJSON() {
        String groupId = this.groupId.getText();
        String gen = this.generation.getSelectionModel().getSelectedItem().toString();
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

    @FXML
    private void handleAddSql() {
        String groupId = this.groupId.getText();
        String gen = this.generation.getSelectionModel().getSelectedItem().toString();
        String spec = this.specialization.getSelectionModel().getSelectedItem().toString();
        ManageGroupManager manageGroupManager = new ManageGroupManager();
        manageGroupManager.manageAddEntitySql(groupId, gen, spec, "active");

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
        this.specialization.getSelectionModel().clearSelection();
    }
}