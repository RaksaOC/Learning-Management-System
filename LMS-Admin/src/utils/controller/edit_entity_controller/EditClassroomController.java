package utils.controller.edit_entity_controller;

import ui.UI;
import utils.manager.edit_entity_manager.EditClassroomManager;
import utils.manager.edit_entity_manager.EditGroupManager;

public class EditClassroomController extends EditEntityController {
    public EditClassroomController() {
        super();
    }

    public void editID() {
        System.out.println(UI.TextColor.addColor(UI.Banner.editId, UI.TextColor.YELLOW));
        // [TO ADD: VALIDATION OF ID'S]
        String oldGroupID = prompt("Enter old Group ID");
        String newGroupID = prompt("Enter new Group ID");
        EditClassroomManager editClassroomManager = new EditClassroomManager(oldGroupID);
        editClassroomManager.setNewID(newGroupID);
        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
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