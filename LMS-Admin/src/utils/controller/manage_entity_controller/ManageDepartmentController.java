package utils.controller.manage_entity_controller;

import org.json.JSONObject;
import ui.UI;
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
        System.out.println(UI.TextColor.addColor(UI.Banner.add, UI.TextColor.YELLOW));
        String name = prompt("Enter Department Name:");
        String id = prompt("Enter Department ID:");
        JSONObject dep = new JSONObject();
        dep.put("name", name);
        dep.put("id", id);
        manager.manageAddEntity(dep);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    }

    @Override
    public void editEntity() {
        System.out.println(UI.TextColor.addColor(UI.Banner.edit, UI.TextColor.YELLOW));
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
        System.out.println(UI.TextColor.addColor(UI.Banner.delete, UI.TextColor.YELLOW));
        String id;
        while (true) {
            id = prompt("Enter Department ID:");
            if (manager.isDepartmentExist(id)) {
                break;
            }
        }
        manager.manageDeleteEntity(id);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    }

    @Override
    public void viewEntity() {
        System.out.println(UI.TextColor.addColor(UI.Banner.view, UI.TextColor.YELLOW));
        System.out.println("got to view entity of controller");
        manager.manageViewEntity();
    }

}