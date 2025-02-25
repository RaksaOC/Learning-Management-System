package main.java.com.lmsadmin.controllers.layer3.specializationEditControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.java.com.lmsadmin.controllers.layer0.MainFrameController;
import main.java.com.lmsadmin.managers.layer3.edit_entity_manager.EditSpecializationManager;

public class EditSpecializationIDController extends MainFrameController {
    EditSpecializationManager idLoader = new EditSpecializationManager();
    EditSpecializationManager manager;

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
        idComboBox.getItems().addAll(idLoader.loadIds());
        idComboBox.setOnAction(event -> {
            manager = new EditSpecializationManager(idComboBox.getValue());
            curTextField.setText(idComboBox.getValue());
            newTextField.setDisable(false);
            newTextField.setText(cutString());
        });
    }

    @FXML
    private void handleEdit(MouseEvent event) {
        manager.manageEditId(newTextField.getText());
        loadSuccess("editSpecializationID");
        clearFields();
    }

    private void clearFields() {
        idComboBox.getSelectionModel().clearSelection();
        curTextField.setText("");
        newTextField.setDisable(true);
    }

    private String cutString() {
        int count  = 0;
        StringBuilder subString = new StringBuilder();
        for(int i = 0; i < idComboBox.getValue().length(); i++) {
            if(idComboBox.getValue().charAt(i) == '-') {
                count++;
            }
            if(count == 1){
                subString.append('-');
                break;
            }
            subString.append(idComboBox.getValue().charAt(i));
        }
        return subString.toString();
    }
}