package main.java.com.lmsAdmin.controllers.layer2.studentActionController;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import lib.Hasher;
import main.SceneManager;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageStudentManager;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditDepartmentManager;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditGenerationManager;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditSpecializationManager;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.utils.CambodiaAdministrative;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AddStudentController extends MainFrameController {
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private DatePicker dob;
    @FXML
    private ComboBox<String> gender;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField guardianFirstName;
    @FXML
    private TextField guardianLastName;
    @FXML
    private ComboBox<String> guardianGender;
    @FXML
    private TextField guardianPhoneNumber;
    @FXML
    private ComboBox<String> commune;
    @FXML
    private ComboBox<String> district;
    @FXML
    private ComboBox<String> province;
    @FXML
    private ComboBox<String> generation;
    @FXML
    private ComboBox<String> department;
    @FXML
    private ComboBox<String> specialization;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private TextField confirmPassword;
    @FXML
    private Button addButton;

    public void initialize() {
        district.setDisable(true);
        district.getItems().clear();
        commune.setDisable(true);
        commune.getItems().clear();
        province.setDisable(false);
        province.getItems().clear();
        specialization.setDisable(false);
        specialization.getItems().clear();

        province.setVisibleRowCount(4);
        district.setVisibleRowCount(6);
        commune.setVisibleRowCount(8);

        CambodiaAdministrative cambodia = new CambodiaAdministrative();

        generation.getItems().addAll(new EditGenerationManager().loadIdsAndName());
        department.getItems().addAll(new EditDepartmentManager().loadIdsAndName());

        department.setOnAction(e -> {
            if (department.getSelectionModel().getSelectedItem()!= null) {
                specialization.getItems().clear();
                ArrayList<String> filteredSpec = (ArrayList<String>) new EditSpecializationManager().loadIdsAndName()
                        .stream()
                        .filter(spec -> spec.split(" ")[0]
                                .equals(extractId(department.getSelectionModel().getSelectedItem())))
                        .toList();
                specialization.getItems().addAll(filteredSpec);
            }
        });

        province.getItems().addAll(cambodia.getProvinces());

        province.setOnAction(event -> {
            if (province.getSelectionModel().getSelectedItem() != null) {
                district.setDisable(false);
                district.getItems().addAll(cambodia.getDistricts(province.getSelectionModel().getSelectedItem()));
            } else {
                district.setDisable(true);
                commune.setDisable(true);
            }
        });

        district.setOnAction(event -> {
            if (district.getSelectionModel().getSelectedItem() != null) {
                commune.setDisable(false);
                commune.getItems().addAll(cambodia.getCommunes(district.getSelectionModel().getSelectedItem(), province.getSelectionModel().getSelectedItem()));
            } else {
                commune.setDisable(true);
            }
        });
    }


    @FXML
    private void handleAdd(MouseEvent event) {
        if(isPasswordSame(password.getText(), confirmPassword.getText())){
            String fName = firstName.getText();
            String lName = lastName.getText();
            String dateOfBirth = dob.getValue().toString();
            String gen = gender.getSelectionModel().getSelectedItem().toString();
            String phone = phoneNumber.getText();
            String gFName = guardianFirstName.getText();
            String gLName = guardianLastName.getText();
            String gGender = guardianGender.getSelectionModel().getSelectedItem().toString();
            String gPhone = guardianPhoneNumber.getText();
            String com = commune.getSelectionModel().getSelectedItem().toString();
            String dis = district.getSelectionModel().getSelectedItem().toString();
            String pro = province.getSelectionModel().getSelectedItem().toString();
            String gener = generation.getSelectionModel().getSelectedItem().toString();
            String dep = extractId(department.getSelectionModel().getSelectedItem().toString());
            String spec = extractId(specialization.getSelectionModel().getSelectedItem().toString());
            String password = confirmPassword.getText();
            String em = email.getText();

            if (isConfirmed()) {
                ManageStudentManager manageStudentManager = new ManageStudentManager();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                String formattedDate = now.format(formatter);

                // missing address
                manageStudentManager.manageAddStudent(
                        fName,
                        lName,
                        gen,
                        dateOfBirth,
                        phone,
                        em,
                        password,
                        com,
                        dis,
                        pro,
                        "active",
                        formattedDate,
                        null,
                        dep,
                        spec,
                        gener,
                        gFName,
                        gLName,
                        gPhone,
                        gGender
                );
                loadSuccess("addStudent");
                SceneManager.refreshScenes();
                resetAllFields();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Password do not match");
            alert.setHeaderText(null);
            alert.setContentText("Password do not match");
            alert.showAndWait();
            resetFields();
        }
    }

    private boolean isPasswordSame(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    private void resetAllFields() {
        firstName.clear();
        lastName.clear();
        dob.setValue(null);
        password.clear();
        guardianFirstName.clear();
        guardianLastName.clear();
        guardianPhoneNumber.clear();
        guardianGender.getSelectionModel().clearSelection();
        email.clear();
        gender.getSelectionModel().clearSelection();
        district.getSelectionModel().clearSelection();
        province.getSelectionModel().clearSelection();
        generation.getSelectionModel().clearSelection();
        department.getSelectionModel().clearSelection();
        specialization.getSelectionModel().clearSelection();
        specialization.getSelectionModel().clearSelection();
        commune.getSelectionModel().clearSelection();
    }

    private void resetFields() {
        password.clear();
        confirmPassword.clear();
    }
}