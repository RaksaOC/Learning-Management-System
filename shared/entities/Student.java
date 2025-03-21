package entities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Student extends User {
    private String id;
    private String gender;
    private String phone;
    private String province;
    private String district;
    private String commune;
    private String DoB;
    private String guardianFirstName;
    private String guardianLastName;
    private String guardianGender;
    private String guardianPhoneNumber;
    private String specialization;
    private String department;
    private JSONObject progress;
    private String generation;
    private String status;
    private JSONArray classrooms;
    private String lastLogin;
    private JSONObject address;

    public Student(JSONObject studentObject) throws JSONException {
        // TODO: change this to accept values from Sql

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
        this.commune = studentObject.getJSONObject("address").getString("commune");
        this.DoB = studentObject.getString("dob");
        this.guardianFirstName = studentObject.getJSONObject("guardian").getJSONObject("name").getString("firstName");
        this.guardianLastName = studentObject.getJSONObject("guardian").getJSONObject("name").getString("lastName");
        this.guardianGender = studentObject.getJSONObject("guardian").getString("guardianGender");
        this.guardianPhoneNumber = studentObject.getJSONObject("guardian").getString("guardianPhoneNumber");
        this.specialization = studentObject.getString("specialization");
        this.department = studentObject.getString("department");
        this.progress = studentObject.getJSONObject("progress");
        this.generation = studentObject.getString("generation");
        this.lastLogin = studentObject.getString("lastLogin");
        this.address = studentObject.getJSONObject("address");
        this.classrooms = studentObject.getJSONArray("classrooms");
    }

    // Getter methods
    public String getAddress(){return address.toString();}
    public String getStatus() { return  status; }
    public String getId() { return id; }
    public String getGender() { return gender; }
    public String getPhone() { return phone; }
    public String getProvince() { return province; }
    public String getDistrict() { return district; }
    public String getCommune(){return this.commune;}
    public String getDoB() { return DoB; }
    public String getGuardianFirstName() { return guardianFirstName; }
    public String getGuardianLastName() { return guardianLastName; }
    public String getGuardianGender() { return guardianGender; }
    public String getGuardianPhoneNumber() { return guardianPhoneNumber; }
    public String getSpecialization() { return specialization; }
    public String getDepartment() { return department; }
    public String getGeneration() { return generation; }
    public JSONObject getProgress() { return progress; }
    public String getLastLogin() { return lastLogin; }
    public JSONArray getClassrooms() { return classrooms; }


//    @Override
//    public String toString() {
//        return "Student{" +
//                "id='" + id + '\'' +
//                ", firstName='" + getFirstName() + '\'' +
//                ", lastName='" + getLastName() + '\'' +
//                ", email='" + getEmail() + '\'' +
//                ", gender='" + gender + '\'' +
//                ", phone='" + phone + '\'' +
//                ", province='" + province + '\'' +
//                ", district='" + district + '\'' +
//                ", DoB='" + DoB + '\'' +
//                ", guardianName='" + guardianName + '\'' +
//                ", guardianGender='" + guardianGender + '\'' +
//                ", guardianPhoneNumber='" + guardianPhoneNumber + '\'' +
//                ", specialization='" + specialization + '\'' +
//                ", department='" + department + '\'' +
//                ", generation='" + generation + '\'' +
//                ", progress=" + progress.toString() +
//                '}';
//    }

}
