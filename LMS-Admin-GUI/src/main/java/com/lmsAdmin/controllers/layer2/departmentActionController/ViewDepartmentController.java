package main.java.com.lmsAdmin.controllers.layer2.departmentActionController;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageDepartmentManager;

import java.util.Map;


public class ViewDepartmentController extends MainFrameController {
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
        ManageDepartmentManager manageDepartmentManager = new ManageDepartmentManager();
        ObservableList<Map<String, String>> data = manageDepartmentManager.getAllDepartmentDetails();
        idColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().get("id"))));
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("name")));
        statusColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("status")));
        tableView.setItems(data);
    }
}