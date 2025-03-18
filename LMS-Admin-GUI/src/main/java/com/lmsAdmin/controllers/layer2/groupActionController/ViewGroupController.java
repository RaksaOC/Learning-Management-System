package main.java.com.lmsAdmin.controllers.layer2.groupActionController;

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
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageGroupManager;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;


public class ViewGroupController extends MainFrameController {

    @FXML
    private TableView<Map<String, String>> tableView;
    @FXML
    private TableColumn<Map<String, String>, String> idColumn;

    @FXML
    public void initialize() {
        initTableViewSql();
    }

//    private void initTableViewJSON() {
//        ManageGroupManager manageGroupManager = new ManageGroupManager();
//        JSONArray all = manageGroupManager.getAllDetails();
//
//        // Convert JSON data to ObservableList
//        ObservableList<JSONObject> data = FXCollections.observableArrayList();
//        for (int i = 0; i < all.length(); i++) {
//            data.add(all.getJSONObject(i));
//        }
//
//        // Set up column cell value factories
//        idColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "id"));
//        classroomsColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "classrooms"));
//
//        // Set data to table
//        tableView.setItems(data);
//    }

    private void initTableViewSql(){
        ManageGroupManager manageGroupManager = new ManageGroupManager();
        ObservableList<Map<String, String>> all = manageGroupManager.getAllDetailsSql();

        // Set up column cell value factories
        idColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("id").toString()));

        // Set data to table
        tableView.setItems(all);
    }


//    private javafx.beans.property.SimpleStringProperty getJSONValue(JSONObject obj, String key) {
//        if (key.equals("classrooms")) {
//            StringBuilder classrooms = new StringBuilder();
//            for (int i = 0; i < obj.getJSONArray("classrooms").length(); i++) {
//                classrooms.append(obj.getJSONArray("classrooms").getString(i));
//                if (i != obj.getJSONArray("classrooms").length() - 1) {
//                    classrooms.append(", ");
//                }
//            }
//            return new javafx.beans.property.SimpleStringProperty(classrooms.toString());
//        }
//        return new javafx.beans.property.SimpleStringProperty(obj.optString(key, "N/A"));
//    }
}