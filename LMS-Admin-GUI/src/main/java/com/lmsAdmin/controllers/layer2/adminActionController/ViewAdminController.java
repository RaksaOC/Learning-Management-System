package main.java.com.lmsAdmin.controllers.layer2.adminActionController;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageAdminManager;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditAdminManager;

import java.util.Map;

public class ViewAdminController extends MainFrameController {


    @FXML
    private ComboBox<String> idComboBox;
    @FXML
    private Button searchButton;

    @FXML
    private TableView<Map<String, String>> tableView;

    @FXML
    private TableColumn<Map<String, String>, String> idColumn;
    @FXML
    private TableColumn<Map<String, String>, String> firstNameColumn;
    @FXML
    private TableColumn<Map<String, String>, String> lastNameColumn;
    @FXML
    private TableColumn<Map<String, String>, String> genderColumn;
    @FXML
    private TableColumn<Map<String, String>, String> dobColumn;
    @FXML
    private TableColumn<Map<String, String>, String> phoneColumn;
    @FXML
    private TableColumn<Map<String, String>, String> emailColumn;
    @FXML
    private TableColumn<Map<String, String>, String> createdAtColumn;
    @FXML
    private TableColumn<Map<String, String>, String> lastLogInColumn;

    @FXML
    private VBox detailsVBox;

    @FXML
    public void initialize() {
        idComboBox.getItems().addAll(new EditAdminManager().loadIdsAndName());
        fillTable();
    }

    @FXML
    private void handleSearch(MouseEvent event) {
        createDetails();
    }

    private void fillTable() {
        ManageAdminManager manageAdminManager = new ManageAdminManager();
        ObservableList<Map<String, String>> allData = manageAdminManager.getAllAdminDetails();

        // Set the cell value factory for each column
        idColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("id")));
        firstNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("first_name")));
        lastNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("last_name")));
        genderColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("gender")));
        dobColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("dob")));
        phoneColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("phone")));
        emailColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("email")));
        createdAtColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("created_at")));
        lastLogInColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("last_login")));

        // Set the data to the TableView
        tableView.setItems(allData);
    }

    public void createDetails() {
        String idToSearch = idComboBox.getValue();
        idToSearch = idToSearch.substring(0, idToSearch.indexOf(" "));
        ManageAdminManager manageAdminManager = new ManageAdminManager();
        Map<String, String> details = manageAdminManager.getAdminDetails(idToSearch);

        // Create VBox to hold the text elements
        detailsVBox.getChildren().clear();
        detailsVBox.setStyle("-fx-background-color: #ebebeb");
        detailsVBox.setAlignment(Pos.CENTER_LEFT);
        detailsVBox.setSpacing(10);

        // Extract values from the map
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

        // Font for the text
        Font textFont = Font.font("Gill Sans", 25);

        // Create Text objects
        Text idText = new Text("ID: " + id);
        Text nameText = new Text("Name: " + name);
        Text genderText = new Text("Gender: " + gender);
        Text dobText = new Text("DOB: " + dateOfBirth);
        Text phoneText = new Text("Phone: " + phone);
        Text emailText = new Text("Email: " + email);
        Text createdAtText = new Text("Created At: " + createdAt);
        Text lastLogText = new Text("Last Login: " + lastLog);

        // Set the font for all text elements
        Text[] textNodes = {idText, nameText, genderText, dobText, phoneText, emailText, createdAtText, lastLogText};
        for (Text text : textNodes) {
            text.setFont(textFont);
        }

        // Add all text nodes to the VBox
        detailsVBox.getChildren().addAll(textNodes);
    }
}
