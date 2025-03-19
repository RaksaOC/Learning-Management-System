package main.java.com.lmsAdmin.controllers.layer2.teacherActionController;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import main.SceneManager;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageTeacherManager;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditTeacherManager;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;
import java.util.Optional;

public class DeleteTeacherController extends MainFrameController{
    @FXML
    private ComboBox <String> idComboBox;
    @FXML
    private Button searchButton;
    @FXML
    private Button deleteButton;
    @FXML
    private VBox detailsVBox;

    private String selectedId;

    public void initialize() {
        idComboBox.getItems().addAll(new EditTeacherManager().loadIdsAndNameSql());

    }

    @FXML
    private void handleSearch(MouseEvent event) {
        // createDetailsJSON();
        createDetailsSql();
    }

    @FXML
    private void handleDelete(MouseEvent event) {
        selectedId = idComboBox.getSelectionModel().getSelectedItem().toString().substring(0, idComboBox.getSelectionModel().getSelectedItem().toString().indexOf(" "));
        handleDeleteSql();
        handleDeleteJSON();
        playSuccessScene();
    }

    private void handleDeleteJSON(){
        if(showDeleteConfirmation()){
            ManageTeacherManager manageTeacherManager = new ManageTeacherManager();
            manageTeacherManager.manageDeleteEntity(selectedId);
        }
        else{
            clearDetails();
        }
    }

    private void handleDeleteSql(){
        if(showDeleteConfirmation()){
            ManageTeacherManager manageTeacherManager = new ManageTeacherManager();
            manageTeacherManager.manageDeleteEntitySql(selectedId);
        }
        else{
            clearDetails();
        }
    }

    private void createDetailsJSON(){
        String idToSearch = selectedId;
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

    private void createDetailsSql(){
        String idToSearch = selectedId;
        ManageTeacherManager manageTeacherManager = new ManageTeacherManager();
        Map<String, String> details = manageTeacherManager.getDetailsSql(idToSearch);
        detailsVBox.getChildren().clear();
        detailsVBox.setStyle("-fx-background-color: #ebebeb");
        Pos center_left = Pos.CENTER_LEFT;
        detailsVBox.setAlignment(center_left);
        detailsVBox.setSpacing(10);
        String id = details.get("id");
        String firstName = details.get("first_name");
        String lastName = details.get("last_name");
        String name = firstName + " " + lastName;
        String gender = details.get("gender");
        String dateOfBirth = details.get("dob");
        String phone = details.get("phone_number");
        String email = details.get("email");
        String createdAt = details.get("created_at");
        String lastLog = details.get("last_login");

        Font textFont = Font.font("Gill Sans", 25);

        Text idText = new Text("ID: " + id);
        Text nameText = new Text("Name: " + name);
        Text genderText = new Text("Gender: " + gender);
        Text dob = new Text("DOB: " + dateOfBirth);
        Text phoneText = new Text("Phone: " + phone);
        Text emailText = new Text("Email: " + email);
        Text createdAtText = new Text("Created At: " + createdAt);
        Text lastLogText = new Text("Last Login: " + lastLog);

        Text[] textNodes = {idText, nameText, genderText, dob, phoneText, emailText, createdAtText, lastLogText};
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
        idComboBox.getSelectionModel().clearSelection();
        detailsVBox.getChildren().clear();
    }

    public void playSuccessScene(){
        SceneManager.setScene("success");
        PauseTransition delay = new PauseTransition(Duration.seconds(2));
        delay.setOnFinished(ev -> {
            SceneManager.setScene("addGeneration");
            clearDetails();
        });

        delay.play();
    }
}