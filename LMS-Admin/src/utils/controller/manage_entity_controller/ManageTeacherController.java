package utils.controller.manage_entity_controller;

import lib.Hasher;
import org.json.JSONArray;
import org.json.JSONObject;
import ui.UI;
import utils.menu.Menu;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import utils.manager.manage_entity_manager.ManageTeacherManager;
import utils.manager.edit_entity_manager.EditTeacherManager;
import utils.controller.edit_entity_controller.EditTeacherController;

import java.util.ArrayList;

public class ManageTeacherController extends ManageEntityController {
    ManageTeacherManager manager;

    public ManageTeacherController() {
        manager = new ManageTeacherManager();
    }

    @Override
    public void addEntity() {
        System.out.println(UI.TextColor.addColor(UI.Banner.add, UI.TextColor.YELLOW));

        JSONObject newTeacher = createNewTeacherObject();
        manager.manageAddEntity(newTeacher);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    }

    @Override
    public void deleteEntity() {
        System.out.println(UI.TextColor.addColor(UI.Banner.delete, UI.TextColor.YELLOW));
        do {
            String teacherID = prompt("Enter Teacher ID");

            // manage for that id, one call for validation check. will be called later within edit controller
            EditTeacherManager editTeacherManager = new EditTeacherManager(teacherID);

            if (editTeacherManager.isEntityIDExist(teacherID)) {
                manager.manageDeleteEntity(teacherID);
                String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
                System.out.println(successBanner);
                return;
            } else {
                System.out.println(UI.TextColor.addColor("\nInvalid Teacher ID\n", UI.TextColor.RED));
            }
        } while (true);
    }

    @Override
    public void editEntity() {
        System.out.println(UI.TextColor.addColor(UI.Banner.edit, UI.TextColor.YELLOW));
        EditTeacherManager editTeacherManager;

        boolean isExist = false;

        String studentID;
        do {
            studentID = prompt("Enter Student ID");
            editTeacherManager = new EditTeacherManager(studentID);
            // call to manager for validation
            if (editTeacherManager.isEntityIDExist(studentID)) {
                isExist = true;
                break;
            } else {
                System.out.println(UI.TextColor.addColor("\nInvalid ID\n", UI.TextColor.RED));
            }
        } while (isExist);

        EditTeacherController editTeacherController = new EditTeacherController(studentID);
        Menu menu = new Menu();

        if (isExist) {
            String choice = menu.showManageTeachersMenu();
            while (true) {
                switch (choice) {
                    case "1":
                        editTeacherController.editName();
                        break;
                    case "2":
                        editTeacherController.editPhone();
                        break;
                    case "3":
                        editTeacherController.editEmail();
                        break;
                    case "4":
                        editTeacherController.editPassword();
                        break;
                    case "5":
                        editTeacherController.editGender();
                        break;
                    case "6":
                        editTeacherController.editDoB();
                        break;
                }
                choice = menu.showManageTeachersMenu();
            }

        }
    }

    @Override
    public void viewEntity() {
        manager.manageViewEntity();
    }

    private JSONObject createNewTeacherObject() {
        String firstName;
        String lastName;
        String gender;
        String dob;
        String email;
        String phoneNumber;
        String password;

        firstName = prompt("Enter First Name");
        lastName = prompt("Enter Last Name");
        gender = prompt("Enter Gender");
        dob = prompt("Enter Data of Birth");
        email = prompt("Enter Email");
        phoneNumber = prompt("Enter Phone Number");

        password = prompt("Create Password for Teacher");

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

        JSONObject newTeacher = new JSONObject();

        JSONObject nameObj = new JSONObject();
        nameObj.put("firstName", firstName);
        nameObj.put("lastName", lastName);

        newTeacher.put("name", nameObj);
        newTeacher.put("gender", gender);
        newTeacher.put("email", email);
        newTeacher.put("dob", dob);
        newTeacher.put("phoneNumber", phoneNumber);
        newTeacher.put("password", hashedPassword);
        newTeacher.put("createdAt", formattedDate);
        newTeacher.put("classrooms", new JSONArray());
        newTeacher.put("lastLogin", "");
        newTeacher.put("status", "active");

        return newTeacher;
    }
}
