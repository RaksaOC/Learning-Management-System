package main.java.com.lmsAdmin.controllers.layer2.classroomActionController;

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
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageClassroomManager;
import org.json.JSONArray;
import org.json.JSONObject;


public class ViewClassroomController extends MainFrameController {


    @FXML
    private TableView<JSONObject> tableView;
    @FXML
    private TableColumn<JSONObject, String> idColumn;
    @FXML
    private TableColumn<JSONObject, String> assignmentsColumn;
    @FXML
    private TableColumn<JSONObject, String> resourcesColumn;
    @FXML
    private TableColumn<JSONObject, String> quizzesColumn;

    @FXML
    private TextField idField;

    @FXML
    private Button searchButton;

    @FXML
    private VBox detailsVBox;

    @FXML
    public void initialize() {
        ManageClassroomManager managerClassroomManager = new ManageClassroomManager();
        JSONArray all = managerClassroomManager.getAllDetails();

        ObservableList<JSONObject> data = FXCollections.observableArrayList();
        for (int i = 0; i < all.length(); i++) {
            data.add(all.getJSONObject(i));
        }

        // Set up column cell value factories
        idColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "id"));
        assignmentsColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "assignments"));
        resourcesColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "resources"));
        quizzesColumn.setCellValueFactory(cellData -> getJSONValue(cellData.getValue(), "quizzes"));

        // Set data to table
        tableView.setItems(data);
    }

    @FXML
    private void handleSearch(MouseEvent event) {
        createDetails();
    }

    private void createDetails(){
        String idToSearch = idField.getText();
        ManageClassroomManager manageClassroomManager = new ManageClassroomManager();
        JSONObject details = manageClassroomManager.getDetails(idToSearch);
        detailsVBox.getChildren().clear();
        detailsVBox.setStyle("-fx-background-color: #ebebeb");
        Pos center_left = Pos.CENTER_LEFT;
        detailsVBox.setAlignment(center_left);
        detailsVBox.setSpacing(10);
        String id = details.getString("id");
        String teacher = details.getString("teacherId");
        String course = details.getString("courseId");

        JSONArray students = details.getJSONArray("students");

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < students.length(); i++) {
            stringBuilder.append(students.getString(i));
            if(i != students.length()-1){
                stringBuilder.append(",");
            }
        }
        String studentsString = stringBuilder.toString();

        Font textFont = Font.font("Gill Sans", 25);

        Text idText = new Text("ID: " + id);
        Text teacherText = new Text("TeacherId: " + teacher);
        Text courseText = new Text("CourseId: " + course);
        Text studentText = new Text("Students: " + studentsString);

        Text[] textNodes = {idText, teacherText, courseText, studentText};
        for (Text text : textNodes) {
            text.setFont(textFont);
        }

        detailsVBox.getChildren().addAll(textNodes);
    }


    private javafx.beans.property.SimpleStringProperty getJSONValue(JSONObject obj, String key) {
        switch (key) {
            case "assignments" -> {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < obj.getJSONArray("assignments").length(); i++) {
                    stringBuilder.append(obj.getJSONArray("assignments").getString(i));
                    if(i != obj.getJSONArray("assignments").length()-1){
                        stringBuilder.append(", ");
                    }
                }
                String assignmentsString = stringBuilder.toString();
                return new javafx.beans.property.SimpleStringProperty(assignmentsString);
            }
            case "resources" -> {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < obj.getJSONArray("resources").length(); i++) {
                    stringBuilder.append(obj.getJSONArray("resources").getString(i));
                    if(i != obj.getJSONArray("resources").length()-1){
                        stringBuilder.append(", ");
                    }
                }
                String resourcesString = stringBuilder.toString();
                return new javafx.beans.property.SimpleStringProperty(resourcesString);
            }
            case "quizzes" -> {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < obj.getJSONArray("quizzes").length(); i++) {
                    stringBuilder.append(obj.getJSONArray("quizzes").getString(i));
                    if(i != obj.getJSONArray("quizzes").length()-1){
                        stringBuilder.append(", ");
                    }
                }
                String quizzesString = stringBuilder.toString();
                return new javafx.beans.property.SimpleStringProperty(quizzesString);
            }
        }

        return new javafx.beans.property.SimpleStringProperty(obj.optString(key, "N/A"));
    }
}