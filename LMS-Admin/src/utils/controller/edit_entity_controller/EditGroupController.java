package utils.controller.edit_entity_controller;

import utils.manager.edit_entity_manager.EditGroupManager;

public class EditGroupController extends EditEntityController{
    public EditGroupController() {
        super();
    }

    public void editID(){
        String oldGroupID = prompt("Enter old Group ID");
        String newGroupID = prompt("Enter new Group ID");
        EditGroupManager editGroupManager = new EditGroupManager(oldGroupID);
        editGroupManager.setNewID(newGroupID);
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