package main.java.com.lmsAdmin.managers.layer3.edit_entity_manager;

import main.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EditClassroomManager extends EditEntityManager {
    private Connection conn = DatabaseConnection.getInstance().getConnection();
    public EditClassroomManager(String classroomID) {
        super(classroomID);
        setFilePath("shared/data/classroom.json");
        setIdToEdit(classroomID); // entuty id to search for is the old groupID
        loadEntityDataToEdit();
    }

    public EditClassroomManager() {
        super();
        setFilePath("shared/data/classroom.json");
        loadEntityDataToEdit();
    }

    public void manageEditId(String newID) {
        this.entityDataToEdit.put("id", newID);
        super.saveEntityData();
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

    public ArrayList<String> loadIds() {
        ArrayList<String> ids = new ArrayList<>();
        for(int i = 0 ; i < entityData_Arr.length(); i++){
            ids.add(entityData_Arr.getJSONObject(i).getString("id"));
        }
        return ids;
    }

    public String getOldID(){
        return entityDataToEdit.getString("id");
    }

    public String getOldIdSql(){
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