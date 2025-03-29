package main.java.com.lms.controllers.teacherSide;

import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.AppSession;
import main.SceneManager;
import main.java.com.lms.managers.studentSide.QuizzesManager;

import java.util.List;
import java.util.Map;

public class QuizViewController {
    private final QuizzesManager quizManager = new QuizzesManager();
    @FXML
    private ImageView backButton;
    @FXML
    private Text quizId;
    @FXML
    private Text quizTitle;
    @FXML
    private TextArea quizDescription;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;
    @FXML
    private VBox questionsWrapper;
    @FXML
    private TableView<Map<String, String>> studentTable;
    @FXML
    private TableColumn<Map<String, String>, String> idColumn;
    @FXML
    private TableColumn<Map<String, String>, String> nameColumn;
    @FXML
    private TableColumn<Map<String, String>, String> scoreColumn;

    private int questionNum;

    public void initialize() {

        backButton.setOnMouseClicked(event -> {
            SceneManager.loadCenterView("teacherClassroomContents", "resources/com/lms/views/teacherSide/ClassroomContents.fxml");
            SceneManager.setCenterView("teacherClassroomContents");
        });

        quizId.setText(AppSession.getInstance().getSelectedQuiz());
        quizTitle.setText(quizManager.getQuizTitle());
        quizDescription.setText(quizManager.getQuizDescription());

        idColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().get("id")));
        nameColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().get("name")));
        scoreColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().get("score")));

        studentTable.getItems().addAll(quizManager.getAllStudentsAndScore());

        editButton.setOnMouseClicked(event -> {
            SceneManager.loadCenterView("editQuiz", "resources/com/lms/views/teacherSide/EditQuiz.fxml");
            SceneManager.setCenterView("editQuiz");
        });

        deleteButton.setOnMouseClicked(event -> {
            // TODO: connect to delete
            SceneManager.loadCenterView("teacherClassroomContents", "resources/com/lms/views/teacherSide/ClassroomContents.fxml");
            SceneManager.setCenterView("teacherClassroomContents");
        });
    }

    private VBox createQuestionCard(String questionText, List<String> choices) {
        // Outer VBox (questionCard)
        VBox questionCard = new VBox();
        questionCard.setPrefSize(791, 375);
        questionCard.setMaxWidth(Region.USE_PREF_SIZE);
        questionCard.setMaxHeight(Region.USE_PREF_SIZE);
        questionCard.setStyle("-fx-background-color: white; -fx-border-radius: 30; -fx-background-radius: 30;");
        questionCard.setPadding(new Insets(20));

        // ----------------- Question Section -----------------
        VBox questionSection = new VBox();
        questionSection.setPrefSize(751, 90);
        questionSection.setAlignment(Pos.TOP_CENTER);
        questionSection.setPadding(new Insets(10));

        Label questionLabel = new Label("Question " + questionNum);
        questionLabel.setStyle("-fx-font-size: 19px; -fx-font-family: AppleGothic");

        Label questionTextLabel = new Label(questionText);
        questionTextLabel.setWrapText(true);
        questionTextLabel.setPrefWidth(731);

        questionSection.getChildren().addAll(questionLabel, questionTextLabel);

        // ----------------- Choices Section -----------------
        VBox choicesSection = new VBox();
        choicesSection.setPrefSize(751, 200);
        choicesSection.setAlignment(Pos.TOP_CENTER);
        choicesSection.setPadding(new Insets(20));
        choicesSection.setSpacing(10);

        Label choicesLabel = new Label("Choices");
        choicesLabel.setStyle("-fx-font-size: 19px; -fx-font-family: AppleGothic");

        VBox choicesWrapper = new VBox();
        choicesWrapper.setSpacing(10);
        choicesWrapper.setPadding(new Insets(10));

        for (String choiceText : choices) {
            HBox choiceBox = new HBox();
            choiceBox.setPrefSize(691, 50);
            choiceBox.setAlignment(Pos.CENTER_LEFT);
            choiceBox.setStyle("-fx-background-color: white; -fx-border-color: #cccccc; -fx-border-radius: 10; -fx-padding: 10;");
            choiceBox.setOnMouseClicked(event -> {
                // Reset colors for all choices
                for (Node node : choicesWrapper.getChildren()) {
                    node.setStyle("-fx-background-color: white; -fx-border-color: #cccccc; -fx-border-radius: 10; -fx-padding: 10;");
                }
                // Highlight selected choice
                choiceBox.setStyle("-fx-background-color: #f4f6fa; -fx-border-color: #cccccc; -fx-border-radius: 10; -fx-padding: 10;");
            });

            Label choiceLabel = new Label(choiceText);
            choiceLabel.setWrapText(true);
            choiceLabel.setPrefWidth(650);

            choiceBox.getChildren().add(choiceLabel);
            choicesWrapper.getChildren().add(choiceBox);
        }

        choicesSection.getChildren().addAll(choicesLabel, choicesWrapper);

        // ----------------- Add Sections to Main VBox -----------------
        questionCard.getChildren().addAll(questionSection, choicesSection);

        questionNum++;
        return questionCard;
    }
}