package main.java.com.lms.controllers.teacherSide;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
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
import main.SceneManager;
import main.java.com.lms.managers.studentSide.QuizzesManager;
import main.java.com.lms.managers.teacherSide.TeacherQuizManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EditQuizController {
    private final TeacherQuizManager quizzesManager = new TeacherQuizManager(AppSession.getInstance().getSelectedClassroom());
    @FXML
    private ImageView backButton;
    private int numOfQuestions;
    @FXML
    private TextField curTitle;
    @FXML
    private TextArea curDescription;
    @FXML
    private TextField newTitle;
    @FXML
    private TextArea newDescription;
    @FXML
    private Button add;
    @FXML
    private VBox questionsWrapper;
    @FXML
    private Button finish;

    public void initialize() {
        add.setCursor(Cursor.HAND);
        finish.setCursor(Cursor.HAND);
        backButton.setCursor(Cursor.HAND);

        curTitle.setText(quizzesManager.getQuizTitle());
        curDescription.setText(quizzesManager.getQuizDescription());
        newTitle.setText(quizzesManager.getQuizTitle());
        newDescription.setText(quizzesManager.getQuizDescription());
        backButton.setOnMouseClicked(event -> {
            SceneManager.loadCenterView("quizView", "resources/com/lms/views/teacherSide/QuizView.fxml");
            SceneManager.setCenterView("quizView");
        });
        numOfQuestions = 0;
        ArrayList<Map<String, Object>> questionsAndChoices = quizzesManager.getQuestionsAndChoices();

        for (int i = 0; i < questionsAndChoices.size(); i++) {
            String title = (String) questionsAndChoices.get(i).get("title");
            List<Map<String, Object>> choicesList = (List<Map<String, Object>>) questionsAndChoices.get(i).get("choices");
            questionsWrapper.getChildren().add(createExistingQuestionCard(title, choicesList));
        }

        add.setOnMouseClicked(event -> {
            numOfQuestions++;
            questionsWrapper.getChildren().add(createEmptyQuestionCard());
        });

        finish.setOnMouseClicked(event -> {
            ArrayList<Map<String, Object>> questionsList = getQuestionsList();
            quizzesManager.manageEditQuizSql(newTitle.getText(),newDescription.getText(), questionsList);

            AppSession.getInstance().setSelectedQuiz(null);
            SceneManager.loadCenterView("teacherClassroomContent", "resources/com/lms/views/teacherSide/ClassroomContents.fxml");
            SceneManager.setCenterView("teacherClassroomContent");
        });

    }

    private VBox createExistingQuestionCard(String questionTitle, List<Map<String, Object>> choices) {
        numOfQuestions++;
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
        questionTextArea.setText(questionTitle);
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
        choice1.setText((String)choices.get(0).get("choice_text"));
        choice1.setPrefSize(281, 57);
        HBox.setHgrow(choice1, Priority.ALWAYS);
        TextField choice2 = new TextField();
        choice2.setText((String)choices.get(1).get("choice_text"));
        choice2.setPrefSize(285, 59);
        HBox.setHgrow(choice2, Priority.ALWAYS);
        choiceRow1.getChildren().addAll(choice1, choice2);

        HBox choiceRow2 = new HBox(20);
        choiceRow2.setPrefSize(691, 51);
        TextField choice3 = new TextField();
        choice3.setPrefSize(281, 57);
        choice3.setText((String)choices.get(2).get("choice_text"));
        HBox.setHgrow(choice3, Priority.ALWAYS);
        TextField choice4 = new TextField();
        choice4.setText((String)choices.get(3).get("choice_text"));
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
        String correctText = "";
        for(int i = 0; i < choices.size(); i++) {
            if(choices.get(i).get("isCorrect").equals(1)) correctText = (String) choices.get(i).get("choice_text");
        }
        correctTextArea.setText(correctText);
        VBox.setMargin(correctTextArea, new Insets(20, 0, 0, 0));

        correctAnswerSection.getChildren().addAll(correctLabel, correctTextArea);

        // ----------------- Add Sections to Main VBox -----------------
        questionCard.getChildren().addAll(questionSection, choicesSection, correctAnswerSection);
        return questionCard;
    }

    private VBox createEmptyQuestionCard() {
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

    private ArrayList<Map<String, Object>> getQuestionsList() {
        ArrayList<Map<String, Object>> questionList = new ArrayList<>();
        for (Node node : questionsWrapper.getChildren()) {
            if (node instanceof VBox questionCard) {
                Map<String, Object> questionData = new HashMap<>();
                ArrayList<Map<String, Object>> choices = new ArrayList<>();

                // Extract question text
                VBox questionSection = (VBox) questionCard.getChildren().get(0);
                TextArea questionTextArea = (TextArea) questionSection.getChildren().get(1);
                questionData.put("title", questionTextArea.getText());

                // Extract choices
                VBox choicesSection = (VBox) questionCard.getChildren().get(1);
                VBox choicesWrapper = (VBox) choicesSection.getChildren().get(1);

                HBox choiceRow1 = (HBox) choicesWrapper.getChildren().get(0);
                TextField choice1 = (TextField) choiceRow1.getChildren().get(0);
                TextField choice2 = (TextField) choiceRow1.getChildren().get(1);

                HBox choiceRow2 = (HBox) choicesWrapper.getChildren().get(1);
                TextField choice3 = (TextField) choiceRow2.getChildren().get(0);
                TextField choice4 = (TextField) choiceRow2.getChildren().get(1);

                choices.add(createChoice(choice1));
                choices.add(createChoice(choice2));
                choices.add(createChoice(choice3));
                choices.add(createChoice(choice4));

                questionData.put("choices", choices);

                // Extract correct answer
                VBox correctAnswerSection = (VBox) questionCard.getChildren().get(2);
                TextArea correctTextArea = (TextArea) correctAnswerSection.getChildren().get(1);
                String correctAnswer = correctTextArea.getText();

                // Mark the correct choice
                for (Map<String, Object> choice : choices) {
                    if (choice.get("choice_text").equals(correctAnswer)) {
                        choice.put("isCorrect", true);
                    }
                }

                questionList.add(questionData);
            }
        }
        return questionList;
    }

    private Map<String, Object> createChoice(TextField choiceField) {
        Map<String, Object> choice = new HashMap<>();
        choice.put("choice_text", choiceField.getText());
        choice.put("isCorrect", false);
        return choice;
    }
}

