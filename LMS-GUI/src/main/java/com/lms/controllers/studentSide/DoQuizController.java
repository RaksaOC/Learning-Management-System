package main.java.com.lms.controllers.studentSide;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import main.AppSession;
import main.DatabaseConnection;
import main.SceneManager;
import main.java.com.lms.managers.studentSide.QuizzesManager;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DoQuizController {
    private Connection conn = DatabaseConnection.getInstance().getConnection();
    private QuizzesManager quizzesManager = new QuizzesManager();
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
    @FXML
    private VBox scoreBox;

    private int questionNum;

    private int score;

    public void initialize() {
        double percent = quizzesManager.getPrevScore();
        Text scoreTxt = new Text("High Score: " + percent + "%");
        scoreTxt.setFont(Font.font("AppleGothic", 24));
        scoreBox.getChildren().add(scoreTxt);

        questionNum = 1;
        score = 0;
        scoreBox.setAlignment(Pos.CENTER);
        title.setText(quizzesManager.getQuizTitle());
        description.setText(quizzesManager.getQuizDescription());
        backButton.setOnMouseClicked(event -> {
            if (!AppSession.getInstance().getIsSubmissionFromAllPage()) {
                AppSession.getInstance().setSelectedQuiz(null);
                SceneManager.loadCenterView("studentClassroomContent", "resources/com/lms/views/studentSide/ClassroomContents.fxml");
                SceneManager.setCenterView("studentClassroomContent");
            } else {
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

        ArrayList<Map<String, Object>> questionsAndChoices = quizzesManager.getQuestionsAndChoices();
        for (int i = 0; i < questionsAndChoices.size(); i++) {
            List<Map<String, Object>> choicesList = (List<Map<String, Object>>) questionsAndChoices.get(i).get("choices");
            questionsWrapper.getChildren().add(createQuestionCard((String) questionsAndChoices.get(i).get("title"), choicesList));
        }

        finish.setCursor(Cursor.HAND);
        finish.setOnMouseClicked(event -> {
            scoreBox.getChildren().clear();

            double percentage = ((double) score / questionsAndChoices.size()) * 100;

            if(quizzesManager.getPrevScore() < percentage) {
                quizzesManager.manageSubmitQuiz(percentage);
            }

            Text scoreText = new Text("You got: " + percentage + "%");
            scoreText.setFont(Font.font("AppleGothic", 24));

            scoreBox.getChildren().add(scoreText);
            questionsWrapper.setDisable(true);
            finish.setDisable(true);
        });

    }

    private VBox createQuestionCard(String questionText, List<Map<String, Object>> choices) {
        System.out.println("Choices for question: " + questionText + " is \n" + choices);
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
        questionSection.setAlignment(Pos.CENTER);
        questionSection.setPadding(new Insets(10));

        Label questionLabel = new Label("Question " + questionNum);
        questionLabel.setStyle("-fx-font-size: 19px; -fx-font-family: AppleGothic");

        Label questionTextLabel = new Label(questionText);
        questionTextLabel.setPrefWidth(731);
        questionTextLabel.setAlignment(Pos.CENTER);
        questionTextLabel.setPadding(new Insets(30, 0, 0, 0));
        questionTextLabel.setFont(Font.font("AppleGothic", 20));

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

        for (Map<String, Object> choice : choices) {
            HBox choiceBox = new HBox();
            choiceBox.setCursor(Cursor.HAND);
            choiceBox.setPrefSize(691, 50);
            choiceBox.setAlignment(Pos.CENTER_LEFT);
            choiceBox.setPadding(new Insets(10));

            Label choiceLabel = new Label((String) choice.get("choice_text"));
            choiceLabel.setWrapText(true);
            choiceLabel.setPrefWidth(650);

            // Apply blueish background ONLY for correct answers
            choiceBox.setStyle("-fx-background-color: white; -fx-border-color: #cccccc; -fx-border-radius: 10; -fx-background-radius: 10");
            choiceBox.setOnMouseClicked(event -> {
                choiceBox.setStyle("-fx-background-color: #2f92bc; -fx-border-color: #cccccc; -fx-border-radius: 10; -fx-background-radius: 10");
                if (choice.get("isCorrect").equals(1)) {
                    score++;
                }
            });


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