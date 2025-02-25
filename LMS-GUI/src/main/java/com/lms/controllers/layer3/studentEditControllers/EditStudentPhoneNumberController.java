package main.java.com.lms.controllers.layer3.studentEditControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import main.java.com.lms.controllers.layer0.MainFrameController;
import main.java.com.lms.managers.layer3.edit_entity_manager.EditStudentManager;

public class EditStudentPhoneNumberController extends MainFrameController {
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
        idComboBox.getItems().addAll(idLoader.loadIds());
        curTextField.setDisable(true);
        newTextField.setDisable(true);
        manager = new EditStudentManager(idComboBox.getValue());
        idComboBox.setOnAction(event -> {
            curTextField.setText(manager.getOldPhone());
            newTextField.setDisable(false);
        });
    }

    @FXML
    public void handleEdit(){
        manager.manageEditPhone(newTextField.getText());
        loadSuccess("editStudentPhoneNumber");
        clearFields();
    }

    private void clearFields(){
        curTextField.clear();
        newTextField.clear();
        idComboBox.getSelectionModel().clearSelection();
    }
}