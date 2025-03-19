package main.java.com.lmsAdmin.controllers.layer3.studentEditControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditStudentManager;
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
        idComboBox.getItems().addAll(idLoader.loadIdsAndNameJSON());
        curFirstNameTextField.setDisable(true);
        curLastNameTextField.setDisable(true);
        newFirstNameTextField.setDisable(true);
        newLastNameTextField.setDisable(true);
        editButton.setDisable(true);
        manager = new EditStudentManager(idComboBox.getValue());
        idComboBox.setOnAction(event -> {
            curFirstNameTextField.setText(manager.getOldFirstNameSql());
            curLastNameTextField.setText(manager.getOldLastNameSql());

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
        manager.manageEditNameSql(newFirstNameTextField.getText(), newLastNameTextField.getText());
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