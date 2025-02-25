package main.java.com.lmsAdmin.controllers.layer2.specializationActionController;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import main.SceneManager;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;

public class EditSpecializationController extends MainFrameController {
    @FXML
    HBox editNameHBox;
    @FXML
    HBox editIdHBox;

    @FXML
    private void navigateToEditName(MouseEvent event) {
        SceneManager.setScene("editSpecializationName");
    }
    @FXML
    private void navigateToEditId(MouseEvent event) {
        SceneManager.setScene("editSpecializationID");
    }
}