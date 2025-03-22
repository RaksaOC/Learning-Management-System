package main.java.com.lmsAdmin.managers.layer3.edit_entity_manager;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EditCourseManager extends EditEntityManager {

    public EditCourseManager(String courseID) {
        super(courseID);
        setIdToEdit(courseID);
    }

    public EditCourseManager() {
        super();
    }

    public void manageEditId(String newID) {
        String query = "UPDATE course SET id=? WHERE id=?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, newID);
            statement.setString(2, idToEdit);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void manageEditName(String newName) {
        String query = "UPDATE course SET name=? WHERE id=?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, newName);
            statement.setString(2, idToEdit);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> loadIdsAndName(){
        ArrayList<String> idsAndName = new ArrayList<>();
        String getCoursesQuery = "SELECT id, name FROM course";
        try(PreparedStatement statement = conn.prepareStatement(getCoursesQuery)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                idsAndName.add(id + " - " + name);
                // sort by name
                Collections.sort(idsAndName, Comparator.comparing(s -> s.substring(s.indexOf("-") + 2)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return idsAndName;
    }

    public String getOldId() {
        String query = "SELECT id FROM course WHERE id = ?";
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
        String query = "SELECT name FROM course WHERE id = ?";
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