package main.java.com.lmsadmin.managers.layer2.manage_entity_manager;

import org.json.JSONArray;
import org.json.JSONObject;
import ui.UI;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ManageCourseManager extends ManageEntityManager{
    JSONArray courses;

    public ManageCourseManager() {
        super();
        setEntityFilePath("shared/data/university.json");
        loadEntity();
        courses = entityData_Obj.getJSONArray("courses");
    }

    @Override
    public void manageAddEntity(JSONObject newCourse) {
        courses.put(newCourse);
        entityData_Obj.put("courses", courses);
        saveEntity();

    }

    @Override
    public void manageDeleteEntity(String id) {
        for (int i = 0; i < courses.length(); i++) {
            if (courses.getJSONObject(i).getString("id").equals(id)) {
                courses.getJSONObject(i).put("status", "inactive");
                break;
            }
        }
        saveEntity();
    }

    @Override
    public void manageViewEntity() {
        System.out.println("Printed departments");
        System.out.println(UI.TextColor.addColor(courses.toString(4), UI.TextColor.BLUE));
    }

    @Override
    public void loadEntity() {
        // override for the loading of entity because university is object not array
        try {
            content = new String(Files.readAllBytes(Paths.get(filePath)));
            entityData_Obj = new JSONObject(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveEntity() {
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(entityData_Obj.toString(4)); // Pretty-print with 4 spaces
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isCourseIdExist(String id) {
        JSONArray courses = entityData_Obj.getJSONArray("courses");
        for (int i = 0; i < courses.length(); i++) {
            if (courses.getJSONObject(i).getString("id").equals(id)) {
                return true;
            }
        }
        return false;
    }

    public JSONObject getDetails(String id) {
        JSONArray courses = entityData_Obj.getJSONArray("courses");
        for (int i = 0; i < courses.length(); i++) {
            if (courses.getJSONObject(i).getString("id").equals(id)) {
                return courses.getJSONObject(i);
            }
        }
        return null;
    }

    public JSONArray getAllDetails(){
        return entityData_Obj.getJSONArray("courses");
    }
}

