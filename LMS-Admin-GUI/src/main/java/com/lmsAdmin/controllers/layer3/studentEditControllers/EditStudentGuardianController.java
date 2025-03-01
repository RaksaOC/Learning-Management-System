package main.java.com.lmsAdmin.controllers.layer3.studentEditControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditStudentManager;
import org.json.JSONObject;

public class EditStudentGuardianController extends MainFrameController {
    EditStudentManager idLoader = new EditStudentManager();
    EditStudentManager manager;

    @FXML
    private ComboBox<String> idComboBox;
    @FXML
    private TextField curGFirstNameTextField;
    @FXML
    private TextField curGLastNameTextField;
    @FXML
    private TextField curGGenderTextField;
    @FXML
    private TextField curGPhoneTextField;
    @FXML
    private TextField newGFirstNameTextField;
    @FXML
    private TextField newGLastNameTextField;
    @FXML
    private ComboBox<String> newGGenderComboBox;
    @FXML
    private TextField newGPhoneTextField;
    @FXML
    private Button editButton;

    @FXML
    private void initialize() {

        editButton.setDisable(true);
        newGFirstNameTextField.setDisable(true);
        newGLastNameTextField.setDisable(true);
        newGGenderComboBox.setDisable(true);
        newGPhoneTextField.setDisable(true);

        idComboBox.getItems().addAll(idLoader.loadIds());

        idComboBox.setOnAction(event -> {
            manager = new EditStudentManager(idComboBox.getValue());
            curGFirstNameTextField.setText(manager.getOldGuardianFirstName());
            curGLastNameTextField.setText(manager.getOldGuardianLastName());
            curGGenderTextField.setText(manager.getOldGuardianGender());
            curGPhoneTextField.setText(manager.getOldGuardianPhone());

            // Enable province selection and populate it
            newGFirstNameTextField.setDisable(false);
            newGLastNameTextField.setDisable(false);
            newGGenderComboBox.setDisable(false);
            newGPhoneTextField.setDisable(false);
        });
    }

    @FXML
    private void handleEdit(MouseEvent event) {
        JSONObject newGuardian = new JSONObject();
        newGuardian.put("gender", newGGenderComboBox.getValue());
        newGuardian.put("phone", newGPhoneTextField.getText());
        JSONObject name = new JSONObject();
        name.put("firstName", curGFirstNameTextField.getText());
        name.put("lastName", curGLastNameTextField.getText());
        newGuardian.put("name", name);
        manager.manageEditGuardian(newGuardian);
        loadSuccess("editStudentGuardian");
        clearFields();
    }

    private void clearFields() {
        idComboBox.getSelectionModel().clearSelection();
        curGFirstNameTextField.clear();
        curGLastNameTextField.clear();
        curGGenderTextField.clear();
        curGPhoneTextField.clear();
        newGFirstNameTextField.clear();
        newGLastNameTextField.clear();
        newGGenderComboBox.getSelectionModel().clearSelection();
        newGPhoneTextField.clear();
    }
}