package utils.controller.edit_entity_controller;

import lib.Hasher;
import org.json.JSONObject;
import ui.UI;
import utils.manager.edit_entity_manager.EditAdminManager;
import utils.manager.edit_entity_manager.EditStudentManager;

import java.util.ArrayList;

public class EditStudentController extends EditEntityController {
    private EditStudentManager editStudentManager;

    public EditStudentController(String idToEdit) {
        super(idToEdit);
        editStudentManager = new EditStudentManager(idToEdit);
    }

    @Override
    public void editName() {
        System.out.println(UI.TextColor.addColor(UI.Banner.editName, UI.TextColor.YELLOW));
        System.out.println(UI.TextColor.addColor("Old name: ", UI.TextColor.GREEN) + UI.TextColor.addColor(editStudentManager.getOldName(), UI.TextColor.WHITE));
        String newName = prompt("Enter new name");
        editStudentManager.setNewName(newName);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    }

    @Override
    public void editPhone() {
        System.out.println(UI.TextColor.addColor(UI.Banner.editPhone, UI.TextColor.YELLOW));
        System.out.println(UI.TextColor.addColor("Old Phone Number: ", UI.TextColor.GREEN) + UI.TextColor.addColor(editStudentManager.getOldPhone(), UI.TextColor.WHITE));
        String newPhone = prompt("Enter new Phone Number");
        editStudentManager.setNewPhone(newPhone);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    }


    @Override
    public void editEmail() {
        System.out.println(UI.TextColor.addColor(UI.Banner.editEmail, UI.TextColor.YELLOW));
        System.out.println(UI.TextColor.addColor("Old Email : ", UI.TextColor.GREEN) + UI.TextColor.addColor(editStudentManager.getOldEmail(), UI.TextColor.WHITE));
        String newEmail = prompt("Enter new Email");
        editStudentManager.setNewEmail(newEmail);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    }

    @Override
    public void editPassword() {
        System.out.println(UI.TextColor.addColor(UI.Banner.editPassword, UI.TextColor.YELLOW));
        System.out.println(UI.TextColor.addColor("Old Password : ", UI.TextColor.GREEN) + UI.TextColor.addColor(editStudentManager.getOldPassword(), UI.TextColor.WHITE));
        do {
            String oldPass = prompt("Enter old password");
            if (Hasher.hash(oldPass).equals(editStudentManager.getOldPassword())) {
                break;
            } else {
                System.out.println("\nPassword does not match old password\n");
            }
        } while (true);
        String newPassword = prompt("Enter new Password");
        editStudentManager.setNewPassword(newPassword);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    }

    // unique editing fields for student

    public void editAddress() {
        // Banner [to change]
        System.out.println(UI.TextColor.addColor(UI.Banner.edit, UI.TextColor.YELLOW));
        System.out.println(UI.TextColor.addColor("Old Address : ", UI.TextColor.GREEN) + UI.TextColor.addColor(editStudentManager.getOldAddress(), UI.TextColor.WHITE));
        String district = prompt("Enter District");
        String province = prompt("Enter Province");

        JSONObject newAddress = new JSONObject();
        newAddress.put("district", district);
        newAddress.put("province", province);
        editStudentManager.setNewAddress(newAddress);

    }

    public void editGender() {
        // Banner [to change]
        System.out.println(UI.TextColor.addColor(UI.Banner.edit, UI.TextColor.YELLOW));
        System.out.println(UI.TextColor.addColor("Old Gender : ", UI.TextColor.GREEN) + UI.TextColor.addColor(editStudentManager.getOldGender(), UI.TextColor.WHITE));

        String gender = prompt("Enter Gender");
        editStudentManager.setNewGender(gender);
    }

    public void editDoB() {
        // Banner [to change]
        System.out.println(UI.TextColor.addColor(UI.Banner.edit, UI.TextColor.YELLOW));
        System.out.println(UI.TextColor.addColor("Old Gender : ", UI.TextColor.GREEN) + UI.TextColor.addColor(editStudentManager.getOldDoB(), UI.TextColor.WHITE));
        String dob = prompt("Enter Date of Birth");
        editStudentManager.setNewDoB(dob);
    }

    public void editDepartment() {
        // Banner [to change]
        System.out.println(UI.TextColor.addColor(UI.Banner.edit, UI.TextColor.YELLOW));
        System.out.println(UI.TextColor.addColor("Old Department : ", UI.TextColor.GREEN) + UI.TextColor.addColor(editStudentManager.getOldDepartment(), UI.TextColor.WHITE));

        ArrayList<String> depAndSpe = getDepAndSpe();
        String dep = depAndSpe.get(0);
        String spe = depAndSpe.get(1);

        editStudentManager.setNewDepartment(dep);
        editStudentManager.setNewSpecialization(spe);

    }

    public void editSpecialization() {
        System.out.println(UI.TextColor.addColor(UI.Banner.edit, UI.TextColor.YELLOW));
        System.out.println(UI.TextColor.addColor("Old Specialization : ", UI.TextColor.GREEN) + UI.TextColor.addColor(editStudentManager.getOldSpecialization(), UI.TextColor.WHITE));

        String specializationsCS = """
                [1] Software Engineering
                [2] Data Science
                """;

        String specializationsTN = """
                [1] Cybersecurity
                [2] Telecommunication
                """;

        boolean isSet = false;
        switch (editStudentManager.getOldDepartment()) {
            case "Computer Science":
                while (true) {
                    System.out.println(UI.TextColor.addColor(specializationsCS, UI.TextColor.BLUE));
                    String spe = prompt("Enter Specialization");
                    switch (spe) {
                        case "1":
                            if (editStudentManager.getOldSpecialization().equals("Software Engineering")) {
                                System.out.println(UI.TextColor.addColor("\nNew Specialization must be Different\n", UI.TextColor.RED));
                                break;
                            } else {
                                editStudentManager.setNewSpecialization("Software Engineering");
                                isSet = true;
                            }
                            break;
                        case "2":
                            if (editStudentManager.getOldSpecialization().equals("Data Science")) {
                                System.out.println(UI.TextColor.addColor("\nNew Specialization must be Different\n", UI.TextColor.RED));
                                break;
                            } else {
                                editStudentManager.setNewSpecialization("Data Science");
                                isSet = true;
                            }
                            break;
                        default:
                            System.out.println(UI.TextColor.addColor("\nInvalid Choice\n", UI.TextColor.RED));
                            break;
                    }
                    if (isSet) break;
                }
                break;
            case "Telecommunication & Networking":
                while (true) {
                    System.out.println(UI.TextColor.addColor(specializationsTN, UI.TextColor.BLUE));
                    String spe = prompt("Enter Specialization");
                    switch (spe) {
                        case "1":
                            if (editStudentManager.getOldSpecialization().equals("Cybersecurity")) {
                                System.out.println(UI.TextColor.addColor("\nNew Specialization must be Different\n", UI.TextColor.RED));
                                break;
                            } else {
                                editStudentManager.setNewSpecialization("Cybersecurity");
                                isSet = true;
                            }
                            break;
                        case "2":
                            if (editStudentManager.getOldSpecialization().equals("Telecommunication")) {
                                System.out.println(UI.TextColor.addColor("\nNew Specialization must be Different\n", UI.TextColor.RED));
                                break;
                            } else {
                                editStudentManager.setNewSpecialization("Telecommunication");
                                isSet = true;
                            }
                            break;
                        default:
                            System.out.println(UI.TextColor.addColor("\nInvalid Choice\n", UI.TextColor.RED));
                            break;
                    }
                    if (isSet) break;
                }
                break;
            case "Digital Business":
                System.out.println(UI.TextColor.addColor("\nDepartment has only one specialization\n", UI.TextColor.RED));
                break;
        }
    }

    public void editGuardian() {
        System.out.println(UI.TextColor.addColor(UI.Banner.edit, UI.TextColor.YELLOW));
        System.out.println(UI.TextColor.addColor("Old Guardian : ", UI.TextColor.GREEN) + UI.TextColor.addColor(editStudentManager.getOldGuardian(), UI.TextColor.WHITE));

        String guardianName = prompt("Enter Guardian Name");
        String guardianGender = prompt("Enter Guardian Gender");
        String guardianPhone = prompt("Enter Guardian Phone");

        JSONObject newGuardian = new JSONObject();
        newGuardian.put("guardianName", guardianName);
        newGuardian.put("guardianGender", guardianGender);
        newGuardian.put("guardianPhone", guardianPhone);

        editStudentManager.setNewGuardian(newGuardian);
    }

    private ArrayList<String> getDepAndSpe() {
        String department;
        String specialization = "";

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

}