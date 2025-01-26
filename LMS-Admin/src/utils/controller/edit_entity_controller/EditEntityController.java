package utils.controller.edit_entity_controller;

import ui.UI;

import java.util.Scanner;

interface EditInterface {
    void editName();
    void editPhone();
    void editEmail();
    void editPassword();
    void setEntityID(String entityID);
}

public abstract class EditEntityController implements EditInterface {

    protected String entityID;

    public EditEntityController(String entityID) {};

    protected static String prompt(String prompt) {
        Scanner sc = new Scanner(System.in);
        prompt = UI.TextColor.addColor(prompt, UI.TextColor.GREEN);
        System.out.println(prompt);
        System.out.print(UI.TextColor.addColor("\n> ", UI.TextColor.GREEN));
        String input = sc.nextLine();
        return input;
    }


    public abstract void editName();
    public abstract void editPhone();
    public abstract void editEmail();
    public abstract void editPassword();
    public abstract void setEntityID(String entityID);

//    public String entityMaker(String entity) {
//        if (entity.equals("admin" || entity.equals("student" || entity.equals("teacher")))) {
//            return entity;
//        } else {
//            System.out.println("Invalid entity");
//            return null;
//        }
//    }



}