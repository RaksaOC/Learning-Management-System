package utils.controller;

import entities.Student;
import entities.Teacher;
import entities.User;
import lib.Hasher;
import ui.UI;
import utils.manager.AuthenticationManager;
import utils.menu.Menu;

public class AuthenticationController {

    public User authenticate(String userType) {
        AuthenticationManager authenticationManager = new AuthenticationManager();
        User userObject;

        // If a user was last logged in, retrieve their info
        if (authenticationManager.isLastLoggedIn(userType)) {
            userObject = getUser(userType);
            if (userType.equals("student") && userObject instanceof Student) {
                Student student = (Student) userObject;
                authenticationManager.createNewLogIn(userType, student.getId());
                return student;
            } else if (userType.equals("teacher") && userObject instanceof Teacher) {
                Teacher teacher = (Teacher) userObject;
                authenticationManager.createNewLogIn(userType, teacher.getId());
                return teacher;
            }
        } else {
            // if the last user logged out or the current user log out
            // Prompt for login until valid credentials are provided
            boolean isUser = false;
            do {
                String email = getEmail();
                String password = getPassword();
                authenticationManager = new AuthenticationManager(userType, email, password);
                isUser = authenticationManager.isUser();
                if (!isUser) {
                    System.out.println(UI.TextColor.addColor("\nInvalid email or password\n", UI.TextColor.RED));
                }
            } while (!isUser);
            //                                                          ^   ^       ^
            // this would get the loggedIn user details from the 3 parameter constructor
            userObject = authenticationManager.getAuthenticatedUser();
            if (userType.equals("student") && userObject instanceof Student) {
                Student student = (Student) userObject;
                authenticationManager.createNewLogIn(userType, student.getId());
                return student;
            } else if (userType.equals("teacher") && userObject instanceof Teacher) {
                Teacher teacher = (Teacher) userObject;
                authenticationManager.createNewLogIn(userType, teacher.getId());
                return teacher;
            }
        }
        return userObject;
    }

    public void logout(String userType) {
        AuthenticationManager authenticationManager = new AuthenticationManager();
        authenticationManager.markLastLoggedOut(userType);
    }

    private User getUser(String userType) {
        // this function only for when last logged in
        AuthenticationManager authenticationManager = new AuthenticationManager();
        String id = authenticationManager.getLastLoggedInUserId(userType);
        // usage of an overloaded method
        User user = authenticationManager.getAuthenticatedUser(id); // this process also include the assignment of "lastLogin" of user

        return user;
    }

    private String getEmail() {
        String email = Menu.prompt("Enter email address");
        return email;
    }

    private String getPassword() {
        String password = Menu.prompt("Enter password");
        return Hasher.hash(password);
    }
}
