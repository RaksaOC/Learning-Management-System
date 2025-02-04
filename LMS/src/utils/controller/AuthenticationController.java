package utils.controller;

import entities.Student;
import entities.Teacher;
import org.json.JSONObject;
import utils.manager.AuthenticationManager;

public class AuthenticationController
{
    public Object authenticate(String userType){
        //                              ^
        // it takes in a userType string argument to use for manger to check for the user in student or teacher file

        // call to manager (manager returns raw json data)
        AuthenticationManager authenticationManager;
        do{
            String email = getEmail();
            String password = getPassword();
            authenticationManager = new AuthenticationManager(userType, email, password);
        }while(!authenticationManager.isUser());

        // now we get the object
        JSONObject user = authenticationManager.getAuthenticatedUser(); // this checked and based on the userType

        Object obj = new Object();
        // create it into a java object
        if(userType.equals("students")){
            Student student;
            // logic to put the info into the student object
            student = new Student(user.getString("name"), user.getString("age")); // wont be error when we get all the info into the constructor
            return student;
        }
        else{
            Teacher teacher;
            // logic to put the info into the teacher object
            teacher = new Teacher(user.getString("name")); // same thing it wont error anymore
            return teacher;
        }
        return null;

    }

    private String getEmail(){
//      ^
//     private because its used only for this class (helper method)

        // Write logic to prompt for the input of email and return back the email string

        // [Return statement TO CHANGE]
        return "";
    }

    private String getPassword(){
        // Write logic to prompt for the input of email and return back the email string

        return "";
    }
}