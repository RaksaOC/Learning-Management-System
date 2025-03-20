package main.java.com.lmsAdmin.controllers.layer2.courseActionController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageCourseManager;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditCourseManager;
import ui.UI;

public class DeleteCourseController extends MainFrameController{
    @FXML
    private ComboBox<String> idComboBox;
    @FXML
    private Button deleteButton;

    private String selectedId;

    public void initialize() {
        EditCourseManager editCourseManager = new EditCourseManager();
        idComboBox.getItems().addAll(editCourseManager.loadIdsAndName());
        deleteButton.setOnMouseClicked((MouseEvent event) -> {
            handleDelete();
        });
    }
    private void handleDelete() {
        selectedId = idComboBox.getSelectionModel().getSelectedItem().toString().substring(0 , idComboBox.getSelectionModel().getSelectedItem().toString().indexOf(" "));
        System.out.println(UI.TextColor.addColor(selectedId, UI.TextColor.RED));
        if(isConfirmed()){
            ManageCourseManager manageCourseManager = new ManageCourseManager();
            manageCourseManager.manageDeleteCourse(selectedId);

            loadSuccess("deleteCourse");
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