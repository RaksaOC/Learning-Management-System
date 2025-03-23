package main.java.com.lmsAdmin.controllers.layer2.classroomActionController;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageClassroomManager;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditClassroomManager;
import org.json.JSONArray;
import org.json.JSONObject;

public class DeleteClassroomController extends MainFrameController {
    @FXML
    private ComboBox<String> idComboBox;
    @FXML
    private Button deleteButton;

    public void initialize() {
        idComboBox.getItems().addAll(new EditClassroomManager().loadIds());
    }

    @FXML
    private void handleDelete(MouseEvent event) {
        ManageClassroomManager manageClassroomManager = new ManageClassroomManager();
        if (manageClassroomManager.isClassroomDeletable(idComboBox.getValue())) {
            if (isConfirmed()) {
                manageClassroomManager.manageDeleteClassroom(idComboBox.getValue());
                loadSuccess("deleteClassroom");
                clearDetails();
            } else {
                clearDetails();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("You are not allowed to delete this classroom");
            alert.showAndWait();
        }
    }

    private void clearDetails() {
        idComboBox.getSelectionModel().clearSelection();
    }
}