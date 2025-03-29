package main.java.com.lmsAdmin.managers.layer3.edit_entity_manager.utils;

import main.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CambodiaAdministrative {
    Connection conn = DatabaseConnection.getInstance().getConnection();
    private ArrayList<String> provinces;
    private ArrayList<String> districts;
    private ArrayList<String> communes;

    public ArrayList<String> getProvinces() {
        String query = "SELECT DISTINCT province FROM administrative";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            ResultSet rs = statement.executeQuery();
            provinces = new ArrayList<>();
            while(rs.next()){
                provinces.add(rs.getString("province"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        Collections.sort(provinces);
        return provinces;
    }

    public ArrayList<String> getDistricts(String province) {
        String query = "SELECT DISTINCT district FROM administrative where province = ?";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, province);
            ResultSet rs = statement.executeQuery();
            districts = new ArrayList<>();
            while(rs.next()){
                districts.add(rs.getString("district"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        Collections.sort(districts);
        return districts;
    }

    public ArrayList<String> getCommunes(String district, String province) {
        String query = "SELECT DISTINCT commune FROM administrative WHERE district = ? AND province = ?";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, district);
            statement.setString(2, province);
            ResultSet rs = statement.executeQuery();
            communes = new ArrayList<>();
            while(rs.next()){
                communes.add(rs.getString("commune"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        Collections.sort(communes);
        return communes;
    }
}
