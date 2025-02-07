package utils.controller;

import entities.Teacher;
import ui.UI;
import utils.manager.TeacherManager;

public class TeacherController {
    Teacher teacher;
    public TeacherController(Teacher teacher) {
//                                ^
//                       takes in a teacher object from the authentication
        this.teacher = teacher;
    }
    public void viewProfile() {
        TeacherManager teacherManager = new TeacherManager(teacher);
        String profileDetails = teacherManager.manageViewProfile();
        System.out.println(UI.TextColor.addColor(profileDetails, UI.TextColor.BLUE));
    }

    public void gradeAssignment(){
        // logic to add a grade to an assignment of the student...
    }

    public void viewStudentAssignment(String studentID){
        //                                  ^
        // look for the assignments of this student associated with the course or taught by this teacher
    }

    public void viewAllStudentAssignments(){}

    public void editStudentAssignment(){
        // this is to edit info like the description of the assignment....
    }

    private void commentOnAssignment(){
        // used with the manageGradeAssignment to add comment...
    }
}