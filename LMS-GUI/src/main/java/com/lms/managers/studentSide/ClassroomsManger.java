package main.java.com.lms.managers.studentSide;

import main.AppSession;
import main.DatabaseConnection;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClassroomsManger {
    private Connection conn = DatabaseConnection.getInstance().getConnection();

    public ArrayList<String> getAllClassrooms(){
        ArrayList<String> classrooms = new ArrayList<>();
        String query = "SELECT classroom_id as id_name FROM progress WHERE student_id = ?";
//        String query = "SELECT CONCAT(cl.id, ' - ', c.name) AS id_name " +
//                "FROM progress p " +
//                "JOIN classroom as cl " +
//                "ON p.classroom_id = cl.id " +
//                "JOIN course as c " +
//                "ON cl.course_id = c.id " +
//                "WHERE p.student_id = ?";
        try(PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, AppSession.getInstance().getStudent().getId());
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                classrooms.add(resultSet.getString("id_name"));
            }
            return classrooms;
        }catch (Exception e){
            e.printStackTrace();
        }
        return classrooms;
    }
}