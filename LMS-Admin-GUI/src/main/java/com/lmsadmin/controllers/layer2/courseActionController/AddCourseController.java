package main.java.com.lmsadmin.controllers.layer2.courseActionController;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import main.SceneManager;
import main.java.com.lmsadmin.controllers.layer0.MainFrameController;
import main.java.com.lmsadmin.managers.manage_entity_manager.ManageCourseManager;
import org.json.JSONObject;

public class AddCourseController extends MainFrameController {
    @FXML
    public Button addButton;
    @FXML
    private TextField name;
    @FXML
    private TextField id;
    @FXML
    private ComboBox credit;
    @FXML
    private ComboBox level;
    @FXML
    private TextField description;

    @FXML
    private void handleAdd(MouseEvent event) {
        String n = name.getText();
        String ID = id.getText();
        String cre = credit.getSelectionModel().getSelectedItem().toString();
        String le = level.getSelectionModel().getSelectedItem().toString();
        String desc = description.getText();

        JSONObject newEntity = new JSONObject();
        newEntity.put("name", n);
        newEntity.put("id", ID);
        newEntity.put("credit", cre);
        newEntity.put("level", le);
        newEntity.put("description", desc);
        newEntity.put("status", "active");
        ManageCourseManager manageCourseManager = new ManageCourseManager();
        manageCourseManager.manageAddEntity(newEntity);

        SceneManager.setScene("success");
        PauseTransition delay = new PauseTransition(Duration.seconds(2));
        delay.setOnFinished(ev -> {
            SceneManager.setScene("addCourse");
            resetAllFields();
        });

        delay.play();

        System.out.println("Content added");
        System.out.println(n);
        System.out.println(ID);
        System.out.println(cre);
        System.out.println(le);
        System.out.println(desc);
        System.out.println(newEntity);
        System.out.println("content added successfully");
    }

    private void resetAllFields() {
        name.clear();
        id.clear();
        credit.getSelectionModel().clearSelection();
        level.getSelectionModel().clearSelection();
        description.clear();
    }
}