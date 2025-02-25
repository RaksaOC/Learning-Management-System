package main.java.com.lmsadmin.controllers.layer2.departmentActionController;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import main.java.com.lmsadmin.controllers.layer0.MainFrameController;
import main.java.com.lmsadmin.managers.layer2.manage_entity_manager.ManageDepartmentManager;
import org.json.JSONArray;
import org.json.JSONObject;

public class DeleteDepartmentController extends MainFrameController{
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
            ManageDepartmentManager manageDepartmentManager = new ManageDepartmentManager();
            manageDepartmentManager.manageDeleteEntity(idField.getText());

            loadSuccess("deleteDepartment");
            clearDetails();
        }
        else{
            clearDetails();
        }
    }

    private void createDetails(){
        String idToSearch = idField.getText();
        ManageDepartmentManager manageDepartmentManager = new ManageDepartmentManager();
        JSONObject details = manageDepartmentManager.getDetails(idToSearch);
        detailsVBox.getChildren().clear();
        detailsVBox.setStyle("-fx-background-color: #ebebeb");
        Pos center_left = Pos.CENTER_LEFT;
        detailsVBox.setAlignment(center_left);
        detailsVBox.setSpacing(10);
        String id = details.getString("id");
        String name = details.getString("name");
        JSONArray spec = details.getJSONArray("specializations");
        StringBuilder specializations = new StringBuilder();
        for (int i = 0; i < spec.length(); i++) {
            specializations.append(spec.getJSONObject(i).getString("id"));
            if (i != spec.length() - 1) {
                specializations.append(",");
            }
        }
        String specialization = specializations.toString();

        Font textFont = Font.font("Gill Sans", 25);

        Text idText = new Text("Department ID: " + id);
        Text nameText = new Text("Department Name: " + name);
        Text specializationText = new Text("Department Specializations: " + specialization);

        Text[] textNodes = {idText, nameText, specializationText};
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