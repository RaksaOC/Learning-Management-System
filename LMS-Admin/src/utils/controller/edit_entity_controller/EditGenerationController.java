package utils.controller.edit_entity_controller;

import ui.UI;
import utils.manager.edit_entity_manager.EditGenerationManager;

public class EditGenerationController extends EditEntityController{
    public EditGenerationController() {}

    public void editID(){
        System.out.println(UI.TextColor.addColor(UI.Banner.editId, UI.TextColor.YELLOW));

        // [TO ADD] : ID Validation

        String oldId = prompt("Enter old Generation ID");
        String newId = prompt("Enter new Generation ID");
        EditGenerationManager editGenerationManager = new EditGenerationManager(oldId);
        editGenerationManager.setNewID(newId);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    }

    // no uses
    @Override
    public void editName(){

    }
    @Override
    public void  editPhone(){

    }
    @Override
    public void  editEmail(){

    }
    @Override
    public void  editPassword(){

    }
}