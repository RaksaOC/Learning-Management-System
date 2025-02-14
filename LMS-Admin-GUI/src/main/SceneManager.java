package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class SceneManager extends Application {
    private static Stage primaryStage;
    private static final HashMap<String, Scene> scenes = new HashMap<>();

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        loadScene("login", "resources/com/lmsadmin/views/layer0/authenticationView/LogInView2.fxml");
        loadScene("home", "resources/com/lmsadmin/views/layer0/homeView/HomeView.fxml");
        loadScene("dashboard", "resources/com/lmsadmin/views/layer1/DashboardView.fxml");
        loadScene("manageStudent", "resources/com/lmsadmin/views/layer1/ManageStudentView.fxml");
        loadScene("manageTeacher", "resources/com/lmsadmin/views/layer1/ManageTeacherView.fxml");
        loadScene("manageDepartment", "resources/com/lmsadmin/views/layer1/ManageDepartmentView.fxml");
        loadScene("manageSpecialization", "resources/com/lmsadmin/views/layer1/ManageSpecializationView.fxml");
        loadScene("manageGeneration", "resources/com/lmsadmin/views/layer1/ManageGenerationView.fxml");
        loadScene("manageGroup", "resources/com/lmsadmin/views/layer1/ManageGroupView.fxml");
        loadScene("manageClassroom", "resources/com/lmsadmin/views/layer1/ManageClassroomView.fxml");
        loadScene("manageCourse", "resources/com/lmsadmin/views/layer1/ManageCourseView.fxml");
        loadScene("manageAdmin", "resources/com/lmsadmin/views/layer1/ManageAdminView.fxml");

        setScene("login"); // Set initial scene
        primaryStage.setTitle("CADT LMS-Admin");
        primaryStage.show();
    }

    private void loadScene(String name, String fxmlPath) {
        try {
//            System.out.println(getClass().getResource(fxmlPath));  // Check if it prints `null`
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            scenes.put(name, scene);
        } catch (IOException e) {
            System.out.println("Error loading scene path" + fxmlPath);
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
