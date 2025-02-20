package main.java.com.lmsadmin.controllers.layer2.adminActionController;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import main.SceneManager;
import main.java.com.lmsadmin.controllers.layer0.MainFrameController;

public class EditAdminController extends MainFrameController {
    @FXML
    HBox editNameHBox;
    @FXML
    HBox editEmailHBox;
    @FXML
    HBox editPhoneHBox;
    @FXML
    HBox editPasswordHBox;
    @FXML
    HBox editGenderHBox;
    @FXML
    HBox editDOBHBox;

    @FXML
    private void navigateToEditName(MouseEvent event) {
        SceneManager.setScene("editAdminName");
    }
    @FXML
    private void navigateToEditEmail(MouseEvent event) {
        SceneManager.setScene("editAdminEmail");
    }
    @FXML
    private void navigateToEditPhone(MouseEvent event) {
        SceneManager.setScene("editAdminPhoneNumber");
    }
    @FXML
    private void navigateToEditPassword(MouseEvent event) {
        SceneManager.setScene("editAdminPassword");
    }
    @FXML
    private void navigateToEditGender(MouseEvent event) {
        SceneManager.setScene("editAdminGender");
    }
    @FXML
    private void navigateToEditDOB(MouseEvent event) {
        SceneManager.setScene("editAdminDOB");
    }
}