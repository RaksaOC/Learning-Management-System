package main.java.com.lmsAdmin.controllers.layer2.groupActionController;

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
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageGroupManager;
import org.json.JSONArray;
import org.json.JSONObject;

public class DeleteGroupController extends MainFrameController {
    @FXML
    private ComboBox<String> idComboBox;
    @FXML
    private Button deleteButton;

    private String selectedId;
    @FXML
    private void handleDelete(MouseEvent event) {
        selectedId = idComboBox.getSelectionModel().getSelectedItem().substring(0, idComboBox.getSelectionModel().getSelectedItem().indexOf(" "));
        handleDeleteSql();
        handleDeleteJSON();
    }

    private void handleDeleteJSON(){
        if (isConfirmed()) {
            ManageGroupManager manageGroupManager = new ManageGroupManager();
            manageGroupManager.manageDeleteEntity(selectedId);

            loadSuccess("deleteGroup");
            clearDetails();
        } else {
            clearDetails();
        }
    }

    private void handleDeleteSql(){
        if (isConfirmed()) {
            ManageGroupManager manageGroupManager = new ManageGroupManager();
            manageGroupManager.manageDeleteEntitySql(selectedId);

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