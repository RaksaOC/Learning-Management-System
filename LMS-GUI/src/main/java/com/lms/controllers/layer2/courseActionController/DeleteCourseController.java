package main.java.com.lms.controllers.layer2.courseActionController;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import main.java.com.lms.controllers.layer0.MainFrameController;
import main.java.com.lms.managers.layer2.manage_entity_manager.ManageCourseManager;
import org.json.JSONObject;

public class DeleteCourseController extends MainFrameController{
    @FXML
    private TextField idField;
    @FXML
    private Button searchButton;
    @FXML
    private Button deleteButton;
    @FXML
    private VBox detailsVBox;

    @FXML
    private void handleSearch(MouseEvent event) {
        createDetails();
    }

    @FXML
    private void handleDelete(MouseEvent event) {
        if(isConfirmed()){
            ManageCourseManager manageCourseManager = new ManageCourseManager();
            manageCourseManager.manageDeleteEntity(idField.getText());

            loadSuccess("deleteCourse");
            clearDetails();
        }
        else{
            clearDetails();
        }
    }

    private void createDetails(){
        String idToSearch = idField.getText();
        ManageCourseManager manageCourseManager = new ManageCourseManager();
        JSONObject details = manageCourseManager.getDetails(idToSearch);
        detailsVBox.getChildren().clear();
        detailsVBox.setStyle("-fx-background-color: #ebebeb");
        Pos center_left = Pos.CENTER_LEFT;
        detailsVBox.setAlignment(center_left);
        detailsVBox.setSpacing(10);
        String id = details.getString("id");
        String name= details.getString("name");
        String credit = details.getString("credit");
        String level = details.getString("level");
        String description = details.getString("description");

        Font textFont = Font.font("Gill Sans", 25);

        Text idText = new Text("ID: " + id);
        Text teacherText = new Text("Course Name: " + name);
        Text courseText = new Text("Credit: " + credit);
        Text studentText = new Text("Level: " + level);
        Text descriptionText = new Text("Description: " + description);

        Text[] textNodes = {idText, teacherText, courseText, studentText, descriptionText};
        for (Text text : textNodes) {
            text.setFont(textFont);
        }

        detailsVBox.getChildren().addAll(textNodes);
    }

    private void clearDetails(){
        idField.clear();
        detailsVBox.getChildren().clear();
    }
}