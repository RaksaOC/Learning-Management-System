package utils.manager;

import entities.Student;
import entities.Teacher;

public class TeacherManager {
    Teacher teacherToEdit;
    public TeacherManager(Teacher teacher) {
        teacherToEdit = teacher;
    }

    public void manageGradeAssignment(){
        // logic to add a grade to an assignment of the student...

    }

    public void manageViewStudentAssignment(String studentID){
        //                                  ^
        // look for the assignments of this student associated with the course or taught by this teacher
    }

    public void manageViewAllStudentAssignments(){}

    public void editStudentAssignment(){
        // this is to edit info like the description of the assignment....
    }

    private void commentOnAssignment(){
        // used with the manageGradeAssignment to add comment...
    }

    // more methods/functionalities to come
}