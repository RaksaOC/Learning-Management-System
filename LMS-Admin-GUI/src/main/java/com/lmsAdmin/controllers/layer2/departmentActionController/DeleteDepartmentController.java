package main.java.com.lmsAdmin.controllers.layer2.departmentActionController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageDepartmentManager;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditDepartmentManager;

public class DeleteDepartmentController extends MainFrameController {
    @FXML
    private ComboBox<String> idComboBox;
    @FXML
    private Button deleteButton;

    private String selectedId;

    public void initialize() {
        EditDepartmentManager idLoader = new EditDepartmentManager();
        idComboBox.getItems().addAll(idLoader.loadIdsAndName());

        deleteButton.setOnMouseClicked((MouseEvent mouseEvent) -> {
            selectedId = idComboBox.getSelectionModel().getSelectedItem().toString().substring(0 , idComboBox.getSelectionModel().getSelectedItem().toString().indexOf(" "));

            if (isConfirmed()) {
                ManageDepartmentManager manageDepartmentManager = new ManageDepartmentManager();
                manageDepartmentManager.manageDeleteDepartment(selectedId);

                loadSuccess("deleteDepartment");
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