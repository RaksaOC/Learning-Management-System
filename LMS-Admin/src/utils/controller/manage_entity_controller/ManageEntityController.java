package utils.controller.manage_entity_controller;

import ui.UI;

import java.util.Scanner;

interface ManageEntityControllerInterface {
    void addEntity();

    void editEntity();

    void deleteEntity();

    void viewEntity();
}

public abstract class ManageEntityController implements ManageEntityControllerInterface {
    Scanner sc = new Scanner(System.in);
    public ManageEntityController() {};

    protected String prompt(String prompt) {
        prompt = UI.TextColor.addColor(prompt, UI.TextColor.GREEN);
        System.out.println(prompt);
        System.out.print(UI.TextColor.addColor("\n> ", UI.TextColor.GREEN));
        String input = sc.nextLine();
        return input;
    }

    public abstract void addEntity();
    public abstract void editEntity();
    public abstract void deleteEntity();
    public abstract void viewEntity();




}