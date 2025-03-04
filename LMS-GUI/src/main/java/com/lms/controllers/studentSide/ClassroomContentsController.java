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
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import main.AppSession;
import main.SceneManager;
import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ClassroomContentsController {

    @FXML
    private ScrollPane assignmentsScrollPane;
    @FXML
    private ScrollPane resourcesScrollPane;
    @FXML
    private ScrollPane quizzesScrollPane;
    @FXML
    private ImageView backButton;

    private ArrayList<String> assignmentIds = new ArrayList<>();

    public void initialize() {
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
        assignmentsScrollPane.setContent(assignmentsWrapper());
        assignmentsScrollPane.setStyle("-fx-background-color: transparent;");
//        assignmentsScrollPane.setStyle("-fx-background-color: white; -fx-background-radius: 30; -fx-border-radius: 30");
        assignmentsScrollPane.setPadding(new Insets(5, 10, 20, 10));
    }

    private void initResourcesScrollPane() {
        resourcesScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        resourcesScrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        resourcesScrollPane.setFitToWidth(true);
        resourcesScrollPane.setContent(assignmentsWrapper());
        resourcesScrollPane.setStyle("-fx-background-color: transparent;");
//        resourcesScrollPane.setStyle("-fx-background-color: white; -fx-background-radius: 30; -fx-border-radius: 30");
        resourcesScrollPane.setPadding(new Insets(5, 10, 20, 10));
    }

    private void initQuizzesScrollPane() {
        quizzesScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        quizzesScrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        quizzesScrollPane.setFitToWidth(true);
        quizzesScrollPane.setContent(assignmentsWrapper());
        quizzesScrollPane.setStyle("-fx-background-color: transparent;");
//        quizzesScrollPane.setStyle("-fx-background-color: white; -fx-background-radius: 30; -fx-border-radius: 30");
        quizzesScrollPane.setPadding(new Insets(5, 10, 20, 10));
    }

    private VBox assignmentsWrapper() {
        System.out.println(assignmentIds);
        VBox assignmentsWrapper = new VBox(10);
        assignmentsWrapper.setStyle("-fx-padding: 20; -fx-background-color: #f4f6fa;");

        AppSession session = AppSession.getInstance();
        String classId = session.getSelectedClassroom();

        // Fetch assignments from JSON (should be handled by a manager class ideally)
        JSONObject selectedClassroom = new JSONObject();
        try {
            String content = new String(Files.readAllBytes(Paths.get("shared/data/classroom.json")));
            JSONArray allClassrooms = new JSONArray(content);
            for (int i = 0; i < allClassrooms.length(); i++) {
                if (allClassrooms.getJSONObject(i).getString("id").equals(classId)) {
                    selectedClassroom = allClassrooms.getJSONObject(i);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JSONArray assignments = selectedClassroom.optJSONArray("assignments");
        if (assignments == null) return assignmentsWrapper;


        for (int i = 0; i < assignments.length(); i++) {
            assignmentIds.add(assignments.getString(i));
        }

        HBox row = new HBox(10);
        for (int i = 0; i < assignmentIds.size(); i++) {
            row.getChildren().add(assignmentCard(i));
        }
        assignmentsWrapper.getChildren().add(row);
        return assignmentsWrapper;
    }

    private VBox assignmentCard(int idx) {
        VBox assignmentCard = new VBox();

        ImageView assignmentCardBanner = new ImageView();
        Image image = new Image(getClass().getResource("../../../../../resources/com/lms/images/assignments-icon.png").toExternalForm());
        assignmentCardBanner.setImage(image);


        VBox assignmentIDVBox = new VBox();
        Text assignmentID = new Text(assignmentIds.get(idx));
        assignmentIDVBox.getChildren().add(assignmentID);

        assignmentCard.getChildren().add(assignmentCardBanner);
        assignmentCard.getChildren().add(assignmentIDVBox);


        // styling
        assignmentCard.setSpacing(5);
        assignmentCard.setAlignment(Pos.TOP_CENTER);
        assignmentCard.setMinWidth(300);
        assignmentCard.setMinHeight(180);
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

//        Rectangle clip = new Rectangle();
//        clip.setArcHeight(30);
//        clip.setArcWidth(30);
//        assignmentCardBanner.setClip(clip);

        assignmentCardBanner.setFitWidth(80);
        assignmentCardBanner.setFitHeight(120);
        assignmentIDVBox.setStyle("-fx-border-radius: 30; -fx-background-color: #2F92BC; -fx-background-radius: 30");
        assignmentIDVBox.setAlignment(Pos.CENTER);
        assignmentIDVBox.setPrefWidth(Double.MAX_VALUE);
        assignmentIDVBox.setPrefHeight(75);

        assignmentID.setFont(Font.font("AppleGothic", 18));
        assignmentCard.setOnMouseClicked(e -> {
            SceneManager.loadCenterView("assignmentSubmission", "resources/com/lms/views/studentSide/AssignmentSubmission.fxml");
            SceneManager.setCenterView("assignmentSubmission");
            AppSession.getInstance().setSelectedAssignment(assignmentIds.get(idx));
            AppSession.getInstance().isAssignmentSubmissionFromAssignmentsPage(false);

            System.out.println(assignmentIds.get(idx) + "has been selected");
        });
        return assignmentCard;
    }
}
