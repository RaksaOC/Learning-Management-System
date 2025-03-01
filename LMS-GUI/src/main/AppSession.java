package main;

import entities.Student;
import entities.Teacher;

public class AppSession {
    private static AppSession instance;
    private Student currentStudent;
    private Teacher currentTeacher;

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

    public Student getStudent() {
        return currentStudent;
    }

    public Teacher getTeacher() {
        return currentTeacher;
    }
}
