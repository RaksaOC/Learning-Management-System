package main.java.com.lmsAdmin.controllers.layer2.adminActionController;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
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
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
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

    //    @FXML
//    private TableView<JSONObject> tableView;
//    @FXML
//    private TableColumn<JSONObject, String> idColumn;
//    @FXML
//    private TableColumn<JSONObject, String> firstNameColumn;
//    @FXML
//    private TableColumn<JSONObject, String> lastNameColumn;
//    @FXML
//    private TableColumn<JSONObject, String> genderColumn;
//    @FXML
//    private TableColumn<JSONObject, String> dobColumn;
//    @FXML
//    private TableColumn<JSONObject, String> phoneColumn;
//    @FXML
//    private TableColumn<JSONObject, String> emailColumn;
//    @FXML
//    private TableColumn<JSONObject, String> createdAtColumn;
//    @FXML
//    private TableColumn<JSONObject, String> lastLogInColumn;

    @FXML
    private VBox detailsVBox;

    @FXML
    public void initialize() {
        // Uncomment to use the JSON version
        // fillTableJSON();

        // SQL-based implementation
        EditAdminManager idLoader = new EditAdminManager();
        fillTableSQL();
        idComboBox.getItems().addAll(idLoader.loadIdsAndNameSQL());
    }

    @FXML
    private void handleSearch(MouseEvent event) {
        // Uncomment to use the JSON version
        // createDetailsJSON();

        // SQL-based implementation
        createDetailsSQL();
    }

    // ============================
    // SQL-based Implementation
    // ============================


    private void fillTableSQL() {
        ManageAdminManager manageAdminManager = new ManageAdminManager();
        ObservableList<Map<String, String>> allData = manageAdminManager.getAllDetailsSQL();

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

    public void createDetailsSQL() {
        String idToSearch = idComboBox.getValue();
        idToSearch = idToSearch.substring(0, idToSearch.indexOf(" "));
        ManageAdminManager manageAdminManager = new ManageAdminManager();
        Map<String, String> details = manageAdminManager.getDetailsSQL(idToSearch);

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

    // ============================
    // JSON-based Implementation (commented out)
    // ============================



    // Uncomment these methods to use the JSON-based implementation

    /*
    private void fillTableJSON() {
        ManageAdminManager manageAdminManager = new ManageAdminManager();
        JSONArray all = manageAdminManager.getAllDetailsJSON();

        // Convert JSON data to ObservableList
        ObservableList<JSONObject> data = FXCollections.observableArrayList();
        for (int i = 0; i < all.length(); i++) {
            data.add(all.getJSONObject(i));
        }

        // Set up column cell value factories
        idColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "id"));
        firstNameColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "firstName"));
        lastNameColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "lastName"));
        genderColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "gender"));
        dobColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "dob"));
        phoneColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "phoneNumber"));
        emailColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "email"));
        createdAtColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "createdAt"));
        lastLogInColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "lastLogin"));

        // Set data to table
        tableView.setItems(data);
    }

    private void createDetailsJSON() {
        String idToSearch = idField.getText();
        ManageAdminManager manageAdminManager = new ManageAdminManager();
        JSONObject details = manageAdminManager.getDetailsJSON(idToSearch);
        detailsVBox.getChildren().clear();
        detailsVBox.setStyle("-fx-background-color: #ebebeb");
        detailsVBox.setAlignment(Pos.CENTER_LEFT);
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

    private javafx.beans.property.SimpleStringProperty getJSONValue(JSONObject obj, String key) {
        if (key.equals("firstName")) {
            return new javafx.beans.property.SimpleStringProperty(obj.optJSONObject("name").optString("firstName", "N/A"));
        }
        if (key.equals("lastName")) {
            return new javafx.beans.property.SimpleStringProperty(obj.optJSONObject("name").optString("lastName", "N/A"));
        }
        return new javafx.beans.property.SimpleStringProperty(obj.optString(key, "N/A"));
    }
    */

}
