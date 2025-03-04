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
import main.java.com.lms.managers.QuizzesManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class QuizCardsWrapperController {
    @FXML
    private ScrollPane scrollPane;

    private ArrayList <String> quizzesList;
    private HashMap<String, String> quiz_classroom;

    public void initialize() {
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setStyle("-fx-background-color: red");

        scrollPane.setContent((quizzesWrapper()));

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

    private VBox quizzesWrapper() {
        VBox QuizzesWrapper = new VBox();
        QuizzesWrapper.setPrefWidth(Double.MAX_VALUE);
        QuizzesWrapper.setPrefHeight(Double.MAX_VALUE);
        QuizzesWrapper.setSpacing(40);

        QuizzesManager QuizzesManager = new QuizzesManager();
        quiz_classroom = QuizzesManager.getAllQuizzes();

        quizzesList = new ArrayList<>(quiz_classroom.keySet());
        Collections.sort(quizzesList);
        System.out.println(quizzesList);

        ArrayList<HBox> rows = new ArrayList<>();
        HBox row = new HBox();
        row.setSpacing(40); // Space between cards

        for (int i = 0; i < quizzesList.size(); i++) {
            if (i % 5 == 0 && i != 0) {
                rows.add(row); // Add completed row
                row = new HBox(); // Start a new row
                row.setSpacing(10);
            }
            row.getChildren().add(QuizCard(i)); // Add card to the row
        }

        // Add the last row if it contains any items
        if (!row.getChildren().isEmpty()) {
            rows.add(row);
        }
        QuizzesWrapper.getChildren().addAll(rows);
        QuizzesWrapper.setPadding(new Insets(20, 15, 15, 15));
        QuizzesWrapper.setStyle("-fx-background-color: #f4f6fa");
        return QuizzesWrapper;
    }

    private VBox QuizCard(int idx) {
        VBox quizCard = new VBox();

        ImageView quizCardBanner = new ImageView();
        Image image = new Image(getClass().getResource("../../../../../../resources/com/lms/images/quizzes-icon.png").toExternalForm());
        quizCardBanner.setImage(image);


        VBox QuizIDVBox = new VBox();
        Text QuizID = new Text(quizzesList.get(idx));
        QuizIDVBox.getChildren().add(QuizID);

        quizCard.getChildren().add(quizCardBanner);
        quizCard.getChildren().add(QuizIDVBox);


        // styling
        quizCard.setSpacing(20);
        quizCard.setAlignment(Pos.TOP_CENTER);
        quizCard.setPrefWidth(400);
        quizCard.setMinHeight(250);
        quizCard.setStyle("-fx-border-radius: 30; -fx-background-color: #FFFFFF; -fx-background-radius: 30");
        quizCard.setCursor(Cursor.HAND);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(10);       // Increase the radius for a larger shadow
        dropShadow.setSpread(0.2);      // Optional: control how concentrated the shadow is
        dropShadow.setOffsetX(0);       // Zero offset makes it centered
        dropShadow.setOffsetY(0);       // Zero offset makes it centered
        dropShadow.setColor(Color.BLACK); // Set the shadow color

        quizCard.setEffect(dropShadow);

        quizCard.setOnMouseEntered(e -> {
            quizCard.setScaleX(1.02);
            quizCard.setScaleY(1.02);
        });
        quizCard.setOnMouseExited(e -> {
            quizCard.setScaleX(1.0);
            quizCard.setScaleY(1.0);
        });

//        Rectangle clip = new Rectangle();
//        clip.setArcHeight(30);
//        clip.setArcWidth(30);
//        quizCardBanner.setClip(clip);

        quizCardBanner.setFitWidth(250);
        quizCardBanner.setFitHeight(250);
        QuizIDVBox.setStyle("-fx-border-radius: 30; -fx-background-color: #2F92BC; -fx-background-radius: 30");
        QuizIDVBox.setAlignment(Pos.CENTER);
        QuizIDVBox.setPrefWidth(Double.MAX_VALUE);
        QuizIDVBox.setPrefHeight(80);

        quizCard.setOnMouseClicked(e -> {
            AppSession.getInstance().setSelectedClassroom(quiz_classroom.get(quizzesList.get(idx)));
            AppSession.getInstance().setSelectedQuiz(quizzesList.get(idx));
            // TODO: transition to quiz viewing page
        });

        QuizID.setFont(Font.font("AppleGothic", 24));
        return quizCard;
    }
}
