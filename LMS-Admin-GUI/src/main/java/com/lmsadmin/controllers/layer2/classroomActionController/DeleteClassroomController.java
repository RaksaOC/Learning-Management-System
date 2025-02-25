package main.java.com.lmsadmin.controllers.layer2.classroomActionController;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import main.java.com.lmsadmin.controllers.layer0.MainFrameController;
import main.java.com.lmsadmin.managers.layer2.manage_entity_manager.ManageClassroomManager;
import org.json.JSONArray;
import org.json.JSONObject;

public class DeleteClassroomController extends MainFrameController{
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
            ManageClassroomManager manageClassroomManager = new ManageClassroomManager();
            manageClassroomManager.manageDeleteEntity(idField.getText());

            loadSuccess("deleteClassroom");
            clearDetails();
        }
        else{
            clearDetails();
        }
    }

    private void createDetails(){
        String idToSearch = idField.getText();
        ManageClassroomManager manageClassroomManager = new ManageClassroomManager();
        JSONObject details = manageClassroomManager.getDetails(idToSearch);
        detailsVBox.getChildren().clear();
        detailsVBox.setStyle("-fx-background-color: #ebebeb");
        Pos center_left = Pos.CENTER_LEFT;
        detailsVBox.setAlignment(center_left);
        detailsVBox.setSpacing(10);
        String id = details.getString("id");
        String teacher = details.getString("teacherId");
        String course = details.getString("courseId");

        JSONArray students = details.getJSONArray("students");

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < students.length(); i++) {
            stringBuilder.append(students.getString(i));
            if(i != students.length()-1){
                stringBuilder.append(",");
            }
        }
        String studentsString = stringBuilder.toString();

        Font textFont = Font.font("Gill Sans", 25);

        Text idText = new Text("ID: " + id);
        Text teacherText = new Text("TeacherId: " + teacher);
        Text courseText = new Text("CourseId: " + course);
        Text studentText = new Text("Students: " + studentsString);

        Text[] textNodes = {idText, teacherText, courseText, studentText};
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