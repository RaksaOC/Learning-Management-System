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
        idComboBox.getItems().addAll(idLoader.loadIdsAndName());
        curFirstNameTextField.setDisable(true);
        curLastNameTextField.setDisable(true);
        newFirstNameTextField.setDisable(true);
        newLastNameTextField.setDisable(true);
        editButton.setDisable(true);

        idComboBox.setOnAction(event -> {
            curFirstNameTextField.setText(manager.getOldFirstName());
            curLastNameTextField.setText(manager.getOldLastName());

            newFirstNameTextField.setDisable(false);
            newLastNameTextField.setDisable(false);
        });
    }

    @FXML
    public void handleEdit(){
        manager = new EditStudentManager(idComboBox.getValue().substring(idComboBox.getValue().indexOf(" ")));
        manager.manageEditName(newFirstNameTextField.getText(), newLastNameTextField.getText());
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