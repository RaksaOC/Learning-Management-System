package main.java.com.lmsAdmin.controllers.layer3.departmentEditControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditDepartmentManager;

public class EditDepartmentIDController extends MainFrameController {
    EditDepartmentManager idLoader = new EditDepartmentManager();
    EditDepartmentManager manager;

    @FXML
    private ComboBox<String> idComboBox;
    @FXML
    private TextField curTextField;
    @FXML
    private TextField newTextField;
    @FXML
    private Button editButton;

    @FXML
    private void initialize() {
        editButton.setDisable(true);
        idComboBox.getItems().addAll(idLoader.loadIdsAndName());
        idComboBox.setOnAction(event -> {
            manager = new EditDepartmentManager(idComboBox.getValue());
            curTextField.setText(manager.getOldId());
            newTextField.setDisable(false);
        });
    }

    @FXML
    private void handleEdit(MouseEvent event) {
        manager.manageEditId(newTextField.getText());
        loadSuccess("editDepartmentID");
        clearFields();
    }

    private void clearFields() {
        idComboBox.getSelectionModel().clearSelection();
        curTextField.setText("");
        newTextField.setDisable(true);
    }
}