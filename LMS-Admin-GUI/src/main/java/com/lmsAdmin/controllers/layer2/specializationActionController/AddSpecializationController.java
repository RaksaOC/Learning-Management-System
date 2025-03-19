package main.java.com.lmsAdmin.controllers.layer2.specializationActionController;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
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
        departmentId.getItems().addAll(new EditDepartmentManager().loadIdsAndNameSql());
    }

    @FXML
    private void handleAdd(MouseEvent event) {
        handleAddSql();
       handleAddJSON();
    }

    private void handleAddJSON(){

        String n = name.getText();
        String ID = id.getText();
        JSONObject newSpec = new JSONObject();
        newSpec.put("id", ID);
        newSpec.put("name", n);
        ManageSpecializationManager manageSpecializationManager = new ManageSpecializationManager();
        manageSpecializationManager.manageAddEntity(depId, newSpec);

        SceneManager.setScene("success");
        PauseTransition delay = new PauseTransition(Duration.seconds(2));
        delay.setOnFinished(ev -> {
            SceneManager.setScene("addSpecialization");
            resetAllFields();
        });

        delay.play();
    }

    private void handleAddSql(){
        depId = departmentId.getSelectionModel().getSelectedItem().toString().substring(0, departmentId.getSelectionModel().getSelectedItem().toString().indexOf(" "));
        String n = name.getText();
        String ID = id.getText();

        ManageSpecializationManager manageSpecializationManager = new ManageSpecializationManager();
        manageSpecializationManager.manageAddEntitySql(ID, depId, n, "active");

        SceneManager.setScene("success");
        PauseTransition delay = new PauseTransition(Duration.seconds(2));
        delay.setOnFinished(ev -> {
            SceneManager.setScene("addSpecialization");
            resetAllFields();
        });

        delay.play();
    }

    private void resetAllFields() {
        departmentId.getSelectionModel().clearSelection();
        name.clear();
        id.clear();
    }
}