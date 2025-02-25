package main.java.com.lms.controllers.layer2.departmentActionController;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import main.SceneManager;
import main.java.com.lms.controllers.layer0.MainFrameController;

public class EditDepartmentController extends MainFrameController {
    @FXML
    HBox editNameHBox;
    @FXML
    HBox editIdHBox;

    @FXML
    private void navigateToEditName(MouseEvent event) {
        SceneManager.setScene("editDepartmentName");
    }
    @FXML
    private void navigateToEditId(MouseEvent event) {
        SceneManager.setScene("editDepartmentID");
    }
}