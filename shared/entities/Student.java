package entities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Student extends User {
    private  String id;
    private  String gender;
    private  String phone;
    private  String province;
    private  String district;
    private  String commune;
    private  String DoB;
    private  String guardianFirstName;
    private  String guardianLastName;
    private  String guardianGender;
    private  String guardianPhoneNumber;
    private  String specialization;
    private  String department;
    private  String createdAt;
    private  String group;
    private  JSONObject progress;
    private  String generation;
    private  String status;
    private  JSONArray classrooms;
    private  String lastLogin;
    private  JSONObject address;

    public Student(String id,
                   String first_name,
                   String last_name,
                   String gender,
                   String dob,
                   String phone_number,
                   String email,
                   String password,
                   String commune,
                   String district,
                   String province,
                   String status,
                   String created_at,
                   String last_login,
                   String department_id,
                   String specialization_id,
                   String generation_id,
                   String group_id,
                   String guardian_first_name,
                   String guardian_last_name,
                   String guardian_phone_number,
                   String guardian_gender){
        this.id = id;
        this.firstName = first_name;
        this.lastName = last_name;
        this.gender = gender;
        this.DoB = dob;
        this.phone = phone_number;
        this.email = email;
        this.password = password;
        this.commune = commune;
        this.district = district;
        this.province = province;
        this.status = status;
        this.lastLogin = last_login;
        this.createdAt = created_at;
        this.department = department_id;
        this.specialization = specialization_id;
        this.generation = generation_id;
        this.group = group_id;
        this.guardianFirstName = guardian_first_name;
        this.guardianLastName = guardian_last_name;
        this.guardianPhoneNumber = guardian_phone_number;
        this.guardianGender = guardian_gender;
    }

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
    public String getEmail(){return email;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
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
    public String getLastLogin() { return lastLogin; }
    public String getCreatedAt() { return createdAt; }
    public String getGroup() { return group; }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", DoB='" + DoB + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", commune='" + commune + '\'' +
                ", district='" + district + '\'' +
                ", province='" + province + '\'' +
                ", status='" + status + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", lastLogin='" + lastLogin + '\'' +
                ", department='" + department + '\'' +
                ", specialization='" + specialization + '\'' +
                ", generation='" + generation + '\'' +
                ", group='" + group + '\'' +
                ", guardianFirstName='" + guardianFirstName + '\'' +
                ", guardianLastName='" + guardianLastName + '\'' +
                ", guardianPhoneNumber='" + guardianPhoneNumber + '\'' +
                ", guardianGender='" + guardianGender + '\'' +
                '}';
    }

}
