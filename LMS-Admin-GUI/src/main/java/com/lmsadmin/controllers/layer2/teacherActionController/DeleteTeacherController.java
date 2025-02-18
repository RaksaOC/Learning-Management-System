package main.java.com.lmsadmin.controllers.layer2.teacherActionController;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import main.java.com.lmsadmin.controllers.layer0.MainFrameController;
import main.java.com.lmsadmin.managers.manage_entity_manager.ManageAdminManager;
import main.java.com.lmsadmin.managers.manage_entity_manager.ManageTeacherManager;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Optional;

public class DeleteTeacherController extends MainFrameController{
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
        if(showDeleteConfirmation()){
            ManageTeacherManager manageTeacherManager = new ManageTeacherManager();
            manageTeacherManager.manageDeleteEntity(idField.getText());
        }
        else{
            clearDetails();
        }
    }

    private void createDetails(){
        String idToSearch = idField.getText();
        ManageTeacherManager manageTeacherManager = new ManageTeacherManager();
        JSONObject details = manageTeacherManager.getDetails(idToSearch);
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
        String createdAt = details.getString("createdAt");
        String lastLog = details.getString("lastLogin");

        JSONArray classroomsArray = details.getJSONArray("classrooms");
        StringBuilder classroomsText = new StringBuilder();
        for (int i = 0; i < classroomsArray.length(); i++) {
            classroomsText.append(classroomsArray.getString(i));
            if (i < classroomsArray.length() - 1) {
                classroomsText.append(", ");
            }
        }
        String classrooms = classroomsText.toString();

        Text adminDetails = new Text("Admin Details");

        Font textFont = Font.font("Gill Sans", 25);

        Text idText = new Text("ID: " + id);
        Text nameText = new Text("Name: " + name);
        Text genderText = new Text("Gender: " + gender);
        Text dob = new Text("DOB: " + dateOfBirth);
        Text phoneText = new Text("Phone: " + phone);
        Text emailText = new Text("Email: " + email);
        Text classroomText = new Text("Classrooms: " + classrooms);
        Text createdAtText = new Text("Created At: " + createdAt);
        Text lastLogText = new Text("Last Login: " + lastLog);

        Text[] textNodes = {idText, nameText, genderText, dob, phoneText, classroomText, emailText, createdAtText, lastLogText};
        for (Text text : textNodes) {
            text.setFont(textFont);
        }

        detailsVBox.getChildren().addAll(textNodes);
    }

    private boolean showDeleteConfirmation(){
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Confirmation");
        confirmation.setHeaderText(null);
        confirmation.setContentText("Are you sure you want to delete?");
        Optional<ButtonType> result = confirmation.showAndWait();
        if (result.get() == ButtonType.OK){
            return true;
        }
        return false;
    }

    private void clearDetails(){
        idField.clear();
        detailsVBox.getChildren().clear();
    }
}