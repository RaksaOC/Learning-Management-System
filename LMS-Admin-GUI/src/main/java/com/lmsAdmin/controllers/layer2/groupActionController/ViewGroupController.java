package main.java.com.lmsAdmin.controllers.layer2.groupActionController;

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
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageGroupManager;
import org.json.JSONArray;
import org.json.JSONObject;


public class ViewGroupController extends MainFrameController {

    @FXML
    private TextField idField;
    @FXML
    private Button searchButton;

    @FXML
    private TableView<JSONObject> tableView;
    @FXML
    private TableColumn<JSONObject, String> idColumn;
    @FXML
    private TableColumn<JSONObject, String> classroomsColumn;
    @FXML
    private VBox detailsVBox;

    @FXML
    public void initialize() {
        ManageGroupManager manageGroupManager = new ManageGroupManager();
        JSONArray all = manageGroupManager.getAllDetails();

        // Convert JSON data to ObservableList
        ObservableList<JSONObject> data = FXCollections.observableArrayList();
        for (int i = 0; i < all.length(); i++) {
            data.add(all.getJSONObject(i));
        }

        // Set up column cell value factories
        idColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "id"));
        classroomsColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "classrooms"));

        // Set data to table
        tableView.setItems(data);
    }

    @FXML
    private void handleSearch(MouseEvent event) {
        createDetails();
    }

    private void createDetails() {
        String idToSearch = idField.getText();
        ManageGroupManager manageGroupManager = new ManageGroupManager();
        JSONObject details = manageGroupManager.getDetails(idToSearch);

        detailsVBox.getChildren().clear();
        detailsVBox.setStyle("-fx-background-color: #ebebeb");
        Pos center_left = Pos.CENTER_LEFT;
        detailsVBox.setAlignment(center_left);
        detailsVBox.setSpacing(10);

        String id = details.getString("id");

        StringBuilder classes = new StringBuilder();
        for(int i = 0; i < details.getJSONArray("classrooms").length(); i++) {
            classes.append(details.getJSONArray("classrooms").getString(i));
            if(i != details.getJSONArray("classrooms").length() - 1) {
                classes.append(", ");
            }
        }
        StringBuilder students = new StringBuilder();
        for(int i = 0; i < details.getJSONArray("students").length(); i++) {
            students.append(details.getJSONArray("students").getString(i));
            if(i != details.getJSONArray("students").length() - 1) {
                students.append(", ");
            }
        }

        Font textFont = Font.font("Gill Sans", 25);

        Text idText = new Text("ID: " + id);
        Text classesText = new Text("Classrooms: " + classes.toString());
        Text studentsText = new Text("Students: " + students.toString());

        Text[] textNodes = {idText, classesText, studentsText};
        for (Text text : textNodes) {
            text.setFont(textFont);
        }

        detailsVBox.getChildren().addAll(textNodes);
    }


    private javafx.beans.property.SimpleStringProperty getJSONValue(JSONObject obj, String key) {
        if (key.equals("classrooms")) {
            StringBuilder classrooms = new StringBuilder();
            for (int i = 0; i < obj.getJSONArray("classrooms").length(); i++) {
                classrooms.append(obj.getJSONArray("classrooms").getString(i));
                if (i != obj.getJSONArray("classrooms").length() - 1) {
                    classrooms.append(", ");
                }
            }
            return new javafx.beans.property.SimpleStringProperty(classrooms.toString());
        }
        return new javafx.beans.property.SimpleStringProperty(obj.optString(key, "N/A"));
    }
}