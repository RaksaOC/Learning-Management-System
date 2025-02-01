package utils.manager.manage_entity_manager;

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
        entityData.put(newClassroom);
        addToClassroomInUni(groupID, newClassroomID); // handles the saving in the function
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

    public JSONArray getStudentsFromGroup(String groupID) {
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

    public void saveEntityToUni(JSONArray departments) {
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
}