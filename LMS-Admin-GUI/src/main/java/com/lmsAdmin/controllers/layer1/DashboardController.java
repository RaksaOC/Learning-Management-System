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

import java.util.Map;

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
    private TableView<Map<String, String>> studentLogTableView;
    @FXML
    private TableColumn<Map<String, String>, String> studentIDTableColumn;
    @FXML
    private TableColumn<Map<String, String>, String> studentTimeTableColumn;
    @FXML
    private TableColumn<Map<String, String>, String> studentActionTableColumn;

    @FXML
    private TableView<Map<String, String>> teacherLogTableView;
    @FXML
    private TableColumn<Map<String, String>, String> teacherIDTableColumn;
    @FXML
    private TableColumn<Map<String, String>, String> teacherTimeTableColumn;
    @FXML
    private TableColumn<Map<String, String>, String> teacherActionTableColumn;

    @FXML
    private TableView<Map<String, String>> activeClassroomTableView;
    @FXML
    private TableColumn<Map<String, String>, String> activeClassroomClassIDTableColumn;
    @FXML
    private TableColumn<Map<String, String>, String> activeClassroomCourseTableColumn;
    @FXML
    private TableColumn<Map<String, String>, String> activeClassroomTeacherTableColumn;
    @FXML
    private TableColumn<Map<String, String>, String> activeClassroomGroupTableColumn;

    public void initialize() {
        numOfStudents.setText(String.valueOf(dashboardManager.getNumberOfStudents()));
        numOfTeachers.setText(String.valueOf(dashboardManager.getNumberOfTeachers()));
        numOfCourses.setText(String.valueOf(dashboardManager.getNumberOfCourses()));
        numOfClassrooms.setText(String.valueOf(dashboardManager.getNumberOfClassrooms()));

        initTeacherLogTable();
        initStudentLogTable();
        initActiveClassroomTable();
    }

    private void initStudentLogTable() {
        ObservableList<Map<String, String>> data  = dashboardManager.getStudentHistory();
        studentIDTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("id")));
        studentTimeTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("time")));
        studentActionTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("last_action")));

        studentLogTableView.setItems(data);
    }

    private void initTeacherLogTable() {
        ObservableList<Map<String, String>> data  = dashboardManager.getTeacherHistory();
        teacherIDTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("id")));
        teacherTimeTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("time")));
        teacherActionTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("last_action")));

        teacherLogTableView.setItems(data);
    }

    private void initActiveClassroomTable() {
        ObservableList<Map<String, String>> data  = dashboardManager.getActiveClassrooms();
        activeClassroomClassIDTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("id")));
        activeClassroomTeacherTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("teacher_id")));
        activeClassroomCourseTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("course_id")));
        activeClassroomGroupTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("group_id")));

        activeClassroomTableView.setItems(data);
    }
}