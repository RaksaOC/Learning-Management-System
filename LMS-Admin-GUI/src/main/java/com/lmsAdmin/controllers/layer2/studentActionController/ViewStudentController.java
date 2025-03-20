package main.java.com.lmsAdmin.controllers.layer2.studentActionController;

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
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageStudentManager;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditStudentManager;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.Map;


public class ViewStudentController extends MainFrameController {

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
    private TableColumn<Map<String, String>, String> phoneColumn;
    @FXML
    private TableColumn<Map<String, String>, String> emailColumn;
    @FXML
    private TableColumn<Map<String, String>, String> genColumn;
    @FXML
    private TableColumn<Map<String, String>, String> depColumn;
    @FXML
    private TableColumn<Map<String, String>, String> specColumn;

    @FXML
    private VBox detailsVBox;

    private String selectedId;

    @FXML
    public void initialize() {
        idComboBox.getItems().addAll(new EditStudentManager().loadIdsAndName());
        initTableView();
    }

    private void initTableView() {
        ManageStudentManager manageStudentManager = new ManageStudentManager();
        ObservableList<Map<String, String>> data = manageStudentManager.getAllStudentDetails();

        idColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("id").toString()));
        firstNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("first_name").toString()));
        lastNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("last_name").toString()));
        genderColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("gender").toString()));
        phoneColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("phone_number").toString()));
        emailColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("email").toString()));
        genColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("generation_id").toString()));
        specColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("specialization_id").toString()));
        depColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("department_id").toString()));

        tableView.setItems(data);
    }

    @FXML
    private void handleSearch(MouseEvent event) {
        this.selectedId = idComboBox.getSelectionModel().getSelectedItem().toString().substring(0, idComboBox.getSelectionModel().getSelectedItem().toString().indexOf(" "));
        createDetails();
    }

    private void createDetails() {
        ManageStudentManager manageStudentManager = new ManageStudentManager();
        Map<String, String> details = manageStudentManager.getStudentDetails(selectedId);
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
        String commune = details.get("commune");
        String district = details.get("district");
        String province = details.get("province");

        String generation = details.get("generation_id");
        String department = details.get("department_id");
        String specialization = details.get("specialization_id");
        String guardianName = details.get("guardian_first_name") + " " + details.get("guardian_last_name");
        String createdAt = details.get("created_at");
        String lastLog = details.get("last_login");

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
//        Text classroomText = new Text("Classrooms: " + classroomsString);
        Text createdAtText = new Text("Created At: " + createdAt);
        Text lastLogText = new Text("Last Login: " + lastLog);

        Text[] textNodes = {idText, nameText, genderText, dob, phoneText, emailText, guardianNameText, provinceText, communeText, districtText, generationText, departmentText, specializationText, createdAtText, lastLogText};
        for (Text text : textNodes) {
            text.setFont(textFont);
        }

        detailsVBox.getChildren().addAll(textNodes);
    }
}