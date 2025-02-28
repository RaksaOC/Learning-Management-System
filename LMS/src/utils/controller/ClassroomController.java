package utils.controller;

import entities.Teacher;
import org.json.JSONArray;
import org.json.JSONObject;
import utils.manager.ClassroomManager;
import utils.menu.Menu;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class ClassroomController {
    String classIdToEdit;

    public ClassroomController(String classroomId) {
        this.classIdToEdit = classroomId;
    }

    // Assignment Controller
    public void addAssignment() {
        // logic to add a grade to an assignment of the student...
        ClassroomManager classroomManager = new ClassroomManager(classIdToEdit);
        classroomManager.manageAddAssignment();
    }

    public void editAssignment() {
        ClassroomManager classroomManager = new ClassroomManager(classIdToEdit);
        classroomManager.manageEditAssignment();
    }

    public void deleteAssignment() {
        ClassroomManager classroomManager = new ClassroomManager(classIdToEdit);
        classroomManager.manageDeleteAssignment();
    }

    public void gradeAssignment() {
        ClassroomManager classroomManager = new ClassroomManager(classIdToEdit);
        classroomManager.manageGradeAssignment();
    }

    public void commentStudentAssignment() {
        ClassroomManager classroomManager = new ClassroomManager(classIdToEdit);
        classroomManager.manageCommentStudentAssignment();
    }

    public void viewStudentAssignment() {
        ClassroomManager classroomManager = new ClassroomManager(classIdToEdit);
        classroomManager.manageViewStudentAssignment();
    }

    public void viewAllStudentAssignment() {
        ClassroomManager classroomManager = new ClassroomManager(classIdToEdit);
        classroomManager.manageViewAllStudentAssignment();
    }

    // Resource Controller
    public void addResource() {
        ClassroomManager classroomManager = new ClassroomManager(classIdToEdit);
        classroomManager.manageAddResource();
    }

    public void editResource() {
        ClassroomManager classroomManager = new ClassroomManager(classIdToEdit);
        classroomManager.manageEditResource();
    }

    public void deleteResource() {
        ClassroomManager classroomManager = new ClassroomManager(classIdToEdit);
        classroomManager.manageDeleteResource();
    }

    public void viewResource() {
        ClassroomManager classroomManager = new ClassroomManager(classIdToEdit);
        classroomManager.manageViewResource();
    }

    // Quizz Controller
    public void addQuizz() {
        ClassroomManager classroomManager = new ClassroomManager(classIdToEdit);
        // Just sample data
        String title = "Rate teacher";
        String createdBy = "T0001";
        String questions = "[{\"questionTitle\":\"How zesty is the teacher?\", \"choices\": [\"straight\", \"lemony\", \"holy zesty\", \"gay\"], \"answer\": \"gay\"}, {\"questionTitle\":\"How zesty is the teacher?\", \"choices\": [\"straight\", \"lemony\", \"holy zesty\", \"gay\"], \"answer\": \"gay\"}, {\"questionTitle\":\"How zesty is the teacher?\", \"choices\": [\"straight\", \"lemony\", \"holy zesty\", \"gay\"], \"answer\": \"gay\"}]";
        JSONArray questionsJson = new JSONArray(questions);
        String classroomID="GEN10-CS-SE-G1-OOP";
        classroomManager.manageAddQuizz(classroomID ,title, createdBy, questionsJson);
    }

    public void editQuizz() {
        ClassroomManager classroomManager = new ClassroomManager(classIdToEdit);
        String id = "GEN10-CS-SE-G1-OOP";
        String title = "Rate teacher beauty";
        String questions = "[{\"questionTitle\":\"How zesty is the teacher?\", \"choices\": [\"straight\", \"lemony\", \"holy zesty\", \"gay\"], \"answer\": \"gay\"}, {\"questionTitle\":\"How zesty is the teacher?\", \"choices\": [\"straight\", \"lemony\", \"holy zesty\", \"gay\"], \"answer\": \"gay\"}, {\"questionTitle\":\"How zesty is the teacher?\", \"choices\": [\"straight\", \"lemony\", \"holy zesty\", \"gay\"], \"answer\": \"gay\"}]";
        JSONArray questionsJson=new JSONArray(questions);
        String idToEdit="Q0001";
        classroomManager.manageEditQuizz(title, questionsJson, idToEdit, id);
    }

    public void deleteQuizz() {
        ClassroomManager classroomManager = new ClassroomManager(classIdToEdit);
        // sample data
        String idToDelete = "Q0000";
        String classID="GEN10-CS-SE-G1-OOP";
        classroomManager.manageDeleteQuizz(idToDelete, classID);
    }

    public void viewQuizz() {
        ClassroomManager classroomManager = new ClassroomManager(classIdToEdit);
        String id = "Q0001";
        String classID="GEN10-CS-SE-G1-OOP";
        classroomManager.manageViewQuizz(id, classID);
    }

    public void goToDoQuiz(){
        ClassroomManager classroomManager = new ClassroomManager(classIdToEdit);
        int index=1;
        String[] answer= {"gay", "gay", "gay"};
        String classID="GEN10-CS-SE-G1-OOP";
        classroomManager.manageDoQuiz(index, answer, classID);
    }
}
