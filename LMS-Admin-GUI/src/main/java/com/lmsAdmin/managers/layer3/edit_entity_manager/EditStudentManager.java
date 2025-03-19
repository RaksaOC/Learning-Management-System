package main.java.com.lmsAdmin.managers.layer3.edit_entity_manager;

import com.mysql.cj.jdbc.result.UpdatableResultSet;
import main.DatabaseConnection;
import org.json.JSONObject;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EditStudentManager extends EditEntityManager {

    private Connection conn = DatabaseConnection.getInstance().getConnection();

    public EditStudentManager(String idToEdit) {
        super(idToEdit);
        setFilePath("shared/data/student.json");
        this.baseId = "S000000";
        setIdToEdit(idToEdit);
        loadEntityDataToEdit();
    }

    public EditStudentManager() {
        setFilePath("shared/data/student.json");
        this.baseId = "S000000";
        loadEntityDataToEdit();
    }

    public String getOldPhoneSql(){
        String query = "SELECT phone_number FROM student WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("phone_number");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getOldEmailSql(){
        String query = "SELECT email FROM student WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("email");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getOldCommuneSql() {
        String query = "SELECT commune FROM student WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("commune");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getOldDistrictSql() {
        String query = "SELECT district FROM student WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("district");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getOldProvinceSql() {
        String query = "SELECT province FROM student WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("province");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public String getOldGenderSql() {
        String query = "SELECT gender FROM student WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("gender");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getOldDoBSql() {
        String query = "SELECT dob FROM student WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("dob");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getOldDepartmentSql() {
        String query = "SELECT department_id FROM student WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("department");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getOldSpecializationSql() {
        String query = "SELECT specialization_id FROM student WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("specialization");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public String getOldGuardianSql() {
//        String query = "SELECT guardian_first_name, guardian_last_name, guardian_gender, guardian_phone_number FROM student WHERE id = ?";
//        try (PreparedStatement statement = conn.prepareStatement(query)) {
//            statement.setString(1, idToEdit);
//            ResultSet rs = statement.executeQuery();
//            if (rs.next()) {
//                return "Guardian: " + rs.getString("guardian_first_name") + rs.getString("guardian_last_name") + " Gender: " + rs.getString("guardian_gender") + " Phone: " + rs.getString("guardian_phone_number");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public String getOldFirstNameSql() {
        String query = "SELECT first_name FROM student WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("first_name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getOldLastNameSql() {
        String query = "SELECT last_name FROM student WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("last_name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getOldGuardianFirstNameSql() {
        String query = "SELECT guardian_first_name FROM student WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("guardian_first_name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getOldGuardianLastNameSql() {
        String query = "SELECT guardian_last_name FROM student WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("guardian_last_name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getOldGuardianGenderSql() {
        String query = "SELECT guardian_gender FROM student WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("guardian_gender");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getOldGuardianPhoneSql() {
        String query = "SELECT guardian_phone_number FROM student WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("guardian_phone");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public String getOldAddress() {
        JSONObject oldAddress = this.entityDataToEdit.getJSONObject("address");
        return "District: " + oldAddress.getString("district") + "Province: " + oldAddress.getString("province");
    }

    public String getOldGender() {
        return this.entityDataToEdit.getString("gender");
    }

    public String getOldDoB() {
        return this.entityDataToEdit.getString("dob");
    }

    public String getOldDepartment() {
        return this.entityDataToEdit.getString("department");
    }

    public String getOldSpecialization() {
        return this.entityDataToEdit.getString("specialization");
    }

    public String getOldGuardian() {
        JSONObject guardian = this.entityDataToEdit.getJSONObject("guardian");
        return "Guardian: " + guardian.getString("name") + "Gender: " + guardian.getString("gender") + "Phone: " + guardian.getString("phone");
    }

    public String getOldFirstName() {
        return this.entityDataToEdit.getJSONObject("name").getString("firstname");
    }

    public String getOldLastName() {
        return this.entityDataToEdit.getJSONObject("name").getString("lastname");
    }

    public String getOldGuardianFirstName() {
        return this.entityDataToEdit.getJSONObject("guardian").getJSONObject("name").getString("firstName");
    }

    public String getOldGuardianLastName() {
        return this.entityDataToEdit.getJSONObject("guardian").getJSONObject("name").getString("lastName");
    }

    public String getOldGuardianGender() {
        return this.entityDataToEdit.getJSONObject("guardian").getString("gender");
    }

    public String getOldGuardianPhone() {
        return this.entityDataToEdit.getJSONObject("guardian").getString("phone");
    }

    public void manageEditAddressSql(String commune, String district, String province) {
        String query = "UPDATE student SET commune = ?, district = ?, province = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, commune);
            stmt.setString(2, district);
            stmt.setString(3, province);
            stmt.setString(4, idToEdit);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void manageEditGenderSql(String newGender) {
        String query = "UPDATE student SET gender = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newGender);
            stmt.setString(2, idToEdit);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void manageEditDoBSql(String newDoB) {
        String query = "UPDATE student SET dob = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newDoB);
            stmt.setString(2, idToEdit);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void manageEditDepartmentSql(String newDepartment) {
        String query = "UPDATE student SET department_id = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newDepartment);
            stmt.setString(2, idToEdit);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void manageEditNameSql(String firstName, String lastName) {
        String query = "UPDATE student SET first_name = ?, last_name = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, idToEdit);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void manageEditPhoneSql(String newPhone) {
        String query = "UPDATE student SET phone_number = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newPhone);
            stmt.setString(2, idToEdit);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void manageEditPasswordSql(String newPassword) {
        String query = "UPDATE student SET password = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newPassword);
            stmt.setString(2, idToEdit);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void manageEditSpecializationSql(String newSpecialization) {
        String query = "UPDATE student SET specialization_id = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newSpecialization);
            stmt.setString(2, idToEdit);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void manageEditGuardianSql(String guardianFirstName, String guardianLastName, String guardianGender, String guardianPhone) {
        String query = "UPDATE student SET guardian_first_name = ?, guardian_last_name = ?, guardian_gender = ?, guardian_phone_number = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, guardianFirstName);
            stmt.setString(2, guardianLastName);
            stmt.setString(3, guardianGender);
            stmt.setString(4, guardianPhone);
            stmt.setString(5, idToEdit);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void manageEditAddress(JSONObject newAddress) {
        this.entityDataToEdit.put("address", newAddress);
        saveEntityData();
    }

    public void manageEditGender(String newGender) {
        this.entityDataToEdit.put("gender", newGender);
        saveEntityData();
    }

    public void manageEditDOB(String newDoB) {
        this.entityDataToEdit.put("dob", newDoB);
        saveEntityData();
    }

    public void manageEditDepartment(String newDepartment) {
        this.entityDataToEdit.put("department", newDepartment);
        saveEntityData();
    }

    public void manageEditName(JSONObject newName) {
        this.entityDataToEdit.put("name", newName);
        saveEntityData();
    }

    public void manageEditPhone(String newPhone) {
        this.entityDataToEdit.put("phoneNumber", newPhone);
        saveEntityData();
    }

    public void manageEditPassword(String newPassword) {
        this.entityDataToEdit.put("password", newPassword);
        saveEntityData();
    }

    public void manageEditSpecialization(String newSpecialization) {
        this.entityDataToEdit.put("specialization", newSpecialization);
        saveEntityData();
    }

    public void manageEditGuardian(JSONObject newGuardian) {
        this.entityDataToEdit.put("guardian", newGuardian);
        saveEntityData();
    }

    public boolean isOldPasswordMatched(String oldPassword) {
        return this.entityDataToEdit.getString("password").equals(oldPassword);
    }


    public String getOldCommune() {
        return this.entityDataToEdit.getJSONObject("address").getString("commune");
    }

    public String getOldDistrict() {
        return this.entityDataToEdit.getJSONObject("address").getString("district");
    }

    public String getOldProvince() {
        return this.entityDataToEdit.getJSONObject("address").getString("province");
    }

    public ArrayList<String> loadIdsAndNameJSON() {
        ArrayList<String> ids = new ArrayList<>();
        for (int i = 0; i < this.entityData_Arr.length(); i++) {
            ids.add(this.entityData_Arr.getJSONObject(i).getString("id"));
        }
        return ids;
    }

    public ArrayList<String> loadIdsAndNameSql() {
        ArrayList<String> ids = new ArrayList<>();
        String query = "SELECT id, CONCAT(first_name, last_name) as name FROM student";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.execute();
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                ids.add(rs.getString("id") + " - " + rs.getString("name"));
            }
            return ids;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return ids;
    }

}