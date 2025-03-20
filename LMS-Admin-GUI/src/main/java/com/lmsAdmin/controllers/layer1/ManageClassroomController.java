package main.java.com.lmsAdmin.controllers.layer1;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import main.SceneManager;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import javafx.scene.input.MouseEvent;


public class ManageClassroomController extends MainFrameController {
    @FXML
    private HBox add;
    @FXML
    private HBox edit;
    @FXML
    private HBox delete;
    @FXML
    private HBox view;

    @FXML
    private void handleAdd(MouseEvent actionEvent) {
        SceneManager.setScene("addClassroom");
    }
    @FXML
    private void handleEdit(MouseEvent actionEvent) {
        SceneManager.setScene("editClassroom");
    }
    @FXML
    private void handleDelete(MouseEvent actionEvent) {
        SceneManager.setScene("deleteClassroom");
    }
    @FXML
    private void handleView(MouseEvent actionEvent) {
        SceneManager.setScene("viewClassroom");
    }
    @FXML
    private void handleAssignTeacher(MouseEvent actionEvent) {
        SceneManager.setScene("assignTeacherToClassroom");
    }
    @FXML
    private void handleAssignCourse(MouseEvent actionEvent) {
        SceneManager.setScene("assignCourseToClassroom");
    }
}