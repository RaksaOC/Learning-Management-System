package main.java.com.lmsAdmin.controllers.layer2.groupActionController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import main.SceneManager;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageGroupManager;

public class DeleteGroupController extends MainFrameController {
    @FXML
    private ComboBox<String> idComboBox;
    @FXML
    private Button deleteButton;

    private String selectedLongId;
    @FXML
    private void handleDelete(MouseEvent event) {
            ManageGroupManager manageGroupManager = new ManageGroupManager();
        selectedLongId = idComboBox.getSelectionModel().getSelectedItem();
        if(manageGroupManager.isGroupDeletable(selectedLongId)){}
        if (isConfirmed()) {
            manageGroupManager.manageDeleteGroup(selectedLongId);

            loadSuccess("deleteGroup");
            SceneManager.refreshScenes();
            clearDetails();
        } else {
            clearDetails();
        }
    }

    private void clearDetails() {
        idComboBox.getSelectionModel().clearSelection();
    }
}