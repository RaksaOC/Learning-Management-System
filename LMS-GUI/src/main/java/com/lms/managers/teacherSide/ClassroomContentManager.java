package main.java.com.lms.managers.teacherSide;

import main.DatabaseConnection;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;

//interface classroomManagementInterface {
//    void manageAddAssignment();
//
//    void manageEditAssignment();
//
//    void manageDeleteAssignment();
//
//    void manageGradeAssignment();
//
//    void manageAddResource();
//
//    void manageEditResource();
//
//    void manageDeleteResource();
//
//    void manageViewResource();
//
//    // void manageAddQuizz(String title, String createdBy, JSONArray questions);
//
//    void manageEditQuizz();
//

/// /    void manageDeleteQuizz(String id);
//
//    void manageViewQuizz();
//
//
//}

public class ClassroomContentManager {

    protected Connection conn = DatabaseConnection.getInstance().getConnection();
    protected final String classIdToEdit;

    public ClassroomContentManager(String ClassIdToEdit) {
        this.classIdToEdit = ClassIdToEdit; // this holds only the user's input
    }
}
