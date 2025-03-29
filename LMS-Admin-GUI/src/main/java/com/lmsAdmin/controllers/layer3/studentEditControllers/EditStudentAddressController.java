package main.java.com.lmsAdmin.controllers.layer3.studentEditControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.SceneManager;
import main.java.com.lmsAdmin.controllers.layer0.MainFrameController;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.EditStudentManager;
import main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.utils.CambodiaAdministrative;

import java.util.ArrayList;
import java.util.Map;

public class EditStudentAddressController extends MainFrameController {
    EditStudentManager idLoader = new EditStudentManager();
    EditStudentManager manager;

    @FXML
    private ComboBox<String> idComboBox;
    @FXML
    private TextField curCommuneTextField;
    @FXML
    private TextField curDistrictTextField;
    @FXML
    private TextField curProvinceTextField;
    @FXML
    private ComboBox<String> newCommuneComboBox;
    @FXML
    private ComboBox<String> newDistrictComboBox;
    @FXML
    private ComboBox<String> newProvinceComboBox;
    @FXML
    private Button editButton;

    @FXML
    private void initialize() {
        CambodiaAdministrative addressInfos = new CambodiaAdministrative();

        editButton.setDisable(true);
        newCommuneComboBox.setDisable(true);
        newDistrictComboBox.setDisable(true);
        newProvinceComboBox.setDisable(true);

        idComboBox.getItems().addAll(idLoader.loadIdsAndName());

        idComboBox.setOnAction(event -> {
            manager = new EditStudentManager(extractId(idComboBox.getItems().getFirst()));
            curCommuneTextField.setText(manager.getOldCommune());
            curDistrictTextField.setText(manager.getOldDistrict());
            curProvinceTextField.setText(manager.getOldProvince());

            // Enable province selection and populate it
            newProvinceComboBox.setDisable(false);
            newProvinceComboBox.getItems().addAll(addressInfos.getProvinces());
        });

        // Add listener to update districts when province is selected
        newProvinceComboBox.setOnAction(event -> {
            String selectedProvince = newProvinceComboBox.getValue();
            if (selectedProvince != null) {
                newDistrictComboBox.getItems().addAll(addressInfos.getDistricts(selectedProvince));
                newDistrictComboBox.setDisable(false);
            } else {
                newDistrictComboBox.getItems().clear();
                newDistrictComboBox.setDisable(true);
            }
            newCommuneComboBox.getItems().clear();
            newCommuneComboBox.setDisable(true);
        });

        // Add listener to update communes when district is selected
        newDistrictComboBox.setOnAction(event -> {
            String selectedProvince = newProvinceComboBox.getValue();
            String selectedDistrict = newDistrictComboBox.getValue();
            if (selectedDistrict != null) {
                newCommuneComboBox.getItems().addAll(addressInfos.getCommunes(selectedDistrict, selectedProvince));
                newCommuneComboBox.setDisable(false);
            } else {
                newCommuneComboBox.getItems().clear();
                newCommuneComboBox.setDisable(true);
            }
        });
    }

    @FXML
    private void handleEdit(MouseEvent event) {
        if (isConfirmed()) {
            manager.manageEditAddress(newCommuneComboBox.getSelectionModel().getSelectedItem(), newDistrictComboBox.getSelectionModel().getSelectedItem(), newProvinceComboBox.getSelectionModel().getSelectedItem());
            loadSuccess("editStudentAddress");
            SceneManager.refreshScenes();
            clearFields();
        }
    }

    private void clearFields() {
        idComboBox.getSelectionModel().clearSelection();
        curCommuneTextField.clear();
        curDistrictTextField.clear();
        curProvinceTextField.clear();
        newProvinceComboBox.getSelectionModel().clearSelection();
        newDistrictComboBox.getSelectionModel().clearSelection();
        newCommuneComboBox.getSelectionModel().clearSelection();
    }
}