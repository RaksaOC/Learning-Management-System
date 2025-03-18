package main.java.com.lmsAdmin.controllers.layer3.generationEditController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditGenerationManager;

public class EditGenerationNameController extends MainFrameController {
    EditGenerationManager idLoader = new EditGenerationManager();
    EditGenerationManager manager;

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
        idComboBox.getItems().addAll(idLoader.loadIdsAndNameJSON());
        idComboBox.setOnAction(event -> {
            manager = new EditGenerationManager(idComboBox.getValue());
            curTextField.setText(idComboBox.getValue());
            newTextField.setDisable(false);
        });
    }

    @FXML
    private void handleEdit(MouseEvent event) {
        manager.manageEditName(newTextField.getText());
        loadSuccess("editGenerationName");
        clearFields();
    }

    private void clearFields() {
        idComboBox.getSelectionModel().clearSelection();
        curTextField.setText("");
        newTextField.setDisable(true);
    }
}