package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

public class SceneManager extends Application {
    private static Stage primaryStage;
    private static final HashMap<String, Scene> scenes = new HashMap<>();

    @Override
    public void start(Stage stage) {
        primaryStage = stage;

        loadScenes();
        setScene("login"); // Set initial scene
        primaryStage.setTitle("CADT LMS-Admin");
        primaryStage.show();
    }

    private void loadScene(String name, String fxmlPath) {
        try {
            URL resource = getClass().getResource(fxmlPath);
            if (resource == null) {
                throw new IOException("FXML file not found: " + fxmlPath);
            }

            System.out.println("Loading FXML: " + resource);
            FXMLLoader loader = new FXMLLoader(resource);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            scenes.put(name, scene);
        } catch (IOException e) {
            System.err.println("Error loading scene: " + fxmlPath);
            e.printStackTrace();
        }
    }

    private void loadScenes() {
        // layer 0
        loadScene("login", "resources/com/lmsadmin/views/layer0/authenticationView/LogInView2.fxml");
        loadScene("home", "resources/com/lmsadmin/views/layer0/homeView/HomeView.fxml");
        // layer 1
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

        // layer 2

        // Adding
        loadScene("addStudent", "resources/com/lmsadmin/views/layer2/StudentActionView/AddStudentView.fxml");
        loadScene("addTeacher", "resources/com/lmsadmin/views/layer2/TeacherActionView/AddTeacherView.fxml");
        loadScene("addDepartment", "resources/com/lmsadmin/views/layer2/DepartmentActionView/AddDepartmentView.fxml");
        loadScene("addSpecialization", "resources/com/lmsadmin/views/layer2/SpecializationActionView/AddSpecializationView.fxml");
        loadScene("addGeneration", "resources/com/lmsadmin/views/layer2/GenerationActionView/AddGenerationView.fxml");
        loadScene("addGroup", "resources/com/lmsadmin/views/layer2/GroupActionView/AddGroupView.fxml");
        loadScene("addClassroom", "resources/com/lmsadmin/views/layer2/ClassroomActionView/AddClassroomView.fxml");
        loadScene("addCourse", "resources/com/lmsadmin/views/layer2/CourseActionView/AddCourseView.fxml");
        loadScene("addAdmin", "resources/com/lmsadmin/views/layer2/AdminActionView/AddAdminView.fxml");

// Editing
        loadScene("editStudent", "resources/com/lmsadmin/views/layer2/StudentActionView/EditStudentView.fxml");
        loadScene("editTeacher", "resources/com/lmsadmin/views/layer2/TeacherActionView/EditTeacherView.fxml");
        loadScene("editDepartment", "resources/com/lmsadmin/views/layer2/DepartmentActionView/EditDepartmentView.fxml");
        loadScene("editSpecialization", "resources/com/lmsadmin/views/layer2/SpecializationActionView/EditSpecializationView.fxml");
        loadScene("editGeneration", "resources/com/lmsadmin/views/layer2/GenerationActionView/EditGenerationView.fxml");
        loadScene("editGroup", "resources/com/lmsadmin/views/layer2/GroupActionView/EditGroupView.fxml");
        loadScene("editClassroom", "resources/com/lmsadmin/views/layer2/ClassroomActionView/EditClassroomView.fxml");
        loadScene("editCourse", "resources/com/lmsadmin/views/layer2/CourseActionView/EditCourseView.fxml");
        loadScene("editAdmin", "resources/com/lmsadmin/views/layer2/AdminActionView/EditAdminView.fxml");

// Deleting
        loadScene("deleteStudent", "resources/com/lmsadmin/views/layer2/StudentActionView/DeleteStudentView.fxml");
        loadScene("deleteTeacher", "resources/com/lmsadmin/views/layer2/TeacherActionView/DeleteTeacherView.fxml");
        loadScene("deleteDepartment", "resources/com/lmsadmin/views/layer2/DepartmentActionView/DeleteDepartmentView.fxml");
        loadScene("deleteSpecialization", "resources/com/lmsadmin/views/layer2/SpecializationActionView/DeleteSpecializationView.fxml");
        loadScene("deleteGeneration", "resources/com/lmsadmin/views/layer2/GenerationActionView/DeleteGenerationView.fxml");
        loadScene("deleteGroup", "resources/com/lmsadmin/views/layer2/GroupActionView/DeleteGroupView.fxml");
        loadScene("deleteClassroom", "resources/com/lmsadmin/views/layer2/ClassroomActionView/DeleteClassroomView.fxml");
        loadScene("deleteCourse", "resources/com/lmsadmin/views/layer2/CourseActionView/DeleteCourseView.fxml");
        loadScene("deleteAdmin", "resources/com/lmsadmin/views/layer2/AdminActionView/DeleteAdminView.fxml");

// Viewing
        loadScene("viewStudent", "resources/com/lmsadmin/views/layer2/StudentActionView/ViewStudentView.fxml");
        loadScene("viewTeacher", "resources/com/lmsadmin/views/layer2/TeacherActionView/ViewTeacherView.fxml");
        loadScene("viewDepartment", "resources/com/lmsadmin/views/layer2/DepartmentActionView/ViewDepartmentView.fxml");
        loadScene("viewSpecialization", "resources/com/lmsadmin/views/layer2/SpecializationActionView/ViewSpecializationView.fxml");
        loadScene("viewGeneration", "resources/com/lmsadmin/views/layer2/GenerationActionView/ViewGenerationView.fxml");
        loadScene("viewGroup", "resources/com/lmsadmin/views/layer2/GroupActionView/ViewGroupView.fxml");
        loadScene("viewClassroom", "resources/com/lmsadmin/views/layer2/ClassroomActionView/ViewClassroomView.fxml");
        loadScene("viewCourse", "resources/com/lmsadmin/views/layer2/CourseActionView/ViewCourseView.fxml");
        loadScene("viewAdmin", "resources/com/lmsadmin/views/layer2/AdminActionView/ViewAdminView.fxml");


        // layer 3


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
