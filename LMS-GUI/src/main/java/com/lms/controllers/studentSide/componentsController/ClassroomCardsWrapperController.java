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
import main.SceneManager;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class ClassroomCardsWrapperController {
    @FXML
    private ScrollPane scrollPane;

    private AppSession session = AppSession.getInstance();
    private JSONObject progress = session.getStudent().getProgress();
    private ArrayList<String> classroomIds = new ArrayList<>();

    public void initialize() {
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setStyle("-fx-background-color: red");

        scrollPane.setContent(classroomsWrapper());

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

    private VBox classroomsWrapper() {
        VBox classroomsWrapper = new VBox();
        classroomsWrapper.setPrefWidth(Double.MAX_VALUE);
        classroomsWrapper.setPrefHeight(Double.MAX_VALUE);
        classroomsWrapper.setSpacing(40);
        Set<String> keys = progress.keySet();
        classroomIds.clear();
        for (String classroomId : keys) {
            classroomIds.add(classroomId);
        }
        Collections.sort(classroomIds);
        System.out.println(classroomIds);

        ArrayList<HBox> rows = new ArrayList<>();
        HBox row = new HBox();
        row.setSpacing(40); // Space between cards

        for (int i = 0; i < classroomIds.size(); i++) {
            if (i % 4 == 0 && i != 0) {
                rows.add(row); // Add completed row
                row = new HBox(); // Start a new row
                row.setSpacing(20);
            }
            row.getChildren().add(classroomCard(i)); // Add card to the row
        }

        // Add the last row if it contains any items
        if (!row.getChildren().isEmpty()) {
            rows.add(row);
        }
        classroomsWrapper.getChildren().addAll(rows);
        classroomsWrapper.setPadding(new Insets(20, 15, 15, 15));
        classroomsWrapper.setStyle("-fx-background-color: #f4f6fa");
        return classroomsWrapper;
    }

    private VBox classroomCard(int idx) {
        VBox classroomCard = new VBox();

        ImageView classroomCardBanner = new ImageView();
        Image image = new Image(getClass().getResource("../../../../../../resources/com/lms/images/img.png").toExternalForm());
        classroomCardBanner.setImage(image);

        VBox classroomIDVBox = new VBox();
        Text classroomID = new Text(classroomIds.get(idx));
        classroomIDVBox.getChildren().add(classroomID);

        classroomCard.getChildren().add(classroomCardBanner);
        classroomCard.getChildren().add(classroomIDVBox);


        // styling
        classroomCard.setSpacing(20);
        classroomCard.setAlignment(Pos.TOP_CENTER);
        classroomCard.setPrefWidth(450);
        classroomCard.setMinHeight(200);
        classroomCard.setStyle("-fx-border-radius: 30; -fx-background-color: #FFFFFF; -fx-background-radius: 30");
        classroomCard.setCursor(Cursor.HAND);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(10);       // Increase the radius for a larger shadow
        dropShadow.setSpread(0.2);      // Optional: control how concentrated the shadow is
        dropShadow.setOffsetX(0);       // Zero offset makes it centered
        dropShadow.setOffsetY(0);       // Zero offset makes it centered
        dropShadow.setColor(Color.BLACK); // Set the shadow color

        classroomCard.setEffect(dropShadow);

        classroomCard.setOnMouseEntered(e -> {
            classroomCard.setScaleX(1.02);
            classroomCard.setScaleY(1.02);
        });
        classroomCard.setOnMouseExited(e -> {
            classroomCard.setScaleX(1.0);
            classroomCard.setScaleY(1.0);
        });

//        Rectangle clip = new Rectangle();
//        clip.setArcHeight(30);
//        clip.setArcWidth(30);
//        classroomCardBanner.setClip(clip);

        classroomCardBanner.setFitWidth(420);
        classroomCardBanner.setFitHeight(250);
        classroomCard.setPadding(new Insets(15, 0, 0, 0));
//        classroomIDVBox.setStyle("-fx-border-radius: 30; -fx-background-color: #2F92BC; -fx-background-radius: 30");
        classroomIDVBox.setAlignment(Pos.CENTER);
        classroomIDVBox.setPrefWidth(Double.MAX_VALUE);
        classroomIDVBox.setPrefHeight(150);


        classroomID.setFont(Font.font("AppleGothic", 24));

        // very important block here to set the id and transibtion scene
        classroomCard.setOnMouseClicked(e -> {
            System.out.println("clicked on "+ classroomIds.get(idx));
            session.setSelectedClassroom(classroomIds.get(idx));
            // switch to classroom contents scene
            SceneManager.loadCenterView("studentClassroomContents", "resources/com/lms/views/studentSide/ClassroomContents.fxml");
            Platform.runLater(() ->{
                SceneManager.setCenterView("studentClassroomContents");
            });
        });

        return classroomCard;
    }
}
