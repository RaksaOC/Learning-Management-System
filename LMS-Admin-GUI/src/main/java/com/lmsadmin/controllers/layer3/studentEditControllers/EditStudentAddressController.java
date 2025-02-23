package main.java.com.lmsadmin.controllers.layer3.studentEditControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.java.com.lmsadmin.controllers.layer0.MainFrameController;
import main.java.com.lmsadmin.managers.edit_entity_manager.EditStudentManager;
import main.java.com.lmsadmin.utils.CambodiaAdministrative;
import org.json.JSONObject;

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
        addressInfos.fillAddressData();
        ArrayList <String> provinces = addressInfos.getProvinces();
        Map<String, ArrayList<String>> districts = addressInfos.getDistricts();
        Map<String, ArrayList<String>> communes = addressInfos.getCommunes();

        editButton.setDisable(true);
        newCommuneComboBox.setDisable(true);
        newDistrictComboBox.setDisable(true);
        newProvinceComboBox.setDisable(true);

        idComboBox.getItems().addAll(idLoader.loadIds());

        idComboBox.setOnAction(event -> {
            manager = new EditStudentManager(idComboBox.getValue());
            curCommuneTextField.setText(manager.getOldCommune());
            curDistrictTextField.setText(manager.getOldDistrict());
            curProvinceTextField.setText(manager.getOldProvince());

            // Enable province selection and populate it
            newProvinceComboBox.setDisable(false);
            newProvinceComboBox.getItems().setAll(provinces);
        });

        // Add listener to update districts when province is selected
        newProvinceComboBox.setOnAction(event -> {
            String selectedProvince = newProvinceComboBox.getValue();
            if (selectedProvince != null) {
                newDistrictComboBox.getItems().setAll(districts.getOrDefault(selectedProvince, new ArrayList<>()));
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
            String selectedDistrict = newDistrictComboBox.getValue();
            if (selectedDistrict != null) {
                newCommuneComboBox.getItems().setAll(communes.getOrDefault(selectedDistrict, new ArrayList<>()));
                newCommuneComboBox.setDisable(false);
            } else {
                newCommuneComboBox.getItems().clear();
                newCommuneComboBox.setDisable(true);
            }
        });
    }

    @FXML
    private void handleEdit(MouseEvent event) {
        JSONObject newAddress = new JSONObject();
        newAddress.put("commune", newCommuneComboBox.getValue());
        newAddress.put("district", newDistrictComboBox.getValue());
        newAddress.put("province", newProvinceComboBox.getValue());
        manager.manageEditAddress(newAddress);
        loadSuccess("editStudentAddress");
        clearFields();
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