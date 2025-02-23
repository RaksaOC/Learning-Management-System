package main.java.com.lmsadmin.controllers.layer3.studentEditControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import main.java.com.lmsadmin.controllers.layer0.MainFrameController;
import main.java.com.lmsadmin.managers.edit_entity_manager.EditStudentManager;
import org.json.JSONObject;

public class EditStudentNameController extends MainFrameController {
    EditStudentManager idLoader = new EditStudentManager();
    EditStudentManager manager;
    @FXML
    ComboBox<String> idComboBox;
    @FXML
    TextField curFirstNameTextField;
    @FXML
    TextField curLastNameTextField;
    @FXML
    TextField newFirstNameTextField;
    @FXML
    TextField newLastNameTextField;

    @FXML
    Button editButton;

    @FXML
    public void initialize() {
        idComboBox.getItems().addAll(idLoader.loadIds());
        curFirstNameTextField.setDisable(true);
        curLastNameTextField.setDisable(true);
        newFirstNameTextField.setDisable(true);
        newLastNameTextField.setDisable(true);
        editButton.setDisable(true);
        manager = new EditStudentManager(idComboBox.getValue());
        idComboBox.setOnAction(event -> {
            curFirstNameTextField.setText(manager.getOldFirstName());
            curLastNameTextField.setText(manager.getOldLastName());

            newFirstNameTextField.setDisable(false);
            newLastNameTextField.setDisable(false);
        });
    }

    @FXML
    public void handleEdit(){
        JSONObject newName = new JSONObject();
        newName.put("firstName", newFirstNameTextField.getText());
        newName.put("lastName", newLastNameTextField.getText());
        manager.manageEditName(newName);
        loadSuccess("editStudentName");
        clearFields();
    }

    private void clearFields(){
        curFirstNameTextField.clear();
        curLastNameTextField.clear();
        newFirstNameTextField.clear();
        newLastNameTextField.clear();
        idComboBox.getSelectionModel().clearSelection();
    }
}