package utils.manager;

import org.json.JSONObject;

public class AuthenticationManager {
    private String userType;
    private String email;
    private String password;

    public AuthenticationManager(String userType, String email, String password) {
        this.userType = userType;
        this.email = email;
        this.password = password;
    }

    public JSONObject getAuthenticatedUser() {
        if(this.isStudent()){
            return getStudentInfo(email);
        }
        return getTeacherInfo(email);
    }

    //  some other methods

    private boolean isStudent(){
        if(userType.equals("student")){
            return true;
        }
        return false;
    }

    public boolean isUser() {
        // takes in the email and pass and go to file and check
        // if everything is correct then return true
        // else
        return false;
    }

    private JSONObject getStudentInfo(String email) {
        // go to file get the student
        return null;
    }

    private JSONObject getTeacherInfo(String email) {
        // go to file get the student
        return null;
    }



}