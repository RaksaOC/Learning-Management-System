package main.java.com.lmsAdmin.controllers.layer3.studentEditControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import main.SceneManager;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditStudentManager;

public class EditStudentEmailController extends MainFrameController {
    EditStudentManager idLoader = new EditStudentManager();
    EditStudentManager manager;
    @FXML
    ComboBox<String> idComboBox;
    @FXML
    TextField curTextField;
    @FXML
    TextField newTextField;

    @FXML
    Button editButton;

    @FXML
    public void initialize() {
        idComboBox.getItems().addAll(idLoader.loadIdsAndName());
        curTextField.setDisable(true);
        newTextField.setDisable(true);
        manager = new EditStudentManager(extractId(idComboBox.getItems().getFirst()));
        idComboBox.setOnAction(event -> {
            curTextField.setText(manager.getOldEmail());
            newTextField.setDisable(false);
        });
    }

    @FXML
    public void handleEdit(){
        if (isConfirmed()) {
            manager.manageEditDoB(newTextField.getText());
            loadSuccess("editStudentEmail");
            SceneManager.refreshScenes();
            clearFields();
        }
    }

    private void clearFields(){
        curTextField.clear();
        newTextField.clear();
        idComboBox.getSelectionModel().clearSelection();
    }
}