package main.java.com.lms.controllers.teacherSide;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
import main.java.com.lms.managers.teacherSide.AssignmentManager;
import main.java.com.lms.managers.teacherSide.ClassroomsManger;
import main.java.com.lms.managers.teacherSide.TeacherQuizManager;
import main.java.com.lms.managers.teacherSide.ResourceManager;

import java.util.ArrayList;
import java.util.Map;

public class ClassroomContentsController {
    private TeacherQuizManager quizzesManager;
    private AssignmentManager assignmentManager;
    private ResourceManager resourcesManager;
    @FXML
    private ScrollPane assignmentsScrollPane;
    @FXML
    private Button addAssignmentButton;
    @FXML
    private Button addResourceButton;
    @FXML
    private Button addQuizButton;
    @FXML
    private ScrollPane resourcesScrollPane;
    @FXML
    private ScrollPane quizzesScrollPane;
    @FXML
    private TableView<Map<String, String>> studentsTable;
    @FXML
    private TableColumn<Map<String, String>, String> studentIdColumn;
    @FXML
    private TableColumn<Map<String, String>, String> studentNameColumn;

    @FXML
    private ImageView backButton;

    private ArrayList<String> assignmentIdsAndName;
    private ArrayList<String> resourceIdsAndName;
    private ArrayList<String> quizIdsAndName;

    public void initialize() {
        addAssignmentButton.setOnMouseClicked(event -> {
            SceneManager.loadCenterView("addAssignment", "resources/com/lms/views/teacherSide/AddAssignment.fxml");
            SceneManager.setCenterView("addAssignment");
        });
        addResourceButton.setOnMouseClicked(event -> {
            SceneManager.loadCenterView("addResource", "resources/com/lms/views/teacherSide/AddResource.fxml");
            SceneManager.setCenterView("addResource");
        });
        addQuizButton.setOnMouseClicked(event -> {
            SceneManager.loadCenterView("addQuiz", "resources/com/lms/views/teacherSide/AddQuiz.fxml");
            SceneManager.setCenterView("addQuiz");
        });
        initContentList();
        initAssignmentsScrollPane();
        initResourcesScrollPane();
        initQuizzesScrollPane();
        backButton.setCursor(Cursor.HAND);
        backButton.setOnMouseClicked(event -> {
            SceneManager.setCenterView("teacherClassrooms");
            AppSession.getInstance().setSelectedClassroom(null);
        });

        ClassroomsManger classroomsManger = new ClassroomsManger();
        ObservableList<Map<String, String>> studentsData = FXCollections.observableArrayList(classroomsManger.getAllStudentsDetailInClassroom());

        studentIdColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("id")));
        studentNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("name")));

        studentsTable.setItems(studentsData);
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
        resourcesScrollPane.setContent(wrapper( "resource",resourceIdsAndName));
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
        assignmentManager = new AssignmentManager(AppSession.getInstance().getSelectedClassroom());
        resourcesManager = new ResourceManager(AppSession.getInstance().getSelectedClassroom());
        quizzesManager = new TeacherQuizManager(AppSession.getInstance().getSelectedClassroom());

        assignmentIdsAndName = new ArrayList<>();
        resourceIdsAndName = new ArrayList<>();
        quizIdsAndName = new ArrayList<>();

        assignmentIdsAndName.addAll(assignmentManager.getClassroomAssignmentsSql());
        resourceIdsAndName.addAll(resourcesManager.getClassroomMaterialsSql());
        quizIdsAndName.addAll(quizzesManager.getClassroomQuizzesSql());
    }

    private VBox wrapper(String type, ArrayList<String> content) {
        VBox assignmentsWrapper = new VBox(10);
        assignmentsWrapper.setStyle("-fx-padding: 20; -fx-background-color: #f4f6fa;");

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
                case "assignment":
                    AppSession.getInstance().setSelectedAssignment(extractId(content.get(idx)));
                    System.out.println("Setting selected assignment ID: " + AppSession.getInstance().getSelectedAssignment());
                    System.out.println(extractId(content.get(idx)) + " has been selected");

                    SceneManager.loadCenterView("assignmentView", "resources/com/lms/views/teacherSide/AssignmentView.fxml");
                    SceneManager.setCenterView("assignmentView");
                    break;
                case "resource":
                    AppSession.getInstance().setSelectedResources(extractId(content.get(idx)));

                    SceneManager.loadCenterView("resourceView", "resources/com/lms/views/teacherSide/ResourceView.fxml");
                    SceneManager.setCenterView("resourceView");
                    break;
                case "quiz":
                    AppSession.getInstance().setSelectedQuiz(extractId(content.get(idx)));

                    SceneManager.loadCenterView("quizView", "resources/com/lms/views/teacherSide/QuizView.fxml");
                    SceneManager.setCenterView("quizView");
                    break;
            }
        });
        return card;
    }

    private String extractId(String longId) {
        return longId.substring(0, longId.indexOf(" "));
    }
}
