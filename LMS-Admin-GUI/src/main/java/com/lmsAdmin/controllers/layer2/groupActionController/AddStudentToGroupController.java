package main.java.com.lmsAdmin.controllers.layer2.groupActionController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import main.SceneManager;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditGroupManager;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditStudentManager;
import main.java.com.lmsAdmin.managers.layer2.manage_entity_manager.ManageGroupManager;

import java.util.ArrayList;

public class AddStudentToGroupController extends MainFrameController {
    private EditGroupManager groupIDLoader = new EditGroupManager();
    private EditStudentManager studentIDLoader = new EditStudentManager();

    @FXML
    private ComboBox<String> groupIDComboBox;
    @FXML
    private ComboBox<String> studentIDComboBox;
    @FXML
    private Button addStudentToGroupButton;

    private String selectedGroupID;
    private String selectedStudentID;

    public void initialize() {
        studentIDComboBox.setPromptText("Select Student ID");
        groupIDComboBox.setPromptText("Select Group ID");
        studentIDComboBox.setDisable(true);
        addStudentToGroupButton.setDisable(true);

        groupIDComboBox.getItems().addAll(groupIDLoader.loadIdsAndName());
        groupIDComboBox.setOnAction(event -> {
            studentIDComboBox.setDisable(false);
            String genId = parseForGenId(groupIDComboBox.getSelectionModel().getSelectedItem());
            String specID = parseForSpecId(groupIDComboBox.getSelectionModel().getSelectedItem());
            System.out.println("We are finding students from " + genId + " , " + specID);
            studentIDComboBox.getItems().clear();
            studentIDComboBox.getItems().addAll(studentIDLoader.loadIdsAndName(genId, specID));
        });

        studentIDComboBox.setOnAction(event -> {
            addStudentToGroupButton.setDisable(false);
        });
    }

    @FXML
    private void handleAddToGroup(MouseEvent event) {
        selectedGroupID = groupIDComboBox.getSelectionModel().getSelectedItem();
        selectedStudentID = extractId(studentIDComboBox.getSelectionModel().getSelectedItem());
        if (isConfirmed()) {
            ManageGroupManager manageGroupManager = new ManageGroupManager();
            manageGroupManager.manageAddStudentToGroup(selectedStudentID, selectedGroupID);

            loadSuccess("addStudentToGroup");
            SceneManager.refreshScenes();
            clearFields();
        }
    }

    private void clearFields() {
        studentIDComboBox.getSelectionModel().clearSelection();
        groupIDComboBox.getSelectionModel().clearSelection();
    }

    private String parseForGenId(String groupId) {
        return groupId.substring(0, groupId.indexOf("-"));
    }

    private String parseForSpecId(String groupId) {
        return groupId.substring(groupId.indexOf("-") + 1, groupId.lastIndexOf("-"));
    }


}