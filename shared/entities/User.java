package entities;


public abstract class User {
    // TODO: change this to accept values from Sql
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password;

    public User() {}

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}