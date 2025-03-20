package main.java.com.lmsAdmin.controllers.layer1;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import main.SceneManager;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;

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
    }
    @FXML
    private void handleEdit(MouseEvent actionEvent) {
        SceneManager.setScene("editGroup");
    }
    @FXML
    private void handleDelete(MouseEvent actionEvent) {
        SceneManager.setScene("deleteGroup");
    }
    @FXML
    private void handleView(MouseEvent actionEvent) {
        SceneManager.setScene("viewGroup");
    }

    @FXML
    private void handleAddStudentToGroup(MouseEvent actionEvent) {
        SceneManager.setScene("addStudentToGroup");
    }

}