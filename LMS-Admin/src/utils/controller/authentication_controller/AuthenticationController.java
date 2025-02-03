package utils.controller.authentication_controller;

import ui.UI;
import utils.manager.authentication_manager.AuthManager;

import java.util.Scanner;

public class AuthenticationController {

    public AuthenticationController() {
    }

    public boolean authenticateUser() {
        AuthManager authManager = new AuthManager();
        String email;
        String password;
        boolean success = false;

        UI.showLoadingBar(10);
        String banner = UI.TextColor.addColor(UI.Banner.authenticate, UI.TextColor.YELLOW);
        System.out.println(banner);
        do {
            email = getEmail();
            password = getPassword();
            UI.showLoadingBar(10);
            if (!authManager.checkCredentials(email, password))
                System.out.println(UI.TextColor.addColor("\nInvalid email or password\n", UI.TextColor.RED));
        } while (!authManager.checkCredentials(email, password));
        success = true;
        return success;
    }

    private String getEmail() {
        Scanner sc = new Scanner(System.in);
        String emailPrompt = UI.TextColor.addColor("\nEnter Email", UI.TextColor.GREEN);
        System.out.println(emailPrompt);
        String input = UI.TextColor.addColor("\n> ", UI.TextColor.GREEN);
        System.out.print(input);
        String email = sc.nextLine();

        return email;
    }

    private String getPassword() {

        Scanner sc = new Scanner(System.in);
        String passwordPrompt = UI.TextColor.addColor("\nEnter Password", UI.TextColor.GREEN);
        System.out.println(passwordPrompt);

        String input = UI.TextColor.addColor("\n> ", UI.TextColor.GREEN);
        System.out.print(input);
        String password = sc.nextLine(); // Normal text input for password

        return password;
    }

}