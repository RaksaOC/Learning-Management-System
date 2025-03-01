package entities;

import org.json.JSONException;
import org.json.JSONObject;

public class Student extends User {
    private final String id;
    private final String gender;
    private final String phone;
    private final String commune;
    private final String district;
    private final String province;
    private final String DoB;
    private final String guardianFirstName;
    private final String guardianLastName;
    private final String guardianGender;
    private final String guardianPhoneNumber;
    private final String specialization;
    private final String department;
    private final JSONObject progress;
    private final String generation;
    private final String lastLogin;

    public Student(JSONObject studentObject) throws JSONException {
        super(
                studentObject.getJSONObject("name").getString("firstName"),
                studentObject.getJSONObject("name").getString("lastName"),
                studentObject.getString("email"),
                studentObject.getString("password")
        );
        this.id = studentObject.getString("id");
        this.gender = studentObject.getString("gender");
        this.phone = studentObject.getString("phoneNumber");
        this.commune= studentObject.getJSONObject("address").getString("commune");
        this.district = studentObject.getJSONObject("address").getString("district");
        this.province = studentObject.getJSONObject("address").getString("province");
        this.DoB = studentObject.getString("dob");
        this.guardianFirstName = studentObject.getJSONObject("guardian").getJSONObject("name").getString("firstName");
        this.guardianLastName = studentObject.getJSONObject("guardian").getJSONObject("name").getString("lastName");
        this.guardianGender = studentObject.getJSONObject("guardian").getString("gender");
        this.guardianPhoneNumber = studentObject.getJSONObject("guardian").getString("phoneNumber");
        this.specialization = studentObject.getString("specialization");
        this.department = studentObject.getString("department");
        this.progress = studentObject.getJSONObject("progress");
        this.generation = studentObject.getString("generation");
        this.lastLogin = studentObject.getString("lastLogin");
    }

    // Getter methods
    public String getId() { return id; }
    public String getGender() { return gender; }
    public String getPhone() { return phone; }
    public String getCommune() { return commune; }
    public String getProvince() { return province; }
    public String getDistrict() { return district; }
    public String getDoB() { return DoB; }
    public String getGuardianFirstName() { return this.guardianFirstName; }
    public String getGuardianLastName() { return this.guardianLastName; }
    public String getGuardianGender() { return guardianGender; }
    public String getGuardianPhoneNumber() { return guardianPhoneNumber; }
    public String getSpecialization() { return specialization; }
    public String getDepartment() { return department; }
    public String getGeneration() { return generation; }
    public JSONObject getProgress() { return progress; }
    public String getLastLogin() { return lastLogin; }


    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", province='" + province + '\'' +
                ", district='" + district + '\'' +
                ", DoB='" + DoB + '\'' +
                ", guardianGender='" + guardianGender + '\'' +
                ", guardianPhoneNumber='" + guardianPhoneNumber + '\'' +
                ", specialization='" + specialization + '\'' +
                ", department='" + department + '\'' +
                ", generation='" + generation + '\'' +
                ", progress=" + progress.toString() +
                '}';
    }

}
