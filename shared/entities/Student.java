package entities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Student extends User {
    private final String id;
    private final String gender;
    private final String phone;
    private final String province;
    private final String district;
    private final String DoB;
    private final String guardianName;
    private final String guardianGender;
    private final String guardianPhoneNumber;
    private final String specialization;
    private final String department;
    private final JSONObject progress;
    private final String generation;
    private final String status;
    private JSONArray classrooms;
    private JSONArray assignments;

    public Student(JSONObject studentObject) throws JSONException {
        super(
                studentObject.getJSONObject("name").getString("firstName"),
                studentObject.getJSONObject("name").getString("lastName"),
                studentObject.getString("email"),
                studentObject.getString("password")
        );
        this.status = studentObject.getString("status");
        this.id = studentObject.getString("id");
        this.gender = studentObject.getString("gender");
        this.phone = studentObject.getString("phoneNumber");
        this.province = studentObject.getJSONObject("address").getString("province");
        this.district = studentObject.getJSONObject("address").getString("district");
        this.DoB = studentObject.getString("dob");
        this.guardianName = studentObject.getJSONObject("guardian").getString("guardianName");
        this.guardianGender = studentObject.getJSONObject("guardian").getString("guardianGender");
        this.guardianPhoneNumber = studentObject.getJSONObject("guardian").getString("guardianPhoneNumber");
        this.specialization = studentObject.getString("specialization");
        this.department = studentObject.getString("department");
        this.progress = studentObject.getJSONObject("progress");
        this.generation = studentObject.getString("generation");
        this.classrooms = studentObject.optJSONArray("classrooms");
        if (this.classrooms == null) this.classrooms = new JSONArray();
        this.assignments = studentObject.optJSONArray("assignments");
        if (this.assignments == null) this.assignments = new JSONArray();

    }


    // Getter methods
    public String getStatus() { return  status; }
    public String getId() { return id; }
    public String getGender() { return gender; }
    public String getPhone() { return phone; }
    public String getProvince() { return province; }
    public String getDistrict() { return district; }
    public String getDoB() { return DoB; }
    public String getGuardianName() { return guardianName; }
    public String getGuardianGender() { return guardianGender; }
    public String getGuardianPhoneNumber() { return guardianPhoneNumber; }
    public String getSpecialization() { return specialization; }
    public String getDepartment() { return department; }
    public String getGeneration() { return generation; }
    public JSONObject getProgress() { return progress; }
    public JSONArray getClassrooms() { return classrooms; }
    public String getAddress() { return province + " " + district; }
    public JSONArray getAssignments() { return assignments; }

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
                ", guardianName='" + guardianName + '\'' +
                ", guardianGender='" + guardianGender + '\'' +
                ", guardianPhoneNumber='" + guardianPhoneNumber + '\'' +
                ", specialization='" + specialization + '\'' +
                ", department='" + department + '\'' +
                ", generation='" + generation + '\'' +
                ", progress=" + progress.toString() +
                '}';
    }

}
