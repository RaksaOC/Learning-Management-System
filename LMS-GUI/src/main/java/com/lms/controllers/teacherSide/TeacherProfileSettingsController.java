package main.java.com.lms.controllers.teacherSide;

import entities.Student;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import main.AppSession;

public class TeacherProfileSettingsController {
    @FXML
    private ImageView profileImage;
    @FXML
    private Text name;
    @FXML
    private Text teacherID;
    @FXML
    private Text gender;
    @FXML
    private Text dob;
    @FXML
    private Text email;
    @FXML
    private Text phone;
    @FXML
    private Text lastLoggedIn;

    public void initialize() {
        AppSession session = AppSession.getInstance();
        this.name.setText(session.getTeacher().getFullName());
        this.teacherID.setText("Teacher ID: " + session.getTeacher().getId());
        this.gender.setText("Gender: "+ session.getTeacher().getGender());
        this.email.setText("Email: " + session.getTeacher().getEmail());
        this.phone.setText("Tel." + session.getTeacher().getPhone());
        this.dob.setText(session.getTeacher().getDoB());
        this.lastLoggedIn.setText(session.getTeacher().getLastLogin());
    }
}