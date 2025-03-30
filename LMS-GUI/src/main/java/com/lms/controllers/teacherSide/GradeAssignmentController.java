package main.java.com.lms.controllers.teacherSide;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class GradeAssignmentController {
    // TODO: make logic for clicking on the attachment item in the list (loop through the children of the VBOX)

    AssignmentManager assignmentManager;

    @FXML
    private ImageView backButton;
    @FXML
    private Text assignmentID;
    @FXML
    private Text assignmentName;
    @FXML
    private Text assignmentDueDate;
    @FXML
    private Text studentID;
    @FXML
    private Text studentName;
    @FXML
    private VBox refWrapper;
    @FXML
    private VBox attachWrapper;

    @FXML
    private TextField gradeInput;
    @FXML
    private Button finishButton;

    public void initialize() {
        finishButton.setCursor(Cursor.HAND);
        assignmentManager = new AssignmentManager(AppSession.getInstance().getSelectedClassroom());

        assignmentID.setText(AppSession.getInstance().getSelectedAssignment());
        assignmentName.setText(assignmentManager.getAssignmentTitle());
        assignmentDueDate.setText(assignmentManager.getAssignmentDeadline());
        studentID.setText(AppSession.getInstance().getStudent().getId());
        studentName.setText(AppSession.getInstance().getStudent().getFirstName() + " " + AppSession.getInstance().getStudent().getLastName());
        refWrapper.getChildren().add(refCard(assignmentManager.getAssignmentRef()));
        backButton.setOnMouseClicked(event -> {
            AppSession.getInstance().setStudent(null);
            SceneManager.loadCenterView("assignmentView", "resources/com/lms/views/teacherSide/AssignmentView.fxml");
            SceneManager.setCenterView("assignmentView");
        });

        if(assignmentManager.isAssignmentSubmitted()){
            attachWrapper.getChildren().clear();
            attachWrapper.getChildren().addAll(attachCard(assignmentManager.getStudentSubAttachment()));
        }

        if (assignmentManager.isAssignmentSubmitted() && assignmentManager.isAssignmentGraded()) {
            attachWrapper.getChildren().clear();
            attachWrapper.getChildren().addAll(attachCard(assignmentManager.getStudentSubAttachment()));
            finishButton.setDisable(true);
            gradeInput.setText(assignmentManager.getAssignmentGrade().toString());
            gradeInput.setDisable(true);
        }

        finishButton.setOnMouseClicked(event -> {
            if (gradeInput.getText().isEmpty() || Integer.parseInt(gradeInput.getText()) > 100 || Integer.parseInt(gradeInput.getText()) < 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a valid grade");
                alert.showAndWait();
            } else {
                assignmentManager.manageGradeAssignmentSql(Double.parseDouble(gradeInput.getText()));
            }
        });
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

    private HBox attachCard(String resourceName) {
        HBox attachCard = new HBox(40);
        attachCard.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-background-radius: 30; -fx-border-radius: 30;");
        attachCard.setMaxWidth(Double.MAX_VALUE);
        attachCard.setPrefHeight(79.0);
        attachCard.setPrefWidth(700.0);
        attachCard.setAlignment(Pos.CENTER_LEFT);
        attachCard.setCursor(Cursor.HAND);

        attachCard.setPadding(new Insets(0, 30, 0, 30));

        Text resourceText = new Text(resourceName);
        resourceText.setFont(Font.font("AppleGothic Regular", 18));

        attachCard.getChildren().addAll(resourceText);

        attachCard.setOnMouseClicked(event -> {
            System.out.println(resourceName + " has been clicked!");
        });

        return attachCard;
    }
}