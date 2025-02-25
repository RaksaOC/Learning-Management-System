package main.java.com.lms.controllers.layer3.adminEditControllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import main.java.com.lms.controllers.layer0.MainFrameController;
import main.java.com.lms.managers.layer3.edit_entity_manager.EditAdminManager;

public class EditAdminPasswordController extends MainFrameController {
    EditAdminManager idLoader = new EditAdminManager();
    EditAdminManager manager;

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
            manager = new EditAdminManager(idComboBox.getValue());
            newTextField.setDisable(true);
            curTextField.textProperty().addListener((observable, oldValue, newValue) -> {
                if (manager.isOldPasswordMatched(newValue)) {
                    newTextField.setDisable(false);
                    editButton.setDisable(false);
                    curTextField.setStyle("-fx-border-color: green");
                }
                else{
                    editButton.setDisable(true);
                    curTextField.setStyle("-fx-border-color: red");
                }
//                else {
//                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//                    alert.setTitle("Confirmation");
//                    alert.setHeaderText(null);
//                    alert.setContentText("Password does not match");
//                    Optional<ButtonType> result = alert.showAndWait();
//                    if (result.get() == ButtonType.OK) {
//                        clearFields();
//                    }
//                }
            });
        });
    }

    @FXML
    private void handleEdit(MouseEvent event) {
        manager.manageEditPassword(newTextField.getText());
        loadSuccess("editAdminPassword");
        clearFields();
    }

    private void clearFields() {
        idComboBox.getSelectionModel().clearSelection();
        curTextField.setText("");
        newTextField.setDisable(true);
    }
}