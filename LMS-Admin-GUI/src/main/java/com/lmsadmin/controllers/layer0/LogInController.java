package main.java.com.lmsadmin.controllers.layer0;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import main.SceneManager;
import main.java.com.lmsadmin.managers.layer0.authentication_manager.AuthManager;

public class LogInController {
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private Button logInButton;

    @FXML
    private void resetTextFields() {
        email.setText("");
        password.setText("");
    }



    @FXML
    private void handleLogIn(ActionEvent event) {
        AuthManager manager = new AuthManager();
        System.out.println(email.getText());
        System.out.println(password.getText());
        if (manager.checkCredentials(email.getText(), password.getText())) {
            System.out.println("Login Successful");
            SceneManager.setScene("home");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Credentials");
            alert.setContentText("Invalid Email or Password");
            alert.showAndWait();
            resetTextFields();
        }
    }
}

