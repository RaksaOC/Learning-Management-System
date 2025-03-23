package main.java.com.lms.controllers.studentSide;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import main.java.com.lms.managers.studentSide.DashboardManager;

import java.util.Map;

public class DashboardController {

    @FXML
    private Text numOfCourse;
    @FXML
    private Text numOfAssignment;
    @FXML
    private Text numOfQuiz;
    @FXML
    private TableView<Map<String, String>> assignmentsTable;
    @FXML
    private TableColumn<Map<String, String>, String> assIdColumn;
    @FXML
    private TableColumn<Map<String, String>, String> assNameColumn;
    @FXML
    private TableColumn<Map<String, String>, String> assStatusColumn;
    @FXML
    private TableColumn<Map<String, String>, String> assScoreColumn;
    @FXML
    private TableView<Map<String, String>> quizTable;
    @FXML
    private TableColumn<Map<String, String>, String> quizIdColumn;
    @FXML
    private TableColumn<Map<String, String>, String> quizNameColumn;
    @FXML
    private TableColumn<Map<String, String>, String> quizStatusColumn;
    @FXML
    private TableColumn<Map<String, String>, String> quizScoreColumn;


    public void initialize() {
        DashboardManager dashboardManager = new DashboardManager();
        numOfCourse.setText(dashboardManager.getNumOfCourses() + "");
        numOfAssignment.setText(dashboardManager.getNumOfAssignments() + "");
        numOfQuiz.setText(dashboardManager.getNumOfQuizzes() + "");
    }
}