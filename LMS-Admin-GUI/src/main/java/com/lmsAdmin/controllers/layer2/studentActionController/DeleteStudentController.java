package main.java.com.lmsAdmin.controllers.layer2.studentActionController;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageStudentManager;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditStudentManager;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.Map;

public class DeleteStudentController extends MainFrameController {
    @FXML
    private ComboBox<String> idComboBox;
    @FXML
    private Button deleteButton;

    private String selectedId;

    public void initialize() {
        EditStudentManager idLoader = new EditStudentManager();
        idComboBox.getItems().addAll(idLoader.loadIdsAndNameSql());
    }



    @FXML
    private void handleDelete(MouseEvent event) {
        selectedId = idComboBox.getSelectionModel().getSelectedItem().toString().substring(0, idComboBox.getSelectionModel().getSelectedItem().toString().indexOf(" "));
        handleDeleteSql();
        handleDeleteJSON();
    }

    @FXML
    private void handleDeleteJSON() {
        if (isConfirmed()) {
            ManageStudentManager manageStudentManager = new ManageStudentManager();
            manageStudentManager.manageDeleteEntity(selectedId);

            loadSuccess("deleteStudent");
            clearDetails();
        } else {
            clearDetails();
        }
    }

    @FXML
    private void handleDeleteSql() {
        if (isConfirmed()) {
            ManageStudentManager manageStudentManager = new ManageStudentManager();
            manageStudentManager.manageDeleteEntitySql(selectedId);

            loadSuccess("deleteStudent");
            clearDetails();
        } else {
            clearDetails();
        }
    }

    private void clearDetails() {
        idComboBox.getSelectionModel().clearSelection();
    }
}