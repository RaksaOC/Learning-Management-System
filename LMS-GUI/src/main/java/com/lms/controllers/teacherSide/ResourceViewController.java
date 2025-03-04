package main.java.com.lms.controllers.teacherSide;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import org.json.JSONObject;

public class ResourceViewController {
    @FXML
    private VBox materailList;
    @FXML
    private TableView<JSONObject> studentsTable;

    public void initialize() {
        // TODO: populate material list (links to the resources) EX: for a resource card called Code Setup we can have links (or resources) like IDESetup.pdf, GCCInstall.pdf, or yt link
        // TODO: populate students table that contains their name, ID and whether they have viewed the resource
    }
}