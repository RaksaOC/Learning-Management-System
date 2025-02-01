package utils.controller.manage_entity_controller;

import org.json.JSONObject;
import utils.manager.manage_entity_manager.ManageDepartmentManager;
import utils.menu.Menu;

import utils.controller.edit_entity_controller.EditDepartmentController;

public class ManageDepartmentController extends ManageEntityController {

    ManageDepartmentManager manager;

    public ManageDepartmentController() {
        manager = new ManageDepartmentManager();
    }

    @Override
    public void addEntity() {
        String name = prompt("Enter Department Name:");
        String id = prompt("Enter Department ID:");
        JSONObject dep = new JSONObject();
        dep.put("name", name);
        dep.put("id", id);
        manager.manageAddEntity(dep);
    }

    @Override
    public void editEntity() {
        String id;
        boolean isExist = false;
        do {
            id = prompt("Enter Department ID:");
            if (manager.isDepartmentExist(id)) {
                isExist = true;
            }
        } while (!isExist);

        Menu menu = new Menu();
        EditDepartmentController editDepartmentController = new EditDepartmentController(id);
        while (true) {
            String choice = menu.showEditDepartmentMenu();
            switch (choice) {
                case "1":
                    editDepartmentController.editName();
                    break;
                case "2":
                    editDepartmentController.editID();
                    break;
                case "-b":
                    return;
                default:
                    break;
            }
        }

    }

    @Override
    public void deleteEntity() {
        String id;
        while (true) {
            id = prompt("Enter Department ID:");
            if (manager.isDepartmentExist(id)) {
                break;
            }
        }
        manager.manageDeleteEntity(id);
    }

    @Override
    public void viewEntity() {
        System.out.println("got to view entity of controller");
        manager.manageViewEntity();
    }

    ;

    public void manageSpecialization() {
        Menu menu = new Menu();
        ManageSpecializationController manageSpecilizationController = new ManageSpecializationController();
        while (true) {
            String choice = menu.showManageSpecializationsMenu();
            switch (choice) {
                case "1":
                    manageSpecilizationController.addEntity();
                    break;
                case "2":
                    manageSpecilizationController.editEntity();
                    break;
                case "3":
                    manageSpecilizationController.deleteEntity();
                    break;
                case "4":
                    manageSpecilizationController.viewEntity();
                    break;
                case "-b":
                    return;
                default:
                    break;
            }
        }

    }

    ;
}