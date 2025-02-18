package main.java.com.lmsadmin.managers.manage_entity_manager;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ManageClassroomManager extends ManageEntityManager {
    public ManageClassroomManager() {
        setEntityFilePath("shared/data/classroom.json");
        loadEntity(); // this would get the classroom.json data only
    }

    public void manageAddEntity(String groupID, String newClassroomID) {
        // works with 2 files (classroom file and university file)
        JSONObject newClassroom = new JSONObject();
        newClassroom.put("id", newClassroomID);
        newClassroom.put("courseId", "");
        newClassroom.put("teacherId", "");
        newClassroom.put("status", "active");
        newClassroom.put("students", getStudentsFromGroup(groupID));
        newClassroom.put("assignments", new JSONArray());
        newClassroom.put("resources", new JSONArray());
        newClassroom.put("quizzes", new JSONArray());
        entityData.put(newClassroom);
        createProgress(newClassroom.getString("id"), newClassroom.getJSONArray("students")); // handles saving to student.json and progress.json
        addToClassroomInUni(groupID, newClassroomID); // handles the saving in the function
        setClassroomToTeacher(newClassroomID, newClassroom.getString("teacherId"));
        saveEntity(); // this only saves to the classroom.json file
    }

    public void manageDeleteEntity(String classroomID) {
        for (int i = 0; i < entityData.length(); i++) {
            if (entityData.getJSONObject(i).getString("id").equals(classroomID)) {
                entityData.getJSONObject(i).put("status", "inactive");
                break;
            }
        }
        saveEntity(); // saves to classroom.json
        deleteClassroomFromUni(classroomID);// handles the saving
    }

    @Override
    public void manageViewEntity() {
        System.out.println(entityData.toString(4));
    }

    public void manageAssignTeacherToClassroom(String classroomID, String teacherID) {
        for (int i = 0; i < entityData.length(); i++) {
            if (entityData.getJSONObject(i).getString("id").equals(classroomID)) {
                entityData.getJSONObject(i).put("teacherId", teacherID);
                break;
            }
        }
        saveEntity();
    }

    private void setClassroomToTeacher(String classroomID, String teacherID) {
        try{
            String content = new String(Files.readAllBytes(Paths.get("shared/data/teacher.json")));
            JSONArray teachers = new JSONArray(content);
            for (int i = 0; i < teachers.length(); i++) {
                if (teachers.getJSONObject(i).getString("id").equals(teacherID)) {
                    teachers.getJSONObject(i).getJSONArray("classrooms").put(classroomID);
                    break;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private JSONArray getStudentsFromGroup(String groupID) {
        JSONArray dep = loadDepartment();

        for (int i = 0; i < dep.length(); i++) {
            for (int j = 0; j < dep.getJSONObject(i).getJSONArray("specializations").length(); j++) {
                for (int k = 0; k < dep.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").length(); k++) {
                    for (int m = 0; m < dep.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").length(); m++) {
                        if (dep.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").getJSONObject(m).getString("id").equals(groupID)) {
                            return dep.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").getJSONObject(m).getJSONArray("students");
                        }
                    }
                }
            }
        }
        return null;
    }

    private void createProgress(String classroomID, JSONArray studentsFromGroup) {
        // create a progress in student
        // create progress in progress.json
        try {
            this.content = new String(Files.readAllBytes(Paths.get("shared/data/classroom.json")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONArray progress = new JSONArray(content);

        JSONObject newProgress = new JSONObject();
        newProgress.put("classroomId", classroomID);
        newProgress.put("assignments", new JSONArray());
        newProgress.put("resources", new JSONArray());
        newProgress.put("quizzes", new JSONArray());

        for (int i = 0; i < studentsFromGroup.length(); i++) {
            newProgress.put("studentId", studentsFromGroup.getString(i));
            newProgress.put("id", generateNewProgressId(progress.length() + i));
            progress.put(newProgress);
        }

        try{
            this.content = new String(Files.readAllBytes(Paths.get("shared/data/student.json")));
        }catch(IOException e){
            e.printStackTrace();
        }

        JSONArray allStudents = new JSONArray(content);

        for (int i = 0; i < allStudents.length(); i++) {
            for(int j = 0; j < studentsFromGroup.length(); j++){
                if(allStudents.getJSONObject(i).getString("id").equals(studentsFromGroup.getString(j))){
                    allStudents.getJSONObject(i).getJSONObject("progress").put(classroomID, newProgress.getString("id"));
                }
            }
        }

        try (FileWriter file = new FileWriter("shared/data/progress.json")) {
            file.write(progress.toString(4)); // Pretty-print with 4 spaces
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }try (FileWriter file = new FileWriter("shared/data/student.json")) {
            file.write(allStudents.toString(4)); // Pretty-print with 4 spaces
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void manageAssignCourseToClassroom(String classroomID, String courseID) {
        for (int i = 0; i < entityData.length(); i++) {
            if (entityData.getJSONObject(i).getString("id").equals(classroomID)) {
                entityData.getJSONObject(i).put("courseId", courseID);
            }
        }
        saveEntity();
    }

    private void addToClassroomInUni(String groupID, String classroomID) {
        JSONArray dep = loadDepartment();
        beginLoop:
        for (int i = 0; i < dep.length(); i++) {
            for (int j = 0; j < dep.getJSONObject(i).getJSONArray("specializations").length(); j++) {
                for (int k = 0; k < dep.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").length(); k++) {
                    for (int l = 0; l < dep.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").length(); l++) {
                        if (dep.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").getJSONObject(l).getString("id").equals(groupID)) {
                            dep.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").getJSONObject(l).getJSONArray("classrooms").put(classroomID);
                            break beginLoop;
                        }
                    }
                }
            }
        }
        saveEntityToUni(dep);
    }

    private void deleteClassroomFromUni(String classroomID) {
        JSONArray dep = loadDepartment();
        beginLoop:
        for (int i = 0; i < dep.length(); i++) {
            for (int j = 0; j < dep.getJSONObject(i).getJSONArray("specializations").length(); j++) {
                for (int k = 0; k < dep.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").length(); k++) {
                    for (int l = 0; l < dep.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").length(); l++) {
                        for (int m = 0; m < dep.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").getJSONObject(l).getJSONArray("classrooms").length(); m++) {
                            if (dep.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").getJSONObject(l).getJSONArray("classrooms").get(m).equals(classroomID)) {
                                dep.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").getJSONObject(l).getJSONArray("classrooms").remove(m);
                                break beginLoop;
                            }
                        }
                    }
                }
            }
        }
        saveEntityToUni(dep);
    }

    private JSONArray loadDepartment() {
        String uniFilePath = "shared/data/university.json";
        try {
            this.content = new String(Files.readAllBytes(Paths.get(uniFilePath)));
            JSONObject uni = new JSONObject(content);
            JSONArray departments = uni.getJSONArray("departments");
            return departments;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void saveEntityToUni(JSONArray departments) {
        // load uni
        String uniFilePath = "shared/data/university.json";
        JSONObject uni = new JSONObject();
        try {
            this.content = new String(Files.readAllBytes(Paths.get(uniFilePath)));
            uni = new JSONObject(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // put department into uni
        uni.put("departments", departments);

        // write uni back
        try (FileWriter file = new FileWriter("shared/data/university.json")) {
            file.write(uni.toString(4)); // Pretty-print with 4 spaces
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isClassroomIDExist(String classroomID) {
        for (int i = 0; i < entityData.length(); i++) {
            if (entityData.getJSONObject(i).getString("id").equals(classroomID)) {
                return true;
            }
        }
        return false;
    }

    private String generateNewProgressId(int lastId){
        String baseId = "P000001";
        String string_lastId = String.valueOf(lastId);
        int start = baseId.length() - string_lastId.length();
        int end = baseId.length();
        int j = 0;
        StringBuilder base = new StringBuilder(baseId);
        StringBuilder last = new StringBuilder(string_lastId);
        for(int i = start; i <= end; i++){
            base.setCharAt(i, last.charAt(j));
            j++;
        }
        baseId = base.toString();
        return baseId;
    }
}