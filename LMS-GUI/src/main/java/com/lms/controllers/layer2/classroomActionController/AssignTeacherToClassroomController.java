package main.java.com.lms.controllers.layer2.classroomActionController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import main.java.com.lms.controllers.layer0.MainFrameController;
import main.java.com.lms.managers.layer3.edit_entity_manager.EditClassroomManager;
import main.java.com.lms.managers.layer3.edit_entity_manager.EditTeacherManager;
import main.java.com.lms.managers.layer2.manage_entity_manager.ManageClassroomManager;

public class AssignTeacherToClassroomController extends MainFrameController {
    private final EditTeacherManager teacherIDLoader = new EditTeacherManager();
    private final EditClassroomManager classroomIDLoader = new EditClassroomManager();
    @FXML
    private ComboBox<String> teacherIDComboBox;
    @FXML
    private ComboBox<String> classroomIDComboBox;
    @FXML
    private Button assignButton;

    public void initialize() {
        assignButton.setDisable(true);
        classroomIDComboBox.setDisable(true);
        teacherIDComboBox.getItems().addAll(teacherIDLoader.loadIds());
        teacherIDComboBox.setOnAction(event -> {
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
        manageClassroomManager.manageAssignTeacherToClassroom(classroomIDComboBox.getValue(), teacherIDComboBox.getValue());

        loadSuccess("assignTeacherToClassroom");
        clearFields();
    }

    private void clearFields() {
        classroomIDComboBox.getSelectionModel().clearSelection();
        teacherIDComboBox.getSelectionModel().clearSelection();
    }
}