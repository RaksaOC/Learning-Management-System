package main.java.com.lms.controllers.teacherSide;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
import main.java.com.lms.managers.teacherSide.ResourceManager;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class EditResourceController {
    private final ResourceManager resourceManager = new ResourceManager(AppSession.getInstance().getSelectedClassroom());
    @FXML
    private ImageView backButton;
    @FXML
    private TextField curTitle;
    @FXML
    private TextArea curDescription;
    @FXML
    private TextField newTitle;
    @FXML
    private TextArea newDescription;
    @FXML
    private VBox refWrapper;
    @FXML
    private Button addButton; // handle adding more materials
    @FXML
    private Button editButton; // handle changing the data

    private AtomicReference<String> link = new AtomicReference<>("");

    public void initialize() {
        backButton.setCursor(Cursor.HAND);
        addButton.setCursor(Cursor.HAND);
        editButton.setCursor(Cursor.HAND);

        backButton.setOnMouseClicked(event -> {
            SceneManager.loadCenterView("resourceView", "resources/com/lms/views/teacherSide/ResourceView.fxml");
            SceneManager.setCenterView("resourceView");
        });

        curTitle.setText(resourceManager.getResourceTitle());
        curDescription.setText(resourceManager.getResourceDescription());
        addButton.setOnMouseClicked(event -> {
            String userInput = showInputDialog();
            if (userInput != null && !userInput.trim().isEmpty()) {
                link.set(userInput);
                refWrapper.getChildren().add(refCard(link.get()));
            }
        });
        editButton.setOnMouseClicked(event -> {
            resourceManager.manageEditMaterialSql(newTitle.getText(), newDescription.getText(), link.get());
            SceneManager.loadCenterView("resourceView", "resources/com/lms/views/teacherSide/ResourceView.fxml");
            SceneManager.setCenterView("resourceView");
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