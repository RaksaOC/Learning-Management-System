package utils.controller.edit_entity_controller;

import lib.Hasher;
import ui.UI;
import utils.manager.edit_entity_manager.EditEntityManager;

import java.util.Scanner;

interface EditInterface {
    void editName();

    void editPhone();

    void editEmail();

    void editPassword();
}

public abstract class EditEntityController implements EditInterface {

    protected String entityID;

    public EditEntityController() {
    }

    public EditEntityController(String entityID) {
        this.entityID = entityID;
    }

    protected static String prompt(String prompt) {
        Scanner sc = new Scanner(System.in);
        prompt = UI.TextColor.addColor(prompt, UI.TextColor.GREEN);
        System.out.println("\n" + prompt);
        System.out.print(UI.TextColor.addColor("\n> ", UI.TextColor.GREEN));
        String input = sc.nextLine();
        return input;
    }

    public void setEntityID(String entityID) {
        this.entityID = entityID;
    }

    public abstract void editName();

    public abstract void editPhone();

    public abstract void editEmail();

    public abstract void editPassword();

}