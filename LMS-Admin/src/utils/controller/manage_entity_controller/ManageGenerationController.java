package utils.controller.manage_entity_controller;


import org.json.JSONArray;
import org.json.JSONObject;
import ui.UI;
import utils.controller.edit_entity_controller.EditGenerationController;
import utils.manager.edit_entity_manager.EditGenerationManager;
import utils.manager.manage_entity_manager.ManageGenerationManager;

public class ManageGenerationController extends ManageEntityController {
    public ManageGenerationController() {
    }

    ;

    @Override
    public void addEntity() {
        System.out.println(UI.TextColor.addColor(UI.Banner.add, UI.TextColor.YELLOW));

        String genID = prompt("Enter New Generation ID");
        JSONObject newGen = new JSONObject();
        newGen.put("id", genID);
        ManageGenerationManager genManager = new ManageGenerationManager();
        genManager.manageAddEntity(newGen);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    }

    @Override
    public void editEntity() {
        // call to edit controller goes here
        System.out.println(UI.TextColor.addColor(UI.Banner.edit, UI.TextColor.YELLOW));

        EditGenerationController editGenerationController = new EditGenerationController();
        editGenerationController.editID();

    }

    @Override
    public void deleteEntity() {
        System.out.println(UI.TextColor.addColor(UI.Banner.delete, UI.TextColor.YELLOW));
        String genID = prompt("Enter Generation ID");
        ManageGenerationManager genManager = new ManageGenerationManager();
        genManager.manageDeleteEntity(genID);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    }

    @Override
    public void viewEntity() {
        System.out.println(UI.TextColor.addColor(UI.Banner.view, UI.TextColor.YELLOW));
        ManageGenerationManager genManager = new ManageGenerationManager();

        // go to every specialization and print the generations array of each
        genManager.manageViewEntity();
    }


}