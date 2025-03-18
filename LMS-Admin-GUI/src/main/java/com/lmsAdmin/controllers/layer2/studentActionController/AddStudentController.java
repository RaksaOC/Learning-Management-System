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
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        department.getItems().addAll(new EditDepartmentManager().loadIdsAndNameSql());
        specialization.setEditable(true); // TO CHANGE
        generation.getItems().addAll(new EditGenerationManager().loadIdsAndNameSql());
    }

    @FXML
    private void handleAdd(MouseEvent event) {
        handleAddSql();
        handleAddJSON();
    }

    private void handleAddSql(){
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
            String dep = department.getSelectionModel().getSelectedItem().toString();
            String spec = specialization.getSelectionModel().getSelectedItem().toString();
            String password = confirmPassword.getText();
            String em = email.getText();

            ManageStudentManager manageStudentManager = new ManageStudentManager();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String formattedDate = now.format(formatter);

            // missing address
            manageStudentManager.manageAddEntitySql(
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

            SceneManager.setScene("success");
            PauseTransition delay = new PauseTransition(Duration.seconds(2));
            delay.setOnFinished(ev -> {
                SceneManager.setScene("addStudent");
                resetAllFields();
            });

            delay.play();
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

    private void handleAddJSON(){
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
            String dep = department.getSelectionModel().getSelectedItem().toString();
            String spec = specialization.getSelectionModel().getSelectedItem().toString();
            String password = confirmPassword.getText();
            String em = email.getText();

            ManageStudentManager manageStudentManager = new ManageStudentManager();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String formattedDate = now.format(formatter);

            JSONObject newStudent = new JSONObject();

            JSONObject name = new JSONObject();
            JSONObject guardian = new JSONObject();
            JSONObject gName = new JSONObject();
            JSONObject address = new JSONObject();

            name.put("firstName", fName);
            name.put("lastName", lName);
            newStudent.put("name", name);
            newStudent.put("dob", dateOfBirth);
            newStudent.put("gender", gen);
            newStudent.put("phoneNumber", phone);

            gName.put("firstName", gFName);
            gName.put("lastName", gLName);
            guardian.put("name", gName);
            guardian.put("gender", gGender);
            guardian.put("phoneNumber", gPhone);
            newStudent.put("guardian", guardian);

            address.put("commune", com);
            address.put("district", dis);
            address.put("province", pro);
            newStudent.put("address", address);

            newStudent.put("generation", gener);
            newStudent.put("department", dep);
            newStudent.put("specialization", spec);
            newStudent.put("email", em);
            newStudent.put("password", Hasher.hash(password));
            newStudent.put("createdAt", formattedDate);
            newStudent.put("lastLogin", "");
            newStudent.put("progress", new JSONObject());
            newStudent.put("status", "active");

            manageStudentManager.manageAddEntity(newStudent);

            System.out.println("Contents to be added");
            System.out.println(fName);
            System.out.println(lName);
            System.out.println(dateOfBirth);
            System.out.println(gen);
            System.out.println(phone);
            System.out.println(em);
            System.out.println(password);
            System.out.println(newStudent);
            System.out.println("Added Successfully");

            SceneManager.setScene("success");
            PauseTransition delay = new PauseTransition(Duration.seconds(2));
            delay.setOnFinished(ev -> {
                SceneManager.setScene("addStudent");
                resetAllFields();
            });

            delay.play();
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
//        firstName.clear();
//        lastName.clear();
//        dob.setValue(null);
//        gender.getSelectionModel().clearSelection();
//        phoneNumber.clear();
//        email.clear();
        password.clear();
        confirmPassword.clear();
    }
}