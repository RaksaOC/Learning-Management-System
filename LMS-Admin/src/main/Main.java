package main;

import org.json.JSONObject;
import entities.Person;

public class Main {
    public static void main(String[] args) {
        String content = "{}";
        JSONObject obj = new JSONObject(content);
        System.out.println(obj.toString());
        System.out.println("Printed the json object");
    }
}