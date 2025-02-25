package main.java.com.lmsAdmin.controllers.layer2.groupActionController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditGroupManager;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditStudentManager;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageGroupManager;

import java.util.ArrayList;

public class AddStudentToGroupController extends MainFrameController{
    EditGroupManager groupIDLoader = new EditGroupManager();
    EditStudentManager studentIDLoader =new EditStudentManager();
    @FXML
    private ComboBox<String> groupIDComboBox;
    @FXML
    private ComboBox<String> studentIDComboBox;
    @FXML
    private Button addStudentToGroupButton;

    public void initialize(){
        studentIDComboBox.setPromptText("Select Student ID");
        groupIDComboBox.setPromptText("Select Group ID");
        studentIDComboBox.setDisable(true);
        addStudentToGroupButton.setDisable(true);

        groupIDComboBox.getItems().addAll(groupIDLoader.loadIds());
        groupIDComboBox.setOnAction(event -> {
            studentIDComboBox.setDisable(false);
            studentIDComboBox.getItems().addAll(studentIDLoader.loadIds());
        });

        studentIDComboBox.setOnAction(event -> {
            addStudentToGroupButton.setDisable(false);
        });

    }

    @FXML
    private void handleAddToGroup(MouseEvent event) {
        ManageGroupManager manageGroupManager = new ManageGroupManager();
        ArrayList<String> studentIDs  = new ArrayList<>(studentIDComboBox.getItems());

        manageGroupManager.manageAddStudentToGroup(groupIDComboBox.getSelectionModel().getSelectedItem(), studentIDs);

        loadSuccess("addStudentToGroup");
        clearFields();
    }

    private void clearFields() {
        studentIDComboBox.getSelectionModel().clearSelection();
        groupIDComboBox.getSelectionModel().clearSelection();
    }
}