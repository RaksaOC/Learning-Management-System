package utils.manager;

import entities.Student;
import entities.Teacher;
import org.json.JSONArray;
import org.json.JSONMLParserConfiguration;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class TeacherManager {
    Teacher teacherToEdit;
    public TeacherManager(Teacher teacher) {
        this.teacherToEdit = teacher;
    }

    public String manageViewProfile(){
        String profile = String.format("""
        Teacher Profile:
        ----------------
        ID: %s
        Name: %s %s
        Email: %s
        Gender: %s
        Phone: %s
        Date of Birth: %s
        Classrooms: %s
        """,
                teacherToEdit.getId(), teacherToEdit.getFirstName(), teacherToEdit.getLastName(),teacherToEdit.getEmail()
                , teacherToEdit.getGender(), teacherToEdit.getPhone(), teacherToEdit.getDoB(), printClassrooms(teacherToEdit.getClassrooms())
        );

        return profile;
    }

    public String printClassrooms(JSONArray classroom){
        String allClass = "";
        for(int i = 0; i < classroom.length(); i ++){
            allClass += classroom.getString(i) + "\n" ;
        }
        return allClass;
    }

    public void addQuiz(){

    }


    // more methods/functionalities to come
}