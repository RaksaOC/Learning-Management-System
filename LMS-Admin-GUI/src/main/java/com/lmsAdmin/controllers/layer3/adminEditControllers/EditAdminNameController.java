package main.java.com.lmsAdmin.controllers.layer3.adminEditControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditAdminManager;

public class EditAdminNameController extends MainFrameController {
    EditAdminManager idLoader = new EditAdminManager();
    EditAdminManager manager;

    @FXML
    private ComboBox<String> idComboBox;
    @FXML
    private TextField curFirstNameTextField;
    @FXML
    private TextField curLastNameTextField;
    @FXML
    private TextField newFirstNameTextField;
    @FXML
    private TextField newLastNameTextField;
    @FXML
    private Button editButton;

    @FXML
    private void initialize() {
        editButton.setDisable(true);
        idComboBox.getItems().addAll(idLoader.loadIdsAndNameJSON());
        idComboBox.setOnAction(event -> {
            manager = new EditAdminManager(idComboBox.getValue());
            curFirstNameTextField.setText(manager.getOldFirstName());
            curLastNameTextField.setText(manager.getOldLastName());
        });
    }

    @FXML
    private void handleEdit(MouseEvent event) {
        manager.manageEditName(newFirstNameTextField.getText(), newLastNameTextField.getText());
        loadSuccess("editAdminName");
        clearFields();
    }

    private void clearFields() {
        idComboBox.getSelectionModel().clearSelection();
        curFirstNameTextField.setText("");
        curLastNameTextField.setDisable(true);
    }
}