package main.java.com.lmsadmin.controllers.layer2.generationActionController;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import main.SceneManager;
import main.java.com.lmsadmin.controllers.layer0.MainFrameController;

public class EditGenerationController extends MainFrameController {
    @FXML
    HBox editNameHBox;
    @FXML
    HBox editIdHBox;

    @FXML
    private void navigateToEditName(MouseEvent event) {
        // scene to be added

    }

    @FXML
    private void navigateToEditId(MouseEvent event) {
        SceneManager.setScene("editGenerationID");
    }
}