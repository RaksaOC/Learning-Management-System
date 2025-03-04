package main.java.com.lms.controllers.teacherSide;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import main.SceneManager;

public class EditResourceController {
    @FXML
    private ImageView backButton;
    @FXML
    private VBox materialList;
    @FXML
    private Button removeButton; // after populating the materialsList add this button to the HBOX and handle its action
    @FXML
    private Button addButton; // handle adding more materials
    @FXML
    private Button editButton; // handle changing the data

    public void initialize() {
        backButton.setOnMouseClicked(event -> {
            SceneManager.setCenterView("resourceView");
        });
        // TODO: populate the materialsList
    }
}