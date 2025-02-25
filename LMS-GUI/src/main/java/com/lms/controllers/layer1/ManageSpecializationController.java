package main.java.com.lms.controllers.layer1;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import main.SceneManager;
import main.java.com.lms.controllers.layer0.MainFrameController;

public class ManageSpecializationController extends MainFrameController {
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
        SceneManager.setScene("addSpecialization");
        System.out.println("At addSpecialization scene");
    }
    @FXML
    private void handleEdit(MouseEvent actionEvent) {
        SceneManager.setScene("editSpecialization");
        System.out.println("At editSpecialization scene");
    }
    @FXML
    private void handleDelete(MouseEvent actionEvent) {
        SceneManager.setScene("deleteSpecialization");
        System.out.println("At deleteSpecialization scene");
    }
    @FXML
    private void handleView(MouseEvent actionEvent) {
        SceneManager.setScene("viewSpecialization");
        System.out.println("At viewSpecialization scene");
    }
}