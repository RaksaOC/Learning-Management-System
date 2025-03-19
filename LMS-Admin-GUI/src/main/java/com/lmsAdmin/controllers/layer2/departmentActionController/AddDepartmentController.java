package main.java.com.lmsAdmin.controllers.layer2.departmentActionController;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
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
        // keep both for now
        handleAddJSON();
        handleAddSql();
        playSuccessScene();
    }

    private void handleAddSql(){
        String n = this.name.getText();
        String ID = this.id.getText();
        ManageDepartmentManager manageDepartmentManager = new ManageDepartmentManager();
        manageDepartmentManager.manageAddEntitySql(n, id.getText());
    }

    private void handleAddJSON(){
        ManageDepartmentManager manageDepartmentManager = new ManageDepartmentManager();
        String n = this.name.getText();
        String ID = this.id.getText();
        JSONObject newDepartment = new JSONObject();
        newDepartment.put("name", n);
        newDepartment.put("id", ID);
        manageDepartmentManager.manageAddEntity(newDepartment);
    }

    private void resetAllFields() {
        name.clear();
        id.clear();
    }

    private void playSuccessScene(){
        SceneManager.setScene("success");
        PauseTransition delay = new PauseTransition(Duration.seconds(2));
        delay.setOnFinished(ev -> {
            SceneManager.setScene("addDepartment");
            resetAllFields();
        });

        delay.play();
    }
}