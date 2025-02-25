package main.java.com.lmsadmin.controllers.layer2.studentActionController;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import main.java.com.lmsadmin.controllers.layer0.MainFrameController;
import main.java.com.lmsadmin.managers.layer2.manage_entity_manager.ManageStudentManager;
import org.json.JSONObject;

import java.util.Iterator;

public class DeleteStudentController extends MainFrameController{
    @FXML
    private TextField idField;
    @FXML
    private Button searchButton;
    @FXML
    private Button deleteButton;
    @FXML
    private VBox detailsVBox;

    @FXML
    private void handleSearch(MouseEvent event) {
        createDetails();
    }

    @FXML
    private void handleDelete(MouseEvent event) {
        if(isConfirmed()){
            ManageStudentManager manageStudentManager = new ManageStudentManager();
            manageStudentManager.manageDeleteEntity(idField.getText());

            loadSuccess("deleteStudent");
            clearDetails();
        }
        else{
            clearDetails();
        }
    }

    private void createDetails(){
        String idToSearch = idField.getText();
        ManageStudentManager manageStudentManager = new ManageStudentManager();
        JSONObject details = manageStudentManager.getDetails(idToSearch);
        detailsVBox.getChildren().clear();
        detailsVBox.setStyle("-fx-background-color: #ebebeb");
        Pos center_left = Pos.CENTER_LEFT;
        detailsVBox.setAlignment(center_left);
        detailsVBox.setSpacing(10);
        String id = details.getString("id");
        String firstName = details.getJSONObject("name").getString("firstName");
        String lastName = details.getJSONObject("name").getString("lastName");
        String name = firstName + " " + lastName;
        String gender = details.getString("gender");
        String dateOfBirth = details.getString("dob");
        String phone = details.getString("phoneNumber");
        String email = details.getString("email");
        String commune = details.getJSONObject("address").getString("commune");
        String district = details.getJSONObject("address").getString("district");
        String province= details.getJSONObject("address").getString("province");

        String generation = details.getString("generation");
        String department = details.getString("department");
        String specialization = details.getString("specialization");
        String guardianName = details.getJSONObject("guardian").getJSONObject("name").getString("firstName") + " " + details.getJSONObject("guardian").getJSONObject("name").getString("lastName");
        String createdAt = details.getString("createdAt");
        String lastLog = details.getString("lastLogin");

        JSONObject classrooms = details.getJSONObject("progress");
        StringBuilder progressText = new StringBuilder();

        Iterator<String> keys = classrooms.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            String value = classrooms.getString(key);
            progressText.append(key).append(": ").append(value);

            if (keys.hasNext()) {
                progressText.append(", ");
            }
        }

        String classroomsString = progressText.toString();

        Font textFont = Font.font("Gill Sans", 25);

        Text idText = new Text("ID: " + id);
        Text nameText = new Text("Name: " + name);
        Text genderText = new Text("Gender: " + gender);
        Text dob = new Text("DOB: " + dateOfBirth);
        Text phoneText = new Text("Phone: " + phone);
        Text emailText = new Text("Email: " + email);
        Text guardianNameText = new Text("Guardian Name: " + guardianName);
        Text provinceText = new Text("District: " + province);
        Text communeText = new Text("Commune: " + commune);
        Text districtText = new Text("District: " + district);
        Text generationText = new Text("Generation: " + generation);
        Text departmentText = new Text("Department: " + department);
        Text specializationText = new Text("Specialization: " + specialization);
        Text classroomText = new Text("Classrooms: " + classroomsString);
        Text createdAtText = new Text("Created At: " + createdAt);
        Text lastLogText = new Text("Last Login: " + lastLog);

        Text[] textNodes = {idText, nameText, genderText, dob, phoneText, emailText, guardianNameText, provinceText, communeText, districtText, generationText, departmentText, specializationText, classroomText, createdAtText, lastLogText};
        for (Text text : textNodes) {
            text.setFont(textFont);
        }

        detailsVBox.getChildren().addAll(textNodes);
    }

    private void clearDetails(){
        idField.clear();
        detailsVBox.getChildren().clear();
    }
}