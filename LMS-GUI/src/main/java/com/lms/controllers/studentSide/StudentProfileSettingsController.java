package main.java.com.lms.controllers.studentSide;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import main.AppSession;
import main.SceneManager;
import main.ThemeManager;

import java.util.concurrent.atomic.AtomicBoolean;

public class StudentProfileSettingsController {
    @FXML
    private ImageView profileImage;
    @FXML
    private Text name;
    @FXML
    private Text studentID;
    @FXML
    private Text generation;
    @FXML
    private Text department;
    @FXML
    private Text specialization;
    @FXML
    private Text gender;
    @FXML
    private Text dob;
    @FXML
    private Text address;
    @FXML
    private Text email;
    @FXML
    private Text phone;
    @FXML
    private Text gName;
    @FXML
    private Text gGender;
    @FXML
    private Text gPhone;
    @FXML
    private Text lastLoggedIn;
    @FXML
    private HBox themeToggleWrapper;
    @FXML
    private VBox themeSwitch;
    @FXML
    private VBox themeToggleLabel;

    public void initialize() {
        initPersonalInfo();
        initSettings();
    }

    private void initPersonalInfo(){
        AppSession session = AppSession.getInstance();
        this.name.setText(session.getStudent().getFullName());
        this.studentID.setText("Student ID: " + session.getStudent().getId());
        this.generation.setText("Generation: " + session.getStudent().getGeneration());
        this.department.setText("Department: " + session.getStudent().getDepartment());
        this.specialization.setText("Specialization: " + session.getStudent().getSpecialization());
        this.gender.setText(session.getStudent().getGender());
        this.dob.setText(session.getStudent().getDoB());
        this.address.setText(session.getStudent().getCommune() + ", " + session.getStudent().getDistrict() + ", " + session.getStudent().getProvince());
        this.email.setText(session.getStudent().getEmail());
        this.phone.setText(session.getStudent().getPhone());
        this.gName.setText(session.getStudent().getGuardianFirstName() + " " + session.getStudent().getGuardianLastName());
        this.gGender.setText(session.getStudent().getGuardianGender());
        this.gPhone.setText(session.getStudent().getGuardianPhoneNumber());
        this.lastLoggedIn.setText(session.getStudent().getLastLogin());
    }

    private void initSettings(){
        AtomicBoolean isOn = new AtomicBoolean(false);
        themeToggleWrapper.setOnMouseClicked(event -> {
            if (!isOn.get()) {
                // ON State (left side filled, right side empty)
                themeSwitch.setStyle("-fx-background-color: white; -fx-border-radius: 20; -fx-background-radius: 20");
                themeToggleLabel.setStyle("-fx-background-color: #2F92BC; -fx-background-radius: 20; -fx-border-radius: 20");

                themeSwitch.getChildren().clear();
                themeToggleLabel.getChildren().clear();

                Text onLabel = new Text("ON");
                onLabel.setFill(Color.BLACK);
                onLabel.setFont(Font.font("AppleGothic", 13));

                themeSwitch.setAlignment(Pos.CENTER);
                themeSwitch.getChildren().add(onLabel); // Add text to the left side

//                ThemeManager.toggleTheme(SceneManager.getMainLayout());
                isOn.set(true);
            } else {
                // OFF State (right side filled, left side empty)
                themeSwitch.setStyle("-fx-background-color: #2F92BC; -fx-border-radius: 20; -fx-background-radius: 20");
                themeToggleLabel.setStyle("-fx-background-color: white; -fx-background-radius: 20; -fx-border-radius: 20");

                themeSwitch.getChildren().clear();
                themeToggleLabel.getChildren().clear();

                Text offLabel = new Text("OFF");
                offLabel.setFill(Color.BLACK);
                offLabel.setFont(Font.font("AppleGothic", 13));

                themeToggleLabel.setAlignment(Pos.CENTER);
                themeToggleLabel.getChildren().add(offLabel); // Add text to the right side
//                ThemeManager.toggleTheme(SceneManager.getMainLayout());

                isOn.set(false);
            }
        });

        themeToggleWrapper.setOnMouseEntered(event -> {
            themeToggleWrapper.setOpacity(0.9);
        });
        themeToggleWrapper.setOnMouseExited(event -> {
            themeToggleWrapper.setOpacity(1);
        });

    }
}