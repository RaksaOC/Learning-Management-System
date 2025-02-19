package utils.manager;

import entities.Student;
import org.json.JSONArray;

public class StudentManager {
    Student studentToEdit;
    private JSONArray classroom;

    public StudentManager(Student student) {
        //                  ^
        //      the constructor takes in the student object to get the changed data in its fields to write back to file
        studentToEdit = student;
    }

    public JSONArray manageViewAssignment() {
        // this function would take the student object, go search for that student's assignments and return the array

        // [To Change]
        return null;
    }

    public String manageViewProfile() {
        // print the student's info in a nice and formatted table/ interface
        String profile = String.format("""
                Student Table:
                ----------------
                Student status: %s
                ID: %s
                Name: %s
                Gender: %s
                Date of Birth: %s
                Email: %s
                Phone number: %s
                Address: %s
                Specialization: %s
                Department: %s
                Generation: %s
                -----------------
                """,
                studentToEdit.getStatus() ,studentToEdit.getId(), studentToEdit.getFullName(), studentToEdit.getGender(), studentToEdit.getDoB(),
                studentToEdit.getEmail(), studentToEdit.getPhone(), studentToEdit.getProvince(),studentToEdit.getSpecialization(),
                studentToEdit.getDepartment(), studentToEdit.getGeneration()
        );
        return profile;
    }

    public void addAssingment(){
        // student,assignmetn.add(newAssignment)
        // convert to json
        // write to file
    }

    public void changeName(String newName){

    }

    public String selectProgress(JSONArray progress){
        String allClass = "";
        for(int i = 0; i < progress.length(); i ++){
            allClass += progress.getString(i) + "\n" ;
        }
        return allClass;
    }

    public String manageViewClassroom(){

        return null;
    }

}