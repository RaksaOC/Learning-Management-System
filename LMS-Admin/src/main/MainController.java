package main;

import utils.controller.authentication_controller.AuthenticationController;
import utils.controller.manage_entity_controller.*;
import utils.manager.manage_entity_manager.ManageDepartmentManager;
import utils.menu.Menu;

public class MainController {
    private final Menu menu;
    private String choice;

    public MainController() {
        this.menu = new Menu();
    }

    // begin the program (step 1)
    public void run() {
        AuthenticationController authenticationController = new AuthenticationController();
        boolean isAuthenticated;
        isAuthenticated = authenticationController.authenticateUser();
        while (isAuthenticated) {
            choice = menu.showMainMenu();
            switch (choice) {
                case "1":
                    handleManageUser();
                    break;
                case "2":
                    handleManageUniversity();
                    break;
                case "3":
                    handleManageAdmin();
                    break;
                case "4":
                    handleExit();
                    break;
                case "-b":
                    isAuthenticated = authenticationController.authenticateUser();
                    break;
                default:
                    break;
            }
        }
    }

    // step 2
    private void handleManageUser() {
        while (true) {
            choice = menu.showManageUsersMenu();
            switch (choice) {
                case "1":
                    handleManageStudentMenu();
                    break;
                case "2":
                    handleManageTeacherMenu();
                    break;
                case "-b":
                    return;
                default:
                    break;
            }
        }
    }

    private void handleManageUniversity() {
        while (true) {
            choice = menu.showManageUniversityMenu();
            switch (choice) {
                case "1":
                    handleManageGenerationMenu();
                    break;
                case "2":
                    handleManageDepartmentMenu();
                    break;
                case "3":
                    handleManageSpecialization();
                    break;
                case "4":
                    handleManageGroup();
                    break;
                case "5":
                    handleManageClassroom();
                case "-b":
                    return;
                default:
                    break;
            }
        }
    }

    private void handleExit() {
        System.exit(0);
    }

    // step 3 (actions) -> delegate actions to respective controllers

    private void handleManageStudentMenu() {
        choice = menu.showManageStudentsMenu();
        ManageStudentController manageStudentController = new ManageStudentController();
        while (true) {
            switch (choice) {
                case "1":
                    manageStudentController.addEntity();
                    break;
                case "2":
                    manageStudentController.editEntity();
                    break;
                case "3":
                    manageStudentController.deleteEntity();
                    break;
                case "4":
                    manageStudentController.viewEntity();
                    break;
                case "-b":
                    return;
                default:
                    break;
            }
            choice = menu.showManageStudentsMenu();
        }

    }

    private void handleManageTeacherMenu() {
        ManageTeacherController manageTeacherController = new ManageTeacherController();
        choice = menu.showManageTeachersMenu();
        while (true) {
            switch (choice) {
                case "1":
                    manageTeacherController.addEntity();
                    break;
                case "2":
                    manageTeacherController.assignTeacherToCourse();
                    break;
                case "3":
                    manageTeacherController.editEntity();
                    break;
                case "4":
                    manageTeacherController.deleteEntity();
                    break;
                case "5":
                    manageTeacherController.viewEntity();
                case "-b":
                    return;
                default:
                    break;
            }
            choice = menu.showManageTeachersMenu();
        }
    }

    private void handleManageGenerationMenu() {
        choice = menu.showManageGenerationMenu();
        ManageGenerationController manageGenerationController = new ManageGenerationController();
        while (true) {
            switch (choice) {
                case "1":
                    manageGenerationController.addEntity();
                    break;
                case "2":
                    manageGenerationController.editEntity();
                    break;
                case "3":
                    manageGenerationController.deleteEntity();
                    break;
                case "4":
                    manageGenerationController.viewEntity();
                    break;
                case "-b":
                    return;
                default:
                    break;
            }
            choice = menu.showManageGenerationMenu();
        }
    }

    private void handleManageDepartmentMenu() {
        choice = menu.showManageDepartmentsMenu();
        ManageDepartmentController manageDepartmentController = new ManageDepartmentController();
        while (true) {
            switch (choice) {
                case "1":
                    manageDepartmentController.addEntity();
                    break;
                case "2":
                    manageDepartmentController.editEntity();
                    break;
                case "3":
                    manageDepartmentController.deleteEntity();
                    break;
                case "4":
                    manageDepartmentController.viewEntity();
                    break;
                case "-b":
                    return;
                default:
                    break;
            }
            choice = menu.showManageDepartmentsMenu();
        }
    }

    private void handleManageSpecialization() {

        ManageSpecializationController manageSpecializationController = new ManageSpecializationController();

        // for department id validation
        ManageDepartmentManager manageDepartmentManager = new ManageDepartmentManager();
        choice = menu.showManageSpecializationsMenu();
        switch (choice) {
            case "1":
                manageSpecializationController.addEntity();
                break;
            case "2":
                manageSpecializationController.editEntity();
                break;
            case "3":
                manageSpecializationController.deleteEntity();
                break;
            case "4":
                manageSpecializationController.viewEntity();
                break;
            case "-b":
                return;
            default:
                break;
        }
    }

    private void handleManageAdmin() {
        choice = menu.showManageAdminsMenu();
        ManageAdminController manageAdminController = new ManageAdminController();
        while (true) {
            switch (choice) {
                case "1":
                    manageAdminController.addEntity();
                    break;
                case "2":
                    // this is another submenu handled by the editAdminController which calls to its respective manager
                    manageAdminController.editEntity();
                    break;
                case "3":
                    manageAdminController.deleteEntity();
                    break;
                case "4":
                    manageAdminController.viewEntity();
                    break;
                case "-b":
                    return;
                default:
                    break;
            }
            choice = menu.showManageAdminsMenu();
        }

    }

    private void handleManageGroup() {
        choice = menu.showManageGroupMenu();
        ManageGroupController manageGroupController = new ManageGroupController();
        while (true) {
            switch (choice) {
                case "1":
                    manageGroupController.addEntity();
                    break;
                case "2":
                    manageGroupController.editEntity();
                    break;
                case "3":
                    manageGroupController.deleteEntity();
                    break;
                case "4":
                    manageGroupController.viewEntity();
                    break;
                case "5":
                    manageGroupController.addStudentsToGroup();
                    break;
                case "-b":
                    return;
                default:
                    break;
            }
            choice = menu.showManageGroupMenu();
        }
    }

    private void handleManageClassroom() {
        choice = menu.showManageClassroomsMenu();
        ManageClassroomController manageClassroomController = new ManageClassroomController();
        while (true) {
            switch (choice) {
                case "1":
                    manageClassroomController.addEntity();
                    break;
                case "2":
                    manageClassroomController.editEntity();
                    break;
                case "3":
                    manageClassroomController.deleteEntity();
                    break;
                case "4":
                    manageClassroomController.viewEntity();
                    break;
                case "5":
                    manageClassroomController.assignTeacherToClassroom();
                    break;
                case "6":
                    manageClassroomController.assignCourseToClassroom();
                    break;
                case "-b":
                    return;
                default:
                    break;
            }
            choice = menu.showManageClassroomsMenu();
        }
    }
}