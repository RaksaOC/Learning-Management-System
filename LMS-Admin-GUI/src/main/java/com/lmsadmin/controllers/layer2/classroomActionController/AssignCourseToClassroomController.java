package main.java.com.lmsadmin.controllers.layer2.classroomActionController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import main.java.com.lmsadmin.controllers.layer0.MainFrameController;
import main.java.com.lmsadmin.managers.layer3.edit_entity_manager.EditClassroomManager;
import main.java.com.lmsadmin.managers.layer3.edit_entity_manager.EditCourseManager;
import main.java.com.lmsadmin.managers.layer2.manage_entity_manager.ManageClassroomManager;

public class AssignCourseToClassroomController extends MainFrameController {
    private final EditCourseManager courseIDLoader = new EditCourseManager();
    private final EditClassroomManager classroomIDLoader = new EditClassroomManager() ;
    @FXML
    private ComboBox<String> courseIDComboBox;
    @FXML
    private ComboBox<String> classroomIDComboBox;
    @FXML
    private Button assignButton;

    public void initialize() {
        assignButton.setDisable(true);
        classroomIDComboBox.setDisable(true);
        courseIDComboBox.getItems().addAll(courseIDLoader.loadIds());
        courseIDComboBox.setOnAction(event -> {
            classroomIDComboBox.setDisable(false);
            classroomIDComboBox.getItems().addAll(classroomIDLoader.loadIds());
        });

        classroomIDComboBox.setOnAction(event -> {
            assignButton.setDisable(false);
        });
    }

    @FXML
    private void handleAssign(MouseEvent event) {
        ManageClassroomManager manageClassroomManager = new ManageClassroomManager();
        manageClassroomManager.manageAssignTeacherToClassroom(classroomIDComboBox.getValue(), courseIDComboBox.getValue());

        loadSuccess("assignCourseToClassroom");
        clearFields();
    }

    private void clearFields() {
        classroomIDComboBox.getSelectionModel().clearSelection();
        courseIDComboBox.getSelectionModel().clearSelection();
    }
}