package main.java.com.lms.managers.layer2.manage_entity_manager;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ManageGenerationManager extends ManageEntityManager {

    public ManageGenerationManager() {
        super();
        setEntityFilePath("shared/data/university.json");
        loadEntity();
    }

    @Override
    public void manageAddEntity(JSONObject newGeneration) {
        JSONArray departments = entityData_Obj.getJSONArray("departments");
        newGeneration.put("groups", new JSONArray());
        newGeneration.put("status", "active");
        for (int i = 0; i < departments.length(); i++) {
            // j for specialization
            for (int j = 0; j < departments.getJSONObject(i).getJSONArray("specializations").length(); j++) {
                departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").put(newGeneration);
            }
        }

        entityData_Obj.put("departments", departments);
        saveEntity();
    }

    @Override
    public void manageDeleteEntity(String genID) {
        // can only delete if the generation has no students/group
        JSONArray departments = entityData_Obj.getJSONArray("departments");
        boolean canDelete = false;
        for (int i = 0; i < departments.length(); i++) {
            for (int j = 0; j < departments.getJSONObject(i).getJSONArray("specializations").length(); j++) {
                for (int k = 0; k < departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").length(); k++) {
                    if (departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getString("id").equals(genID)) {
                        int groupLength = departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").length();
                        if (groupLength == 0) {
                            departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).put("status", "inactive");
                            canDelete = true;
                            continue;
                        }
                        for (int l = 0; l < groupLength; l++) {
                            if (!(departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").getJSONObject(l).getJSONArray("students").isEmpty())) {
                                departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).put("status", "inactive");
                                canDelete = true;
                                continue;
                            }
                        }
                    }
                }
            }
        }
        if (!canDelete) {
            System.out.println("Cannot delete the generation because it has groups with students in it");
            return;
        }
        ;

        entityData_Obj.put("departments", departments);
        saveEntity();
    }

    @Override
    public void manageViewEntity() {
        JSONArray departments = entityData_Obj.getJSONArray("departments");
        for (int i = 0; i < departments.length(); i++) {
            for (int j = 0; j < departments.getJSONObject(i).getJSONArray("specializations").length(); j++) {
                JSONArray generations = departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations");
                System.out.println(generations.toString(4));  // Print once per specialization
            }
        }

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

    public boolean isGenerationIdExist(String genID) {
        JSONArray departments = entityData_Obj.getJSONArray("departments");
        for (int i = 0; i < departments.length(); i++) {
            JSONArray specializations = departments.getJSONObject(i).getJSONArray("specializations");
            for (int j = 0; j < specializations.length(); j++) {
                JSONArray generations = specializations.getJSONObject(j).getJSONArray("generations");
                for (int k = 0; k < generations.length(); k++) {
                    if (generations.getJSONObject(k).getString("id").equals(genID)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public JSONArray getDetails(String genID) {
        JSONArray genDetails = new JSONArray();
        JSONArray departments = entityData_Obj.getJSONArray("departments");
        for (int i = 0; i < departments.length(); i++) {
            JSONArray specializations = departments.getJSONObject(i).getJSONArray("specializations");
            for (int j = 0; j < specializations.length(); j++) {
                JSONArray generations = specializations.getJSONObject(j).getJSONArray("generations");
                for (int k = 0; k < generations.length(); k++) {
                    if (generations.getJSONObject(k).getString("id").equals(genID)) {
                        genDetails.put(generations.getJSONObject(k));
                        break;
                    }
                }
            }
        }
        return genDetails;
    }

    public JSONArray getAllDetails() {
        JSONArray genDetails = new JSONArray();
        JSONArray departments = entityData_Obj.getJSONArray("departments");
        for (int i = 0; i < departments.length(); i++) {
            JSONArray specializations = departments.getJSONObject(i).getJSONArray("specializations");
            for (int j = 0; j < specializations.length(); j++) {
                JSONArray generations = specializations.getJSONObject(j).getJSONArray("generations");
                for (int k = 0; k < generations.length(); k++) {
                    genDetails.put(generations.getJSONObject(k));
                }
            }
        }
        return genDetails;
    }

}