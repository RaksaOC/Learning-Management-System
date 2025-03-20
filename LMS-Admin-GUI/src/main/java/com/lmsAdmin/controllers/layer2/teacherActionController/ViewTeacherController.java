package main.java.com.lmsAdmin.controllers.layer2.teacherActionController;

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
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageTeacherManager;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditTeacherManager;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

public class ViewTeacherController extends MainFrameController {

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
    private VBox detailsVBox;

    private String selectedId;

    @FXML
    public void initialize() {
        idComboBox.getItems().addAll(new EditTeacherManager().loadIdsAndName());
        initTableView();
    }

    private void initTableView() {
        ManageTeacherManager manageTeacherManager = new ManageTeacherManager();
        ObservableList<Map<String, String>> data = manageTeacherManager.getAllTeacherDetails();

        idColumn.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().get("id").toString()));
        firstNameColumn.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().get("first_name").toString()));
        lastNameColumn.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().get("last_name").toString()));
        genderColumn.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().get("gender").toString()));
        dobColumn.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().get("dob").toString()));
        phoneColumn.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().get("phone_number").toString()));
        emailColumn.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().get("email").toString()));

        tableView.setItems(data);
    }

    @FXML
    private void handleSearch(MouseEvent event) {
        selectedId = idComboBox.getSelectionModel().getSelectedItem().toString().substring(0, idComboBox.getSelectionModel().getSelectedItem().indexOf(" "));
        createDetails();
    }


    private void createDetails(){
        String idToSearch = selectedId;
        ManageTeacherManager manageTeacherManager = new ManageTeacherManager();
        Map<String, String> details = manageTeacherManager.getTeacherDetails(idToSearch);
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
}