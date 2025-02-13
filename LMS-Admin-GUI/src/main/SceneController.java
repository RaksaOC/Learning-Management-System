package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.java.com.lmsadmin.controllers.LogInController;

import java.io.IOException;
import java.util.HashMap;

public class SceneController extends Application {
    private static Stage primaryStage;
    private static final HashMap<String, Scene> scenes = new HashMap<>();

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        loadScene("login", "resources/com/lmsadmin/views/LogInView2.fxml");
        loadScene("home", "resources/com/lmsadmin/views/HomeView.fxml");
        loadScene("dashboard", "resources/com/lmsadmin/views/DashboardView.fxml");
        loadScene("manageStudent", "resources/com/lmsadmin/views/ManageStudentView.fxml");
        loadScene("manageTeacher", "resources/com/lmsadmin/views/ManageTeacherView.fxml");
        loadScene("manageDepartment", "resources/com/lmsadmin/views/ManageDepartmentView.fxml");
        loadScene("manageSpecialization", "resources/com/lmsadmin/views/ManageSpecializationView.fxml");
        loadScene("manageGeneration", "resources/com/lmsadmin/views/ManageGenerationView.fxml");
        loadScene("manageGroup", "resources/com/lmsadmin/views/ManageGroupView.fxml");
        loadScene("manageClassroom", "resources/com/lmsadmin/views/ManageClassroomView.fxml");
        loadScene("manageCourse", "resources/com/lmsadmin/views/ManageCourseView.fxml");

        loadScene("manageAdmin", "resources/com/lmsadmin/views/ManageAdminView.fxml");

        setScene("login"); // Set initial scene
        primaryStage.setTitle("LMS Admin");
        primaryStage.show();
    }

    private void loadScene(String name, String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            scenes.put(name, scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setScene(String name) {
        Scene scene = scenes.get(name);
        if (scene != null) {
            primaryStage.setScene(scene);
        } else {
            System.out.println("Scene '" + name + "' not found!");
        }
    }
}
