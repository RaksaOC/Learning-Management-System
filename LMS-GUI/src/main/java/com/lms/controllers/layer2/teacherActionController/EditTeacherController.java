package main.java.com.lms.controllers.layer2.teacherActionController;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import main.SceneManager;
import main.java.com.lms.controllers.layer0.MainFrameController;

public class EditTeacherController extends MainFrameController {
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
        SceneManager.setScene("editTeacherName");
    }
    @FXML
    private void navigateToEditEmail(MouseEvent event) {
        SceneManager.setScene("editTeacherEmail");
    }
    @FXML
    private void navigateToEditPhone(MouseEvent event) {
        SceneManager.setScene("editTeacherPhoneNumber");
    }
    @FXML
    private void navigateToEditPassword(MouseEvent event) {
        SceneManager.setScene("editTeacherPassword");
    }
    @FXML
    private void navigateToEditGender(MouseEvent event) {
        SceneManager.setScene("editTeacherGender");
    }
    @FXML
    private void navigateToEditDOB(MouseEvent event) {
        SceneManager.setScene("editTeacherDOB");
    }
}