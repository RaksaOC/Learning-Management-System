package entities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Teacher extends User {
    private final String id;
    private final String gender;
    private final String phoneNumber;
    private final String DoB;
    private final JSONArray classrooms;
    private final String lastLogin;

    public Teacher(JSONObject teacher) throws JSONException {
        super(teacher.getJSONObject("name").getString("firstName"),
                teacher.getJSONObject("name").getString("firstName"),
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

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + id + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", DoB='" + DoB + '\'' +
                ", classrooms=" + classrooms.toString() +
                '}';
    }

}