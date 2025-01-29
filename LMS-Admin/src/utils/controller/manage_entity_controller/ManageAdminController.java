package utils.controller.manage_entity_controller;

import lib.Hasher;
import org.json.JSONObject;
import ui.UI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import utils.controller.edit_entity_controller.EditAdminController;
import utils.manager.edit_entity_manager.EditAdminManager;
import utils.manager.manage_entity_manager.ManageAdminManager;
import utils.menu.Menu;

public class ManageAdminController extends ManageEntityController {
    ManageAdminManager manager;
    Scanner sc = new Scanner(System.in);

    public ManageAdminController() {
        manager = new ManageAdminManager();
    }

    @Override
    public void addEntity() {
        System.out.println(UI.TextColor.addColor(UI.Banner.add, UI.TextColor.YELLOW));
        String name;
        String email;
        String phoneNumber;
        String password;

        name = prompt("Enter Name");
        email = prompt("Enter Email");
        phoneNumber = prompt("Enter Phone Number");
        password = prompt("Enter Password");

        boolean isSame = false;
        do {
            String passwordConfirm = prompt("Enter Password Confirm");
            if (password.equals(passwordConfirm)) {
                isSame = true;
            } else {
                System.out.println(UI.TextColor.addColor("\nPasswords do not match\n", UI.TextColor.RED));
            }
        } while (!isSame);

        String hashedPassword = Hasher.hash(password);

        LocalDateTime now = LocalDateTime.now();

        // Format the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = now.format(formatter);

        JSONObject newAdmin = new JSONObject();
        newAdmin.put("name", name);
        newAdmin.put("email", email);
        newAdmin.put("phoneNumber", phoneNumber);
        newAdmin.put("password", hashedPassword);
        newAdmin.put("createdAt", formattedDate);
        newAdmin.put("lastLogin", "");
        // new id generation handled by manager

        // call to manager
        manager.manageAddEntity(newAdmin);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    }

    @Override
    public void editEntity() {
        System.out.println(UI.TextColor.addColor(UI.Banner.edit, UI.TextColor.YELLOW));
        EditAdminManager editAdminManager;
        boolean isExist = false;

        String adminID;
        do{
            adminID = prompt("Enter Admin ID");
            editAdminManager = new EditAdminManager(adminID);
            if(editAdminManager.isEntityIDExist(adminID)){
                isExist = true;
                break;
            }
            else{
                System.out.println(UI.TextColor.addColor("\nInvalid ID\n", UI.TextColor.RED));
            }
        }while(isExist);

        EditAdminController editAdminController = new EditAdminController(adminID);
        Menu menu = new Menu();
        if (isExist) {
            String choice = menu.showEditAdminMenu();
            switch (choice) {
                case "1":
                    editAdminController.editName();
                    break;
                case "2":
                    editAdminController.editPhone();
                    break;
                case "3":
                    editAdminController.editEmail();
                    break;
                case "4":
                    editAdminController.editPassword();
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
        do{
            String adminID = prompt("Enter Admin ID");

            // manage for that id, one call for validation check. will be called later within edit admin controller
            EditAdminManager editAdminManager = new EditAdminManager(adminID);

            if (editAdminManager.isEntityIDExist(adminID)) {
                manager.manageDeleteEntity(adminID);
                String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
                System.out.println(successBanner);
                return;
            }
            else{
                System.out.println(UI.TextColor.addColor("\nInvalid admin ID\n", UI.TextColor.RED));
            }
        }while(true);
    }

    @Override
    public void viewEntity() {
        System.out.println(UI.TextColor.addColor(UI.Banner.view, UI.TextColor.YELLOW));
        manager.manageViewEntity();
    }

}