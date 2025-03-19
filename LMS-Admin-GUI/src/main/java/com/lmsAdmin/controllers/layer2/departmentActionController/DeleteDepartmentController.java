package main.java.com.lmsAdmin.controllers.layer2.departmentActionController;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageDepartmentManager;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditDepartmentManager;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

public class DeleteDepartmentController extends MainFrameController {
    @FXML
    private ComboBox<String> idComboBox;
    @FXML
    private Button deleteButton;

    //    @FXML
//    private void handleSearch(MouseEvent event) {
//        createDetails();
//    }
    private String selectedId;

    public void initialize() {
        EditDepartmentManager idLoader = new EditDepartmentManager();
        idComboBox.getItems().addAll(idLoader.loadIdsAndNameSql());

        deleteButton.setOnMouseClicked((MouseEvent mouseEvent) -> {
            handleDeleteSql();
            handleDeleteJSON();
        });
    }

    private void handleDeleteSql() {
        selectedId = idComboBox.getSelectionModel().getSelectedItem().toString().substring(0 , idComboBox.getSelectionModel().getSelectedItem().toString().indexOf(" "));

        if (isConfirmed()) {
            ManageDepartmentManager manageDepartmentManager = new ManageDepartmentManager();
            manageDepartmentManager.manageDeleteEntitySql(selectedId);

            loadSuccess("deleteDepartment");
            clearDetails();
        } else {
            clearDetails();
        }
    }

    private void handleDeleteJSON() {
        if (isConfirmed()) {
            ManageDepartmentManager manageDepartmentManager = new ManageDepartmentManager();
            manageDepartmentManager.manageDeleteEntity(selectedId);

            loadSuccess("deleteDepartment");
            clearDetails();
        } else {
            clearDetails();
        }
    }

//    private void createDetails(){
//
//    }

//    private void createDetailsSql(){
//        String idToSearch = idField.getText();
//        ManageDepartmentManager manageDepartmentManager = new ManageDepartmentManager();
//        Map<String, String> details = manageDepartmentManager.getDetailsSql(idToSearch);
//        detailsVBox.getChildren().clear();
//        detailsVBox.setStyle("-fx-background-color: #ebebeb");
//        Pos center_left = Pos.CENTER_LEFT;
//        detailsVBox.setAlignment(center_left);
//        detailsVBox.setSpacing(10);
//        String id = details.get("id");
//        String name = details.get("name");
//
//        Font textFont = Font.font("Gill Sans", 25);
//
//        Text idText = new Text("Department ID: " + id);
//        Text nameText = new Text("Department Name: " + name);
//
//        Text[] textNodes = {idText, nameText};
//        for (Text text : textNodes) {
//            text.setFont(textFont);
//        }
//
//        detailsVBox.getChildren().addAll(textNodes);
//    }
//
//    private void createDetailsJSON(){
//        String idToSearch = idField.getText();
//        ManageDepartmentManager manageDepartmentManager = new ManageDepartmentManager();
//        JSONObject details = manageDepartmentManager.getDetails(idToSearch);
//        detailsVBox.getChildren().clear();
//        detailsVBox.setStyle("-fx-background-color: #ebebeb");
//        Pos center_left = Pos.CENTER_LEFT;
//        detailsVBox.setAlignment(center_left);
//        detailsVBox.setSpacing(10);
//        String id = details.getString("id");
//        String name = details.getString("name");
//        JSONArray spec = details.getJSONArray("specializations");
//        StringBuilder specializations = new StringBuilder();
//        for (int i = 0; i < spec.length(); i++) {
//            specializations.append(spec.getJSONObject(i).getString("id"));
//            if (i != spec.length() - 1) {
//                specializations.append(",");
//            }
//        }
//        String specialization = specializations.toString();
//
//        Font textFont = Font.font("Gill Sans", 25);
//
//        Text idText = new Text("Department ID: " + id);
//        Text nameText = new Text("Department Name: " + name);
//        Text specializationText = new Text("Department Specializations: " + specialization);
//
//        Text[] textNodes = {idText, nameText, specializationText};
//        for (Text text : textNodes) {
//            text.setFont(textFont);
//        }
//
//        detailsVBox.getChildren().addAll(textNodes);
//    }

    private void clearDetails() {
        idComboBox.getSelectionModel().clearSelection();
    }
}