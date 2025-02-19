package main.java.com.lmsadmin.controllers.layer2.generationActionController;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import main.SceneManager;
import main.java.com.lmsadmin.controllers.layer0.MainFrameController;
import main.java.com.lmsadmin.managers.manage_entity_manager.ManageClassroomManager;
import main.java.com.lmsadmin.managers.manage_entity_manager.ManageDepartmentManager;
import main.java.com.lmsadmin.managers.manage_entity_manager.ManageGenerationManager;
import main.java.com.lmsadmin.managers.manage_entity_manager.ManageStudentManager;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.temporal.TemporalQueries;
import java.util.Iterator;

public class DeleteGenerationController extends MainFrameController{
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
            ManageGenerationManager manageGenerationManager = new ManageGenerationManager();
            manageGenerationManager.manageDeleteEntity(idField.getText());

            loadSuccess("deleteGeneration");
            clearDetails();
        }
        else{
            clearDetails();
        }
    }

    private void createDetails(){
        String idToSearch = idField.getText();
        ManageGenerationManager manageGenerationManager = new ManageGenerationManager();
        JSONArray details = manageGenerationManager.getDetails(idToSearch);

        detailsVBox.getChildren().clear();
        detailsVBox.setStyle("-fx-background-color: #ebebeb");
        Pos center_left = Pos.CENTER_LEFT;
        detailsVBox.setAlignment(center_left);
        detailsVBox.setSpacing(10);

        StringBuilder groupsStringBuilder = new StringBuilder();
        for (int i = 0; i < details.length(); i++) {
            JSONArray groups = details.getJSONObject(i).getJSONArray("groups");
            for (int j = 0; j < groups.length(); j++) {
                groupsStringBuilder.append(groups.getJSONObject(i).getString("id"));
                if (j != groups.length() - 1) {
                    groupsStringBuilder.append(", ");
                }
            }
        }

        String gps = groupsStringBuilder.toString();

        String id = idToSearch;
        String name = details.getJSONObject(0).getString("name");

        Font textFont = Font.font("Gill Sans", 25);

        Text idText = new Text("Generation ID: " + id);
        Text nameText = new Text("Generation Name: " + name);
        Text gpsText = new Text("Generation Groups: " + gps);

        Text[] textNodes = {idText, nameText, gpsText};
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