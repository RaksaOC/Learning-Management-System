package utils.manager;

import entities.Student;
import org.json.JSONArray;
import org.json.JSONObject;

public class StudentManager {
    Student studentToEdit;
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
        String profile = """
                
                """;
        return profile;
    }

    public void addAssingment(){
        // student,assignmetn.add(newAssignment)
        // convert to json
        // write to file
    }

    public void changeName(String newName){


    }
}