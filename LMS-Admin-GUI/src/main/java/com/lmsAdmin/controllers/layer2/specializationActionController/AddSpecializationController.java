package main.java.com.lmsAdmin.controllers.layer2.specializationActionController;

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
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageSpecializationManager;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditDepartmentManager;
import org.json.JSONObject;

public class AddSpecializationController extends MainFrameController {
    @FXML
    private ComboBox<String> departmentId;
    @FXML
    private TextField name;
    @FXML
    private TextField id;
    @FXML
    private Button addButton;

    private String depId;

    public void initialize() {
        departmentId.getItems().clear();
        departmentId.getItems().addAll(new EditDepartmentManager().loadIdsAndName());
        id.setText(extractId(departmentId.getItems().getFirst()) + "-");
        departmentId.setOnMouseClicked(e -> {
            if (departmentId.getSelectionModel().getSelectedItem() != null) {
                id.setText(extractId(departmentId.getSelectionModel().getSelectedItem()) + "-");
            }
        });
    }

    @FXML
    private void handleAdd(MouseEvent event) {
        ManageSpecializationManager manageSpecializationManager = new ManageSpecializationManager();
        depId = extractId(departmentId.getSelectionModel().getSelectedItem());
        String n = name.getText();
        String ID = id.getText();

        if (!manageSpecializationManager.isSpecializationIdTaken(id.getText())) {
            if (isConfirmed()) {
                manageSpecializationManager.manageAddSpecialization(ID, depId, n, "active");

                loadSuccess("addSpecialization");
                SceneManager.refreshScenes();
                resetAllFields();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Specialization id is not valid");
            alert.showAndWait();
        }
    }

    private void resetAllFields() {
        departmentId.getSelectionModel().clearSelection();
        name.clear();
        id.clear();
    }
}