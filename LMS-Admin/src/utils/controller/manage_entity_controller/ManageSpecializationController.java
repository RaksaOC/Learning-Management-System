package utils.controller.manage_entity_controller;

import org.json.JSONObject;
import utils.controller.edit_entity_controller.EditSpecializationController;
import utils.manager.manage_entity_manager.ManageDepartmentManager;
import utils.manager.manage_entity_manager.ManageSpecializationManager;
import utils.menu.Menu;

public class ManageSpecializationController extends ManageEntityController {
    @Override
    public void addEntity() {
        String id_dep = inputID();
        String name = prompt("Enter Specialization Name");
        String id = prompt("Enter Specialization ID");
        JSONObject newSpecialization = new JSONObject();
        newSpecialization.put("name", name);
        newSpecialization.put("id", id);
        ManageSpecializationManager manageSpecializationManager = new ManageSpecializationManager();
        manageSpecializationManager.manageAddEntity(id_dep, newSpecialization);
    }

    @Override
    public void deleteEntity() {
        String id_dep = inputID();
        // need to add specialzation validation
        String specialization_id = prompt("Enter Specialization ID");
        ManageSpecializationManager manageSpecializationManager = new ManageSpecializationManager();
        manageSpecializationManager.manageDeleteEntity(id_dep, specialization_id);
    }

    @Override
    public void editEntity() {
        Menu menu = new Menu();
        // this menu is the same as the edit department menu (name and id)
        String id_dep = inputID();
        String specialization_id = prompt("Enter Specialization ID");
        String choice = menu.showEditDepartmentMenu();

        EditSpecializationController editSpecializationController = new EditSpecializationController(id_dep, specialization_id); // the contrutor to be overloaded with another argument

        while (true) {
            switch (choice){
                case "1":
                    editSpecializationController.editName();
                    break;
                case "2":
                    editSpecializationController.editID();
                    break;
                case "-b":
                    return;
                default:
                    break;
            }
            choice = menu.showEditDepartmentMenu();
        }
    }

    @Override
    public void viewEntity() {
        String dep_id = inputID();
        ManageSpecializationManager manageSpecializationManager = new ManageSpecializationManager();
        manageSpecializationManager.manageViewEntity(dep_id);
    }

    private String inputID() {
        boolean isExist = false;
        String id;
        ManageDepartmentManager manageDepartmentManager;
        do {
            id = prompt("Enter Department ID");
            manageDepartmentManager = new ManageDepartmentManager();
            if (manageDepartmentManager.isDepartmentExist(id)) {
                isExist = true;
            } else {
                System.out.println("Department does not exist");
            }
        } while (!isExist);
        return id;
    }
}