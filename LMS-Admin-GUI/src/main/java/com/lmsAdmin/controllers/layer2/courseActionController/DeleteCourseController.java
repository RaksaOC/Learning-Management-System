package main.java.com.lmsAdmin.controllers.layer2.courseActionController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import main.SceneManager;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageCourseManager;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditCourseManager;
import ui.UI;

public class DeleteCourseController extends MainFrameController{
    @FXML
    private ComboBox<String> idComboBox;
    @FXML
    private Button deleteButton;

    private String selectedLongId;

    public void initialize() {
        EditCourseManager editCourseManager = new EditCourseManager();
        idComboBox.getItems().addAll(editCourseManager.loadIdsAndName());
        deleteButton.setOnMouseClicked((MouseEvent event) -> {
            handleDelete();
        });
    }
    private void handleDelete() {
        selectedLongId = idComboBox.getSelectionModel().getSelectedItem();

        if(isConfirmed()){
            ManageCourseManager manageCourseManager = new ManageCourseManager();
            manageCourseManager.manageDeleteCourse(extractId(selectedLongId));

            loadSuccess("deleteCourse");
            SceneManager.refreshScenes();
            clearDetails();
        }
        else{
            clearDetails();
        }
    }

    private void clearDetails(){
        idComboBox.getSelectionModel().clearSelection();
    }
}