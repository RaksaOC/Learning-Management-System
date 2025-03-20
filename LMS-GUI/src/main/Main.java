package main;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection.getInstance().getConnection();
        SceneManager.launch(SceneManager.class, args);
    }
}
