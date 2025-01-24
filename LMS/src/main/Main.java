package main;

import org.json.JSONObject;
import entities.Person;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("raksa", "chan", 18, "male", "012554049", "ocraksa@gmail.com", "209348923084902384902384");
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person.getGender());
        System.out.println(person.getEmail());
        System.out.println(person.getPhone());
    }
}