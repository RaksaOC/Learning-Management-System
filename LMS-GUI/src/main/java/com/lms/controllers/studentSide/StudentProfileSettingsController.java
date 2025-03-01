package main.java.com.lms.controllers.studentSide;

import entities.Student;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import main.AppSession;

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

    public void initialize() {
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
}