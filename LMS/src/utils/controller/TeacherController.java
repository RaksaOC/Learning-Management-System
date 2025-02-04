package utils.controller;

import entities.Teacher;

public class TeacherController {
    public TeacherController(Teacher teacher) {
//                                ^
//                       takes in a teacher object from the authentication
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