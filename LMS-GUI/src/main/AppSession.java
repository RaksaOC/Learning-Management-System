package main;

import entities.Student;
import entities.Teacher;

public class AppSession {
    private static AppSession instance;
    private Student currentStudent;
    private Teacher currentTeacher;

    private String selectedClassroom;

    private String selectedAssignment;
    private String selectedResources;
    private String selectedQuiz;

    private boolean isAssignmentSubmissionFromAssignmentsPage = false;

    private AppSession() {}  // Private constructor for singleton pattern

    public static AppSession getInstance() {
        if (instance == null) {
            instance = new AppSession();
        }
        return instance;
    }

    public void setStudent(Student student) {
        this.currentStudent = student;
        this.currentTeacher = null; // Reset teacher if a student logs in
        System.out.println("Current student is " + this.currentStudent);
    }

    public void setTeacher(Teacher teacher) {
        this.currentTeacher = teacher;
        this.currentStudent = null; // Reset student if a teacher logs i// n
        System.out.println("Current teacher is " + this.currentTeacher);
    }

    public void setSelectedClassroom(String selectedClassroom) {
        this.selectedClassroom = selectedClassroom;
    }

    public void setSelectedAssignment(String selectedAssignment) {
        this.selectedAssignment = selectedAssignment;
    }

    public void isAssignmentSubmissionFromAssignmentsPage(boolean assignmentSubmissionFromAssignmentsPage) {
        this.isAssignmentSubmissionFromAssignmentsPage = assignmentSubmissionFromAssignmentsPage;
    }

    public void setSelectedResources(String selectedResources) {
        this.selectedResources = selectedResources;
    }
    public void setSelectedQuiz(String selectedQuiz) {
        this.selectedQuiz = selectedQuiz;
    }

    public Student getStudent() {
        return currentStudent;
    }

    public Teacher getTeacher() {
        return currentTeacher;
    }

    public String getSelectedClassroom() {
        return selectedClassroom;
    }

    public String getSelectedAssignment() {
        return selectedAssignment;
    }
    public String getSelectedResources() {
        return selectedResources;
    }
    public String getSelectedQuiz() {
        return selectedQuiz;
    }

    public boolean getIsAssignmentSubmissionFromAssignmentsPage() {
        return this.isAssignmentSubmissionFromAssignmentsPage;
    }

}
