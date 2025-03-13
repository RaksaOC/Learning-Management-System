package main.java.com.lms.controllers;

import entities.Student;
import entities.Teacher;
import entities.User;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import main.AppSession;
import main.SceneManager;
import main.java.com.lms.managers.AuthenticationManager;

public class UserTypeController {
    @FXML
    private HBox studentHbox;
    @FXML
    private HBox teacherHbox;

    public void initialize() {
        studentHbox.setOnMouseEntered(event -> {
            studentHbox.setScaleX(1.03);
            studentHbox.setScaleY(1.03);
            studentHbox.setOpacity(0.9);
        });
        teacherHbox.setOnMouseEntered(event -> {
            teacherHbox.setScaleX(1.03);
            teacherHbox.setScaleY(1.03);
            teacherHbox.setOpacity(0.9);
        });
        studentHbox.setOnMouseExited(event -> {
            studentHbox.setScaleX(1.0);
            studentHbox.setScaleY(1.0);
            studentHbox.setOpacity(1);
        });
        teacherHbox.setOnMouseExited(event -> {
            teacherHbox.setScaleX(1.0);
            teacherHbox.setScaleY(1.0);
            teacherHbox.setOpacity(1);
        });

        studentHbox.setOnMouseClicked(event -> {
            AuthenticationManager authenticationManager = new AuthenticationManager();
            if (authenticationManager.isLastLoggedIn("student")) {
                Student student = (Student) getUser("student");
                authenticationManager.createNewLogIn("student", student.getId());

                AppSession session = AppSession.getInstance();
                session.setStudent(student);

                StudentMainFrameController studentMainFrameController = SceneManager.loadMainFrame("student");
                studentMainFrameController.setNameText(session.getStudent().getFullName());

                SceneManager.loadCenterView("studentDashboard", "resources/com/lms/views/studentSide/Dashboard.fxml");
                SceneManager.setCenterView("studentDashboard");
            } else {
                SceneManager.loadFullView("studentLogIn", "resources/com/lms/views/studentSide/LogIn.fxml");
                SceneManager.setFullView("studentLogIn"); // authentication further handled by studentLogInController
            }
        });
        teacherHbox.setOnMouseClicked(event -> {
            AuthenticationManager authenticationManager = new AuthenticationManager();
            if (authenticationManager.isLastLoggedIn("teacher")) {
                Teacher teacher = (Teacher) getUser("teacher");
                authenticationManager.createNewLogIn("teacher", teacher.getId());

                AppSession session = AppSession.getInstance();
                session.setTeacher(teacher);

                TeacherMainFrameController teacherMainFrameController = SceneManager.loadMainFrame("teacher");
                teacherMainFrameController.setNameText(session.getTeacher().getFullName());

                SceneManager.loadCenterView("teacherDashboard", "resources/com/lms/views/teacherSide/Dashboard.fxml");
                SceneManager.setCenterView("teacherDashboard");
            } else {
                SceneManager.loadFullView("teacherLogIn", "resources/com/lms/views/teacherSide/LogIn.fxml");
                SceneManager.setFullView("teacherLogIn"); // authentication further handled by teacherLogInController
            }
        });
    }

    private User getUser(String userType) {
        // this function only for when last logged in
        AuthenticationManager authenticationManager = new AuthenticationManager();
        String id = authenticationManager.getLastLoggedInUserId(userType);
        // usage of an overloaded method
        User user = authenticationManager.getAuthenticatedUser(id); // this process also include the assignment of "lastLogin" of user

        return user;
    }
}