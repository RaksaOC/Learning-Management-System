package utils.controller.edit_entity_controller;

import ui.UI;
import utils.manager.edit_entity_manager.EditDepartmentManager;

public class EditDepartmentController extends EditEntityController {
    EditDepartmentManager editDepartmentManager;

    public EditDepartmentController(String idToEdit) {
        super(idToEdit);
        editDepartmentManager = new EditDepartmentManager(idToEdit);
    }

    @Override
    public void editName() {
        // Show old name
        System.out.println(UI.TextColor.addColor(UI.Banner.editName, UI.TextColor.YELLOW));
        System.out.println(UI.TextColor.addColor("Old name: ", UI.TextColor.GREEN) + UI.TextColor.addColor(editDepartmentManager.getOldName(), UI.TextColor.WHITE));

        String name = prompt("Enter new Department Name");
        EditDepartmentManager editDepartmentManager = new EditDepartmentManager(entityID);
        editDepartmentManager.setNewName(name);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    }

    // unique method
    public void editID() {
        // Show old id
        System.out.println(UI.TextColor.addColor(UI.Banner.editId, UI.TextColor.YELLOW));
        System.out.println(UI.TextColor.addColor("Old Id: ", UI.TextColor.GREEN) + UI.TextColor.addColor(editDepartmentManager.getOldID(), UI.TextColor.WHITE));

        String id = prompt("Enter new ID");
        EditDepartmentManager editDepartmentManager = new EditDepartmentManager(entityID);
        editDepartmentManager.setNewID(id);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    }


    // NO USES
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