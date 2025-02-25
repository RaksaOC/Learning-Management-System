package main.java.com.lmsAdmin.controllers.layer2.studentActionController;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import main.SceneManager;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;

public class EditStudentController extends MainFrameController {
    @FXML
    HBox editNameHBox;
    @FXML
    HBox editEmailHBox;
    @FXML
    HBox editPhoneHBox;
    @FXML
    HBox editPasswordHBox;
    @FXML
    HBox editAddressHBox;
    @FXML
    HBox editGenderHBox;
    @FXML
    HBox editDOBHBox;
    @FXML
    HBox editDepartmentHBox;
    @FXML
    HBox editSpecializationHBox;
    @FXML
    HBox editGuardianHBox;

    @FXML
    private void navigateToEditName(MouseEvent event) {
        SceneManager.setScene("editStudentName");
    }
    @FXML
    private void navigateToEditEmail(MouseEvent event) {
        SceneManager.setScene("editStudentEmail");
    }
    @FXML
    private void navigateToEditPhone(MouseEvent event) {
        SceneManager.setScene("editStudentPhoneNumber");
    }
    @FXML
    private void navigateToEditPassword(MouseEvent event) {
        SceneManager.setScene("editStudentPassword");
    }
    @FXML
    private void navigateToEditAddress(MouseEvent event) {
        SceneManager.setScene("editStudentAddress");
    }
    @FXML
    private void navigateToEditGender(MouseEvent event) {
        SceneManager.setScene("editStudentGender");
    }
    @FXML
    private void navigateToEditDOB(MouseEvent event) {
        SceneManager.setScene("editStudentDOB");
    }
    @FXML
    private void navigateToEditDepartment(MouseEvent event) {
        SceneManager.setScene("editStudentDepartment");
    }
    @FXML
    private void navigateToEditSpecialization(MouseEvent event) {
        SceneManager.setScene("editStudentSpecialization");
    }
    @FXML
    private void navigateToEditGuardian(MouseEvent event) {
        SceneManager.setScene("editStudentGuardian");
    }
}