package main.java.com.lmsAdmin.controllers.layer2.generationActionController;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageGenerationManager;

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


    @FXML
    public void initialize() {
        ManageGenerationManager manager = new ManageGenerationManager();
        ObservableList<Map<String, String>> data = manager.getAllGenerationDetails();

        idColumn.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().get("id").toString()));
        nameColumn.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().get("name").toString()));
        statusColumn.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().get("status").toString()));

        tableView.setItems(data);
    }
}