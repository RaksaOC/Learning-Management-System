package entities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Teacher extends User {
    private final String id;
    private final String gender;
    private final String phoneNumber;
    private final String DoB;
    private JSONArray classrooms;
    private String status;
    private String createdAt;
    private final String lastLogin;

    public Teacher(String id,
                   String first_name,
                   String last_name,
                   String gender,
                   String dob,
                   String phone_number,
                   String email,
                   String password,
                   String status,
                   String created_at,
                   String last_login
    ) {
        this.id = id;
        this.firstName = first_name;
        this.lastName = last_name;
        this.gender = gender;
        this.DoB = dob;
        this.phoneNumber = phone_number;
        this.email = email;
        this.password = password;
        this.status = status;
        this.lastLogin = last_login;
        this.createdAt = created_at;

    }

    public Teacher(JSONObject teacher) throws JSONException {
        // TODO: change this to accept values from Sql

        super(teacher.getJSONObject("name").getString("firstName"),
                teacher.getJSONObject("name").getString("lastName"),
                teacher.getString("email"),
                teacher.getString("password"));
        this.id = teacher.getString("id");
        this.gender = teacher.getString("gender");
        this.phoneNumber = teacher.getString("phoneNumber");
        this.DoB = teacher.getString("dob");
        this.classrooms = teacher.getJSONArray("classrooms");
        this.lastLogin = teacher.getString("lastLogin");
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getEmail() {return email;}
    public String getPassword() {return password;}
    public String getStatus() {return status;}
    public String getCreatedAt() {return createdAt;}
    public String getPhoneNumber() {return phoneNumber;}

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phoneNumber;
    }

    public String getDoB() {
        return DoB;
    }

    public JSONArray getClassrooms() {
        return classrooms;
    }

    public String getLastLogin() {
        return lastLogin;
    }

//    @Override
//    public String toString() {
//        return "Teacher{" +
//                "id='" + id + '\'' +
//                ", firstName='" + getFirstName() + '\'' +
//                ", lastName='" + getLastName() + '\'' +
//                ", email='" + getEmail() + '\'' +
//                ", gender='" + gender + '\'' +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                ", DoB='" + DoB + '\'' +
//                ", classrooms=" + classrooms.toString() +
//                '}';
//    }

}