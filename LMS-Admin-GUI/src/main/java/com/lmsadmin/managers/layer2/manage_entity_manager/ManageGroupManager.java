package main.java.com.lmsadmin.managers.layer2.manage_entity_manager;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ManageGroupManager extends ManageEntityManager {

    public ManageGroupManager() {
        super();
        setEntityFilePath("shared/data/university.json");
        loadEntity();
    }

    public void manageAddEntity(String specID, String genID, JSONObject newObj) {
        JSONArray departments = entityData_Obj.getJSONArray("departments");
        newObj.put("students", new JSONArray());
        newObj.put("status", "active");
        newObj.put("classrooms", new JSONArray());

        beginLoop:
        for (int i = 0; i < departments.length(); i++) {
            for (int j = 0; i < departments.getJSONObject(i).getJSONArray("specializations").length(); i++) {
                if (specID.equals(departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getString("id"))) {
                    for (int k = 0; k < departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").length(); k++) {
                        if (departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getString("id").equals(genID)) {
                            departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").put(newObj);
                            break beginLoop;
                        }
                    }
                }
            }
        }
        entityData_Obj.put("departments", departments);
        saveEntity();
    }

    public void manageDeleteEntity(String groupID) {
        JSONArray departments = entityData_Obj.getJSONArray("departments");
        beginLoop:
        for (int i = 0; i < departments.length(); i++) {
            for (int j = 0; i < departments.getJSONObject(i).getJSONArray("specializations").length(); i++) {
                for (int k = 0; k < departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").length(); k++) {
                    for (int l = 0; l < departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").length(); l++) {
                        if (departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").getJSONObject(l).getString("id").equals(groupID)) {
                            departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").getJSONObject(l).put("status", "inactive");
                            break beginLoop;
                        }
                    }
                }
            }
        }
        entityData_Obj.put("departments", departments);
        saveEntity();
    }

    public void manageViewEntity() {
        JSONArray departments = entityData_Obj.getJSONArray("departments");
//        for (int i = 0; i < departments.length(); i++) {
//            for (int j = 0; i < departments.getJSONObject(i).getJSONArray("specializations").length(); i++) {
//                for (int k = 0; k < departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").length(); k++) {
//                    for(int l = 0; l < departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").length(); l++) {
//                        if(departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").getJSONObject(l).getString("id").equals(groupID)) {
//                            System.out.println(departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").getJSONObject(l).toString(4));
//                        }
//                    }
//                }
//            }
//        }
        for (int i = 0; i < departments.length(); i++) {
            for (int j = 0; j < departments.getJSONObject(i).getJSONArray("specializations").length(); j++) {
                for (int k = 0; k < departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").length(); k++) {
                    for (int l = 0; l < departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").length(); l++) {
                        System.out.println(departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").toString(4));
                    }
                }
            }
        }
    }

    public void manageAddStudentToGroup(String groupID, ArrayList<String> studentIDs) {
        JSONArray departments = entityData_Obj.getJSONArray("departments");
        beginLoop:
        for (int i = 0; i < departments.length(); i++) {
            for (int j = 0; j < departments.getJSONObject(i).getJSONArray("specializations").length(); j++) {
                for (int k = 0; k < departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").length(); k++) {
                    for (int l = 0; l < departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").length(); l++) {
                        if (departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").getJSONObject(l).getString("id").equals(groupID)) {
                            for (int m = 0; m < studentIDs.size(); m++) {
                                departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").getJSONObject(l).getJSONArray("students").put(studentIDs.get(m));
                            }
                            break beginLoop;
                        }
                    }
                }
            }
        }
        entityData_Obj.put("departments", departments);
        saveEntity();
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

    public boolean isGroupIDExist(String groupID) {
        JSONArray departments = entityData_Obj.getJSONArray("departments");
        for (int i = 0; i < departments.length(); i++) {
            JSONArray specializations = departments.getJSONObject(i).getJSONArray("specializations");
            for (int j = 0; j < specializations.length(); j++) {
                JSONArray generations = specializations.getJSONObject(j).getJSONArray("generations");
                for (int k = 0; k < generations.length(); k++) {
                    JSONArray groups = generations.getJSONObject(k).getJSONArray("groups");
                    for (int l = 0; l < groups.length(); l++) {
                        if (groups.getJSONObject(l).getString("id").equals(groupID)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public JSONObject getDetails(String groupID) {
        JSONArray departments = entityData_Obj.getJSONArray("departments");
        for (int i = 0; i < departments.length(); i++) {
            JSONArray specializations = departments.getJSONObject(i).getJSONArray("specializations");
            for (int j = 0; j < specializations.length(); j++) {
                JSONArray generations = specializations.getJSONObject(j).getJSONArray("generations");
                for (int k = 0; k < generations.length(); k++) {
                    JSONArray groups = generations.getJSONObject(k).getJSONArray("groups");
                    for (int l = 0; l < groups.length(); l++) {
                        if (groups.getJSONObject(l).getString("id").equals(groupID)) {
                            return groups.getJSONObject(l);
                        }
                    }
                }
            }
        }
        return null;
    }

    public JSONArray getAllDetails(){
        JSONArray gps = new JSONArray();
        JSONArray departments = entityData_Obj.getJSONArray("departments");
        for (int i = 0; i < departments.length(); i++) {
            JSONArray specializations = departments.getJSONObject(i).getJSONArray("specializations");
            for (int j = 0; j < specializations.length(); j++) {
                JSONArray generations = specializations.getJSONObject(j).getJSONArray("generations");
                for (int k = 0; k < generations.length(); k++) {
                    JSONArray groups = generations.getJSONObject(k).getJSONArray("groups");
                    for (int l = 0; l < groups.length(); l++) {
                        gps.put(groups.getJSONObject(l));
                    }
                }

            }
        }
        return gps;
    }


}