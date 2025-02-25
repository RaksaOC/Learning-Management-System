package main.java.com.lms.controllers.layer2.departmentActionController;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import main.SceneManager;
import main.java.com.lms.controllers.layer0.MainFrameController;
import main.java.com.lms.managers.layer2.manage_entity_manager.ManageDepartmentManager;
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
        ManageDepartmentManager manageDepartmentManager = new ManageDepartmentManager();
        String n = this.name.getText();
        String ID = this.id.getText();
        JSONObject newDepartment = new JSONObject();
        newDepartment.put("name", n);
        newDepartment.put("id", ID);
        manageDepartmentManager.manageAddEntity(newDepartment);

        SceneManager.setScene("success");
        PauseTransition delay = new PauseTransition(Duration.seconds(2));
        delay.setOnFinished(ev -> {
            SceneManager.setScene("addDepartment");
            resetAllFields();
        });

        delay.play();
    }

    private void resetAllFields() {
        name.clear();
        id.clear();
    }
}