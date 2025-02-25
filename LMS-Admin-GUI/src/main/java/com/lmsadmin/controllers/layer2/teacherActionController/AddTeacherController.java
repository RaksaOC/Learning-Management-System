package main.java.com.lmsadmin.controllers.layer2.teacherActionController;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import lib.Hasher;
import main.SceneManager;
import main.java.com.lmsadmin.controllers.layer0.MainFrameController;
import main.java.com.lmsadmin.managers.layer2.manage_entity_manager.ManageTeacherManager;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddTeacherController extends MainFrameController {
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private DatePicker dob;
    @FXML
    private ComboBox gender;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private TextField confirmPassword;
    @FXML
    private Button addButton;

    @FXML
    private void handleAdd(MouseEvent event) {
        if(isPasswordSame(password.getText(), confirmPassword.getText())){
            String fName = firstName.getText();
            String lName = lastName.getText();
            String dateOfBirth = dob.getValue().toString();
            String gen = gender.getSelectionModel().getSelectedItem().toString();
            String phone = phoneNumber.getText();
            String password = confirmPassword.getText();
            String em = email.getText();

            ManageTeacherManager manageTeacherManager = new ManageTeacherManager();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String formattedDate = now.format(formatter);

            JSONObject newTeacher = new JSONObject();

            JSONObject name = new JSONObject();

            name.put("firstName", fName);
            name.put("lastName", lName);
            newTeacher.put("name", name);
            newTeacher.put("dob", dateOfBirth);
            newTeacher.put("gender", gen);
            newTeacher.put("phoneNumber", phone);
            newTeacher.put("email", em);
            newTeacher.put("password", Hasher.hash(password));
            newTeacher.put("createdAt", formattedDate);
            newTeacher.put("lastLogin", "");
            newTeacher.put("classrooms", new JSONArray());
            newTeacher.put("status", "active");

            manageTeacherManager.manageAddEntity(newTeacher);

            System.out.println("Contents to be added");
            System.out.println(fName);
            System.out.println(lName);
            System.out.println(dateOfBirth);
            System.out.println(gen);
            System.out.println(phone);
            System.out.println(em);
            System.out.println(password);
            System.out.println(newTeacher);
            System.out.println("Added Successfully");

            SceneManager.setScene("success");
            PauseTransition delay = new PauseTransition(Duration.seconds(2));
            delay.setOnFinished(ev -> {
                SceneManager.setScene("addTeacher");
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
            resetPassFields();
        }

    }

    private boolean isPasswordSame(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    private void resetAllFields(){
        firstName.clear();
        lastName.clear();
        dob.setValue(null);
        gender.getSelectionModel().clearSelection();
        phoneNumber.clear();
        confirmPassword.clear();
        email.clear();
        password.clear();
    }

    private void resetPassFields() {
        password.clear();
        confirmPassword.clear();
    }
}