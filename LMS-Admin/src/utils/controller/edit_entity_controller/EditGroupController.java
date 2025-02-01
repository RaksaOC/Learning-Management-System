package utils.controller.edit_entity_controller;

import ui.UI;
import utils.manager.edit_entity_manager.EditGroupManager;
import utils.manager.manage_entity_manager.ManageGroupManager;

public class EditGroupController extends EditEntityController{
    public EditGroupController() {
        super();
    }

    public void editID(){

        System.out.println(UI.TextColor.addColor(UI.Banner.editId, UI.TextColor.YELLOW));
        boolean isExitst = false;
        String oldGroupID;
        do{
            oldGroupID = prompt("Enter old Group ID");
            ManageGroupManager gm = new ManageGroupManager();
            if(gm.isGroupIDExist(oldGroupID)){
                isExitst = true;
            }
            else{
                System.out.println(UI.TextColor.addColor("\nInvalid Group ID\n", UI.TextColor.RED));
            }
        }while (isExitst);

        String newGroupID = prompt("Enter new Group ID");
        EditGroupManager editGroupManager = new EditGroupManager(oldGroupID);
        editGroupManager.setNewID(newGroupID);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    }

    @Override
    public void editName(){

    }

    @Override
    public void editPhone() {
        // these have no use for this controller but defined with empty body because was abstract in superClass
    }

    @Override
    public void editEmail() {
        // these have no use for this controller but defined with empty body because was abstract in superClass
    }

    @Override
    public void editPassword() {
        // these have no use for this controller but defined with empty body because was abstract in superClass
    }
}