package main.java.com.lmsAdmin.managers.layer3.edit_entity_manager;

import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class EditClassroomManager extends EditEntityManager {
    public EditClassroomManager(String classroomID) {
        super(classroomID);
        setIdToEdit(classroomID);
    }

    public EditClassroomManager() {
        super();
    }

    public void manageEditIdSql(String newID) {
        String query = "UPDATE classroom SET id=? WHERE id=?";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, newID);
            statement.setString(2, idToEdit);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<String> loadIds(){
        String query = "SELECT * FROM classroom WHERE id=?";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            ArrayList<String> ids = new ArrayList<>();
            while(rs.next()){
                ids.add(rs.getString("id"));
            }
            Collections.sort(ids);
            return ids;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public String getOldId(){
        String query = "SELECT id FROM classroom WHERE id=?";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, idToEdit);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                return rs.getString("id");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}