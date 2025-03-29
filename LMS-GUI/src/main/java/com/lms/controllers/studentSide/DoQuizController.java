package main.java.com.lms.controllers.studentSide;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.AppSession;
import main.DatabaseConnection;
import main.SceneManager;
import main.java.com.lms.managers.studentSide.QuizzesManager;

import java.sql.Connection;
import java.util.List;

public class DoQuizController {
    private Connection conn = DatabaseConnection.getInstance().getConnection();

    @FXML
    private ImageView backButton;
    @FXML
    private Text title;
    @FXML
    private Text description;
    @FXML
    private VBox questionsWrapper;
    @FXML
    private Button finish;

    private int questionNum;

    private int numOfQuestions;

    public void initialize() {
        backButton.setOnMouseClicked(event -> {
            if(!AppSession.getInstance().getIsSubmissionFromAllPage()){
                AppSession.getInstance().setSelectedQuiz(null);
                AppSession.getInstance().setSelectedClassroom(null);
                SceneManager.loadCenterView("studentClassroomContent", "resources/com/lms/views/studentSide/ClassroomContents.fxml");
                SceneManager.setCenterView("studentClassroomContent");

            }else {
                AppSession.getInstance().setSelectedQuiz(null);
                AppSession.getInstance().setSelectedClassroom(null);
                loadDynamicComponentToCenterView(
                        "studentQuizzes",
                        "studentQuizCardsWrapper",
                        "resources/com/lms/views/studentSide/Quizzes.fxml",
                        "resources/com/lms/views/studentSide/components/QuizCardsWrapper.fxml"
                );
                SceneManager.setCenterView("studentQuizzes");
            }
        });
    }

    private void createAllQuestions() {
        QuizzesManager studentQuizzesManager = new QuizzesManager();
//        ArrayList<Map<String, Object>> allQuestions =  studentQuizzesManager.displayChosenQuiz(quizIndexToDo, studentID);
        finish.setOnMouseClicked(event -> {
//            studentQuizzesManager.submitAndCheckAnswer();
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

    private void loadDynamicComponentToCenterView(String centerViewName, String dynamicComponentName, String centerViewFilePath, String dynamicComponentFilePath) {
        SceneManager.loadCenterView(centerViewName, centerViewFilePath);
        SceneManager.loadComponent(dynamicComponentName, dynamicComponentFilePath);

        VBox center = (VBox) SceneManager.getCenterView(centerViewName);
        center.getChildren().add(SceneManager.getComponent(dynamicComponentName));
    }
}