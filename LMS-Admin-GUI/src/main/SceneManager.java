package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

public class SceneManager extends Application {
    private static Stage primaryStage;
    public static  HashMap<String, Scene> scenes = new HashMap<>();
    private int numOfScenes;

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
            numOfScenes++;
        } catch (IOException e) {
            System.err.println("Error loading scene: " + fxmlPath);
            e.printStackTrace();
        }
    }

    private void loadScenes() {
        // Layer 0
        loadScene("login", "resources/com/lmsAdmin/views/layer0/authenticationView/LogInView2.fxml");
        loadScene("home", "resources/com/lmsAdmin/views/layer0/homeView/HomeView.fxml");

// Layer 1
        loadScene("dashboard", "resources/com/lmsAdmin/views/layer1/DashboardView.fxml");
        loadScene("manageStudent", "resources/com/lmsAdmin/views/layer1/ManageStudentView.fxml");
        loadScene("manageTeacher", "resources/com/lmsAdmin/views/layer1/ManageTeacherView.fxml");
        loadScene("manageDepartment", "resources/com/lmsAdmin/views/layer1/ManageDepartmentView.fxml");
        loadScene("manageSpecialization", "resources/com/lmsAdmin/views/layer1/ManageSpecializationView.fxml");
        loadScene("manageGeneration", "resources/com/lmsAdmin/views/layer1/ManageGenerationView.fxml");
        loadScene("manageGroup", "resources/com/lmsAdmin/views/layer1/ManageGroupView.fxml");
        loadScene("manageClassroom", "resources/com/lmsAdmin/views/layer1/ManageClassroomView.fxml");
        loadScene("manageCourse", "resources/com/lmsAdmin/views/layer1/ManageCourseView.fxml");
        loadScene("manageAdmin", "resources/com/lmsAdmin/views/layer1/ManageAdminView.fxml");

// Layer 2 - Student
        loadScene("addStudent", "resources/com/lmsAdmin/views/layer2/StudentActionView/AddStudentView.fxml");
        loadScene("editStudent", "resources/com/lmsAdmin/views/layer2/StudentActionView/EditStudentView.fxml");
        loadScene("deleteStudent", "resources/com/lmsAdmin/views/layer2/StudentActionView/DeleteStudentView.fxml");
        loadScene("viewStudent", "resources/com/lmsAdmin/views/layer2/StudentActionView/ViewStudentView.fxml");

// Layer 2 - Teacher
        loadScene("addTeacher", "resources/com/lmsAdmin/views/layer2/TeacherActionView/AddTeacherView.fxml");
        loadScene("editTeacher", "resources/com/lmsAdmin/views/layer2/TeacherActionView/EditTeacherView.fxml");
        loadScene("deleteTeacher", "resources/com/lmsAdmin/views/layer2/TeacherActionView/DeleteTeacherView.fxml");
        loadScene("viewTeacher", "resources/com/lmsAdmin/views/layer2/TeacherActionView/ViewTeacherView.fxml");

// Layer 2 - Department
        loadScene("addDepartment", "resources/com/lmsAdmin/views/layer2/DepartmentActionView/AddDepartmentView.fxml");
        loadScene("editDepartment", "resources/com/lmsAdmin/views/layer2/DepartmentActionView/EditDepartmentView.fxml");
        loadScene("deleteDepartment", "resources/com/lmsAdmin/views/layer2/DepartmentActionView/DeleteDepartmentView.fxml");
        loadScene("viewDepartment", "resources/com/lmsAdmin/views/layer2/DepartmentActionView/ViewDepartmentView.fxml");

// Layer 2 - Specialization
        loadScene("addSpecialization", "resources/com/lmsAdmin/views/layer2/SpecializationActionView/AddSpecializationView.fxml");
        loadScene("editSpecialization", "resources/com/lmsAdmin/views/layer2/SpecializationActionView/EditSpecializationView.fxml");
        loadScene("deleteSpecialization", "resources/com/lmsAdmin/views/layer2/SpecializationActionView/DeleteSpecializationView.fxml");
        loadScene("viewSpecialization", "resources/com/lmsAdmin/views/layer2/SpecializationActionView/ViewSpecializationView.fxml");

// Layer 2 - Generation
        loadScene("addGeneration", "resources/com/lmsAdmin/views/layer2/GenerationActionView/AddGenerationView.fxml");
        loadScene("editGeneration", "resources/com/lmsAdmin/views/layer2/GenerationActionView/EditGenerationView.fxml");
        loadScene("deleteGeneration", "resources/com/lmsAdmin/views/layer2/GenerationActionView/DeleteGenerationView.fxml");
        loadScene("viewGeneration", "resources/com/lmsAdmin/views/layer2/GenerationActionView/ViewGenerationView.fxml");

// Layer 2 - Group
        loadScene("addGroup", "resources/com/lmsAdmin/views/layer2/GroupActionView/AddGroupView.fxml");
        loadScene("editGroup", "resources/com/lmsAdmin/views/layer2/GroupActionView/EditGroupView.fxml");
        loadScene("deleteGroup", "resources/com/lmsAdmin/views/layer2/GroupActionView/DeleteGroupView.fxml");
        loadScene("viewGroup", "resources/com/lmsAdmin/views/layer2/GroupActionView/ViewGroupView.fxml");
        loadScene("addStudentToGroup", "resources/com/lmsAdmin/views/layer2/GroupActionView/AddStudentToGroupView.fxml");


// Layer 2 - Classroom
        loadScene("addClassroom", "resources/com/lmsAdmin/views/layer2/ClassroomActionView/AddClassroomView.fxml");
        loadScene("editClassroom", "resources/com/lmsAdmin/views/layer2/ClassroomActionView/EditClassroomView.fxml");
        loadScene("deleteClassroom", "resources/com/lmsAdmin/views/layer2/ClassroomActionView/DeleteClassroomView.fxml");
        loadScene("viewClassroom", "resources/com/lmsAdmin/views/layer2/ClassroomActionView/ViewClassroomView.fxml");
        loadScene("assignTeacherToClassroom", "resources/com/lmsAdmin/views/layer2/ClassroomActionView/AssignTeacherToClassroomView.fxml");
        loadScene("assignCourseToClassroom", "resources/com/lmsAdmin/views/layer2/ClassroomActionView/AssignCourseToClassroomView.fxml");

// Layer 2 - Course
        loadScene("addCourse", "resources/com/lmsAdmin/views/layer2/CourseActionView/AddCourseView.fxml");
        loadScene("editCourse", "resources/com/lmsAdmin/views/layer2/CourseActionView/EditCourseView.fxml");
        loadScene("deleteCourse", "resources/com/lmsAdmin/views/layer2/CourseActionView/DeleteCourseView.fxml");
        loadScene("viewCourse", "resources/com/lmsAdmin/views/layer2/CourseActionView/ViewCourseView.fxml");

// Layer 2 - Admin
        loadScene("addAdmin", "resources/com/lmsAdmin/views/layer2/AdminActionView/AddAdminView.fxml");
        loadScene("editAdmin", "resources/com/lmsAdmin/views/layer2/AdminActionView/EditAdminView.fxml");
        loadScene("deleteAdmin", "resources/com/lmsAdmin/views/layer2/AdminActionView/DeleteAdminView.fxml");
        loadScene("viewAdmin", "resources/com/lmsAdmin/views/layer2/AdminActionView/ViewAdminView.fxml");

        // layer 3

        // StudentEditView
        loadScene("editStudentAddress", "resources/com/lmsAdmin/views/layer3/StudentEditView/EditStudentAddress.fxml");
        loadScene("editStudentDOB", "resources/com/lmsAdmin/views/layer3/StudentEditView/EditStudentDOB.fxml");
        loadScene("editStudentDepartment", "resources/com/lmsAdmin/views/layer3/StudentEditView/EditStudentDepartment.fxml");
        loadScene("editStudentEmail", "resources/com/lmsAdmin/views/layer3/StudentEditView/EditStudentEmail.fxml");
        loadScene("editStudentGender", "resources/com/lmsAdmin/views/layer3/StudentEditView/EditStudentGender.fxml");
        loadScene("editStudentGuardian", "resources/com/lmsAdmin/views/layer3/StudentEditView/EditStudentGuardian.fxml");
        loadScene("editStudentName", "resources/com/lmsAdmin/views/layer3/StudentEditView/EditStudentName.fxml");
        loadScene("editStudentPassword", "resources/com/lmsAdmin/views/layer3/StudentEditView/EditStudentPassword.fxml");
        loadScene("editStudentPhoneNumber", "resources/com/lmsAdmin/views/layer3/StudentEditView/EditStudentPhoneNumber.fxml");
        loadScene("editStudentSpecialization", "resources/com/lmsAdmin/views/layer3/StudentEditView/EditStudentSpecialization.fxml");

        // TeacherEditView
        loadScene("editTeacherDOB", "resources/com/lmsAdmin/views/layer3/TeacherEditView/EditTeacherDOB.fxml");
        loadScene("editTeacherEmail", "resources/com/lmsAdmin/views/layer3/TeacherEditView/EditTeacherEmail.fxml");
        loadScene("editTeacherGender", "resources/com/lmsAdmin/views/layer3/TeacherEditView/EditTeacherGender.fxml");
        loadScene("editTeacherName", "resources/com/lmsAdmin/views/layer3/TeacherEditView/EditTeacherName.fxml");
        loadScene("editTeacherPassword", "resources/com/lmsAdmin/views/layer3/TeacherEditView/EditTeacherPassword.fxml");
        loadScene("editTeacherPhoneNumber", "resources/com/lmsAdmin/views/layer3/TeacherEditView/EditTeacherPhoneNumber.fxml");

// DepartmentEditView
        loadScene("editDepartmentID", "resources/com/lmsAdmin/views/layer3/DepartmentEditView/EditDepartmentID.fxml");
        loadScene("editDepartmentName", "resources/com/lmsAdmin/views/layer3/DepartmentEditView/EditDepartmentName.fxml");

        // SpecializationEditView
        loadScene("editSpecializationID", "resources/com/lmsAdmin/views/layer3/SpecializationEditView/EditSpecializationID.fxml");
        loadScene("editSpecializationName", "resources/com/lmsAdmin/views/layer3/SpecializationEditView/EditSpecializationName.fxml");

        // GenerationEditView
        loadScene("editGenerationID", "resources/com/lmsAdmin/views/layer3/GenerationEditView/EditGenerationID.fxml");
        loadScene("editGenerationName", "resources/com/lmsAdmin/views/layer3/GenerationEditView/EditGenerationName.fxml");

        // GroupEditView
        loadScene("editGroupID", "resources/com/lmsAdmin/views/layer3/GroupEditView/EditGroupID.fxml");

// ClassroomEditView
        loadScene("editClassroomID", "resources/com/lmsAdmin/views/layer3/ClassroomEditView/EditClassroomID.fxml");

// CourseEditView
        loadScene("editCourseID", "resources/com/lmsAdmin/views/layer3/CourseEditView/EditCourseID.fxml");
        loadScene("editCourseName", "resources/com/lmsAdmin/views/layer3/CourseEditView/EditCourseName.fxml");

        // AdminEditView
        loadScene("editAdminDOB", "resources/com/lmsAdmin/views/layer3/AdminEditView/EditAdminDOB.fxml");
        loadScene("editAdminEmail", "resources/com/lmsAdmin/views/layer3/AdminEditView/EditAdminEmail.fxml");
        loadScene("editAdminGender", "resources/com/lmsAdmin/views/layer3/AdminEditView/EditAdminGender.fxml");
        loadScene("editAdminName", "resources/com/lmsAdmin/views/layer3/AdminEditView/EditAdminName.fxml");
        loadScene("editAdminPassword", "resources/com/lmsAdmin/views/layer3/AdminEditView/EditAdminPassword.fxml");
        loadScene("editAdminPhoneNumber", "resources/com/lmsAdmin/views/layer3/AdminEditView/EditAdminPhoneNumber.fxml");

        // misc
        loadScene("success", "resources/com/lmsAdmin/views/misc/SuccessView.fxml");

        System.out.println("Finished loading " + numOfScenes + " scenes");
    }

    public static void setScene(String name) {
        Scene scene = scenes.get(name);
        if (scene != null) {
            Rectangle2D screenBounds = Screen.getPrimary().getBounds();
            primaryStage.setScene(scene);
            primaryStage.setWidth(screenBounds.getWidth());
            primaryStage.setHeight(screenBounds.getHeight());
            System.out.println("Scene " + name + " loaded");
        } else {
            System.out.println("Scene '" + name + "' not found!");
        }
    }


}
