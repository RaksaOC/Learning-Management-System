package main.java.com.lmsAdmin.controllers.layer2.generationActionController;

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
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageDepartmentManager;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageGenerationManager;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;


public class ViewGenerationController extends MainFrameController {

    @FXML
    private TableView<Map<String, String>> tableView;
    @FXML
    private TableColumn<Map<String, String>, String> idColumn;
    @FXML
    private TableColumn<Map<String, String>, String> nameColumn;
    @FXML
    private TableColumn<Map<String, String>, String> statusColumn;

//    @FXML
//    private TableView<JSONObject> tableView;
//    @FXML
//    private TableColumn<JSONObject, String> idColumn;
//    @FXML
//    private TableColumn<JSONObject, String> nameColumn;

    @FXML
    public void initialize() {
        initTableViewSql();
    }

//    private void initTableViewJSON() {
//        ManageGenerationManager manageGenerationManager = new ManageGenerationManager();
//        JSONArray all = manageGenerationManager.getAllDetails();
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
        ManageGenerationManager manager = new ManageGenerationManager();
        ObservableList<Map<String, String>> data = manager.getAllDetailsSql();

        idColumn.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().get("id").toString()));
        nameColumn.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().get("name").toString()));
        statusColumn.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().get("status").toString()));

        tableView.setItems(data);
    }


//    private javafx.beans.property.SimpleStringProperty getJSONValue(JSONObject obj, String key) {
//        if (key.equals("specializations")) {
//            StringBuilder specializations = new StringBuilder();
//            for (int i = 0; i < obj.getJSONArray("specializations").length(); i++) {
//                specializations.append(obj.getJSONArray("specializations").getJSONObject(i).getString("id"));
//                if (i != obj.getJSONArray("specializations").length() - 1) {
//                    specializations.append(", ");
//                }
//            }
//            return new javafx.beans.property.SimpleStringProperty(specializations.toString());
//        }
//        return new javafx.beans.property.SimpleStringProperty(obj.optString(key, "N/A"));
//    }
}