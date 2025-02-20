package main.java.com.lmsadmin.controllers.layer2.studentActionController;

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
import main.java.com.lmsadmin.managers.manage_entity_manager.ManageAdminManager;
import main.java.com.lmsadmin.managers.manage_entity_manager.ManageStudentManager;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;


public class ViewStudentController extends MainFrameController {

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
    private TableColumn<JSONObject, String> communeColumn;
    @FXML
    private TableColumn<JSONObject, String> districtColumn;
    @FXML
    private TableColumn<JSONObject, String> provinceColumn;
    @FXML
    private TableColumn<JSONObject, String> gFNameColumn;
    @FXML
    private TableColumn<JSONObject, String> gLNameColumn;
    @FXML
    private TableColumn<JSONObject, String> gPhoneColumn;
    @FXML
    private TableColumn<JSONObject, String> gGenderColumn;
    @FXML
    private TableColumn<JSONObject, String> genColumn;
    @FXML
    private TableColumn<JSONObject, String> depColumn;
    @FXML
    private TableColumn<JSONObject, String> specColumn;

    @FXML
    private VBox detailsVBox;

    @FXML
    public void initialize() {
        ManageStudentManager manageStudentManager = new ManageStudentManager();
        JSONArray all = manageStudentManager.getAllDetails();

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
        communeColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "commune"));
        districtColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "district"));
        provinceColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "province"));
        gFNameColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "gFirstName"));
        gLNameColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "gLastName"));
        gGenderColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "gGender"));
        gPhoneColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "gPhoneNumber"));
        genColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "generation"));
        depColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "department"));
        specColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "specialization"));

        // Set data to table
        tableView.setItems(data);
    }

    @FXML
    private void handleSearch(MouseEvent event) {
        createDetails();
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


    private javafx.beans.property.SimpleStringProperty getJSONValue(JSONObject obj, String key) {
        return switch (key) {
            case "firstName" ->
                    new javafx.beans.property.SimpleStringProperty(obj.optJSONObject("name").optString("firstName", "N/A"));
            case "lastName" ->
                    new javafx.beans.property.SimpleStringProperty(obj.optJSONObject("name").optString("lastName", "N/A"));
            case "commune" ->
                    new javafx.beans.property.SimpleStringProperty(obj.optJSONObject("address").optString("commune", "N/A"));
            case "district" ->
                    new javafx.beans.property.SimpleStringProperty(obj.optJSONObject("address").optString("district", "N/A"));
            case "province" ->
                    new javafx.beans.property.SimpleStringProperty(obj.optJSONObject("address").optString("province", "N/A"));
            case "gFirstName" ->
                    new javafx.beans.property.SimpleStringProperty(obj.optJSONObject("guardian").getJSONObject("name").optString("firstName", "N/A"));
            case "gLastName" ->
                    new javafx.beans.property.SimpleStringProperty(obj.optJSONObject("guardian").getJSONObject("name").optString("lastName", "N/A"));
            case "gGender" ->
                    new javafx.beans.property.SimpleStringProperty(obj.optJSONObject("guardian").optString("gender", "N/A"));
            case "gPhoneNumber" ->
                    new javafx.beans.property.SimpleStringProperty(obj.optJSONObject("guardian").optString("phoneNumber", "N/A"));
            default -> new javafx.beans.property.SimpleStringProperty(obj.optString(key, "N/A"));
        };

    }
}