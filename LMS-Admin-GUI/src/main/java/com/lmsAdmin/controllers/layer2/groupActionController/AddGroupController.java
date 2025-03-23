package main.java.com.lmsAdmin.controllers.layer2.groupActionController;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import main.SceneManager;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageGroupManager;
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
        generation.getItems().addAll(new EditGenerationManager().loadIdsAndName());
        specialization.getItems().addAll(new EditSpecializationManager().loadIdsAndName());
        groupId.setText(generation.getItems().get(0) + "-" + specialization.getItems().get(0));
        generation.setOnMouseClicked(mouseEvent -> {
            if (generation.getSelectionModel().getSelectedItem() != null) {
                groupId.setText(generation.getSelectionModel().getSelectedItem() + "-" + specialization.getSelectionModel().getSelectedItem());
            }
        });
        specialization.setOnMouseClicked(mouseEvent -> {
            if (specialization.getSelectionModel().getSelectedItem() != null) {
                groupId.setText(generation.getSelectionModel().getSelectedItem() + "-" + specialization.getSelectionModel().getSelectedItem());
            }
        });
    }

    @FXML
    private void handleAdd(MouseEvent event) {
        ManageGroupManager manageGroupManager = new ManageGroupManager();
        String groupId = this.groupId.getText();
        String gen = this.generation.getSelectionModel().getSelectedItem().toString();
        String spec = this.specialization.getSelectionModel().getSelectedItem().toString();
        if (!manageGroupManager.isGroupIdTaken(groupId)) {
            if (isConfirmed()) {
                manageGroupManager.manageAddGroup(groupId, gen, spec, "active");

                loadSuccess("addGroup");
                SceneManager.refreshScenes();
                resetAllFields();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Group Id already exists");
            alert.showAndWait();
        }
    }

    private void resetAllFields() {
        this.groupId.clear();
        this.generation.getSelectionModel().clearSelection();
        this.specialization.getSelectionModel().clearSelection();
    }
}