package utils.controller.manage_entity_controller;


import org.json.JSONArray;
import org.json.JSONObject;
import utils.controller.edit_entity_controller.EditGenerationController;
import utils.manager.edit_entity_manager.EditGenerationManager;
import utils.manager.manage_entity_manager.ManageGenerationManager;

public class ManageGenerationController extends ManageEntityController {
    public ManageGenerationController() {};

    @Override
    public void addEntity() {
        String genID = prompt("Enter Generation ID");
        JSONObject newGen = new JSONObject();
        newGen.put("id", genID);
        ManageGenerationManager genManager = new ManageGenerationManager();
        genManager.manageAddEntity(newGen);
    }

    @Override
    public void viewEntity() {
        ManageGenerationManager genManager = new ManageGenerationManager();

        // go to every specialization and print the generations array of each
        genManager.manageViewEntity();
    }

    @Override
    public void editEntity() {
        // call to edit controller goes here

        EditGenerationController editGenerationController = new EditGenerationController();
        editGenerationController.editID();

    }

    @Override
    public void deleteEntity() {
        String genID = prompt("Enter Generation ID");
        ManageGenerationManager genManager = new ManageGenerationManager();
        genManager.manageDeleteEntity(genID);
    }

}