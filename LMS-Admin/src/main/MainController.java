package main;

import utils.controller.authentication_controller.AuthenticationController;
import utils.controller.manage_entity_controller.*;
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
                    manageStudentController.addStudent();
                    break;
                case "2":
                    manageStudentController.editStudent();
                    break;
                case "3":
                    manageStudentController.deleteStudent();
                    break;
                case "-b":
                    return;
                default:
                    break;
            }
        }

    }

    private void handleManageTeacherMenu() {
        choice = menu.showManageTeachersMenu();
        ManageTeacherController manageTeacherController = new ManageTeacherController();
        while (true) {
            switch (choice) {
                case "1":
                    manageTeacherController.addTeacher();
                    break;
                case "2":
                    manageTeacherController.editTeacher();
                    break;
                case "3":
                    manageTeacherController.deleteTeacher();
                    break;
                case "-b":
                    return;
                default:
                    break;
            }
        }
    }

    private void handleManageGenerationMenu() {
        choice = menu.showManageGenerationMenu();
        ManageGenerationController manageGenerationController = new ManageGenerationController();
        while (true) {
            switch (choice) {
                case "1":
                    manageGenerationController.addGeneration();
                    break;
                case "2":
                    manageGenerationController.viewGenerations();
                    break;
                case "3":
                    manageGenerationController.editGeneration();
                    break;
                case "-b":
                    return;
                default:
                    break;
            }
        }
    }

    private void handleManageDepartmentMenu() {
        choice = menu.showManageDepartmentsMenu();
        ManageDepartmentController manageDepartmentController = new ManageDepartmentController();
        while (true) {
            switch (choice) {
                case "1":
                    manageDepartmentController.addDepartment();
                    break;
                case "2":
                    manageDepartmentController.editDepartment();
                    break;
                case "3":
                    manageDepartmentController.deleteDepartment();
                    break;
                case "4":
                    manageDepartmentController.viewDepartments();
                    break;
                case "5":
                    manageDepartmentController.manageSpecialization();
                case "-b":
                    return;
                default:
                    break;
            }
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
}