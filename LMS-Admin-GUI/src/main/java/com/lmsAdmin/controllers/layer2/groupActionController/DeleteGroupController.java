package main.java.com.lmsAdmin.controllers.layer2.groupActionController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageGroupManager;

public class DeleteGroupController extends MainFrameController {
    @FXML
    private ComboBox<String> idComboBox;
    @FXML
    private Button deleteButton;

    private String selectedId;
    @FXML
    private void handleDelete(MouseEvent event) {
        selectedId = idComboBox.getSelectionModel().getSelectedItem().substring(0, idComboBox.getSelectionModel().getSelectedItem().indexOf(" "));
        if (isConfirmed()) {
            ManageGroupManager manageGroupManager = new ManageGroupManager();
            manageGroupManager.manageDeleteGroup(selectedId);

            loadSuccess("deleteGroup");
            clearDetails();
        } else {
            clearDetails();
        }
    }

    private void clearDetails() {
        idComboBox.getSelectionModel().clearSelection();
    }
}