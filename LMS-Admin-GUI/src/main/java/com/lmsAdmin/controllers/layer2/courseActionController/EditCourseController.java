package main.java.com.lmsAdmin.controllers.layer2.courseActionController;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import main.SceneManager;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;

public class EditCourseController extends MainFrameController {
    @FXML
    HBox editNameHBox;
    @FXML
    HBox editIdHBox;
    @FXML
    HBox editCreditHBox;
    @FXML
    HBox editLevelHBox;
    @FXML
    HBox editDescHBox;

    @FXML
    private void navigateToEditName(MouseEvent event) {
        SceneManager.setScene("editCourseName");
    }
    @FXML
    private void navigateToEditId(MouseEvent event) {
        SceneManager.setScene("editCourseID");
    }
    @FXML
    private void navigateToEditCredit(MouseEvent event) {

    }
    @FXML
    private void navigateToEditLevel(MouseEvent event) {

    }
    @FXML
    private void navigateToEditDesc(MouseEvent event) {

    }
}