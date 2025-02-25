package main.java.com.lmsAdmin.controllers.layer2.specializationActionController;

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


public class ViewSpecializationController extends MainFrameController {

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
    private VBox detailsVBox;

    @FXML
    public void initialize() {
        ManageSpecializationManager mangeSpecializationManager = new ManageSpecializationManager();
        JSONArray all = mangeSpecializationManager.getAllDetails();

        // Convert JSON data to ObservableList
        ObservableList<JSONObject> data = FXCollections.observableArrayList();
        for (int i = 0; i < all.length(); i++) {
            data.add(all.getJSONObject(i));
        }

        // Set up column cell value factories
        idColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "id"));
        nameColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "name"));

        // Set data to table
        tableView.setItems(data);
    }

    @FXML
    private void handleSearch(MouseEvent event) {
        createDetails();
    }

    private void createDetails() {
        String idToSearch = idField.getText();
        ManageSpecializationManager mangeSpecializationManager = new ManageSpecializationManager();
        JSONObject details = mangeSpecializationManager.getDetails(idToSearch);

        detailsVBox.getChildren().clear();
        detailsVBox.setStyle("-fx-background-color: #ebebeb");
        Pos center_left = Pos.CENTER_LEFT;
        detailsVBox.setAlignment(center_left);
        detailsVBox.setSpacing(10);
        String id = details.getString("id");
        String name  = details.getString("name");

        StringBuilder gps = new StringBuilder();
        JSONArray gen = details.getJSONArray("generations");
        for (int i = 0; i < gen.length(); i++) {
            JSONArray groups = gen.getJSONObject(i).getJSONArray("groups");
            for (int j = 0; j < groups.length(); j++) {
                 gps.append(groups.getJSONObject(j).getString("id"));
                 if (j != groups.length() - 1) {
                     gps.append(", ");
                 }
            }
        }

        Font textFont = Font.font("Gill Sans", 25);

        Text idText = new Text("ID: " + id);
        Text nameText = new Text("Name: " + name);
        Text gpsText = new Text("Groups: " + gps.toString());

        Text[] textNodes = {idText, nameText, gpsText};
        for (Text text : textNodes) {
            text.setFont(textFont);
        }

        detailsVBox.getChildren().addAll(textNodes);
    }


    private javafx.beans.property.SimpleStringProperty getJSONValue(JSONObject obj, String key) {
        return new javafx.beans.property.SimpleStringProperty(obj.optString(key, "N/A"));
    }
}