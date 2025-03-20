package main.java.com.lmsAdmin.controllers.layer1;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer1.DashboardManager;
import org.json.JSONArray;
import org.json.JSONObject;

public class DashboardController extends MainFrameController {

    // TODO: change these to SQL

    private DashboardManager dashboardManager = new DashboardManager();

    @FXML
    private Text numOfStudents;
    @FXML
    private Text numOfTeachers;
    @FXML
    private Text numOfCourses;
    @FXML
    private Text numOfClassrooms;
    @FXML
    private TableView<JSONObject> studentLogTableView;
    @FXML
    private TableView<JSONObject> teacherLogTableView;
    @FXML
    private TableView<JSONObject> activeClassroomTableView;
    @FXML
    private TableColumn<JSONObject, String> studentIDTableColumn;
    @FXML
    private TableColumn<JSONObject, String> studentTimeTableColumn;
    @FXML
    private TableColumn<JSONObject, String> studentActionTableColumn;
    @FXML
    private TableColumn<JSONObject, String> teacherIDTableColumn;
    @FXML
    private TableColumn<JSONObject, String> teacherTimeTableColumn;
    @FXML
    private TableColumn<JSONObject, String> teacherActionTableColumn;
    @FXML
    private TableColumn<JSONObject, String> activeClassroomClassIDTableColumn;
    @FXML
    private TableColumn<JSONObject, String> activeClassroomCourseTableColumn;
    @FXML
    private TableColumn<JSONObject, String> activeClassroomTeacherTableColumn;

    public void initialize() {
        numOfStudents.setText(String.valueOf(dashboardManager.getNumberOfStudents()));
        numOfTeachers.setText(String.valueOf(dashboardManager.getNumberOfTeachers()));
        numOfCourses.setText(String.valueOf(dashboardManager.getNumberOfCourses()));
        numOfClassrooms.setText(String.valueOf(dashboardManager.getNumberOfClassrooms()));

        // Load student logs
        JSONArray studentLogHistory = dashboardManager.getStudentsHistory();
        if (studentLogHistory != null) {
            ObservableList<JSONObject> studentLog = FXCollections.observableArrayList();
            for (int i = 0; i < studentLogHistory.length(); i++) {
                studentLog.add(studentLogHistory.getJSONObject(i));
            }
            studentIDTableColumn.setCellValueFactory(cellData ->
                    new SimpleStringProperty(cellData.getValue().optString("id", "N/A"))
            );
            studentTimeTableColumn.setCellValueFactory(cellData ->
                    new SimpleStringProperty(cellData.getValue().optString("time", "N/A"))
            );
            studentActionTableColumn.setCellValueFactory(cellData ->
                    new SimpleStringProperty(cellData.getValue().optString("lastAction", "N/A"))
            );
            studentLogTableView.setItems(studentLog);
        }

        // Load teacher logs
        JSONArray teacherLogHistory = dashboardManager.getTeachersHistory();
        if (teacherLogHistory != null) {
            ObservableList<JSONObject> teacherLog = FXCollections.observableArrayList();
            for (int i = 0; i < teacherLogHistory.length(); i++) {
                teacherLog.add(teacherLogHistory.getJSONObject(i));
            }
            teacherIDTableColumn.setCellValueFactory(cellData ->
                    new SimpleStringProperty(cellData.getValue().optString("id", "N/A"))
            );
            teacherTimeTableColumn.setCellValueFactory(cellData ->
                    new SimpleStringProperty(cellData.getValue().optString("time", "N/A"))
            );
            teacherActionTableColumn.setCellValueFactory(cellData ->
                    new SimpleStringProperty(cellData.getValue().optString("lastAction", "N/A"))
            );
            teacherLogTableView.setItems(teacherLog);
        }

        // Load active classroom logs
        JSONArray activeClassroomHistory = dashboardManager.getActiveClassrooms();
        if (activeClassroomHistory != null) {
            ObservableList<JSONObject> activeClassroomLog = FXCollections.observableArrayList();
            for (int i = 0; i < activeClassroomHistory.length(); i++) {
                activeClassroomLog.add(activeClassroomHistory.getJSONObject(i));
            }
            activeClassroomClassIDTableColumn.setCellValueFactory(cellData ->
                    new SimpleStringProperty(cellData.getValue().optString("id", "N/A"))
            );
            activeClassroomCourseTableColumn.setCellValueFactory(cellData ->
                    new SimpleStringProperty(cellData.getValue().optString("courseId", "N/A"))
            );
            activeClassroomTeacherTableColumn.setCellValueFactory(cellData ->
                    new SimpleStringProperty(cellData.getValue().optString("teacherId", "N/A"))
            );
            activeClassroomTableView.setItems(activeClassroomLog);
        }
    }

    private javafx.beans.property.SimpleStringProperty getJSONValue(JSONObject obj, String key) {
        return new javafx.beans.property.SimpleStringProperty(obj.optString(key, "N/A"));
    }
}