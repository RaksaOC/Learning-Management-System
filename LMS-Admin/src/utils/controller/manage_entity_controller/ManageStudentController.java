package utils.controller.manage_entity_controller;

import lib.Hasher;
import org.json.JSONArray;
import org.json.JSONObject;
import ui.UI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import utils.controller.edit_entity_controller.EditStudentController;
import utils.manager.edit_entity_manager.EditStudentManager;
import utils.manager.manage_entity_manager.ManageStudentManager;
import utils.menu.Menu;

public class ManageStudentController extends ManageEntityController {
    ManageStudentManager manager;

    public ManageStudentController() {
        manager = new ManageStudentManager();
    }

    @Override
    public void addEntity() {
        System.out.println(UI.TextColor.addColor(UI.Banner.add, UI.TextColor.YELLOW));

        JSONObject newStudent = createNewStudentObject();
        manager.manageAddEntity(newStudent);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    }

    @Override
    public void editEntity() {
        System.out.println(UI.TextColor.addColor(UI.Banner.edit, UI.TextColor.YELLOW));
        EditStudentManager editStudentManager;
        boolean isExist = false;

        String studentID;
        do {
            studentID = prompt("Enter Student ID");
            editStudentManager = new EditStudentManager(studentID);
            // call to manager for validation
            if (editStudentManager.isEntityIDExist(studentID)) {
                isExist = true;
                break;
            } else {
                System.out.println(UI.TextColor.addColor("\nInvalid ID\n", UI.TextColor.RED));
            }
        } while (isExist);

        EditStudentController editStudentController = new EditStudentController(studentID);
        Menu menu = new Menu();
        if (isExist) {
            String choice = menu.showEditStudentMenu();
            while (true) {
                switch (choice) {
                    case "1":
                        editStudentController.editName();
                        break;
                    case "2":
                        editStudentController.editPhone();
                        break;
                    case "3":
                        editStudentController.editEmail();
                        break;
                    case "4":
                        editStudentController.editPassword();
                        break;
                    case "5":
                        editStudentController.editAddress();
                        break;
                    case "6":
                        editStudentController.editGender();
                        break;
                    case "7":
                        editStudentController.editDoB();
                        break;
                    case "8":
                        editStudentController.editDepartment();
                        break;
                    case "9":
                        editStudentController.editSpecialization();
                        break;
                    case "10":
                        editStudentController.editGuardian();
                        break;
                    case "-b":
                        return;
                    default:
                        break;
                }
                choice = menu.showEditStudentMenu();
            }

        }
    }

    @Override
    public void deleteEntity() {
        System.out.println(UI.TextColor.addColor(UI.Banner.delete, UI.TextColor.YELLOW));
        do {
            String studentID = prompt("Enter Student ID");

            // manage for that id, one call for validation check. will be called later within edit controller
            EditStudentManager editStudentManager = new EditStudentManager(studentID);

            if (editStudentManager.isEntityIDExist(studentID)) {
                manager.manageDeleteEntity(studentID);
                String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
                System.out.println(successBanner);
                return;
            } else {
                System.out.println(UI.TextColor.addColor("\nInvalid Student ID\n", UI.TextColor.RED));
            }
        } while (true);
    }

    @Override
    public void viewEntity() {
        manager.manageViewEntity();
    }

    //helper function

    private ArrayList<String> getDepartmentAndSpecialization() {
        String department;
        String specialization = "";


        // [TO CHANGE TO DYNAMIC]

        String departments = """
                [1] Computer Science
                [2] Telecommunication & Networking
                [3] Digital Business
                """;


        String specializationsCS = """
                [1] Software Engineering
                [2] Data Science
                """;

        String specializationsTN = """
                [1] Cybersecurity
                [2] Telecommunication
                """;

        String specializationsDB = """
                [1] E-Commerce
                """;

        System.out.println(UI.TextColor.addColor(departments, UI.TextColor.BLUE));

        boolean isCorrectDepartment = false;
        boolean isCorrectSpecialization = false;
        while (true) {
            department = prompt("Select department");
            switch (department) {
                case "1":
                    System.out.println(UI.TextColor.addColor(specializationsCS, UI.TextColor.BLUE));
                    department = "Computer Science";
                    isCorrectDepartment = true;
                    while (isCorrectDepartment) {
                        specialization = prompt("Select specialization");
                        switch (specialization) {
                            case "1":
                                specialization = "Software Engineering";
                                isCorrectSpecialization = true;
                                break;
                            case "2":
                                specialization = "Data Science";
                                isCorrectSpecialization = true;
                                break;
                            default:
                                System.out.println(UI.TextColor.addColor("\nInvalid Specialization\n", UI.TextColor.RED));
                                break;
                        }
                        if (isCorrectSpecialization) break;
                    }
                    break;
                case "2":
                    System.out.println(UI.TextColor.addColor(specializationsTN, UI.TextColor.BLUE));
                    department = "Telecommunication & Networking";
                    while (isCorrectDepartment) {
                        specialization = prompt("Select specialization");
                        switch (specialization) {
                            case "1":
                                specialization = "Cybersecurity";
                                isCorrectSpecialization = true;
                                break;
                            case "2":
                                specialization = "Telecommunication";
                                isCorrectSpecialization = true;
                                break;
                            default:
                                System.out.println(UI.TextColor.addColor("\nInvalid Specialization\n", UI.TextColor.RED));
                                break;
                        }
                        if (isCorrectSpecialization) break;
                    }
                    break;
                case "3":
                    System.out.println(UI.TextColor.addColor(specializationsDB, UI.TextColor.BLUE));
                    department = "Digital Business";
                    while (isCorrectDepartment) {
                        specialization = prompt("Select specialization");
                        switch (specialization) {
                            case "1":
                                specialization = "E-Commerce";
                                isCorrectSpecialization = true;
                                break;
                            default:
                                System.out.println(UI.TextColor.addColor("\nInvalid Specialization\n", UI.TextColor.RED));
                                break;
                        }
                        if (isCorrectSpecialization) break;
                    }
                    break;
                default:
                    System.out.println(UI.TextColor.addColor("\nInvalid department\n", UI.TextColor.RED));
                    break;
            }
            if (isCorrectDepartment) break;
        }
        ArrayList<String> depAndSpe = new ArrayList<String>();
        depAndSpe.add(department);
        depAndSpe.add(specialization);
        return depAndSpe;
    }

    private JSONObject createNewStudentObject() {
        String generation;
        String firstName;
        String lastName;
        String gender;
        String district;
        String province;
        String dob;
        String email;
        String phoneNumber;
        String password;
        String guardianName;
        String guardianPhoneNumber;
        String guardianGender;

        ArrayList<String> depAndSpe = getDepartmentAndSpecialization();
        String department = depAndSpe.get(0);
        String specialization = depAndSpe.get(1);

        String generations = """
                [1] Generation 1
                [2] Generation 2
                [3] Generation 3
                [4] Generation 4
                """;

        boolean isCorrectGen = false;
        while (true) {
            System.out.println(UI.TextColor.addColor(generations, UI.TextColor.BLUE));
            generation = prompt("Enter generation");

            switch (generation) {
                case "1":
                    generation = "GEN001";
                    isCorrectGen = true;
                    break;
                case "2":
                    generation = "GEN002";
                    isCorrectGen = true;
                    break;
                case "3":
                    generation = "GEN003";
                    isCorrectGen = true;
                    break;
                case "4":
                    generation = "GEN004";
                    isCorrectGen = true;
                    break;
                default:
                    System.out.println(UI.TextColor.addColor("\nInvalid Generation\n", UI.TextColor.RED));
                    break;
            }
            if (isCorrectGen) break;
        }

        firstName = prompt("Enter First Name");
        lastName = prompt("Enter Last Name");
        gender = prompt("Enter Gender");
        dob = prompt("Enter Data of Birth");
        email = prompt("Enter Email");
        phoneNumber = prompt("Enter Phone Number");

        guardianName = prompt("Enter Guardian Name");
        guardianGender = prompt("Enter Guardian Gender");
        guardianPhoneNumber = prompt("Enter Guardian Phone Number");

        district = prompt("Enter District");
        province = prompt("Enter Province");

        password = prompt("Create Password for Student");

        boolean isSame = false;
        do {
            String passwordConfirm = prompt("Enter Password Confirm");
            if (password.equals(passwordConfirm)) {
                isSame = true;
            } else {
                System.out.println(UI.TextColor.addColor("\nPasswords do not match\n", UI.TextColor.RED));
            }
        } while (!isSame);

        String hashedPassword = Hasher.hash(password);

        LocalDateTime now = LocalDateTime.now();

        // Format the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = now.format(formatter);

        JSONObject addressObj = new JSONObject();
        addressObj.put("district", district);
        addressObj.put("province", province);

        JSONObject guardianObj = new JSONObject();
        guardianObj.put("guardianName", guardianName);
        guardianObj.put("guardianGender", guardianGender);
        guardianObj.put("guardianPhoneNumber", guardianPhoneNumber);

        JSONObject newStudent = new JSONObject();

        JSONObject nameObj = new JSONObject();
        nameObj.put("firstName", firstName);
        nameObj.put("lastName", lastName);

        newStudent.put("name", nameObj);
        newStudent.put("gender", gender);
        newStudent.put("email", email);
        newStudent.put("dob", dob);
        newStudent.put("phoneNumber", phoneNumber);
        newStudent.put("password", hashedPassword);
        newStudent.put("address", addressObj);
        newStudent.put("guardian", guardianObj);
        newStudent.put("createdAt", formattedDate);
        newStudent.put("courses", new JSONArray());
        newStudent.put("generation", generation);
        newStudent.put("specialization", specialization);
        newStudent.put("department", department);
        newStudent.put("lastLogin", "");
        newStudent.put("status", "active");

        return newStudent;
    }
}