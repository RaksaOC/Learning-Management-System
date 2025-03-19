package main.java.com.lmsAdmin.controllers.layer2.courseActionController;

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
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageCourseManager;
import org.json.JSONObject;

import java.util.Map;


public class ViewCourseController extends MainFrameController {

    @FXML
    private ComboBox <String> idComboBox;

    @FXML
    private TableView<Map<String, String>> tableView;
    @FXML
    private TableColumn<Map<String, String>, String> idColumn;
    @FXML
    private TableColumn<Map<String, String>, String> nameColumn;
    @FXML
    private TableColumn<Map<String, String>, String> creditColumn;
    @FXML
    private TableColumn<Map<String, String>, String> levelColumn;
    @FXML
    private TableColumn<Map<String, String>, String> descColumn;

//    @FXML
//    private TableView<JSONObject> tableView;
//    @FXML
//    private TableColumn<JSONObject, String> idColumn;
//    @FXML
//    private TableColumn<JSONObject, String> nameColumn;
//    @FXML
//    private TableColumn<JSONObject, String> creditColumn;
//    @FXML
//    private TableColumn<JSONObject, String> levelColumn;
//    @FXML
//    private TableColumn<JSONObject, String> descColumn;

    @FXML
    public void initialize() {
       initTableViewSql();
    }
    private void initTableViewSql(){
        ManageCourseManager manager = new ManageCourseManager();
        ObservableList<Map<String, String>> details = manager.getAllDetailsSql();

        idColumn.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().get("id")));
        nameColumn.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().get("name")));
        creditColumn.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().get("credit")));
        levelColumn.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().get("level")));
        descColumn.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().get("desc")));
        tableView.setItems(details);
    }

//    private void initTableViewJSON() {
//        ManageCourseManager manageCourseManager = new ManageCourseManager();
//        JSONArray all = manageCourseManager.getAllDetailsJSON();
//
//        // Convert JSON data to ObservableList
//        ObservableList<JSONObject> data = FXCollections.observableArrayList();
//        for (int i = 0; i < all.length(); i++) {
//            data.add(all.getJSONObject(i));
//        }
//
//        // Set up column cell value factories
//        idColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "id"));
//        nameColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "name"));
//        creditColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "credit"));
//        levelColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "level"));
//        descColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "description"));
//
//
//        // Set data to table
//        tableView.setItems(data);
//    }
//
//    private void createDetailsJSON() {
//        String idToSearch = idComboBox.getValue();
//        ManageCourseManager manageCourseManager = new ManageCourseManager();
//        JSONObject details = manageCourseManager.getDetailsJSON(idToSearch);
//
//        detailsVBox.getChildren().clear();
//        detailsVBox.setStyle("-fx-background-color: #ebebeb");
//        Pos center_left = Pos.CENTER_LEFT;
//        detailsVBox.setAlignment(center_left);
//        detailsVBox.setSpacing(10);
//
//        String id = details.getString("id");
//        String name = details.getString("name");
//        String credit = details.getString("credit");
//        String level = details.getString("level");
//        String description  = details.getString("description");
//
//        Font textFont = Font.font("Gill Sans", 25);
//
//        Text idText = new Text("ID: " + id);
//        Text nameText = new Text("Name: " + name);
//        Text creditText = new Text("Credit: " + credit);
//        Text levelText = new Text("Level: " + level);
//        Text descriptionText = new Text("Description: " + description);
//
//        Text[] textNodes = {idText, nameText, creditText, levelText, descriptionText};
//        for (Text text : textNodes) {
//            text.setFont(textFont);
//        }
//
//        detailsVBox.getChildren().addAll(textNodes);
//    }

//    private javafx.beans.property.SimpleStringProperty getJSONValue(JSONObject obj, String key) {
//        return new javafx.beans.property.SimpleStringProperty(obj.optString(key, "N/A"));
//    }
}