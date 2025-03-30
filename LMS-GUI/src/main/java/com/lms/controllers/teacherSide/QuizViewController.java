package main.java.com.lms.controllers.teacherSide;

import entities.Teacher;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import main.AppSession;
import main.SceneManager;
import main.java.com.lms.managers.studentSide.QuizzesManager;
import main.java.com.lms.managers.teacherSide.TeacherQuizManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QuizViewController {
    private final TeacherQuizManager quizManager = new TeacherQuizManager(AppSession.getInstance().getSelectedClassroom());
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
        editButton.setCursor(Cursor.HAND);
        deleteButton.setCursor(Cursor.HAND);
        questionNum = 1;
        questionsWrapper.setAlignment(Pos.CENTER);
        backButton.setOnMouseClicked(event -> {
            AppSession.getInstance().setSelectedQuiz(null);
            SceneManager.loadCenterView("teacherClassroomContents", "resources/com/lms/views/teacherSide/ClassroomContents.fxml");
            SceneManager.setCenterView("teacherClassroomContents");
        });

        quizId.setText(AppSession.getInstance().getSelectedQuiz());
        quizTitle.setText(quizManager.getQuizTitle());
        quizDescription.setText(quizManager.getQuizDescription());

        idColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().get("id")));
        nameColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().get("name")));
        scoreColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().get("score")));

        System.out.println(quizManager.getAllStudentsAndScore());
        studentTable.setItems(FXCollections.observableArrayList(quizManager.getAllStudentsAndScore()));
        System.out.println("table content:"  + studentTable.getItems());
        studentTable.setMinHeight(400);
        studentTable.refresh();

        ArrayList<Map<String, Object>> questionsAndChoices = quizManager.getQuestionsAndChoices();

        for (int i = 0; i < questionsAndChoices.size(); i++) {
            String title = (String) questionsAndChoices.get(i).get("title");

            // Extract choice texts into a list
            List<Map<String, Object>> choicesList = (List<Map<String, Object>>) questionsAndChoices.get(i).get("choices");

            questionsWrapper.getChildren().add(createQuestionCard(title, choicesList));
        }

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

    private VBox createQuestionCard(String questionText, List<Map<String, Object>> choices) {
        System.out.println("Choices for question: "+ questionText + " is \n" + choices);
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
            choiceBox.setPrefSize(691, 50);
            choiceBox.setAlignment(Pos.CENTER_LEFT);
            choiceBox.setPadding(new Insets(10));

            Label choiceLabel = new Label((String) choice.get("choice_text"));
            choiceLabel.setWrapText(true);
            choiceLabel.setPrefWidth(650);

            // Apply blueish background ONLY for correct answers
            if (choice.get("isCorrect").equals(1)) {
                choiceBox.setStyle("-fx-background-color: #2f92bc; -fx-border-color: #cccccc; -fx-border-radius: 10; -fx-background-radius: 10");
            } else {
                choiceBox.setStyle("-fx-background-color: white; -fx-border-color: #cccccc; -fx-border-radius: 10; -fx-background-radius: 10");
            }

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