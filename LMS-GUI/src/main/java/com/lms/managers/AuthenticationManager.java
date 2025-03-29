package main.java.com.lms.managers;

import entities.Student;
import entities.Teacher;
import entities.User;
import lib.Hasher;
import main.DatabaseConnection;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.xml.crypto.Data;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuthenticationManager {
    private Connection conn = DatabaseConnection.getInstance().getConnection();

    private String userType;
    private String email;
    private String password;

    public AuthenticationManager() {
    }

    // AUTO LOGIN
    public AuthenticationManager(String userType) {
        this.userType = userType;
    }

    // MANUAL LOGIN
    public AuthenticationManager(String userType, String email, String password) {
        this.userType = userType;
        this.email = email;
        this.password = Hasher.hash(password);
    }

    public User getLastLoggedInUserSql() {
        if (userType.equals("student")) {
            String query = "SELECT * FROM student WHERE id = (SELECT student_id FROM student_history ORDER BY time DESC LIMIT 1)";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                ResultSet rs = statement.executeQuery();
                Student student = null;
                while (rs.next()) {
                    student = new Student(
                            rs.getString("id"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("phone_number"),
                            rs.getString("email"),
                            rs.getString("password"),
                            rs.getString("commune"),
                            rs.getString("district"),
                            rs.getString("province"),
                            rs.getString("status"),
                            rs.getString("created_at"),
                            rs.getString("last_login"),
                            rs.getString("department_id"),
                            rs.getString("specialization_id"),
                            rs.getString("generation_id"),
                            rs.getString("group_id"),
                            rs.getString("guardian_first_name"),
                            rs.getString("guardian_last_name"),
                            rs.getString("guardian_phone_number"),
                            rs.getString("guardian_gender"));
                }
                return student;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (userType.equals("teacher")) {
            String query = "SELECT * FROM teacher WHERE id = (SELECT teacher_id FROM teacher_history ORDER BY time DESC LIMIT 1)";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                ResultSet rs = statement.executeQuery();
                Teacher teacher = null;
                while (rs.next()) {
                    teacher = new Teacher(
                            rs.getString("id"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("phone_number"),
                            rs.getString("email"),
                            rs.getString("password"),
                            rs.getString("status"),
                            rs.getString("created_at"),
                            rs.getString("last_login")
                    );
                }
                return teacher;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public User getAuthenticatedUserSql() {
        if (userType.equals("student")) {
            String query = "SELECT * FROM student WHERE email = ? AND password = ?";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                statement.setString(1, email);
                statement.setString(2, password);
                ResultSet rs = statement.executeQuery();
                Student student = null;
                while (rs.next()) {
                    student = new Student(
                            rs.getString("id"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("phone_number"),
                            rs.getString("email"),
                            rs.getString("password"),
                            rs.getString("commune"),
                            rs.getString("district"),
                            rs.getString("province"),
                            rs.getString("status"),
                            rs.getString("created_at"),
                            rs.getString("last_login"),
                            rs.getString("department_id"),
                            rs.getString("specialization_id"),
                            rs.getString("generation_id"),
                            rs.getString("group_id"),
                            rs.getString("guardian_first_name"),
                            rs.getString("guardian_last_name"),
                            rs.getString("guardian_phone_number"),
                            rs.getString("guardian_gender"));
                }
                return student;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (userType.equals("teacher")) {
            String query = "SELECT * FROM teacher WHERE email = ? AND password = ?";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                statement.setString(1, email);
                statement.setString(2, password);
                ResultSet rs = statement.executeQuery();
                Teacher teacher = null;
                while (rs.next()) {
                    teacher = new Teacher(
                            rs.getString("id"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("phone_number"),
                            rs.getString("email"),
                            rs.getString("password"),
                            rs.getString("status"),
                            rs.getString("created_at"),
                            rs.getString("last_login")
                    );
                }
                return teacher;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public boolean isLastLoggedInSql() {
        if (userType.equals("student")) {
            String query = "SELECT * FROM student_history ORDER BY time DESC LIMIT 1";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                ResultSet rs = statement.executeQuery();
                if (!rs.next()) {
                    return false;
                }
                return rs.getString("last_action").equals("login");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (userType.equals("teacher")) {
            String query = "SELECT * FROM teacher_history ORDER BY time DESC LIMIT 1";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                ResultSet rs = statement.executeQuery();
                if (!rs.next()) {
                    return false;
                }
                return rs.getString("last_action").equals("login");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean isUserSql() {
        String query = "";

        if (userType.equals("student")) {
            query = "SELECT * FROM student WHERE email = ? AND password = ?";
        } else if (userType.equals("teacher")) {
            query = "SELECT * FROM teacher WHERE email = ? AND password = ?";
        } else {
            return false;
        }

        try (PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setString(1, email);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public User getAuthenticatedUser() {
        if (this.isStudent(userType)) {
            JSONObject studentInfo = getStudentInfo(email);
            JSONArray students = loadStudents();
            for (int i = 0; i < students.length(); i++) {
                JSONObject stu = students.getJSONObject(i);
                if (stu.getString("id").equals(studentInfo.getString("id"))) {
                    stu.put("lastLogin", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                    students.put(i, stu);
                    saveStudent(students);
                    break;
                }
            }
            Student student = new Student(studentInfo);
            return student;
        }
        JSONArray teachers = loadTeachers();
        JSONObject teacherInfo = getTeacherInfo(email);
        for (int i = 0; i < teachers.length(); i++) {
            JSONObject stu = teachers.getJSONObject(i);
            if (stu.getString("id").equals(teacherInfo.getString("id"))) {
                stu.put("lastLogin", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                teachers.put(i, stu);
                saveStudent(teachers);
                break;
            }
        }
        Teacher teacher = new Teacher(teacherInfo);

        return teacher;
    }

    public void createNewLogInSql(String id) {
        String timeNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        if (userType.equals("student")) {
            String query = "INSERT INTO student_history (student_id, last_action, time) VALUES (?, ?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                statement.setString(1, id);
                statement.setString(2, "logIn");
                statement.setString(3, timeNow);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            String query2 = "UPDATE student SET last_login = ? WHERE id = ?";
            try (PreparedStatement statement = conn.prepareStatement(query2)) {
                statement.setString(1, timeNow);
                statement.setString(2, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (userType.equals("teacher")) {
            String query = "INSERT INTO teacher_history (teacher_id, last_action, time) VALUES (?, ?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                statement.setString(1, id);
                statement.setString(2, "logIn");
                statement.setString(3, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            String query2 = "UPDATE teacher SET last_login = ? WHERE id = ?";
            try (PreparedStatement statement = conn.prepareStatement(query2)) {
                statement.setString(1, timeNow);
                statement.setString(2, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void createNewLogOutSql(String id) {
        String timeNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        if (userType.equals("student")) {
            String query = "INSERT INTO student_history (student_id, last_action, time) VALUES (?, ?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                statement.setString(1, id);
                statement.setString(2, "logOut");
                statement.setString(3, timeNow);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (userType.equals("teacher")) {
            String query = "INSERT INTO teacher_history (teacher_id, last_action, time) VALUES (?, ?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                statement.setString(1, id);
                statement.setString(2, "logOut");
                statement.setString(3, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // JSON RELATED METHODS

    public User getAuthenticatedUser(String id) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = now.format(formatter);
        if (id.charAt(0) == 'S') {
            JSONArray students = loadStudents();
            for (int i = 0; i < students.length(); i++) {
                JSONObject stu = students.getJSONObject(i);
                if (stu.getString("id").equals(id)) {
                    // this block set the lastLogIn of student to the time of logging in right now
                    stu.put("lastLogin", formattedDate);
                    students.put(i, stu);
                    saveStudent(students);
                    // ----------------------------------------------------------------------------
                    Student student = new Student(stu);
                    return student;
                }
            }
        } else {
            JSONArray teachers = loadTeachers();
            for (int i = 0; i < teachers.length(); i++) {
                JSONObject teach = teachers.getJSONObject(i);
                if (teach.getString("id").equals(id)) {
                    // this block set the lastLogIn of teacher to the time of logging in right now
                    teach.put("lastLogin", formattedDate);
                    teachers.put(i, teach);
                    saveTeacher(teachers);
                    // ----------------------------------------------------------------------------
                    Teacher teacher = new Teacher(teach);
                    return teacher;
                }
            }
        }
        return null;
    }

    //  some other methods

    private boolean isStudent(String userType) {
        if (userType.equals("student")) {
            return true;
        }
        return false;
    }

    // used for log in check
    public boolean isUser() {
        if (userType.equals("student")) {
            JSONArray students = loadStudents();
            for (int i = 0; i < students.length(); i++) {
                JSONObject student = students.getJSONObject(i);
                if (student.getString("email").equals(email) && student.getString("password").equals(password)) {
                    return true;
                }
            }
        } else {
            JSONArray teachers = loadTeachers();
            for (int i = 0; i < teachers.length(); i++) {
                JSONObject teacher = teachers.getJSONObject(i);
                if (teacher.getString("email").equals(email) && teacher.getString("password").equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

    private JSONObject getStudentInfo(String email) {
        JSONArray students = loadStudents();
        for (int i = 0; i < students.length(); i++) {
            JSONObject student = students.getJSONObject(i);
            if (student.getString("email").equals(email) && student.getString("password").equals(password)) {
                return student;
            }
        }
        return null;
    }

    private JSONObject getTeacherInfo(String email) {
        JSONArray teachers = loadTeachers();
        for (int i = 0; i < teachers.length(); i++) {
            JSONObject teacher = teachers.getJSONObject(i);
            if (teacher.getString("email").equals(email) && teacher.getString("password").equals(password)) {
                return teacher;
            }
        }
        return null;
    }

    private JSONObject loadHistory() {
        try {
            String content = new String(Files.readAllBytes(Paths.get("shared/data/history.json")));
            JSONObject history = new JSONObject(content);
            return history;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isLastLoggedIn(String userType) {
        JSONObject history = loadHistory();
        JSONArray userHistory;
        if (isStudent(userType)) userHistory = history.getJSONArray("student");
        else userHistory = history.getJSONArray("teacher");

        if (userHistory.getJSONObject(userHistory.length() - 1).getString("lastAction").equals("logIn")) {
            return true;
        }
        return false;
    }

    public String getLastLoggedInUserId(String userType) {
        JSONObject history = loadHistory();
        JSONArray userHistory = history.getJSONArray(userType);
        return userHistory.getJSONObject(userHistory.length() - 1).getString("id");
    }

    public void markLastLoggedOut(String userType) {
        JSONObject history = loadHistory();
        JSONArray userHistory = history.getJSONArray(userType);
        String id = userHistory.getJSONObject(userHistory.length() - 1).getString("id");
        JSONObject newLogOut = new JSONObject();
        newLogOut.put("id", id);
        newLogOut.put("lastAction", "logOut");
        newLogOut.put("time", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        userHistory.put(newLogOut);
        history.put(userType, userHistory);
        saveLogOut(history);
    }

    public void createNewLogIn(String userType, String id) {
        JSONObject history = loadHistory();
        JSONArray userHistory = history.getJSONArray(userType);

        LocalDateTime now = LocalDateTime.now();

        // Format the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formattedDate = now.format(formatter);
        // this block is to log the last time the admin logged in

        JSONObject newLogIn = new JSONObject();
        newLogIn.put("id", id);
        newLogIn.put("lastAction", "logIn");
        newLogIn.put("time", formattedDate);
        userHistory.put(newLogIn);
        history.put(userType, userHistory);
        saveLogOut(history);
    }

    private void saveLogOut(JSONObject history) {
        try (FileWriter file = new FileWriter("shared/data/history.json")) {
            file.write(history.toString(4)); // Pretty-print with 4 spaces
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private JSONArray loadStudents() {
        try {
            String content = new String(Files.readAllBytes(Paths.get("shared/data/student.json")));
            JSONArray students = new JSONArray(content);
            return students;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private JSONArray loadTeachers() {
        try {
            String content = new String(Files.readAllBytes(Paths.get("shared/data/teacher.json")));
            JSONArray teachers = new JSONArray(content);
            return teachers;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void saveStudent(JSONArray students) {
        try (FileWriter file = new FileWriter("shared/data/student.json")) {
            file.write(students.toString(4)); // Pretty-print with 4 spaces
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveTeacher(JSONArray teachers) {
        try (FileWriter file = new FileWriter("shared/data/teacher.json")) {
            file.write(teachers.toString(4)); // Pretty-print with 4 spaces
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}