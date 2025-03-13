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
    public void addAssignment(){
        // logic to add a grade to an assignment of the student...
        ClassroomManager classroomManager = new ClassroomManager(classIdToEdit);
        classroomManager.manageAddAssignment();
    }

    public void editAssignment(){
        ClassroomManager classroomManager = new ClassroomManager(classIdToEdit);
        classroomManager.manageEditAssignment();
    }

    public void deleteAssignment(){
        ClassroomManager classroomManager = new ClassroomManager(classIdToEdit);
        classroomManager.manageDeleteAssignment();
    }

    public void gradeAssignment() {
        ClassroomManager classroomManager = new ClassroomManager(classIdToEdit);
        classroomManager.manageGradeAssignment();
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
        classroomManager.manageAddQuizz();
    }

    public void editQuizz() {
        ClassroomManager classroomManager = new ClassroomManager(classIdToEdit);
        classroomManager.manageEditQuizz();
    }

    public void gradeQuizz() {
        ClassroomManager classroomManager = new ClassroomManager(classIdToEdit);
        classroomManager.manageGradeQuizz();
    }

    public void deleteQuizz() {
        ClassroomManager classroomManager = new ClassroomManager(classIdToEdit);
        classroomManager.manageDeleteQuizz();
    }

    public void viewQuizz() {
        ClassroomManager classroomManager = new ClassroomManager(classIdToEdit);
        classroomManager.manageViewQuizz();
    }

}
