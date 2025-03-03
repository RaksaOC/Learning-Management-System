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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import main.AppSession;
import main.java.com.lms.managers.studentSide.ResourcesManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ResourceCardsWrapperController {

    @FXML
    private ScrollPane scrollPane;

    private HashMap<String, String> resource_classroom;
    private ArrayList<String> resourcesList;


    public void initialize() {
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setStyle("-fx-background-color: red");

        scrollPane.setContent(resourcesWrapper());

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

    private VBox resourcesWrapper() {
        VBox resourcesWrapper = new VBox();
        resourcesWrapper.setPrefWidth(Double.MAX_VALUE);
        resourcesWrapper.setPrefHeight(Double.MAX_VALUE);
        resourcesWrapper.setSpacing(40);

        ResourcesManager resourcesManager = new ResourcesManager();
        resource_classroom = resourcesManager.getAllResources();

        resourcesList = new ArrayList<>(resource_classroom.keySet());
        Collections.sort(resourcesList);
        System.out.println(resourcesList);

        ArrayList<HBox> rows = new ArrayList<>();
        HBox row = new HBox();
        row.setSpacing(40); // Space between cards

        for (int i = 0; i < resourcesList.size(); i++) {
            if (i % 5 == 0 && i != 0) {
                rows.add(row); // Add completed row
                row = new HBox(); // Start a new row
                row.setSpacing(10);
            }
            row.getChildren().add(resourceCard(i)); // Add card to the row
        }

        // Add the last row if it contains any items
        if (!row.getChildren().isEmpty()) {
            rows.add(row);
        }
        resourcesWrapper.getChildren().addAll(rows);
        resourcesWrapper.setPadding(new Insets(20, 15, 15, 15));
        resourcesWrapper.setStyle("-fx-background-color: #f4f6fa");
        return resourcesWrapper;
    }

    private VBox resourceCard(int idx) {
        VBox resourceCard = new VBox();

        ImageView resourceCardBanner = new ImageView();
        Image image = new Image(getClass().getResource("../../../../../../resources/com/lms/images/resources-icon.png").toExternalForm());
        resourceCardBanner.setImage(image);


        VBox resourceIDVBox = new VBox();
        Text resourceID = new Text(resourcesList.get(idx));
        resourceIDVBox.getChildren().add(resourceID);

        resourceCard.getChildren().add(resourceCardBanner);
        resourceCard.getChildren().add(resourceIDVBox);


        // styling
        resourceCard.setSpacing(20);
        resourceCard.setAlignment(Pos.TOP_CENTER);
        resourceCard.setPrefWidth(400);
        resourceCard.setMinHeight(250);
        resourceCard.setStyle("-fx-border-radius: 30; -fx-background-color: #FFFFFF; -fx-background-radius: 30");
        resourceCard.setCursor(Cursor.HAND);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(10);       // Increase the radius for a larger shadow
        dropShadow.setSpread(0.2);      // Optional: control how concentrated the shadow is
        dropShadow.setOffsetX(0);       // Zero offset makes it centered
        dropShadow.setOffsetY(0);       // Zero offset makes it centered
        dropShadow.setColor(Color.BLACK); // Set the shadow color

        resourceCard.setEffect(dropShadow);

        resourceCard.setOnMouseEntered(e -> {
            resourceCard.setScaleX(1.02);
            resourceCard.setScaleY(1.02);
        });
        resourceCard.setOnMouseExited(e -> {
            resourceCard.setScaleX(1.0);
            resourceCard.setScaleY(1.0);
        });

//        Rectangle clip = new Rectangle();
//        clip.setArcHeight(30);
//        clip.setArcWidth(30);
//        resourceCardBanner.setClip(clip);

        resourceCardBanner.setFitWidth(250);
        resourceCardBanner.setFitHeight(250);
        resourceIDVBox.setStyle("-fx-border-radius: 30; -fx-background-color: #2F92BC; -fx-background-radius: 30");
        resourceIDVBox.setAlignment(Pos.CENTER);
        resourceIDVBox.setPrefWidth(Double.MAX_VALUE);
        resourceIDVBox.setPrefHeight(80);

        resourceID.setFont(Font.font("AppleGothic", 24));

        resourceCard.setOnMouseClicked(e->{
            AppSession.getInstance().setSelectedClassroom(resource_classroom.get(resourcesList.get(idx)));
            AppSession.getInstance().setSelectedResources(resourcesList.get(idx));
            // TODO: transition to resource viewing page
        });

        return resourceCard;
    }
}