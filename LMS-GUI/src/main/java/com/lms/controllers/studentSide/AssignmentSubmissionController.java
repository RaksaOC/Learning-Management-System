package main.java.com.lms.controllers.studentSide;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import main.AppSession;
import main.SceneManager;
import main.java.com.lms.managers.studentSide.AssignmentsManager;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class AssignmentSubmissionController {
    private AssignmentsManager assignmentsManager;
    private AppSession session = AppSession.getInstance();

    @FXML
    private ImageView backButton;
    @FXML
    private Text assId;
    @FXML
    private Text assTitle;
    @FXML
    private Text deadLine;
    @FXML
    private VBox refWrapper;
    @FXML
    private VBox attachmentWrapper;
    @FXML
    private Button submit;
    @FXML
    private Button attach;
    @FXML
    private VBox scoreBox;

    private String ass_ref;

    public void initialize() {
        assignmentsManager = new AssignmentsManager();
        backButton.setOnMouseClicked(event -> {
            if (AppSession.getInstance().getIsSubmissionFromAllPage()) {
                loadDynamicComponentToCenterView(
                        "studentAssignments",
                        "studentAssignmentCardsWrapper",
                        "resources/com/lms/views/studentSide/Assignments.fxml",
                        "resources/com/lms/views/studentSide/components/AssignmentCardsWrapper.fxml"
                );
                SceneManager.setCenterView("studentAssignments");
            } else {
                SceneManager.loadCenterView("studentClassroomContents", "resources/com/lms/views/studentSide/ClassroomContents.fxml");
                SceneManager.setCenterView("studentClassroomContents");
            }
        });
        attach.setCursor(Cursor.HAND);
        submit.setCursor(Cursor.HAND);
        String assignmentId = session.getSelectedAssignment();
        // means that its submitted
        if (assignmentsManager.getPrevAssignmentRef() == null) {
            attachmentWrapper.getChildren().clear();
        }
        else{
            attach.setDisable(true);
            submit.setDisable(true);
            attachmentWrapper.getChildren().clear();
            attachmentWrapper.getChildren().add(attachCard(assignmentsManager.getPrevAssignmentRef(), ""));
        }

        if(assignmentsManager.isAssignmentGraded()){
            Text score = new Text("Your Score: " + assignmentsManager.getAssignmentGrade().toString());
            score.setFont(Font.font("AppleGothic", 20));

            scoreBox.setAlignment(Pos.CENTER);
            scoreBox.getChildren().add(score);
        }

        assId.setText(assignmentId);
        assTitle.setText(assignmentsManager.getAssignmentTitle());
        deadLine.setText(assignmentsManager.getAssignmentDeadline());
        ass_ref = assignmentsManager.getAssignmentRef();
        refWrapper.getChildren().clear();
        refWrapper.getChildren().add(refCard(ass_ref));

        AtomicReference<String> link = new AtomicReference<>("");

        attach.setOnMouseClicked(event -> {
            String inputLink = showInputDialog();
            if (inputLink != null && !inputLink.isEmpty()) {
                link.set(inputLink);
                attachmentWrapper.getChildren().clear();
                attachmentWrapper.getChildren().add(attachCard(link.get(), ""));
            }
        });

        submit.setOnMouseClicked(event -> {
            if (link.get() != null && !link.get().isEmpty()) {
                assignmentsManager.manageSubmitAssignment(link.get());
            } else {
                System.out.println("No attachment link provided!");
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

    private HBox attachCard(String resourceName, String resourceImagePath) {
        // Create the HBox container with a white background and black border
        HBox attachCard = new HBox(40);
        attachCard.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-background-radius: 30; -fx-border-radius: 30;");
        attachCard.setMaxWidth(Double.MAX_VALUE);
        attachCard.setPrefHeight(79.0);
        attachCard.setPrefWidth(700.0);
        attachCard.setAlignment(Pos.CENTER_LEFT);
        attachCard.setCursor(Cursor.HAND);
        attachCard.setMaxWidth(Region.USE_PREF_SIZE);

        // Set the padding
        attachCard.setPadding(new Insets(0, 30, 0, 30));

        // Create the ImageView and set the image
        ImageView imageView = new ImageView();
        imageView.setFitHeight(68.0);
        imageView.setFitWidth(63.0);
        imageView.setImage(new Image(getClass().getResource(resourceImagePath).toExternalForm()));

        // Create the Text node for the resource name
        Text resourceText = new Text(resourceName);
        resourceText.setFont(Font.font("AppleGothic Regular", 18));

        // Add the ImageView and Text to the HBox
        attachCard.getChildren().addAll(imageView, resourceText);

        // Add a click event (you can add specific action here)
        attachCard.setOnMouseClicked(event -> {
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().browse(new URI(resourceName));
                } catch (IOException | URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        });

        return attachCard;
    }

    public String showInputDialog() {
        // Create a TextInputDialog
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Attachment Link");
        dialog.setHeaderText("Enter Attachment Link:");
        dialog.setContentText("Link:");

        // Wait for the user response
        Optional<String> result = dialog.showAndWait();

        // If the user clicked OK and entered a value, return it. Otherwise, return an empty string.
        return result.orElse("");
    }

    private void loadDynamicComponentToCenterView(String centerViewName, String dynamicComponentName, String centerViewFilePath, String dynamicComponentFilePath) {
        SceneManager.loadCenterView(centerViewName, centerViewFilePath);
        SceneManager.loadComponent(dynamicComponentName, dynamicComponentFilePath);

        VBox center = (VBox) SceneManager.getCenterView(centerViewName);
        center.getChildren().add(SceneManager.getComponent(dynamicComponentName));
    }
}