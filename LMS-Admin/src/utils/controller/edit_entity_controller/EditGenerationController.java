package utils.controller.edit_entity_controller;

import ui.UI;
import utils.manager.edit_entity_manager.EditGenerationManager;
import utils.manager.manage_entity_manager.ManageGenerationManager;

public class EditGenerationController extends EditEntityController {
    public EditGenerationController() {
    }

    public void editID() {
        System.out.println(UI.TextColor.addColor(UI.Banner.editId, UI.TextColor.YELLOW));

        // [TO ADD] : ID Validation
        boolean isExst = false;
        String oldId;
        do {
            oldId = prompt("Enter old Generation ID");
            ManageGenerationManager mgm = new ManageGenerationManager();
            if (mgm.isGenerationIdExist(oldId)) {
                isExst = true;
            } else {
                System.out.println(UI.TextColor.addColor("\nInvalid Generation ID\n", UI.TextColor.RED));
            }
        } while (!isExst);

        String newId = prompt("Enter new Generation ID");
        EditGenerationManager editGenerationManager = new EditGenerationManager(oldId);
        editGenerationManager.setNewID(newId);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    }

    // no uses
    @Override
    public void editName() {

    }

    @Override
    public void editPhone() {

    }

    @Override
    public void editEmail() {

    }

    @Override
    public void editPassword() {

    }
}