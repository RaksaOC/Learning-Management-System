package utils.controller.edit_entity_controller;

import lib.Hasher;
import org.json.JSONObject;
import ui.UI;
import utils.manager.edit_entity_manager.EditTeacherManager;

public class EditTeacherController extends EditEntityController {
    private EditTeacherManager editTeacherManager;

    public EditTeacherController(String idToEdit) {
        super(idToEdit);
        editTeacherManager = new EditTeacherManager(idToEdit);
    }

    @Override
    public void editName() {
        System.out.println(UI.TextColor.addColor(UI.Banner.editName, UI.TextColor.YELLOW));
        System.out.println(UI.TextColor.addColor("Old name: ", UI.TextColor.GREEN) + UI.TextColor.addColor(editTeacherManager.getOldName(), UI.TextColor.WHITE));
        String newFirstName = prompt("Enter new Old name");
        String newLastName = prompt("Enter new Last name");
        JSONObject obj = new JSONObject();
        obj.put("newFirstName", newFirstName);
        obj.put("newLastName", newLastName);

        editTeacherManager.setNewName(obj);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    }

    @Override
    public void editPhone() {
        System.out.println(UI.TextColor.addColor(UI.Banner.editPhone, UI.TextColor.YELLOW));
        System.out.println(UI.TextColor.addColor("Old Phone Number: ", UI.TextColor.GREEN) + UI.TextColor.addColor(editTeacherManager.getOldPhone(), UI.TextColor.WHITE));
        String newPhone = prompt("Enter new Phone Number");
        editTeacherManager.setNewPhone(newPhone);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    }


    @Override
    public void editEmail() {
        System.out.println(UI.TextColor.addColor(UI.Banner.editEmail, UI.TextColor.YELLOW));
        System.out.println(UI.TextColor.addColor("Old Email : ", UI.TextColor.GREEN) + UI.TextColor.addColor(editTeacherManager.getOldEmail(), UI.TextColor.WHITE));
        String newEmail = prompt("Enter new Email");
        editTeacherManager.setNewEmail(newEmail);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    }

    @Override
    public void editPassword() {
        System.out.println(UI.TextColor.addColor(UI.Banner.editPassword, UI.TextColor.YELLOW));
        System.out.println(UI.TextColor.addColor("Old Password : ", UI.TextColor.GREEN) + UI.TextColor.addColor(editTeacherManager.getOldPassword(), UI.TextColor.WHITE));
        do {
            String oldPass = prompt("Enter old password");
            if (Hasher.hash(oldPass).equals(editTeacherManager.getOldPassword())) {
                break;
            } else {
                System.out.println("\nPassword does not match old password\n");
            }
        } while (true);
        String newPassword = prompt("Enter new Password");
        editTeacherManager.setNewPassword(newPassword);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    }

    // unique edit methods for teacher

    public void editGender() {
        // Banner [to change]
        System.out.println(UI.TextColor.addColor(UI.Banner.edit, UI.TextColor.YELLOW));
        System.out.println(UI.TextColor.addColor("Old Gender : ", UI.TextColor.GREEN) + UI.TextColor.addColor(editTeacherManager.getOldGender(), UI.TextColor.WHITE));

        String gender = prompt("Enter Gender");
        editTeacherManager.setNewGender(gender);
    }

    public void editDoB() {
        // Banner [to change]
        System.out.println(UI.TextColor.addColor(UI.Banner.edit, UI.TextColor.YELLOW));
        System.out.println(UI.TextColor.addColor("Old Gender : ", UI.TextColor.GREEN) + UI.TextColor.addColor(editTeacherManager.getOldDoB(), UI.TextColor.WHITE));
        String dob = prompt("Enter Date of Birth");
        editTeacherManager.setNewDoB(dob);
    }
}