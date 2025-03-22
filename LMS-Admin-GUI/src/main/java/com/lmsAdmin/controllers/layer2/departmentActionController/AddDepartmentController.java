package main.java.com.lmsAdmin.controllers.layer2.departmentActionController;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import main.SceneManager;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageDepartmentManager;
import org.json.JSONObject;

public class AddDepartmentController extends MainFrameController {

    @FXML
    private TextField name;
    @FXML
    private TextField id;
    @FXML
    private Button addButton;

    @FXML
    private void handleAdd(MouseEvent event) {
        String n = this.name.getText();
        String ID = this.id.getText();
        ManageDepartmentManager manageDepartmentManager = new ManageDepartmentManager();

        if (!manageDepartmentManager.isDepartmentIdTaken(id.getText())) {
            if (isConfirmed()) {
                manageDepartmentManager.manageAddDepartment(n, id.getText());
                loadSuccess("addDepartment");
                SceneManager.refreshScenes();
                resetAllFields();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Department ID already exists");
        }
    }

    private void resetAllFields() {
        name.clear();
        id.clear();
    }
}