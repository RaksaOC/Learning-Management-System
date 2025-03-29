package main.java.com.lms.controllers.teacherSide;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import main.AppSession;
import main.SceneManager;
import main.java.com.lms.managers.teacherSide.ResourceManager;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class AddResourceController {
    @FXML
    private ImageView backButton;

    @FXML
    private TextField resourceTitle;
    @FXML
    private TextArea resourceDescription;
    @FXML
    private Button addAttach;

    @FXML
    private VBox referenceMaterialVBox;
    @FXML
    private Button finishButton;

    private AtomicReference<String> link = new AtomicReference<>("");

    public void initialize() {
        backButton.setOnMouseClicked(event -> {
            SceneManager.loadCenterView("teacherClassroomContents", "resources/com/lms/views/teacherSide/ClassroomContents.fxml");
            SceneManager.setCenterView("teacherClassroomContents");
        });

        addAttach.setOnMouseClicked(event -> {
            String userInput = showInputDialog();
            if (userInput != null && !userInput.trim().isEmpty()) {
                link.set(userInput);
                referenceMaterialVBox.getChildren().add(attachCard(link.get(), ""));
            }
        });

        finishButton.setOnMouseClicked(event -> {
            if (!(resourceTitle.getText().isEmpty() ||
                    resourceDescription.getText().isEmpty())) {

                ResourceManager resourceManager = new ResourceManager(AppSession.getInstance().getSelectedClassroom());
                String title = resourceTitle.getText();
                String description = resourceDescription.getText();

                resourceManager.manageAddMaterial(title, description, link.get());
                SceneManager.loadCenterView("teacherClassroomContents", "resources/com/lms/views/teacherSide/ClassroomContents.fxml");
                SceneManager.setCenterView("teacherClassroomContents");
            } else {
                showAlert("Error", "Please fill all the fields.");
            }
        });
    }

    private HBox attachCard(String resourceName, String resourceImagePath) {
        HBox attachCard = new HBox(40);
        attachCard.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-background-radius: 30; -fx-border-radius: 30;");
        attachCard.setMaxWidth(Double.MAX_VALUE);
        attachCard.setPrefHeight(79.0);
        attachCard.setPrefWidth(700.0);
        attachCard.setAlignment(Pos.CENTER_LEFT);
        attachCard.setCursor(Cursor.HAND);

        attachCard.setPadding(new Insets(0, 30, 0, 30));

//        ImageView imageView = new ImageView();
//        imageView.setFitHeight(68.0);
//        imageView.setFitWidth(63.0);
//        imageView.setImage(new Image(getClass().getResource(resourceImagePath).toExternalForm()));

        Text resourceText = new Text(resourceName);
        resourceText.setFont(Font.font("AppleGothic Regular", 18));

        attachCard.getChildren().addAll(resourceText);

        attachCard.setOnMouseClicked(event -> {
            System.out.println(resourceName + " has been clicked!");
        });

        return attachCard;
    }

    private String showInputDialog() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Attachment Link");
        dialog.setHeaderText("Enter Attachment Link:");
        dialog.setContentText("Link:");

        Optional<String> result = dialog.showAndWait();
        return result.orElse("");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}