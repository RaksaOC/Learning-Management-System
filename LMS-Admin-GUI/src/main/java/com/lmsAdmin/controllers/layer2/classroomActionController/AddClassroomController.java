package main.java.com.lmsAdmin.controllers.layer2.classroomActionController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageClassroomManager;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditCourseManager;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditGroupManager;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditTeacherManager;

public class AddClassroomController extends MainFrameController {
    @FXML
    private TextField classID;
    @FXML
    private ComboBox<String> teacherId;
    @FXML
    private ComboBox<String> courseID;
    @FXML
    private ComboBox<String> groupID;
    @FXML
    private Button addButton;

    public void initialize() {
        teacherId.getItems().addAll(new EditTeacherManager().loadIdsAndName());
        courseID.getItems().addAll(new EditCourseManager().loadIdsAndName());
        groupID.getItems().addAll(new EditGroupManager().loadIdsAndName());
        classID.setText(groupID.getItems().getFirst() + "-" + extractId(courseID.getItems().getFirst()));
        courseID.setOnAction(event -> {
            if (groupID.getSelectionModel().getSelectedItem() != null) {
                classID.clear();
                classID.setText(groupID.getSelectionModel().getSelectedItem() + "-" + extractId(courseID.getSelectionModel().getSelectedItem()));
            }
        });
    }

    @FXML
    private void handleAdd(MouseEvent event) {
        ManageClassroomManager manageClassroomManager = new ManageClassroomManager();

        manageClassroomManager.manageAddClassroom(classID.getText(),
                extractId(teacherId.getSelectionModel().getSelectedItem()),
                extractId(courseID.getSelectionModel().getSelectedItem()),
                groupID.getSelectionModel().getSelectedItem(),
                "status");
    }

    private void resetAllFields() {
        classID.clear();
        groupID.getSelectionModel().clearSelection();
    }
}