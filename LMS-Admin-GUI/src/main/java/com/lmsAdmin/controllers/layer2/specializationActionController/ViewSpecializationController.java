package main.java.com.lmsAdmin.controllers.layer2.specializationActionController;

import javafx.beans.property.SimpleStringProperty;
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
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageSpecializationManager;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;


public class ViewSpecializationController extends MainFrameController {

    @FXML
    private TableView<Map<String, String>> tableView;
    @FXML
    private TableColumn<Map<String, String>, String> idColumn;
    @FXML
    private TableColumn<Map<String, String>, String> dep_idColumn;
    @FXML
    private TableColumn<Map<String, String>, String> nameColumn;

//    @FXML
//    private TableView<JSONObject> tableView;
//    @FXML
//    private TableColumn<JSONObject, String> idColumn;
//    @FXML
//    private TableColumn<JSONObject, String> dep_idColumn;
//    @FXML
//    private TableColumn<JSONObject, String> nameColumn;
//    @FXML
//    private VBox detailsVBox;

    @FXML
    public void initialize() {
        initTableViewSql();
    }

//    private void initTableViewJSON(){
//        ManageSpecializationManager mangeSpecializationManager = new ManageSpecializationManager();
//        JSONArray all = mangeSpecializationManager.getAllDetails();
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
//
//        // Set data to table
//        tableView.setItems(data);
//    }

    private void initTableViewSql() {
        ManageSpecializationManager manager = new ManageSpecializationManager();
        ObservableList<Map<String, String>> data = manager.getAllDetailsSql();

        idColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("id")));
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("name")));
        dep_idColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("department_id")));
        tableView.setItems(data);
    }

//    private javafx.beans.property.SimpleStringProperty getJSONValue(JSONObject obj, String key) {
//        return new javafx.beans.property.SimpleStringProperty(obj.optString(key, "N/A"));
//    }
}