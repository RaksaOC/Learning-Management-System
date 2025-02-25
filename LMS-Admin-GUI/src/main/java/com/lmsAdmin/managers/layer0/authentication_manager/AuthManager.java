package main.java.com.lmsAdmin.managers.layer0.authentication_manager;

import lib.Hasher;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuthManager {
    public AuthManager() {
    }

    public boolean checkCredentials(String email, String password) {
        // hash the inputted password
        String hashedPassword = Hasher.hash(password);
        try {
            String content = new String(Files.readAllBytes(Paths.get("shared/data/admin.json")));
            JSONArray adminData = new JSONArray(content);

            JSONObject admin;
            for (int i = 0; i < adminData.length(); i++) {
                admin = adminData.getJSONObject(i);
                if (adminData.getJSONObject(i).getString("email").equals(email) && adminData.getJSONObject(i).getString("password").equals(hashedPassword)) {
                    logLastLogIn(adminData, admin);
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private void logLastLogIn(JSONArray allAdmin, JSONObject loggedAdmin) {
        LocalDateTime now = LocalDateTime.now();

        // Format the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formattedDate = now.format(formatter);
        // this block is to log the last time the admin logged in
        loggedAdmin.put("lastLogin", formattedDate);
        try (FileWriter file = new FileWriter("shared/data/admin.json")) {
            file.write(allAdmin.toString(4)); // Pretty-print with 4 spaces
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}