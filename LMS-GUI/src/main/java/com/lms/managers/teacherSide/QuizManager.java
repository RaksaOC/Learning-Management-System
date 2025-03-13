package main.java.com.lms.managers.teacherSide;

import main.AppSession;

public class QuizManager extends ClassroomContentManager{
    private String classIdToEdit = AppSession.getInstance().getSelectedClassroom();

    // TO CHANGE: later
    public QuizManager(String classIdToEdit) {
        super(classIdToEdit);
    }
}