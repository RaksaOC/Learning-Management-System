package main.java.com.lms.controllers.studentSide;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import main.AppSession;
import main.SceneManager;
import main.java.com.lms.managers.studentSide.AssignmentsManager;
import main.java.com.lms.managers.studentSide.QuizzesManager;
import main.java.com.lms.managers.studentSide.ResourcesManager;

import java.util.ArrayList;

public class ClassroomContentsController {
    private QuizzesManager quizzesManager;
    private AssignmentsManager assignmentManager;
    private ResourcesManager resourcesManager;
    @FXML
    private ScrollPane assignmentsScrollPane;
    @FXML
    private ScrollPane resourcesScrollPane;
    @FXML
    private ScrollPane quizzesScrollPane;
    @FXML
    private ImageView backButton;

    private ArrayList<String> assignmentIdsAndName;
    private ArrayList<String> resourceIdsAndName;
    private ArrayList<String> quizIdsAndName;

    public void initialize() {
        initContentList();
        initAssignmentsScrollPane();
        initResourcesScrollPane();
        initQuizzesScrollPane();
        backButton.setCursor(Cursor.HAND);
        backButton.setOnMouseClicked(event -> {
            SceneManager.setCenterView("studentClassrooms");
            AppSession.getInstance().setSelectedClassroom(null);
        });
    }

    private void initAssignmentsScrollPane() {
        assignmentsScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        assignmentsScrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        assignmentsScrollPane.setFitToWidth(true);
        assignmentsScrollPane.setContent(wrapper("assignment", assignmentIdsAndName));
        assignmentsScrollPane.setStyle("-fx-background-color: transparent;");
        assignmentsScrollPane.setPadding(new Insets(5, 10, 20, 10));
    }

    private void initResourcesScrollPane() {
        resourcesScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        resourcesScrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        resourcesScrollPane.setFitToWidth(true);
        resourcesScrollPane.setContent(wrapper("resource", resourceIdsAndName));
        resourcesScrollPane.setStyle("-fx-background-color: transparent;");
        resourcesScrollPane.setPadding(new Insets(5, 10, 20, 10));
    }

    private void initQuizzesScrollPane() {
        quizzesScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        quizzesScrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        quizzesScrollPane.setFitToWidth(true);
        quizzesScrollPane.setContent(wrapper("quiz", quizIdsAndName));
        quizzesScrollPane.setStyle("-fx-background-color: transparent;");
        quizzesScrollPane.setPadding(new Insets(5, 10, 20, 10));
    }

    private void initContentList() {
        assignmentManager = new AssignmentsManager();
        resourcesManager = new ResourcesManager();
        quizzesManager = new QuizzesManager();

        assignmentIdsAndName = new ArrayList<>();
        resourceIdsAndName = new ArrayList<>();
        quizIdsAndName = new ArrayList<>();

        assignmentIdsAndName.addAll(assignmentManager.getClassroomAssignments());
        resourceIdsAndName.addAll(resourcesManager.getClassroomResources());
        quizIdsAndName.addAll(quizzesManager.getClassroomQuizzes());
    }

    private VBox wrapper(String type, ArrayList<String> content) {
        VBox assignmentsWrapper = new VBox(10);
        assignmentsWrapper.setStyle("-fx-padding: 20; -fx-background-color: #f4f6fa;");
        assignmentsWrapper.setMaxHeight(Double.MAX_VALUE);
        assignmentsWrapper.setMaxWidth(Double.MAX_VALUE);

        if(content.isEmpty()) {
            VBox empty = new VBox(10);
            empty.setMaxHeight(Double.MAX_VALUE);
            empty.setMaxWidth(Double.MAX_VALUE);
            Text text = new Text("No content to display");
            text.setFont(Font.font("AppleGothic", 24));
            empty.setAlignment(Pos.CENTER);
            empty.getChildren().add(text);
            assignmentsWrapper.getChildren().add(empty);
            return assignmentsWrapper;
        }
        HBox row = new HBox(10);

        for (int i = 0; i < content.size(); i++) {
            row.getChildren().add(card(type, content, i));
        }
        assignmentsWrapper.getChildren().add(row);
        return assignmentsWrapper;
    }

    private VBox card(String type, ArrayList<String> content, int idx) {
        VBox card = new VBox();

        ImageView cardBanner = new ImageView();
        Image image = new Image(getClass().getResource("../../../../../resources/com/lms/images/assignments-icon.png").toExternalForm());
        cardBanner.setImage(image);

        VBox cardIDVBox = new VBox();
        Text cardID = new Text(content.get(idx));
        cardIDVBox.getChildren().add(cardID);

        card.getChildren().add(cardBanner);
        card.getChildren().add(cardIDVBox);

        // styling
        card.setSpacing(5);
        card.setAlignment(Pos.TOP_CENTER);
        card.setMinWidth(300);
        card.setMinHeight(180);
        card.setStyle("-fx-border-radius: 30; -fx-background-color: #FFFFFF; -fx-background-radius: 30");
        card.setCursor(Cursor.HAND);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(10);       // Increase the radius for a larger shadow
        dropShadow.setSpread(0.2);      // Optional: control how concentrated the shadow is
        dropShadow.setOffsetX(0);       // Zero offset makes it centered
        dropShadow.setOffsetY(0);       // Zero offset makes it centered
        dropShadow.setColor(Color.BLACK); // Set the shadow color

        card.setEffect(dropShadow);

        card.setOnMouseEntered(e -> {
            card.setScaleX(1.02);
            card.setScaleY(1.02);
        });
        card.setOnMouseExited(e -> {
            card.setScaleX(1.0);
            card.setScaleY(1.0);
        });

        cardBanner.setFitWidth(80);
        cardBanner.setFitHeight(120);
        cardIDVBox.setStyle("-fx-border-radius: 30; -fx-background-color: #2F92BC; -fx-background-radius: 30");
        cardIDVBox.setAlignment(Pos.CENTER);
        cardIDVBox.setPrefWidth(Double.MAX_VALUE);
        cardIDVBox.setPrefHeight(75);

        cardID.setFont(Font.font("AppleGothic", 18));
        card.setOnMouseClicked(e -> {
            switch (type) {
                case "assignment" -> {
                    AppSession.getInstance().setSelectedAssignment(extractId(content.get(idx)));
                    AppSession.getInstance().isSubmissionFromAllPage(false);
                    SceneManager.loadCenterView("assignmentSubmission", "resources/com/lms/views/studentSide/AssignmentSubmission.fxml");
                    SceneManager.setCenterView("assignmentSubmission");
                }
                case "resource" -> {
                    AppSession.getInstance().setSelectedResources(extractId(content.get(idx)));
                    AppSession.getInstance().isSubmissionFromAllPage(false);
                    SceneManager.loadCenterView("resourceSubmission", "resources/com/lms/views/studentSide/ResourceSubmission.fxml");
                    SceneManager.setCenterView("resourceSubmission");
                }
                case "quiz" -> {
                    AppSession.getInstance().setSelectedQuiz(extractId(content.get(idx)));
                    AppSession.getInstance().isSubmissionFromAllPage(false);
                    SceneManager.loadCenterView("doQuiz", "resources/com/lms/views/studentSide/DoQuiz.fxml");
                    SceneManager.setCenterView("doQuiz");
                }
            }
        });
        return card;
    }

    private String extractId(String longId) {
        return longId.substring(0, longId.indexOf(" "));
    }
}
