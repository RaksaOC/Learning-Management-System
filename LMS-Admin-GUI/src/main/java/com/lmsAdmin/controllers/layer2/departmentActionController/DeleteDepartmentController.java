package main.java.com.lmsAdmin.controllers.layer2.departmentActionController;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import main.SceneManager;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageDepartmentManager;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditDepartmentManager;

public class DeleteDepartmentController extends MainFrameController {
    @FXML
    private ComboBox<String> idComboBox;
    @FXML
    private Button deleteButton;

    private String selectedLongId;

    public void initialize() {
        EditDepartmentManager idLoader = new EditDepartmentManager();
        ManageDepartmentManager manageDepartmentManager = new ManageDepartmentManager();
        idComboBox.getItems().addAll(idLoader.loadIdsAndName());

        deleteButton.setOnMouseClicked((MouseEvent mouseEvent) -> {
            selectedLongId = idComboBox.getSelectionModel().getSelectedItem();
            if(manageDepartmentManager.isDepartmentDeletable(extractId(selectedLongId))){
                if (isConfirmed()) {
                    manageDepartmentManager.manageDeleteDepartment(extractId(selectedLongId));

                    loadSuccess("deleteDepartment");
                    SceneManager.refreshScenes();
                    clearDetails();
                } else {
                    clearDetails();
                }
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("You are not allowed to delete this department");
                alert.showAndWait();
            }
        });
    }

    private void clearDetails() {
        idComboBox.getSelectionModel().clearSelection();
    }
}