package main.java.com.lms.controllers.studentSide;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import main.AppSession;
import main.SceneManager;
import ui.UI;

public class AssignmentSubmissionController {
    @FXML
    private ImageView backButton;

    public void initialize() {
        backButton.setOnMouseClicked(event -> {
            System.out.println(UI.TextColor.addColor("back button pressed", UI.TextColor.GREEN));
            if (AppSession.getInstance().getIsAssignmentSubmissionFromAssignmentsPage()) {
                SceneManager.setCenterView("studentAssignments");
            } else {
                SceneManager.setCenterView("classroomContents");
            }
        });
    }
}