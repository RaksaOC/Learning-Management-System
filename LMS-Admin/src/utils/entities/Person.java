package utils.entities;


public class Person {
    protected String name;
    protected String surname;
    protected int age;
    protected String gender;
    protected String phone;
    protected String email;
    protected String password;

    public Person(String name, String surname, int age, String gender, String phone, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}