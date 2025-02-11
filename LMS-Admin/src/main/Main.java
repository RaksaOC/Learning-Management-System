package main;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {

        MainController controller = new MainController();
        controller.run();

//        try {
//            Class.forName("org.mariadb.jdbc.Driver");
//            System.out.println("Driver loaded successfully!");
//        } catch (ClassNotFoundException e) {
//            System.out.println("Driver not found: " + e.getMessage());
//        }
//        String url = "jdbc:mariadb://localhost:3306/LMS";
//        String username = "root";
//        String password = "";
//        System.out.println(System.getProperty("java.class.path"));
//
//
//        try {
//            // Load the MariaDB driver
//            Class.forName("org.mariadb.jdbc.Driver");
//
//            // Connect to the database
//            Connection connection = DriverManager.getConnection(url, username, password);
//
//            System.out.println("Connection successful!");
//
//            // Your SQL operations here...
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }
}