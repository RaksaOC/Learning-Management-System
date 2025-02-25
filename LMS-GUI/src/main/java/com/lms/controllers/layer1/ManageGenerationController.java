package main.java.com.lms.controllers.layer1;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import main.SceneManager;
import main.java.com.lms.controllers.layer0.MainFrameController;

public class ManageGenerationController extends MainFrameController {
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
        SceneManager.setScene("addGeneration");
        System.out.println("At addGeneration scene");
    }
    @FXML
    private void handleEdit(MouseEvent actionEvent) {
        SceneManager.setScene("editGeneration");
        System.out.println("At editGeneration scene");
    }
    @FXML
    private void handleDelete(MouseEvent actionEvent) {
        SceneManager.setScene("deleteGeneration");
        System.out.println("At deleteGeneration scene");
    }
    @FXML
    private void handleView(MouseEvent actionEvent) {
        SceneManager.setScene("viewGeneration");
        System.out.println("At viewGeneration scene");
    }
}