package utils.controller.edit_entity_controller;
import lib.Hasher;
import ui.UI;
import utils.manager.edit_entity_manager.EditAdminManager;

public class EditAdminController extends EditEntityController {
    private EditAdminManager manager;
    public EditAdminController(String entityID) {
        super(entityID);
        manager = new EditAdminManager(entityID);
        setEntityID(entityID);
    }

    @Override
    public void setEntityID(String entityID) {
        this.entityID = entityID;
    }

    @Override
    public void editName(){
        System.out.println(UI.TextColor.addColor(UI.Banner.editName, UI.TextColor.YELLOW));
        System.out.println(UI.TextColor.addColor("Old name: ", UI.TextColor.GREEN) + UI.TextColor.addColor(manager.getOldName(), UI.TextColor.WHITE));
        String newName = prompt("\nEnter new name");
        manager.setNewName(newName);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    }
    @Override
    public void editPhone(){
        System.out.println(UI.TextColor.addColor(UI.Banner.editPhone, UI.TextColor.YELLOW));
        System.out.println(UI.TextColor.addColor("Old Phone Number: ", UI.TextColor.GREEN) + UI.TextColor.addColor(manager.getOldPhone(), UI.TextColor.WHITE));
        String newPhone = prompt("\nEnter new Phone Number");
        manager.setNewPhone(newPhone);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    }
    @Override
    public void editEmail(){
        System.out.println(UI.TextColor.addColor(UI.Banner.editEmail, UI.TextColor.YELLOW));
        System.out.println(UI.TextColor.addColor("Old Email : ", UI.TextColor.GREEN) + UI.TextColor.addColor(manager.getOldEmail(), UI.TextColor.WHITE));
        String newEmail = prompt("\nEnter new Email");
        manager.setNewEmail(newEmail);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    }
    @Override
    public void editPassword(){
        System.out.println(UI.TextColor.addColor(UI.Banner.editPassword, UI.TextColor.YELLOW));
        System.out.println(UI.TextColor.addColor("Old Password : ", UI.TextColor.GREEN) + UI.TextColor.addColor(manager.getOldPassword(), UI.TextColor.WHITE));
        do{
            String oldPass = prompt("\nEnter old password");
            if(Hasher.hash(oldPass).equals(manager.getOldPassword())){
                break;
            }
            else{
                System.out.println("\nPassword does not match old password\n");
            }
        }while(true);
        String newPassword = prompt("\nEnter new Password");
        manager.setNewPassword(newPassword);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    }
}