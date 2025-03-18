package main;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection.getInstance().getConnection();
        SceneManager.launch(SceneManager.class, args);
    }
}
