package main.java.com.lmsAdmin.controllers.layer2.teacherActionController;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import lib.Hasher;
import main.SceneManager;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageTeacherManager;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddTeacherController extends MainFrameController {
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private DatePicker dob;
    @FXML
    private ComboBox<String> gender;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private TextField confirmPassword;
    @FXML
    private Button addButton;

    @FXML
    private void handleAdd(MouseEvent event) {
        if(isPasswordSame(password.getText(), confirmPassword.getText())){
            String fName = firstName.getText();
            String lName = lastName.getText();
            String dateOfBirth = dob.getValue().toString();
            String gen = gender.getSelectionModel().getSelectedItem().toString();
            String phone = phoneNumber.getText();
            String password = confirmPassword.getText();
            String em = email.getText();

            if (isConfirmed()) {
                ManageTeacherManager manageTeacherManager = new ManageTeacherManager();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                String formattedDate = now.format(formatter);

                manageTeacherManager.manageAddTeacher(
                        fName,
                        lName,
                        gen,
                        dateOfBirth,
                        phone,
                        em,
                        "active",
                        formattedDate,
                        null,
                        password
                );

                loadSuccess("addTeacher");
                SceneManager.refreshScenes();
                resetAllFields();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Password do not match");
            alert.setHeaderText(null);
            alert.setContentText("Password do not match");
            alert.showAndWait();
            resetPassFields();
        }

    }

    private boolean isPasswordSame(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    private void resetAllFields(){
        firstName.clear();
        lastName.clear();
        dob.setValue(null);
        gender.getSelectionModel().clearSelection();
        phoneNumber.clear();
        confirmPassword.clear();
        email.clear();
        password.clear();
    }

    private void resetPassFields() {
        password.clear();
        confirmPassword.clear();
    }
}