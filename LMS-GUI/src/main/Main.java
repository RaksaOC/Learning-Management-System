package main;

import entities.Student;
import main.java.com.lms.managers.studentSide.StudentQuizzesManager;
import main.java.com.lms.managers.teacherSide.TeacherQuizManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection.getInstance().getConnection();
//        SceneManager.launch(SceneManager.class, args);
//        StudentQuizzesManager k= new StudentQuizzesManager();
//        ArrayList<Integer> answerList= new ArrayList<>();
//        answerList.add(1);
//        answerList.add(4);
//        answerList.add(3);
//        answerList.add(4);
//        System.out.println(k.manageDisplayQuizSql("S000001"));
//        System.out.println(k.displayChosenQuiz(1,"S000001"));
//        k.submitAndCheckAnswer(k.displayChosenQuiz(1,"S000001"), "S000001", 1,answerList);








































        ArrayList<Map<String, Object>> choices = getMaps();
        Map<String, Object> question1= new HashMap<>();
        question1.put("title", "how long is your sausage");
        question1.put("choices", choices);
        Map<String, Object> question2= new HashMap<>();
        question2.put("title", "how long is your hotdog");
        question2.put("choices", choices);
        Map<String, Object> question3= new HashMap<>();
        question3.put("title", "how long is your bacon");
        question3.put("choices", choices);
        Map<String, Object> question4= new HashMap<>();
        question4.put("title", "how long is your bottle");
        question4.put("choices", choices);
        ArrayList<Map<String, Object>> quizList=new ArrayList<>();
        quizList.add(question1);
        quizList.add(question2);
        quizList.add(question3);
        quizList.add(question4);
        TeacherQuizManager k= new TeacherQuizManager("GEN10-CS-SE-G1-OOP");
        k.manageEditQuiz(quizList, "Q0001", "bloh", "bloh");
    }

    private static ArrayList<Map<String, Object>> getMaps() {
        Map<String, Object> choice1= new HashMap<>();
        choice1.put("choice_text", "1cm");
        choice1.put("isCorrect", false);
        Map<String, Object> choice2= new HashMap<>();
        choice2.put("choice_text", "12cm");
        choice2.put("isCorrect", false);
        Map<String, Object> choice3= new HashMap<>();
        choice3.put("choice_text", "23cm");
        choice3.put("isCorrect", false);
        Map<String, Object> choice4= new HashMap<>();
        choice4.put("choice_text", "34cm");
        choice4.put("isCorrect", true);
        ArrayList<Map<String , Object>> choices= new ArrayList<>();
        choices.add(choice1);
        choices.add(choice2);
        choices.add(choice3);
        choices.add(choice4);
        return choices;
    }
}
