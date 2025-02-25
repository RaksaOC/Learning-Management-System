package main.java.com.lms.controllers.layer2.adminActionController;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import main.SceneManager;
import main.java.com.lms.controllers.layer0.MainFrameController;
import main.java.com.lms.managers.layer2.manage_entity_manager.ManageAdminManager;
import org.json.JSONObject;

import java.util.Optional;

public class DeleteAdminController extends MainFrameController{
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
            ManageAdminManager manageAdminManager = new ManageAdminManager();
            manageAdminManager.manageDeleteEntity(idField.getText());
            SceneManager.setScene("success"); // Show success screen
            PauseTransition delay = new PauseTransition(Duration.seconds(2)); // 2-second delay
            delay.setOnFinished(ev -> {
                SceneManager.setScene("addAdmin"); // Return to addAdmin scene
                clearDetails(); // Clear input fields
            });

            delay.play(); // Start the delay
        }
        else{
            clearDetails();
        }
    }

    private void createDetails(){
        String idToSearch = idField.getText();
        ManageAdminManager manageAdminManager = new ManageAdminManager();
        JSONObject details = manageAdminManager.getDetails(idToSearch);
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
        confirmation.setContentText("Are you sure you want to delete this admin?");
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