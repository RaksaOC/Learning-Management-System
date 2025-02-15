package main.java.com.lmsadmin.controllers.layer1;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import main.SceneManager;
import main.java.com.lmsadmin.controllers.layer0.MainFrameController;

public class ManageTeacherController extends MainFrameController {

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
        SceneManager.setScene("addTeacher");
        System.out.println("At addTeacher scene");
    }
    @FXML
    private void handleEdit(MouseEvent actionEvent) {
        SceneManager.setScene("editTeacher");
        System.out.println("At editTeacher scene");
    }
    @FXML
    private void handleDelete(MouseEvent actionEvent) {
        SceneManager.setScene("deleteTeacher");
        System.out.println("At deleteTeacher scene");
    }
    @FXML
    private void handleView(MouseEvent actionEvent) {
        SceneManager.setScene("viewTeacher");
        System.out.println("At viewTeacher scene");
    }

}