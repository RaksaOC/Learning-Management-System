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
        System.out.println("At addClassroom scene");
    }
    @FXML
    private void handleEdit(MouseEvent actionEvent) {
        SceneManager.setScene("editClassroom");
        System.out.println("At editClassroom scene");
    }
    @FXML
    private void handleDelete(MouseEvent actionEvent) {
        SceneManager.setScene("deleteClassroom");
        System.out.println("At deleteClassroom scene");
    }
    @FXML
    private void handleView(MouseEvent actionEvent) {
        SceneManager.setScene("viewClassroom");
        System.out.println("At viewClassroom scene");
    }
    @FXML
    private void handleAssignTeacher(MouseEvent actionEvent) {
        SceneManager.setScene("assignTeacherToClassroom");
        System.out.println("At assignTeacherToClassroom scene");
    }
    @FXML
    private void handleAssignCourse(MouseEvent actionEvent) {
        SceneManager.setScene("assignCourseToClassroom");
        System.out.println("At assignCourseToClassroom scene");
    }
}