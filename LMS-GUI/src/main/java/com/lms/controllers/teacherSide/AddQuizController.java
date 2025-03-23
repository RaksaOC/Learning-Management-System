package main.java.com.lms.controllers.teacherSide;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import main.AppSession;
import main.java.com.lms.managers.teacherSide.QuizManager;

import java.util.ArrayList;

public class AddQuizController {
    private int numOfQuestions = 1;

    @FXML
    private ImageView backButton;
    @FXML
    private TextField title;
    @FXML
    private TextArea description;
    @FXML
    private VBox questionsWrapper;
    @FXML
    private VBox questionCard;
    @FXML
    private TextArea question;
    @FXML
    private TextField choice1;
    @FXML
    private TextField choice2;
    @FXML
    private TextField choice3;
    @FXML
    private TextField choice4;
    @FXML
    private TextArea correct;
    @FXML
    private Button add;
    @FXML
    private Button finish;

    public void initialize() {
        questionsWrapper.getChildren().add(createQuestionCard());
        add.setOnMouseClicked(event -> {
            numOfQuestions++;
            questionsWrapper.getChildren().add(createQuestionCard());
        });

        finish.setOnMouseClicked(event -> {
            QuizManager quizManager = new QuizManager(AppSession.getInstance().getSelectedClassroom());
        });
    }

    private VBox createQuestionCard() {
        // Outer VBox (questionCard)
        VBox questionCard = new VBox();
        questionCard.setId("questionCard" + numOfQuestions);
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

        Label questionLabel = new Label("Question " + numOfQuestions);
        questionLabel.setStyle("-fx-font-size: 19px; -fx-font-family: AppleGothic");

        TextArea questionTextArea = new TextArea();
        questionTextArea.setPrefSize(731, 39);
        VBox.setMargin(questionTextArea, new Insets(20, 0, 0, 0));

        questionSection.getChildren().addAll(questionLabel, questionTextArea);

        // ----------------- Choices Section -----------------
        VBox choicesSection = new VBox();
        choicesSection.setPrefSize(100, 200);
        choicesSection.setAlignment(Pos.TOP_CENTER);
        choicesSection.setPadding(new Insets(20));

        Label choicesLabel = new Label("Choices");
        choicesLabel.setStyle("-fx-font-size: 19px; -fx-font-family: AppleGothic");

        VBox choicesWrapper = new VBox();
        choicesWrapper.setPrefSize(751, 171);
        choicesWrapper.setSpacing(10);
        choicesWrapper.setPadding(new Insets(10));

        HBox choiceRow1 = new HBox(20);
        choiceRow1.setPrefSize(691, 51);
        TextField choice1 = new TextField();
        choice1.setPrefSize(281, 57);
        HBox.setHgrow(choice1, Priority.ALWAYS);
        TextField choice2 = new TextField();
        choice2.setPrefSize(285, 59);
        HBox.setHgrow(choice2, Priority.ALWAYS);
        choiceRow1.getChildren().addAll(choice1, choice2);

        HBox choiceRow2 = new HBox(20);
        choiceRow2.setPrefSize(691, 51);
        TextField choice3 = new TextField();
        choice3.setPrefSize(281, 57);
        HBox.setHgrow(choice3, Priority.ALWAYS);
        TextField choice4 = new TextField();
        choice4.setPrefSize(285, 59);
        HBox.setHgrow(choice4, Priority.ALWAYS);
        choiceRow2.getChildren().addAll(choice3, choice4);

        choicesWrapper.getChildren().addAll(choiceRow1, choiceRow2);
        choicesSection.getChildren().addAll(choicesLabel, choicesWrapper);

        // ----------------- Correct Answer Section -----------------
        VBox correctAnswerSection = new VBox();
        correctAnswerSection.setPrefSize(751, 90);
        correctAnswerSection.setAlignment(Pos.TOP_CENTER);
        correctAnswerSection.setPadding(new Insets(10));

        Label correctLabel = new Label("Correct Answer");
        correctLabel.setStyle("-fx-font-size: 19px; font-family: AppleGothic");

        TextArea correctTextArea = new TextArea();
        correctTextArea.setPrefSize(731, 39);
        VBox.setMargin(correctTextArea, new Insets(20, 0, 0, 0));

        correctAnswerSection.getChildren().addAll(correctLabel, correctTextArea);

        // ----------------- Add Sections to Main VBox -----------------
        questionCard.getChildren().addAll(questionSection, choicesSection, correctAnswerSection);

        return questionCard;
    }

}