package utils.menu;

import java.util.Scanner;
import ui.UI;

public class Menu {
    private String banner;
    private String menu;
    private String choice;
    Scanner sc = new Scanner(System.in);

    private final String input = UI.TextColor.addColor("> ", UI.TextColor.GREEN);
    private final String invalidChoice = UI.TextColor.addColor("\nInvalid Choice\n", UI.TextColor.RED);

    public Menu(){}

    // step 1
    public String showMainMenu(){

        String bannerApp = UI.TextColor.addColor(UI.Banner.cadtLms_Admin, UI.TextColor.YELLOW);
        banner = UI.TextColor.addColor(UI.Banner.mainMenu, UI.TextColor.YELLOW);

        System.out.println(bannerApp);
        System.out.println(banner);

        do {
            menu = """
                [1] Manage Users
                [2] Manage University
                [3] Manage Admin
                [4] Exit
                """;

            printMenu();
            this.choice = sc.nextLine();
            if(!(isChoiceValid("1", "4", choice)))System.out.println(invalidChoice);
        }while(!isChoiceValid("1", "4", choice));
        return choice;
    }

    // step 2

    // manage users
    public String showManageUsersMenu(){
        UI.showLoadingBar(10);

        banner = UI.TextColor.addColor(UI.Banner.manageUser, UI.TextColor.YELLOW);
        System.out.println(banner);

        do {
            menu = """
                [1] Manage Student
                [2] Manage Teacher
                """;

            printMenu();
            this.choice = sc.nextLine();
            if(!(isChoiceValid("1", "2", choice)))System.out.println(invalidChoice);
        }while(!isChoiceValid("1", "2", choice));
        return choice;
    }

    // manage university
    public String showManageUniversityMenu(){
        UI.showLoadingBar(10);

        banner = UI.TextColor.addColor(UI.Banner.manageUniversity, UI.TextColor.YELLOW);
        System.out.println(banner);

        do {
            menu = """
                    [1] Add Generation
                    [2] Manage Department
                    [3] Manage Specialization
                    """;
            printMenu();
            this.choice = sc.nextLine();
            if(!(isChoiceValid("1", "3", choice)))System.out.println(invalidChoice);
        }while(!isChoiceValid("1", "3", choice));
        return choice;
    }


    // step 3

    //manage student
    public String showManageStudentsMenu(){
        UI.showLoadingBar(10);

        banner = UI.TextColor.addColor(UI.Banner.manageStudent, UI.TextColor.YELLOW);
        System.out.println(banner);

        do {
            menu = """
                    [1] Add Student
                    [2] Edit Student
                    [3] Delete Student
                    [4] View Students
                    """;
            printMenu();
            this.choice = sc.nextLine();
            if(!(isChoiceValid("1", "3", choice)))System.out.println(invalidChoice);
        }while(!isChoiceValid("1", "3", choice));
        return choice;
    }

    // manage teacher
    public String showManageTeachersMenu(){
        UI.showLoadingBar(10);

        banner = UI.TextColor.addColor(UI.Banner.manageTeacher, UI.TextColor.YELLOW);
        System.out.println(banner);

        do {
            menu = """
                    [1] Add Teacher
                    [2] Assign Teacher to Course
                    [3] Edit Teacher
                    [4] Delete Teacher
                    [5] View Teachers
                    """;
            printMenu();
            this.choice = sc.nextLine();
            if(!(isChoiceValid("1", "3", choice)))System.out.println(invalidChoice);
        }while(!isChoiceValid("1", "3", choice));
        return choice;
    }

    // manage generation
    public String showManageGenerationMenu(){
        UI.showLoadingBar(10);

        banner = UI.TextColor.addColor(UI.Banner.manageGeneration, UI.TextColor.YELLOW);
        System.out.println(banner);

        do {
            menu = """
                    [1] Add Generation
                    [2] Edit Generation
                    [3] Delete Generation
                    [4] View Generations
                    """;
            printMenu();
            this.choice = sc.nextLine();
            if(!(isChoiceValid("1", "3", choice)))System.out.println(invalidChoice);
        }while(!isChoiceValid("1", "3", choice));
        return choice;
    }

    // manage Department
    public String showManageDepartmentsMenu(){
        UI.showLoadingBar(10);

        banner = UI.TextColor.addColor(UI.Banner.manageDepartment, UI.TextColor.YELLOW);
        System.out.println(banner);

        do {
            menu = """
                    [1] Add Department
                    [2] Edit Department
                    [3] Delete Department
                    [4] View Department
                    [5] Manage Specialization
                    """;
            printMenu();
            this.choice = sc.nextLine();
            if(!(isChoiceValid("1", "5", choice)))System.out.println(invalidChoice);
        }while(!isChoiceValid("1", "5", choice));
        return choice;
    }

    // manage specialization
    public String showManageSpecializationsMenu(){
        // enter the department id first to manage (done by controller)
        UI.showLoadingBar(10);

        banner = UI.TextColor.addColor(UI.Banner.manageSpecialization, UI.TextColor.YELLOW);
        System.out.println(banner);

        do {
            menu = """
                    [1] Add Specialization
                    [2] Edit Specialization
                    [3] Delete Specialization
                    [4] View Specialization
                    """;
            printMenu();
            this.choice = sc.nextLine();
            if(!(isChoiceValid("1", "4", choice)))System.out.println(invalidChoice);
        }while(!isChoiceValid("1", "4", choice));
        return choice;
    }

    // manage admins
    public String showManageAdminsMenu(){
        UI.showLoadingBar(10);

        banner = UI.TextColor.addColor(UI.Banner.manageAdmin, UI.TextColor.YELLOW);
        System.out.println(banner);

        do {
            menu = """
                    [1] Add Admin
                    [2] Edit Admin
                    [3] Delete Admin
                    [4] View All Admins
                    """;
            printMenu();
            this.choice = sc.nextLine();
            if(!(isChoiceValid("1", "4", choice)))System.out.println(invalidChoice);
        }while(!isChoiceValid("1", "4", choice));
        return choice;
    }

// deeper steps

    public String showEditAdminMenu(){
        UI.showLoadingBar(10);

        do{
            menu = """
                    [1] Edit Name
                    [2] Edit Phone Number
                    [3] Edit Email
                    [4] Edit Password
                    """;
            printMenu();
            this.choice = sc.nextLine();
            if(!(isChoiceValid("1", "4", choice)))System.out.println(invalidChoice);
        }while(!isChoiceValid("1", "4", choice));
        return choice;
    }

    public String showEditStudentMenu(){
        UI.showLoadingBar(10);

        do{
            menu = """
                    [1] Edit Name
                    [2] Edit Phone Number
                    [3] Edit Email
                    [4] Edit Password
                    [5] Edit Address
                    [6] Edit Gender
                    [7] Edit Date of Birth
                    [8] Edit Department
                    [9] Edit Specialization
                    [10] Edit Guardian
                    """;
            printMenu();
            this.choice = sc.nextLine();
            if(!(isChoiceValid("1", "10", choice)))System.out.println(invalidChoice);
        }while(!isChoiceValid("1", "10", choice));
        return choice;
    }

    public String showEditDepartmentMenu(){
        UI.showLoadingBar(10);

        do{
            menu = """
                    [1] Edit Name
                    [2] Edit ID
                    """;
            printMenu();
            this.choice = sc.nextLine();
            if(!(isChoiceValid("1", "2", choice)))System.out.println(invalidChoice);
        }while(!isChoiceValid("1", "2", choice));
        return choice;
    }

    private void printMenu() {
        menu = UI.TextColor.addColor(menu, UI.TextColor.BLUE);
        System.out.println(menu);
        System.out.print(input);
    }

    private static boolean isChoiceValid(String from, String to, String choice) {
        if(choice.equals("-b")) return true;
        try {
            int int_from = Integer.parseInt(from);
            int int_to = Integer.parseInt(to);
            int int_choice = Integer.parseInt(choice);
            if (int_choice < int_from || int_choice > int_to) return false;
        } catch (NumberFormatException e) {
            return false; // Return false if input is not a number
        }
        return true;
    }
}