package main.java.com.lms.controllers.layer2.generationActionController;

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
import main.java.com.lms.controllers.layer0.MainFrameController;
import main.java.com.lms.managers.layer2.manage_entity_manager.ManageDepartmentManager;
import main.java.com.lms.managers.layer2.manage_entity_manager.ManageGenerationManager;
import org.json.JSONArray;
import org.json.JSONObject;


public class ViewGenerationController extends MainFrameController {

    @FXML
    private TextField idField;
    @FXML
    private Button searchButton;

    @FXML
    private TableView<JSONObject> tableView;
    @FXML
    private TableColumn<JSONObject, String> idColumn;
    @FXML
    private TableColumn<JSONObject, String> nameColumn;
    @FXML
    private TableColumn<JSONObject, String> groupColumn;
    @FXML
    private VBox detailsVBox;

    @FXML
    public void initialize() {
        ManageGenerationManager manageGenerationManager = new ManageGenerationManager();
        JSONArray all = manageGenerationManager.getDetails(idField.getText());

        // Convert JSON data to ObservableList
        ObservableList<JSONObject> data = FXCollections.observableArrayList();
        for (int i = 0; i < all.length(); i++) {
            data.add(all.getJSONObject(i));
        }

        // Set up column cell value factories
        idColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "id"));
        nameColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "name"));
        groupColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "specializations"));

        // Set data to table
        tableView.setItems(data);
    }

    @FXML
    private void handleSearch(MouseEvent event) {
        createDetails();
    }

    private void createDetails() {
        String idToSearch = idField.getText();
        ManageDepartmentManager manageDepartmentManager = new ManageDepartmentManager();
        JSONObject details = manageDepartmentManager.getDetails(idToSearch);

        detailsVBox.getChildren().clear();
        detailsVBox.setStyle("-fx-background-color: #ebebeb");
        Pos center_left = Pos.CENTER_LEFT;
        detailsVBox.setAlignment(center_left);
        detailsVBox.setSpacing(10);
        String id = details.getString("id");
        String name  = details.getString("name");

        StringBuilder spec = new StringBuilder();
        for(int i = 0; i < details.getJSONArray("specializations").length(); i++) {
            spec.append(details.getJSONArray("specializations").getJSONObject(i).getString("id"));
            if(i != details.getJSONArray("specializations").length() - 1) {
                spec.append(", ");
            }
        }

        Font textFont = Font.font("Gill Sans", 25);


        Text idText = new Text("ID: " + id);
        Text nameText = new Text("Name: " + name);
        Text specText = new Text("Specializations: " + spec.toString());

        Text[] textNodes = {idText, nameText, specText};
        for (Text text : textNodes) {
            text.setFont(textFont);
        }

        detailsVBox.getChildren().addAll(textNodes);
    }


    private javafx.beans.property.SimpleStringProperty getJSONValue(JSONObject obj, String key) {
        if (key.equals("specializations")) {
            StringBuilder specializations = new StringBuilder();
            for (int i = 0; i < obj.getJSONArray("specializations").length(); i++) {
                specializations.append(obj.getJSONArray("specializations").getJSONObject(i).getString("id"));
                if (i != obj.getJSONArray("specializations").length() - 1) {
                    specializations.append(", ");
                }
            }
            return new javafx.beans.property.SimpleStringProperty(specializations.toString());
        }
        return new javafx.beans.property.SimpleStringProperty(obj.optString(key, "N/A"));
    }
}