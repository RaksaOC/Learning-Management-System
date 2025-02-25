package main.java.com.lmsAdmin.controllers.layer2.groupActionController;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageGroupManager;
import org.json.JSONArray;
import org.json.JSONObject;

public class DeleteGroupController extends MainFrameController {
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
        if (isConfirmed()) {
            ManageGroupManager manageGroupManager = new ManageGroupManager();
            manageGroupManager.manageDeleteEntity(idField.getText());

            loadSuccess("deleteGroup");
            clearDetails();
        } else {
            clearDetails();
        }
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

        JSONArray studentsArray = details.getJSONArray("students");
        StringBuilder studentsStringBuilder = new StringBuilder();
        for (int i = 0; i < studentsArray.length(); i++) {
            studentsStringBuilder.append(studentsArray.getString(i));
            if (i != studentsArray.length() - 1) {
                studentsStringBuilder.append(", ");
            }
        }
        String students = studentsStringBuilder.toString();

        JSONArray classroomsArray = details.getJSONArray("classrooms");
        StringBuilder classroomsStringBuilder = new StringBuilder();
        for (int i = 0; i < classroomsArray.length(); i++) {
            classroomsStringBuilder.append(classroomsArray.getString(i));
            if (i != classroomsArray.length() - 1) {
                classroomsStringBuilder.append(", ");
            }
        }
        String classrooms = classroomsStringBuilder.toString();

        Font textFont = Font.font("Gill Sans", 25);

        Text idText = new Text("Group ID: " + id);
        Text studentsText = new Text("Students: " + students);
        Text classroomsText = new Text("Classrooms: " + classrooms);

        Text[] textNodes = {idText, studentsText, classroomsText};
        for (Text text : textNodes) {
            text.setFont(textFont);
        }

        detailsVBox.getChildren().addAll(textNodes);
    }

    private void clearDetails() {
        idField.clear();
        detailsVBox.getChildren().clear();
    }
}