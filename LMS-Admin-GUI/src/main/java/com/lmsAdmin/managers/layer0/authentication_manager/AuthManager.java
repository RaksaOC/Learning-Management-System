package main.java.com.lmsAdmin.managers.layer0.authentication_manager;

import lib.Hasher;
import main.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuthManager {
    private Connection conn = DatabaseConnection.getInstance().getConnection();

    public AuthManager() {
    }

    public boolean checkCredentials(String email, String password) {
        String hashedPassword = Hasher.hash(password);
        String query = "SELECT id, email, password FROM admin WHERE email = ? AND password = ? ";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, email);
            statement.setString(2, hashedPassword);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getString("email").equals(email) && resultSet.getString("password").equals(hashedPassword)) {
                    logLastLogIn(resultSet.getString("id"));
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private void logLastLogIn(String id){
        String query = "UPDATE admin SET last_login = ? WHERE id = ? ";
        LocalDateTime now = LocalDateTime.now();

        // Format the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formattedDate = now.format(formatter);
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setTimestamp(1, Timestamp.valueOf(formattedDate));
            statement.setString(2, id);
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}