package utils.controller.edit_entity_controller;
import lib.Hasher;
import ui.UI;
import utils.manager.edit_entity_manager.EditAdminManager;

public class EditAdminController extends EditEntityController {
    EditAdminManager editAdminManager;
    public EditAdminController(String entityID) {
        super(entityID);
        editAdminManager = new EditAdminManager(entityID);
    }

    @Override
    public void editName(){
        System.out.println(UI.TextColor.addColor(UI.Banner.editName, UI.TextColor.YELLOW));
        System.out.println(UI.TextColor.addColor("Old name: ", UI.TextColor.GREEN) + UI.TextColor.addColor(editAdminManager.getOldName(), UI.TextColor.WHITE));
        String newName = prompt("\nEnter new name");
        editAdminManager.setNewName(newName);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    };

    @Override
    public void editPhone(){
        System.out.println(UI.TextColor.addColor(UI.Banner.editPhone, UI.TextColor.YELLOW));
        System.out.println(UI.TextColor.addColor("Old Phone Number: ", UI.TextColor.GREEN) + UI.TextColor.addColor(editAdminManager.getOldPhone(), UI.TextColor.WHITE));
        String newPhone = prompt("\nEnter new Phone Number");
        editAdminManager.setNewPhone(newPhone);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    };

    @Override
    public void editEmail(){
        System.out.println(UI.TextColor.addColor(UI.Banner.editEmail, UI.TextColor.YELLOW));
        System.out.println(UI.TextColor.addColor("Old Email : ", UI.TextColor.GREEN) + UI.TextColor.addColor(editAdminManager.getOldEmail(), UI.TextColor.WHITE));
        String newEmail = prompt("\nEnter new Email");
        editAdminManager.setNewEmail(newEmail);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    };

    @Override
    public void editPassword(){
        System.out.println(UI.TextColor.addColor(UI.Banner.editPassword, UI.TextColor.YELLOW));
        System.out.println(UI.TextColor.addColor("Old Password : ", UI.TextColor.GREEN) + UI.TextColor.addColor(editAdminManager.getOldPassword(), UI.TextColor.WHITE));
        do{
            String oldPass = prompt("\nEnter old password");
            if(Hasher.hash(oldPass).equals(editAdminManager.getOldPassword())){
                break;
            }
            else{
                System.out.println("\nPassword does not match old password\n");
            }
        }while(true);
        String newPassword = prompt("\nEnter new Password");
        editAdminManager.setNewPassword(newPassword);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    };

    // no other unique functionalities for admin

}