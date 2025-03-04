package main.java.com.lms.controllers.teacherSide;

import entities.Teacher;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import main.AppSession;
import main.SceneManager;
import main.java.com.lms.controllers.TeacherMainFrameController;
import main.java.com.lms.managers.studentSide.AuthenticationManager;

public class TeacherLogInController {
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

            AuthenticationManager manager = new AuthenticationManager("teacher", email, password);

            if (email.isEmpty() || password.isEmpty() || !manager.isUser()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please enter valid details");
                alert.showAndWait();
            }
            else {
                Teacher teacher = (Teacher) manager.getAuthenticatedUser();
                manager.createNewLogIn("teacher", teacher.getId());

                AppSession session = AppSession.getInstance();
                session.setTeacher(teacher);

                TeacherMainFrameController teacherMainFrameController = SceneManager.loadMainFrame("student");
                teacherMainFrameController.setNameText(session.getTeacher().getFullName());
                SceneManager.setCenterView("teacherDashboard");
            }
        });
    }
}