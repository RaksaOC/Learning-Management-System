package utils.controller.manage_entity_controller;

import org.json.JSONObject;
import ui.UI;
import utils.controller.edit_entity_controller.EditSpecializationController;
import utils.manager.edit_entity_manager.EditSpecializationManager;
import utils.manager.manage_entity_manager.ManageDepartmentManager;
import utils.manager.manage_entity_manager.ManageSpecializationManager;
import utils.menu.Menu;

public class ManageSpecializationController extends ManageEntityController {
    @Override
    public void addEntity() {
        System.out.println(UI.TextColor.addColor(UI.Banner.add, UI.TextColor.YELLOW));
        String id_dep = inputID();
        String name = prompt("Enter Specialization Name");
        String id = prompt("Enter Specialization ID");
        JSONObject newSpecialization = new JSONObject();
        newSpecialization.put("name", name);
        newSpecialization.put("id", id);
        ManageSpecializationManager manageSpecializationManager = new ManageSpecializationManager();
        manageSpecializationManager.manageAddEntity(id_dep, newSpecialization);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    }

    @Override
    public void editEntity() {
        System.out.println(UI.TextColor.addColor(UI.Banner.edit, UI.TextColor.YELLOW));
        Menu menu = new Menu();
        // this menu is the same as the edit department menu (name and id)
        String id_dep = inputID(); // this already valdiates the department id
        String specialization_id = prompt("Enter Specialization ID");
        String choice = menu.showEditDepartmentMenu();

        EditSpecializationController editSpecializationController = new EditSpecializationController(id_dep, specialization_id); // the contrutor to be overloaded with another argument

        while (true) {
            switch (choice) {
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
    public void deleteEntity() {
        System.out.println(UI.TextColor.addColor(UI.Banner.delete, UI.TextColor.YELLOW));
        String id_dep = inputID();
        // need to add specialzation validation
        ManageSpecializationManager manageSpecializationManager = new ManageSpecializationManager();
        String specialization_id = prompt("Enter Specialization ID");
        do {
            specialization_id = prompt("Enter Specialization ID");
            if (manageSpecializationManager.isSpecializationExist(specialization_id)) break;
            else System.out.println(UI.TextColor.addColor("\nInvalid Generation ID\n", UI.TextColor.RED));
        } while (true);

        manageSpecializationManager.manageDeleteEntity(id_dep, specialization_id);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    }


    @Override
    public void viewEntity() {
        System.out.println(UI.TextColor.addColor(UI.Banner.view, UI.TextColor.YELLOW));
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