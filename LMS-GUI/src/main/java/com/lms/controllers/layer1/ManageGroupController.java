package main.java.com.lms.controllers.layer1;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import main.SceneManager;
import main.java.com.lms.controllers.layer0.MainFrameController;

public class ManageGroupController extends MainFrameController {
    @FXML
    private HBox add;
    @FXML
    private HBox edit;
    @FXML
    private HBox delete;
    @FXML
    private HBox view;
    // more buttons to add

    @FXML
    private void handleAdd(MouseEvent actionEvent) {
        SceneManager.setScene("addGroup");
        System.out.println("At addGroup scene");
    }
    @FXML
    private void handleEdit(MouseEvent actionEvent) {
        SceneManager.setScene("editGroup");
        System.out.println("At editGroup scene");
    }
    @FXML
    private void handleDelete(MouseEvent actionEvent) {
        SceneManager.setScene("deleteGroup");
        System.out.println("At deleteGroup scene");
    }
    @FXML
    private void handleView(MouseEvent actionEvent) {
        SceneManager.setScene("viewGroup");
        System.out.println("At viewGroup scene");
    }

    @FXML
    private void handleAddStudentToGroup(MouseEvent actionEvent) {
        SceneManager.setScene("addStudentToGroup");
        System.out.println("At addStudentToGroup scene");
    }

}