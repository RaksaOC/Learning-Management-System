package main.java.com.lms.controllers.teacherSide;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import main.AppSession;
import main.SceneManager;
import main.java.com.lms.managers.teacherSide.AssignmentManager;
import main.java.com.lms.managers.teacherSide.ClassroomsManger;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Optional;

public class AssignmentViewController {

    private final AssignmentManager assignmentManager = new AssignmentManager(AppSession.getInstance().getSelectedClassroom());

    @FXML
    private Text assignmentID;
    @FXML
    private Text assignmentName;
    @FXML
    private Text assignmentDueDate;
    @FXML
    private TextArea assignmentDescription;
    @FXML
    private VBox refWrapper;
    @FXML
    private ImageView backButton;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;
    @FXML
    private VBox studentsList;

    private ClassroomsManger classroomsManger = new ClassroomsManger();
    private ArrayList<String> students;

    public void initialize() {


        students = classroomsManger.getAllStudentsInClassroom();

        assignmentID.setText(AppSession.getInstance().getSelectedAssignment());
        assignmentName.setText(assignmentManager.getAssignmentTitle());
        assignmentDueDate.setText(assignmentManager.getAssignmentDeadline());
        assignmentDescription.setText(assignmentManager.getAssignmentDescription());
        backButton.setOnMouseClicked(event -> {
            AppSession.getInstance().setSelectedAssignment(null);
            AppSession.getInstance().setSelectedResources(null);
            AppSession.getInstance().setSelectedQuiz(null);

            SceneManager.loadCenterView("teacherClassroomContents", "resources/com/lms/views/teacherSide/ClassroomContents.fxml");
            SceneManager.setCenterView("teacherClassroomContents");
        });
        editButton.setOnMouseClicked(event -> {
            SceneManager.loadCenterView("editAssignment", "resources/com/lms/views/teacherSide/EditAssignment.fxml");
            SceneManager.setCenterView("editAssignment");
        });
        deleteButton.setOnMouseClicked(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Assignment");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to delete this assignment?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                assignmentManager.manageDeleteAssignmentSql();
                AppSession.getInstance().setSelectedAssignment(null);

                SceneManager.loadCenterView("teacherClassroomContents", "resources/com/lms/views/teacherSide/ClassroomContents.fxml");
                SceneManager.setCenterView("teacherClassroomContents");
            }
        });
        refWrapper.getChildren().clear();
        refWrapper.getChildren().addAll(refCard(assignmentManager.getAssignmentRef()));

        studentsList.setAlignment(Pos.TOP_LEFT);
        for (int i = 0; i < students.size(); i++) {
            studentsList.getChildren().add(studentCard(students.get(i)));
        }
    }

    private HBox refCard(String refTitle) {
        // Create the HBox container
        HBox resourceCard = new HBox(40);
        resourceCard.setStyle("-fx-background-color: #2F92BC; -fx-border-color: black; -fx-background-radius: 30; -fx-border-radius: 30;");
        resourceCard.setMaxWidth(Double.MAX_VALUE);
        resourceCard.setPrefHeight(79.0);
        resourceCard.setPrefWidth(700.0);
        resourceCard.setAlignment(Pos.CENTER_LEFT);
        resourceCard.setCursor(Cursor.HAND);
        resourceCard.setMaxWidth(Region.USE_PREF_SIZE);

        // Set the padding
        resourceCard.setPadding(new Insets(0, 30, 0, 30));

        // Create the ImageView and set the image
        ImageView imageView = new ImageView();
        imageView.setFitHeight(68.0);
        imageView.setFitWidth(63.0);
        imageView.setImage(new Image(getClass().getResource("").toExternalForm()));

        // Create the Text node for the resource name
        Text resourceText = new Text(refTitle);
        resourceText.setFont(Font.font("AppleGothic Regular", 18));

        // Add the ImageView and Text to the HBox
        resourceCard.getChildren().addAll(imageView, resourceText);

        // Add a click event (you can add specific action here)
        resourceCard.setOnMouseClicked(event -> {
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().browse(new URI(refTitle));
                } catch (IOException | URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        });

        return resourceCard;
    }

    private HBox studentCard(String studentId_name) {
        // Create the HBox container
        HBox resourceCard = new HBox(40);
        resourceCard.setStyle("-fx-background-color: #ffffff; -fx-border-color: black; -fx-background-radius: 30; -fx-border-radius: 30;");
        resourceCard.setMaxWidth(Double.MAX_VALUE);
        resourceCard.setPrefHeight(79.0);
        resourceCard.setPrefWidth(400.0);
        resourceCard.setAlignment(Pos.CENTER_LEFT);
        resourceCard.setCursor(Cursor.HAND);
        resourceCard.setMaxWidth(Region.USE_PREF_SIZE);

        resourceCard.setPadding(new Insets(30, 30, 30, 30));

        Text resourceText = new Text(studentId_name);
        resourceText.setFont(Font.font("AppleGothic Regular", 18));

        Button gradeButton = new Button("Grade");
        gradeButton.setCursor(Cursor.HAND);
        gradeButton.setOnMouseClicked(event -> {
            AppSession.getInstance().setStudent(classroomsManger.getStudentToGrade(extractId(studentId_name)));

            SceneManager.loadCenterView("gradeAssignment", "resources/com/lms/views/teacherSide/GradeAssignment.fxml");
            SceneManager.setCenterView("gradeAssignment");

            System.out.println("Student to grade is: " + AppSession.getInstance().getStudent().toString());
        });

        resourceCard.getChildren().addAll(resourceText, gradeButton);

        return resourceCard;
    }

    public String extractId(String longId){
        return longId.substring(0, longId.indexOf(" "));
    }
}