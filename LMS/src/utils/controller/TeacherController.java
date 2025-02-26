package utils.controller;

import entities.Teacher;
import ui.UI;
import utils.manager.TeacherManager;
import utils.menu.Menu;

public class TeacherController {
    Teacher teacher;
    String indexOfClass;
    public TeacherController(Teacher teacher) {
//                                ^
//                       takes in a teacher object from the authentication
        this.teacher = teacher;
    }

    public       TeacherController(Teacher teacher, String IndexOfClass) {
        this.indexOfClass = IndexOfClass;
    }

    public String selectClassroom() {
        TeacherManager teacherManager = new TeacherManager(teacher);
        System.out.println(teacherManager.printClassrooms(teacher.getClassrooms()));
        String choice = Menu.prompt("Select a Classroom: ");
        return Integer.toString(Integer.parseInt(choice) - 1);
    }

    public void viewProfile() {
        TeacherManager teacherManager = new TeacherManager(teacher);
        String profileDetails = teacherManager.manageViewProfile();
        System.out.println(UI.TextColor.addColor(profileDetails, UI.TextColor.BLUE));
    }

    // Assignment Controller
    public void handleAddAssignment() {
        ClassroomController classroomController = new ClassroomController(indexOfClass);
        classroomController.addAssignment();
    }

    public void handleEditAssignment() {
        ClassroomController classroomController = new ClassroomController(indexOfClass);
        classroomController.editAssignment();
    }

    public void handleDeleteAssignment() {
        ClassroomController classroomController = new ClassroomController(indexOfClass);
        classroomController.deleteAssignment();
    }

    public void handleGradeStudentAssignment() {
        ClassroomController classroomController = new ClassroomController(indexOfClass);
        classroomController.gradeAssignment();
    }

    public void handleCommentStudentAssignment() {
        ClassroomController classroomController = new ClassroomController(indexOfClass);
        classroomController.commentStudentAssignment();
    }

    public void handleViewStudentAssignment() {
        ClassroomController classroomController = new ClassroomController(indexOfClass);
        classroomController.viewStudentAssignment();
    }

    public void handleViewAllStudentAssignment() {
        ClassroomController classroomController = new ClassroomController(indexOfClass);
        classroomController.viewAllStudentAssignment();
    }

    // Resources Controller
    public void handleAddResources() {
        ClassroomController classroomController = new ClassroomController(indexOfClass);
        classroomController.addResource();
    }

    public void handleEditResources() {
        ClassroomController classroomController = new ClassroomController(indexOfClass);
        classroomController.editResource();
    }

    public void handleDeleteResources() {
        ClassroomController classroomController = new ClassroomController(indexOfClass);
        classroomController.deleteResource();
    }

    public void handleViewResources() {
        ClassroomController classroomController = new ClassroomController(indexOfClass);
        classroomController.viewResource();
    }

    // Quizz Controller
    public void handleAddQuizzes() {
        ClassroomController classroomController = new ClassroomController(indexOfClass);

        classroomController.addQuizz();
    }

    public void handleEditQuizzes() {
        ClassroomController classroomController = new ClassroomController(indexOfClass);
        classroomController.editQuizz();
    }

    public void handleDeleteQuizzes() {
        ClassroomController classroomController = new ClassroomController(indexOfClass);
        classroomController.deleteQuizz();
    }



    public void handleViewQuizzes() {
        ClassroomController classroomController = new ClassroomController(indexOfClass);
        classroomController.viewQuizz();
    }

}