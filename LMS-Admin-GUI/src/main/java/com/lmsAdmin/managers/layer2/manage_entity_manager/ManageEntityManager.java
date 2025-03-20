package main.java.com.lmsAdmin.managers.layer2.manage_entity_manager;

import main.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// this controller only handles add, delete and view
// for editing refer to the edit_entity_manager/controller


public abstract class ManageEntityManager {
    protected Connection conn = DatabaseConnection.getInstance().getConnection();
    protected String baseID;

    public ManageEntityManager() {}

    protected String generateNewID(String tableName) {
        try {
            String query = "SELECT COUNT(id) as last_id FROM " + tableName;
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            int newID = 1;
            if (rs.next()) {
                newID = Integer.parseInt(rs.getString("last_id")) + 1;
            }
            String newID_String = newID + "";
            int start = baseID.length() - newID_String.length();

            StringBuilder baseIDBuilder = new StringBuilder(baseID); // Convert to StringBuilder
            StringBuilder newIDBuilder = new StringBuilder(newID_String);
            int j = 0;
            for (int i = start; i < baseID.length(); i++) {
                baseIDBuilder.setCharAt(i, newIDBuilder.charAt(j)); // Set the character at index i
                j++;
            }
            baseID = baseIDBuilder.toString(); // Convert back to string
            return baseID;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}