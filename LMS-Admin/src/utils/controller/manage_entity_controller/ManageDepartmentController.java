package utils.controller.manage_entity_controller;
import utils.menu.Menu;

public class ManageDepartmentController
{
    public ManageDepartmentController(){};
    public void addDepartment(){};
    public void deleteDepartment(){};
    public void editDepartment(){};
    public void viewDepartments(){};
    public void manageSpecialization(){
        Menu menu = new Menu();
        ManageSpecializationController manageSpecilizationController = new ManageSpecializationController();
        while(true){
            String choice = menu.showManageSpecializationsMenu();
            switch (choice){
                case "1":
                    manageSpecilizationController.addSpecialization();
                    break;
                case "2":
                    manageSpecilizationController.viewSpecializations();
                    break;
                case "3":
                    manageSpecilizationController.deleteSpecialization();
                    break;
                case "-b":
                    return;
                default:
                    break;
            }
        }

    };
}