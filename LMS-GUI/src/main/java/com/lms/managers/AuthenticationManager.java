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
}