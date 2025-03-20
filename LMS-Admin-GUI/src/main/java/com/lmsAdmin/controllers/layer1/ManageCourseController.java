package main.java.com.lmsAdmin.controllers.layer1;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import main.SceneManager;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import javafx.scene.input.MouseEvent;

public class ManageCourseController extends MainFrameController{
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
        SceneManager.setScene("addCourse");
    }
    @FXML
    private void handleEdit(MouseEvent actionEvent) {
        SceneManager.setScene("editCourse");
    }
    @FXML
    private void handleDelete(MouseEvent actionEvent) {
        SceneManager.setScene("deleteCourse");
    }
    @FXML
    private void handleView(MouseEvent actionEvent) {
        SceneManager.setScene("viewCourse");
    }
}