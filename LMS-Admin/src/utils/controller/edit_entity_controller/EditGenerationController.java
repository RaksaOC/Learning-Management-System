package utils.controller.edit_entity_controller;

import utils.manager.edit_entity_manager.EditGenerationManager;

public class EditGenerationController extends EditEntityController{
    public EditGenerationController() {}

    public void editID(){
        // [TO ADD] : ID Validation and menu
        String oldId = prompt("Enter old Generation ID");
        String newId = prompt("Enter new Generation ID");
        EditGenerationManager editGenerationManager = new EditGenerationManager(oldId);
        editGenerationManager.setNewID(newId);
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