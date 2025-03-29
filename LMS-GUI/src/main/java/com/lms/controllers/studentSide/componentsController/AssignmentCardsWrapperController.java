package main.java.com.lms.controllers.studentSide.componentsController;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import main.AppSession;
import main.SceneManager;
import main.java.com.lms.managers.studentSide.AssignmentsManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class AssignmentCardsWrapperController {
    @FXML
    private ScrollPane scrollPane;

    private HashMap<String, String> assignment_classroom;
    private ArrayList<String> assignmentsList;

    private int numOfCardsPerRow;

    public void initialize() {
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        scrollPane.setContent(assignmentsWrapper());

        // Delay execution until parent is available
        Platform.runLater(() -> {
            if (scrollPane.getScene() != null && scrollPane.getScene().getRoot() instanceof BorderPane parent) {
                Node centerNode = parent.getCenter();
                if (centerNode instanceof Region region) {
                    // Bind width to the available space
                    scrollPane.maxWidthProperty().bind(region.widthProperty());

                    // Dynamically set height to maintain responsiveness
                    scrollPane.setPrefHeight(region.getHeight() * 0.9); // 90% of the parent height
                    scrollPane.maxHeightProperty().bind(region.heightProperty()); // Prevent overflow

                    // Enable scrolling while maintaining content's natural size
                    scrollPane.setFitToHeight(false);
                    scrollPane.setFitToWidth(true);

                    // Allow content inside to scroll properly
                    VBox content = (VBox) scrollPane.getContent();
                    content.maxHeightProperty().bind(scrollPane.maxHeightProperty()); // Bind content height to ScrollPane
                }
            }
        });
    }

    private VBox assignmentsWrapper() {
        VBox assignmentsWrapper = new VBox();
        assignmentsWrapper.setPrefWidth(Double.MAX_VALUE);
        assignmentsWrapper.setPrefHeight(Double.MAX_VALUE);
        assignmentsWrapper.setSpacing(40);

        AssignmentsManager assignmentsManager = new AssignmentsManager();
        assignment_classroom = (HashMap<String, String>) assignmentsManager.getAllAssignments();

        assignmentsList = new ArrayList<>(assignment_classroom.keySet());
        Collections.sort(assignmentsList);

        ArrayList<HBox> rows = new ArrayList<>();
        HBox row = new HBox();
        row.setSpacing(10); // Space between cards

        numOfCardsPerRow = 0;
        for (int i = 0; i < assignmentsList.size(); i++) {
            if (i % 5 == 0 && i != 0) {
                rows.add(row); // Add completed row
                row = new HBox(); // Start a new row
                row.setSpacing(10); // Space between cards
                numOfCardsPerRow = 0;
            }
            row.getChildren().add(assignmentCard(i)); // Add card to the row
            numOfCardsPerRow++;
        }

        // Add the last row if it contains any items
        if (!row.getChildren().isEmpty()) {
            rows.add(row);
        }
        assignmentsWrapper.getChildren().addAll(rows);
        assignmentsWrapper.setPadding(new Insets(20, 15, 15, 15));
        assignmentsWrapper.setStyle("-fx-background-color: #f4f6fa");
        return assignmentsWrapper;
    }

    private VBox assignmentCard(int idx) {
        VBox assignmentCard = new VBox();

        ImageView assignmentCardBanner = new ImageView();
        Image image = new Image(getClass().getResource("../../../../../../resources/com/lms/images/assignments-icon.png").toExternalForm());
        assignmentCardBanner.setImage(image);


        VBox assignmentIDVBox = new VBox();
        Text assignmentID = new Text(assignmentsList.get(idx));
        assignmentIDVBox.getChildren().add(assignmentID);

        assignmentCard.getChildren().add(assignmentCardBanner);
        assignmentCard.getChildren().add(assignmentIDVBox);
        if (numOfCardsPerRow >= 5){
            HBox.setHgrow(assignmentCard, Priority.ALWAYS);
        }

        // styling
        assignmentCard.setSpacing(20);
        assignmentCard.setAlignment(Pos.TOP_CENTER);
        assignmentCard.setPrefWidth(350);
        assignmentCard.setMinHeight(250);
        assignmentCard.setStyle("-fx-border-radius: 30; -fx-background-color: #FFFFFF; -fx-background-radius: 30");
        assignmentCard.setCursor(Cursor.HAND);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(10);       // Increase the radius for a larger shadow
        dropShadow.setSpread(0.2);      // Optional: control how concentrated the shadow is
        dropShadow.setOffsetX(0);       // Zero offset makes it centered
        dropShadow.setOffsetY(0);       // Zero offset makes it centered
        dropShadow.setColor(Color.BLACK); // Set the shadow color

        assignmentCard.setEffect(dropShadow);

        assignmentCard.setOnMouseEntered(e -> {
            assignmentCard.setScaleX(1.02);
            assignmentCard.setScaleY(1.02);
        });
        assignmentCard.setOnMouseExited(e -> {
            assignmentCard.setScaleX(1.0);
            assignmentCard.setScaleY(1.0);
        });

        assignmentCardBanner.setFitWidth(150);
        assignmentCardBanner.setFitHeight(150);
        assignmentIDVBox.setStyle("-fx-border-radius: 30; -fx-background-color: #2F92BC; -fx-background-radius: 30");
        assignmentIDVBox.setAlignment(Pos.CENTER);
        assignmentIDVBox.setPrefWidth(Double.MAX_VALUE);
        assignmentIDVBox.setPrefHeight(80);

        assignmentID.setFont(Font.font("AppleGothic", 20));

        assignmentCard.setOnMouseClicked(e -> {
            AppSession.getInstance().setSelectedClassroom(assignment_classroom.get(assignmentsList.get(idx)));
            AppSession.getInstance().setSelectedAssignment(extractId(assignmentsList.get(idx)));
            AppSession.getInstance().isSubmissionFromAllPage(true);

            SceneManager.loadCenterView("assignmentSubmission", "resources/com/lms/views/studentSide/AssignmentSubmission.fxml");
            SceneManager.setCenterView("assignmentSubmission");
        });

        return assignmentCard;
    }

    private String extractId(String longId) {
        return longId.substring(0, longId.indexOf(" "));
    }
}
