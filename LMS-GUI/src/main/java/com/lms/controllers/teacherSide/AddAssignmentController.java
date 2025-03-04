package main.java.com.lms.controllers.teacherSide;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import main.SceneManager;

public class AddAssignmentController {
    @FXML
    private ImageView backButton;

    public void initialize() {
        backButton.setOnMouseClicked(event -> {
            SceneManager.setCenterView("teacherClassroomContents");
        });
    }
}