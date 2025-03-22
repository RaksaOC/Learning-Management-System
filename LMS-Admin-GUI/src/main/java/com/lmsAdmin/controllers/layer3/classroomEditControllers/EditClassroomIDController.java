package main.java.com.lmsAdmin.controllers.layer3.classroomEditControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.SceneManager;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditClassroomManager;

public class EditClassroomIDController extends MainFrameController {
    EditClassroomManager idLoader = new EditClassroomManager();
    EditClassroomManager manager;

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
            manager = new EditClassroomManager(idComboBox.getSelectionModel().getSelectedItem());
            curTextField.setText(manager.getOldId());
            newTextField.setDisable(false);
            newTextField.setText(cutString());
        });
    }

    @FXML
    private void handleEdit(MouseEvent event) {
        if (isConfirmed()) {
            manager.manageEditIdSql(newTextField.getText());
            loadSuccess("editClassroomID");
            SceneManager.refreshScenes();
            clearFields();
        }
    }

    private void clearFields() {
        idComboBox.getSelectionModel().clearSelection();
        curTextField.setText("");
        newTextField.setDisable(true);
    }

    private String cutString() {
        int count  = 0;
        StringBuilder subString = new StringBuilder();
        for(int i = 0; i < manager.getOldId().length(); i++) {
            if(manager.getOldId().charAt(i) == '-') {
                count++;
            }
            if(count == 4){
                subString.append('-');
                break;
            }
            subString.append(manager.getOldId().charAt(i));
        }
        return subString.toString();
    }
}