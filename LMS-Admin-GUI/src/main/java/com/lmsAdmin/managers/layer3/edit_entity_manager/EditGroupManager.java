package main.java.com.lmsAdmin.managers.layer3.edit_entity_manager;

import org.json.JSONArray;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EditGroupManager extends EditEntityManager {

    // idToEdit = old ID
    public EditGroupManager(String groupID) {
        super(groupID);
        setIdToEdit(groupID);
    }

    public EditGroupManager() {}

    public String getOldId() {
        String query = "SELECT id FROM student_group WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void manageEditId(String newId) {
        String query = "UPDATE student_group SET id = ? WHERE id = ?";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, newId);
            statement.setString(2, idToEdit);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<String> loadIdsAndName() {
        ArrayList<String> ids = new ArrayList<>();
        String query = "SELECT id FROM student_group";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                ids.add(rs.getString("id"));
            }
            return ids;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ids;
    }
}