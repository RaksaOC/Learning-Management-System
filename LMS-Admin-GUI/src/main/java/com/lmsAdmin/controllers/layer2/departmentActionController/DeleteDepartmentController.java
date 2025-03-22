package main.java.com.lmsAdmin.controllers.layer2.departmentActionController;

import javafx.fxml.FXML;
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
        idComboBox.getItems().addAll(idLoader.loadIdsAndName());

        deleteButton.setOnMouseClicked((MouseEvent mouseEvent) -> {
            selectedLongId = idComboBox.getSelectionModel().getSelectedItem();

            if (isConfirmed()) {
                ManageDepartmentManager manageDepartmentManager = new ManageDepartmentManager();
                manageDepartmentManager.manageDeleteDepartment(extractId(selectedLongId));

                loadSuccess("deleteDepartment");
                SceneManager.refreshScenes();
                clearDetails();
            } else {
                clearDetails();
            }
        });
    }

    private void clearDetails() {
        idComboBox.getSelectionModel().clearSelection();
    }
}