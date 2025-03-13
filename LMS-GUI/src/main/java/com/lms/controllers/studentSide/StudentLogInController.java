package main.java.com.lms.controllers.studentSide;

import entities.Student;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lib.Hasher;
import main.AppSession;
import main.SceneManager;
import main.java.com.lms.controllers.StudentMainFrameController;
import main.java.com.lms.managers.AuthenticationManager;

public class StudentLogInController {
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Button loginButton;

    public void initialize() {
        loginButton.setOnAction(event -> {
            String email = emailTextField.getText();
            String password = passwordTextField.getText();

            AuthenticationManager manager = new AuthenticationManager("student", email, password);
            System.out.println("email" + email);
            System.out.println("raw pass"+password);
            System.out.println("hashed pass"+ Hasher.hash(password));
            if (email.isEmpty() || password.isEmpty() || !manager.isUser()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please enter valid details");
                alert.showAndWait();
            } else {
                Student student = (Student) manager.getAuthenticatedUser();
                manager.createNewLogIn("student", student.getId());

                AppSession session = AppSession.getInstance();
                session.setStudent(student);

                // The main frame loading begins here and other main frames should be in the sceneManager because appsession student entity is no longer null
                StudentMainFrameController studentMainFrameController = SceneManager.loadMainFrame("student");
                studentMainFrameController.setNameText(session.getStudent().getFullName());

                SceneManager.setCenterView("studentDashboard");
            }
        });
    }
}