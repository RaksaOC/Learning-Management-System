package utils.controller.edit_entity_controller;

import utils.manager.edit_entity_manager.EditClassroomManager;
import utils.manager.edit_entity_manager.EditGroupManager;

public class EditClassroomController extends EditEntityController {
    public EditClassroomController() {
        super();
    }

    public void editID() {
        String oldGroupID = prompt("Enter old Group ID");
        String newGroupID = prompt("Enter new Group ID");
        EditClassroomManager editClassroomManager = new EditClassroomManager(oldGroupID);
        editClassroomManager.setNewID(newGroupID);
    }

    @Override
    public void editName() {
// these have no use for this controller but defined with empty body because was abstract in superClass
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