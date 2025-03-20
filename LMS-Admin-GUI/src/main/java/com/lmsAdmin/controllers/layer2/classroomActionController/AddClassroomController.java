package main.java.com.lmsAdmin.controllers.layer2.classroomActionController;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import main.SceneManager;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageClassroomManager;

public class AddClassroomController extends MainFrameController {
    @FXML
    private TextField classID;
    @FXML
    private ComboBox<String> groupID;
    @FXML
    private Button addButton;

    // TODO: add functionalities

    @FXML
    private void handleAdd(MouseEvent event) {
//        String classId = classID.getText();
//        String gId = groupID.getSelectionModel().getSelectedItem().toString();
//        ManageClassroomManager manageClassroomManager = new ManageClassroomManager();
//        manageClassroomManager(gId, classId);
//
//        System.out.println("Content");
//        System.out.println(classId);
//        System.out.println(gId);
//        System.out.println("Added Successfully");
//
//        SceneManager.setScene("success");
//        PauseTransition delay = new PauseTransition(Duration.seconds(2));
//        delay.setOnFinished(ev -> {
//            SceneManager.setScene("addClassroom");
//            resetAllFields();
//        });
//
//        delay.play();
    }
//
    private void resetAllFields() {
        classID.clear();
        groupID.getSelectionModel().clearSelection();
    }
}