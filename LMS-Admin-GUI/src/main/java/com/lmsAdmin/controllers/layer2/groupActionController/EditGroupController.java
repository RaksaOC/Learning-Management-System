package main.java.com.lmsAdmin.controllers.layer2.groupActionController;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import main.SceneManager;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;

public class EditGroupController extends MainFrameController {

    @FXML
    HBox editIdHBox;

    @FXML
    private void navigateToEditId(MouseEvent event) {
        SceneManager.setScene("editGroupID");
    }
}