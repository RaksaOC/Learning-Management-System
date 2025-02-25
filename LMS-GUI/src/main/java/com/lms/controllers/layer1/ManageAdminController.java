package main.java.com.lms.controllers.layer1;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import main.SceneManager;
import main.java.com.lms.controllers.layer0.MainFrameController;
import javafx.scene.input.MouseEvent;

public class ManageAdminController extends MainFrameController {
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
        SceneManager.setScene("addAdmin");
        System.out.println("At addAdmin scene");
    }
    @FXML
    private void handleEdit(MouseEvent actionEvent) {
        SceneManager.setScene("editAdmin");
        System.out.println("At editAdmin scene");
    }
    @FXML
    private void handleDelete(MouseEvent actionEvent) {
        SceneManager.setScene("deleteAdmin");
        System.out.println("At deleteAdmin scene");
    }
    @FXML
    private void handleView(MouseEvent actionEvent) {
        SceneManager.setScene("viewAdmin");
        System.out.println("At viewAdmin scene");
    }
}