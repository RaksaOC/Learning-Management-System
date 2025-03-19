package main.java.com.lmsAdmin.controllers.layer2.adminActionController;

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
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageAdminManager;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditAdminManager;
import org.json.JSONObject;

import java.util.Map;
import java.util.Optional;

public class DeleteAdminController extends MainFrameController {
    @FXML
    private Button searchButton;
    @FXML
    private Button deleteButton;
    @FXML
    private ComboBox<String> idComboBox;
    @FXML
    private VBox detailsVBox;

    public void initialize() {
        EditAdminManager idLoader = new EditAdminManager();
        idComboBox.getItems().addAll(idLoader.loadIdsAndNameSQL());
//        idComboBox.getItems().addAll(idLoader.loadIdsAndNameJSON());
    }

    @FXML
    private void handleSearch(MouseEvent event) {
        createDetailsSQL();
//        createDetails();
    }

    @FXML
    private void handleDelete(MouseEvent event) {
        if (showDeleteConfirmation()) {
            ManageAdminManager manageAdminManager = new ManageAdminManager();

            // with JSON
            manageAdminManager.manageDeleteEntity(idComboBox.getValue());
            // With sql
            manageAdminManager.manageDeleteEntitySQL(idComboBox.getValue());

            SceneManager.setScene("success"); // Show success screen
            PauseTransition delay = new PauseTransition(Duration.seconds(2)); // 2-second delay
            delay.setOnFinished(ev -> {
                SceneManager.setScene("deleteAdmin");
                clearDetails();
            });

            delay.play();
        } else {
            clearDetails();
        }
    }

    public void createDetailsSQL() {
        String idToSearch = idComboBox.getValue();
        ManageAdminManager manageAdminManager = new ManageAdminManager();
        Map<String, String> details = manageAdminManager.getDetailsSQL(idToSearch);

        VBox detailsVBox = new VBox();

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
        Text dobText = new Text("DOB: " + dateOfBirth);
        Text phoneText = new Text("Phone: " + phone);
        Text emailText = new Text("Email: " + email);
        Text createdAtText = new Text("Created At: " + createdAt);
        Text lastLogText = new Text("Last Login: " + lastLog);

        Text[] textNodes = {idText, nameText, genderText, dobText, phoneText, emailText, createdAtText, lastLogText};
        for (Text text : textNodes) {
            text.setFont(textFont);
        }

        detailsVBox.getChildren().addAll(textNodes);
    }

//    private void createDetails() {
//        String idToSearch = idComboBox.getValue();
//        ManageAdminManager manageAdminManager = new ManageAdminManager();
//        JSONObject details = manageAdminManager.getDetailsJSON(idToSearch);
//        detailsVBox.getChildren().clear();
//        detailsVBox.setStyle("-fx-background-color: #ebebeb");
//        Pos center_left = Pos.CENTER_LEFT;
//        detailsVBox.setAlignment(center_left);
//        detailsVBox.setSpacing(10);
//        String id = details.getString("id");
//        String firstName = details.getJSONObject("name").getString("firstName");
//        String lastName = details.getJSONObject("name").getString("lastName");
//        String name = firstName + " " + lastName;
//        String gender = details.getString("gender");
//        String dateOfBirth = details.getString("dob");
//        String phone = details.getString("phoneNumber");
//        String email = details.getString("email");
//        String createdAt = details.getString("createdAt");
//        String lastLog = details.getString("lastLogin");
//
//        Font textFont = Font.font("Gill Sans", 25);
//
//        Text idText = new Text("ID: " + id);
//        Text nameText = new Text("Name: " + name);
//        Text genderText = new Text("Gender: " + gender);
//        Text dob = new Text("DOB: " + dateOfBirth);
//        Text phoneText = new Text("Phone: " + phone);
//        Text emailText = new Text("Email: " + email);
//        Text createdAtText = new Text("Created At: " + createdAt);
//        Text lastLogText = new Text("Last Login: " + lastLog);
//
//        Text[] textNodes = {idText, nameText, genderText, dob, phoneText, emailText, createdAtText, lastLogText};
//        for (Text text : textNodes) {
//            text.setFont(textFont);
//        }
//
//        detailsVBox.getChildren().addAll(textNodes);
//    }

    private boolean showDeleteConfirmation() {
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Confirmation");
        confirmation.setHeaderText(null);
        confirmation.setContentText("Are you sure you want to delete this admin?");
        Optional<ButtonType> result = confirmation.showAndWait();
        if (result.get() == ButtonType.OK) {
            return true;
        }
        return false;
    }

    private void clearDetails() {
        idComboBox.getSelectionModel().clearSelection();
        detailsVBox.getChildren().clear();
    }
}