package main.java.com.lmsAdmin.controllers.layer2.adminActionController;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import lib.Hasher;
import main.SceneManager;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageAdminManager;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddAdminController extends MainFrameController {
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private DatePicker dob;
    @FXML
    private ComboBox gender;
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
        if (isPasswordSame(password.getText(), confirmPassword.getText())) {
            String fName = firstName.getText();
            String lName = lastName.getText();
            String dateOfBirth = dob.getValue().toString();
            String gen = gender.getSelectionModel().getSelectedItem().toString();
            String phone = phoneNumber.getText();
            String password = confirmPassword.getText();
            String em = email.getText();

            ManageAdminManager manageAdminManager = new ManageAdminManager();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String formattedDate = now.format(formatter);

            JSONObject newAdmin = new JSONObject();

            JSONObject name = new JSONObject();

            name.put("firstName", fName);
            name.put("lastName", lName);
            newAdmin.put("name", name);
            newAdmin.put("dob", dateOfBirth);
            newAdmin.put("gender", gen);
            newAdmin.put("phoneNumber", phone);
            newAdmin.put("email", em);
            newAdmin.put("password", Hasher.hash(password));
            newAdmin.put("createdAt", formattedDate);
            newAdmin.put("lastLogin", "");
            newAdmin.put("status", "active");

            manageAdminManager.manageAddEntitySQL(
                    fName,
                    lName,
                    formattedDate,
                    null,
                    password,
                    phone,
                    gen,
                    dateOfBirth,
                    em,
                    "active"
            );

            manageAdminManager.manageAddEntity(newAdmin);

            System.out.println("Contents to be added");
            System.out.println(fName);
            System.out.println(lName);
            System.out.println(dateOfBirth);
            System.out.println(gen);
            System.out.println(phone);
            System.out.println(em);
            System.out.println(password);
            System.out.println(newAdmin.toString());
            System.out.println("Added Admin Successfully");

            SceneManager.setScene("success"); // Show success screen
            PauseTransition delay = new PauseTransition(Duration.seconds(2)); // 2-second delay
            delay.setOnFinished(ev -> {
                SceneManager.setScene("addAdmin"); // Return to addAdmin scene
                resetAllFields(); // Clear input fields
            });

            delay.play(); // Start the delay
        } else {
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

    private void resetPassFields() {
        password.clear();
        confirmPassword.clear();
    }

    private void resetAllFields() {
        firstName.clear();
        lastName.clear();
        dob.setValue(null);
        gender.getSelectionModel().clearSelection();
        phoneNumber.clear();
        email.clear();
        password.clear();
        confirmPassword.clear();
    }
}