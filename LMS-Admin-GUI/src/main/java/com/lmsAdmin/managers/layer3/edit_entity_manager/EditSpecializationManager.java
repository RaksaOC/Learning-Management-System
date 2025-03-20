package main.java.com.lmsAdmin.managers.layer3.edit_entity_manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EditSpecializationManager extends EditEntityManager {

    public EditSpecializationManager(String idToEdit) {
        super(idToEdit);
        setIdToEdit(idToEdit);
    }

    public EditSpecializationManager() {
    }

    public void manageEditId(String newId){
        String query = "UPDATE specialization SET id = ? WHERE id = ?";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, newId);
            statement.setString(2, idToEdit);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void manageEditName(String newId){
        String query = "UPDATE specialization SET name = ? WHERE id = ?";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, newId);
            statement.setString(2, idToEdit);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<String> loadIdsAndName(){
        ArrayList<String> ids = new ArrayList<>();
        String query = "SELECT id, name FROM specialization";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                ids.add(rs.getString("id") + " - " + rs.getString("name"));
            }
            return ids;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return ids;
    }

    public String getOldId() {
        String query = "SELECT id FROM specialization WHERE id = ?";
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

    public String getOldName() {
        String query = "SELECT name FROM specialization WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}