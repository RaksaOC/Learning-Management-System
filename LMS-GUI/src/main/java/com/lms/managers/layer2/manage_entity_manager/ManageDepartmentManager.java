package main.java.com.lms.managers.layer2.manage_entity_manager;

import org.json.JSONArray;
import org.json.JSONObject;
import ui.UI;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ManageDepartmentManager extends ManageEntityManager {

    JSONArray departments;

    public ManageDepartmentManager() {
        super();
        setEntityFilePath("shared/data/university.json");
        loadEntity();
        departments = new JSONArray();
        departments = entityData_Obj.getJSONArray("departments");
    }

    @Override
    public void manageAddEntity(JSONObject newDepartment) {
        newDepartment.put("specializations", new JSONArray());
        newDepartment.put("status", "active");
        departments.put(newDepartment);
        entityData_Obj.put("departments", departments);
        saveEntity();
    }

    @Override
    public void manageDeleteEntity(String id) {
        for (int i = 0; i < departments.length(); i++) {
            if (departments.getJSONObject(i).getString("id").equals(id)) {
                departments.getJSONObject(i).put("status", "inactive");
                break;
            }
        }
        saveEntity();
    }

    @Override
    public void manageViewEntity() {
        System.out.println("Printed departments");
        System.out.println(UI.TextColor.addColor(departments.toString(4), UI.TextColor.BLUE));
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

    // helper unique to department
    public boolean isDepartmentExist(String id) {
        for (int i = 0; i < departments.length(); i++) {
            if (departments.getJSONObject(i).getString("id").equals(id)) {
                return true;
            }
        }
        return false;
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
        for (int i = 0; i < departments.length(); i++) {
            if (departments.getJSONObject(i).getString("id").equals(id)) {
                return departments.getJSONObject(i);
            }
        }
        return null;
    }

    public JSONArray getAllDetails(){
        return departments;
    }


}
