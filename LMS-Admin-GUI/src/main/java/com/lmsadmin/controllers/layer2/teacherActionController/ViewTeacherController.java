package main.java.com.lmsadmin.controllers.layer2.teacherActionController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import main.java.com.lmsadmin.controllers.layer0.MainFrameController;
import main.java.com.lmsadmin.managers.layer2.manage_entity_manager.ManageTeacherManager;
import org.json.JSONArray;
import org.json.JSONObject;

public class ViewTeacherController extends MainFrameController {

    @FXML
    private TextField idField;
    @FXML
    private Button searchButton;

    @FXML
    private TableView<JSONObject> tableView;
    @FXML
    private TableColumn<JSONObject, String> idColumn;
    @FXML
    private TableColumn<JSONObject, String> firstNameColumn;
    @FXML
    private TableColumn<JSONObject, String> lastNameColumn;
    @FXML
    private TableColumn<JSONObject, String> genderColumn;
    @FXML
    private TableColumn<JSONObject, String> dobColumn;
    @FXML
    private TableColumn<JSONObject, String> phoneColumn;
    @FXML
    private TableColumn<JSONObject, String> emailColumn;
    @FXML
    private TableColumn<JSONObject, String> createdAtColumn;
    @FXML
    private TableColumn<JSONObject, String> lastLoginColumn;

    @FXML
    private VBox detailsVBox;

    @FXML
    public void initialize() {
        ManageTeacherManager manageTeacherManager = new ManageTeacherManager();
        JSONArray all = manageTeacherManager.getAllDetails();

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
        lastLoginColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "lastLogin"));

        // Set data to table
        tableView.setItems(data);
    }

    @FXML
    private void handleSearch(MouseEvent event) {
        createDetails();
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


    private javafx.beans.property.SimpleStringProperty getJSONValue(JSONObject obj, String key) {
        return switch (key) {
            case "firstName" ->
                    new javafx.beans.property.SimpleStringProperty(obj.optJSONObject("name").optString("firstName", "N/A"));
            case "lastName" ->
                    new javafx.beans.property.SimpleStringProperty(obj.optJSONObject("name").optString("lastName", "N/A"));
            default -> new javafx.beans.property.SimpleStringProperty(obj.optString(key, "N/A"));
        };
    }
}