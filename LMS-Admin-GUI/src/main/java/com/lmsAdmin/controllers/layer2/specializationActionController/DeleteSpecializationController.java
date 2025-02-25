package main.java.com.lmsAdmin.controllers.layer2.specializationActionController;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageSpecializationManager;
import org.json.JSONArray;
import org.json.JSONObject;

public class DeleteSpecializationController extends MainFrameController{
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
            ManageSpecializationManager manageSpecializationManager = new ManageSpecializationManager();
            manageSpecializationManager.manageDeleteEntity(idField.getText());

            loadSuccess("deleteSpecialization");
            clearDetails();
        }
        else{
            clearDetails();
        }
    }

    private void createDetails(){
        String idToSearch = idField.getText();
        ManageSpecializationManager manageSpecializationManager = new ManageSpecializationManager();
        JSONObject details = manageSpecializationManager.getDetails(idToSearch);

        detailsVBox.getChildren().clear();
        detailsVBox.setStyle("-fx-background-color: #ebebeb");
        Pos center_left = Pos.CENTER_LEFT;
        detailsVBox.setAlignment(center_left);
        detailsVBox.setSpacing(10);

        StringBuilder groupsStringBuilder = new StringBuilder();
        for (int i = 0; i < details.length(); i++) {
            JSONArray gen = details.getJSONArray("generations");
            for (int j = 0; j < gen.length(); j++) {
                JSONArray gro = gen.getJSONObject(j).getJSONArray("groups");
                for (int k = 0; k < gro.length(); k++) {
                    groupsStringBuilder.append(gro.getJSONObject(k).getString("id"));
                    if (k < gro.length() - 1) {
                        groupsStringBuilder.append(", ");
                    }
                }
            }
        }

        String id = details.getString("id");
        String name = details.getString("name");
        String groups = groupsStringBuilder.toString();

        Font textFont = Font.font("Gill Sans", 25);

        Text idText = new Text("Specialization ID: " + id);
        Text nameText = new Text("Specialization Name: " + name);
        Text gpsText = new Text("Specializations Groups: " + groups);

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