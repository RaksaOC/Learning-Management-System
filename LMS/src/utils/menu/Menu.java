package utils.menu;

import ui.UI;

import java.util.Scanner;

public class Menu {
    private String banner;
    private String menu;
    private String choice;
    Scanner sc = new Scanner(System.in);

    private final String input = UI.TextColor.addColor("> ", UI.TextColor.GREEN);
    private final String invalidChoice = UI.TextColor.addColor("\nInvalid Choice\n", UI.TextColor.RED);

    public Menu() {

    }

    public String showUserTypeMenu() {
        UI.showLoadingBar(10);
        System.out.println(UI.TextColor.addColor(UI.Banner.authenticate, UI.TextColor.YELLOW));

        do {
            menu = """
                    [1] Student
                    [2] Teacher
                    """;
            printMenu();
            this.choice = sc.nextLine();
            if (!(isChoiceValid("1", "2", choice))) System.out.println(invalidChoice);
        } while (!isChoiceValid("1", "2", choice));
        switch (choice) {
            case "1":
                choice = "student";
                break;
            case "2":
                choice = "teacher";
                break;
        }
        this.clearScreen();
        return choice;
    }

    public String showStudentSideMenu() {
        UI.showLoadingBar(10);
        System.out.println("student side menu");
        do {
            menu = """
                    [1] View Classrooms
                    [2] View Profile
                    [3] Log Out
                    [4] Exit
                    """;
            printMenu();
            this.choice = sc.nextLine();
            if (!(isChoiceValid("1", "4", choice))) System.out.println(invalidChoice);
        } while (!isChoiceValid("1", "4", choice));
        this.clearScreen();
        return choice;
    }

    public String showTeacherSideMenu() {
        UI.showLoadingBar(10);
        System.out.println("teacher side menu");
        do {
            menu = """
                    [1] View Classrooms
                    [2] View Profile
                    [3] Log Out
                    [4] Exit
                    """;
            printMenu();
            this.choice = sc.nextLine();
            if (!(isChoiceValid("1", "4", choice))) System.out.println(invalidChoice);
        } while (!isChoiceValid("1", "4", choice));
        this.clearScreen();
        return choice;
    }

    public String showViewClassroomMenu(){
        UI.showLoadingBar(10);
        System.out.println("Teacher Manage Classroom: ");
        do {
            menu = """
                    [1] Manage Assignment
                    [2] Manage Resources
                    [3] Manage Quizzes
                    """;
            printMenu();
            this.choice = sc.nextLine();
            if (!(isChoiceValid("1", "4", choice))) System.out.println(invalidChoice);
        } while (!isChoiceValid("1", "4", choice));
        this.clearScreen();
        return choice;
    }

    public String showManageAssignmentMenu(){
        UI.showLoadingBar(10);
        System.out.println("Teacher Manage Classroom: ");
        do {
            menu = """
                    [1]. Add Assignment
                    [2]. Edit Assignment
                    [3]. Delete Assignment
                    [4]. Grade Assignment
                    """;
            printMenu();
            this.choice = sc.nextLine();
            if (!(isChoiceValid("1", "4", choice))) System.out.println(invalidChoice);
        } while (!isChoiceValid("1", "4", choice));
        this.clearScreen();
        return choice;
    }

    public String showManageResourcesMenu(){
        UI.showLoadingBar(10);
        System.out.println("Teacher Manage Classroom: ");
        do {
            menu = """
                    [1]. Add Resources
                    [2]. Edit Resources
                    [3]. Delete Resources
                    [4]. View Resources
                    """;
            printMenu();
            this.choice = sc.nextLine();
            if (!(isChoiceValid("1", "4", choice))) System.out.println(invalidChoice);
        } while (!isChoiceValid("1", "4", choice));
        this.clearScreen();
        return choice;
    }

    public String showManageQuizzesMenu(){
        UI.showLoadingBar(10);
        System.out.println("Teacher Manage Classroom: ");
        do {
            menu = """
                    [1]. Add Quizzes
                    [2]. Edit Quizzes
                    [3]. Delete Quizzes
                    [4]. Grade Quizzes
                    [5]. View Quizzes
                    """;
            printMenu();
            this.choice = sc.nextLine();
            if (!(isChoiceValid("1", "4", choice))) System.out.println(invalidChoice);
        } while (!isChoiceValid("1", "4", choice));
        this.clearScreen();
        return choice;
    }

    private void printMenu() {
        menu = UI.TextColor.addColor(menu, UI.TextColor.BLUE);
        System.out.println(menu);
        System.out.print(input);
    }

    private static boolean isChoiceValid(String from, String to, String choice) {
        if (choice.equals("-b"))
            return true;
        try {
            int int_from = Integer.parseInt(from);
            int int_to = Integer.parseInt(to);
            int int_choice = Integer.parseInt(choice);
            if (int_choice < int_from || int_choice > int_to)
                return false;
        } catch (NumberFormatException e) {

            return false; // Return false if input is not a number
        }

        return true;
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static String prompt(String prompt) {
        Scanner sc = new Scanner(System.in);
        prompt = UI.TextColor.addColor(prompt, UI.TextColor.GREEN);
        System.out.println("\n" + prompt);
        System.out.print(UI.TextColor.addColor("\n> ", UI.TextColor.GREEN));
        String input = sc.nextLine();
        return input;
    }
}