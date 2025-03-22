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

import java.util.Map;
import java.util.Optional;

public class DeleteAdminController extends MainFrameController {
    private final ManageAdminManager manageAdminManager = new ManageAdminManager();

    @FXML
    private Button searchButton;
    @FXML
    private Button deleteButton;
    @FXML
    private ComboBox<String> idComboBox;
    @FXML
    private VBox detailsVBox;

    private String selectedLongId;

    public void initialize() {
        EditAdminManager idLoader = new EditAdminManager();
        idComboBox.getItems().addAll(idLoader.loadIdsAndName());
    }

    @FXML
    private void handleSearch(MouseEvent event) {
        createDetails();
    }

    @FXML
    private void handleDelete(MouseEvent event) {
        selectedLongId = idComboBox.getSelectionModel().getSelectedItem();
        if (isConfirmed()) {
            manageAdminManager.manageDeleteAdmin(extractId(selectedLongId));
            loadSuccess("deleteAdmin");
            SceneManager.refreshScenes();
        } else {
            clearDetails();
        }
    }

    public void createDetails() {
        String idToSearch = idComboBox.getValue();
        ManageAdminManager manageAdminManager = new ManageAdminManager();
        Map<String, String> details = manageAdminManager.getAdminDetails(idToSearch);

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

    private void clearDetails() {
        idComboBox.getSelectionModel().clearSelection();
        detailsVBox.getChildren().clear();
    }
}