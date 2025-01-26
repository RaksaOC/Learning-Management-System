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
        System.out.println(UI.TextColor.addColor("Old name: ", UI.TextColor.GREEN) + UI.TextColor.addColor(manager.getOldName(), UI.TextColor.WHITE));
        String newName = prompt("Enter new name");
        manager.setNewName(newName);
    }
    @Override
    public void editPhone(){
        System.out.println(UI.TextColor.addColor("Old Phone Number: ", UI.TextColor.GREEN) + UI.TextColor.addColor(manager.getOldPhone(), UI.TextColor.WHITE));
        String newPhone = prompt("Enter new Phone Number");
        manager.setNewPhone(newPhone);
    }
    @Override
    public void editEmail(){
        System.out.println(UI.TextColor.addColor("Old Email : ", UI.TextColor.GREEN) + UI.TextColor.addColor(manager.getOldEmail(), UI.TextColor.WHITE));
        String newEmail = prompt("Enter new Email");
        manager.setNewEmail(newEmail);
    }
    @Override
    public void editPassword(){
        System.out.println(UI.TextColor.addColor("Old Password : ", UI.TextColor.GREEN) + UI.TextColor.addColor(manager.getOldPassword(), UI.TextColor.WHITE));
        do{
            String oldPass = prompt("Enter old password");
            if(Hasher.hash(oldPass).equals(manager.getOldPassword())){
                break;
            }
            else{
                System.out.println("Password does not match old password");
            }
        }while(true);
        String newPassword = prompt("Enter new Password");
        manager.setNewPassword(newPassword);
    }
}