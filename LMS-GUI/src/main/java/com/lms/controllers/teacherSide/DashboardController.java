package main.java.com.lms.controllers.teacherSide;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import main.java.com.lms.managers.teacherSide.DashboardManager;

public class DashboardController {
    @FXML
    private Text numOfClassrooms;
    @FXML
    private Text numOfAssCreated;
    @FXML
    private Text numOfAssGraded;
    @FXML
    private Text numOfQuizCreated;

    public void initialize() {
        DashboardManager dashboardManager = new DashboardManager();
        numOfAssCreated.setText(dashboardManager.getNumOfAssignmentsCreated() + "");
        numOfClassrooms.setText(dashboardManager.getNumOfClassrooms() + "");
        numOfAssGraded.setText(dashboardManager.getNumOfAssignmentsGraded() + "");
        numOfQuizCreated.setText(dashboardManager.getNumOfQuizzesCreated() + "");
    }
}