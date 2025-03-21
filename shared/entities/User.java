package entities;


public abstract class User {
    // TODO: change this to accept values from Sql
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password;

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getFullName() {
        return firstName + " " + lastName;
    }
}