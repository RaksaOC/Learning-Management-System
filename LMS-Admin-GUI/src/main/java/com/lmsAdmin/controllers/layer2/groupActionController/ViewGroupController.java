package main.java.com.lmsAdmin.controllers.layer2.groupActionController;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageGroupManager;

import java.util.Map;


public class ViewGroupController extends MainFrameController {

    @FXML
    private TableView<Map<String, String>> tableView;
    @FXML
    private TableColumn<Map<String, String>, String> idColumn;

    @FXML
    public void initialize() {
        ManageGroupManager manageGroupManager = new ManageGroupManager();
        ObservableList<Map<String, String>> all = manageGroupManager.getAllGroupDetails();

        idColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("id").toString()));

        tableView.setItems(all);
    }
}