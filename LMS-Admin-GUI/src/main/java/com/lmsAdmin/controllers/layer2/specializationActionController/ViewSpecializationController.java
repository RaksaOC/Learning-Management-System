package main.java.com.lmsAdmin.controllers.layer2.specializationActionController;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageSpecializationManager;

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

    @FXML
    public void initialize() {
        ManageSpecializationManager manager = new ManageSpecializationManager();
        ObservableList<Map<String, String>> data = manager.getAllSpecializationDetails();

        idColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("id")));
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("name")));
        dep_idColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("department_id")));
        tableView.setItems(data);
    }
}