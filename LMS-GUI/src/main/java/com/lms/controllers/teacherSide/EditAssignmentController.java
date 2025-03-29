package main.java.com.lms.controllers.teacherSide;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
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
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class EditAssignmentController {

    private final AssignmentManager assignmentManager = new AssignmentManager(AppSession.getInstance().getSelectedClassroom());
    @FXML
    private ImageView backButton;
    @FXML
    private TextField curAssignmentName;
    @FXML
    private TextArea curAssignmentDescription;
    @FXML
    private TextField curAssignmentDeadline;

    @FXML
    private TextField newAssignmentName;
    @FXML
    private TextArea newAssignmentDescription;
    @FXML
    private DatePicker newAssignmentDeadline;
    @FXML
    private Button editButton;
    @FXML
    private VBox refWrapper;
    @FXML
    private Button addRef;

    private AtomicReference<String> link = new AtomicReference<>("");

    public void initialize() {
        curAssignmentName.setText(assignmentManager.getAssignmentTitle());
        curAssignmentDescription.setText(assignmentManager.getAssignmentDescription());
        curAssignmentDeadline.setText(assignmentManager.getAssignmentDeadline());

        addRef.setOnMouseClicked(event -> {
            String userInput = showInputDialog();
            if (userInput != null && !userInput.trim().isEmpty()) {
                link.set(userInput);
                refWrapper.getChildren().add(refCard(link.get()));
            }
        });
        editButton.setOnAction(event -> {
            assignmentManager.manageEditAssignmentSql(newAssignmentName.getText(), newAssignmentDescription.getText(), newAssignmentDeadline.toString(), link.get());
            SceneManager.loadCenterView("assignmentView", "resources/com/lms/views/teacherSide/AssignmentView.fxml");
            SceneManager.setCenterView("assignmentView");
        });

        backButton.setOnMouseClicked(event -> {
            SceneManager.loadCenterView("assignmentView", "resources/com/lms/views/teacherSide/AssignmentView.fxml");
            SceneManager.setCenterView("assignmentView");
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

    private String showInputDialog() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Attachment Link");
        dialog.setHeaderText("Enter Attachment Link:");
        dialog.setContentText("Link:");

        Optional<String> result = dialog.showAndWait();
        return result.orElse("");
    }
}