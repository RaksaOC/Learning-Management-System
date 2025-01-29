package utils.manager.manage_entity_manager;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ManageSpecializationManager extends ManageEntityManager{

    private JSONArray specializations;

    public ManageSpecializationManager() {
        super();
        setEntityFilePath("shared/data/university.json");
        loadEntity();
    }

    public void manageAddEntity(String dep_id, JSONObject newSpecialization) {
        getSpecializations(dep_id);
        newSpecialization.put("dep_id", dep_id);
        newSpecialization.put("status", "active");
        specializations.put(newSpecialization);
        saveEntity();
    }

    public void manageDeleteEntity(String dep_id, String spec_id) {
        getSpecializations(dep_id);
        for(int i = 0; i<specializations.length(); i++) {
            if(specializations.getJSONObject(i).getString("id").equals(spec_id)) {
                specializations.getJSONObject(i).put("status", "inactive");
                break;
            }
        }
        saveEntity();
    }

    public void manageViewEntity(String dep_id) {
        getSpecializations(dep_id);
        System.out.println(specializations.toString(4));
    }

    @Override
    public void loadEntity(){
        // override for the loading of entity because university is object not array
        try{
            content = new String(Files.readAllBytes(Paths.get(filePath)));
            entityData_Obj = new JSONObject(content);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void saveEntity(){
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(entityData_Obj.toString(4)); // Pretty-print with 4 spaces
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getSpecializations(String dep_id){
        JSONArray departments = entityData_Obj.getJSONArray("departments");
        for(int i = 0; i<departments.length(); i++) {
            if(departments.getJSONObject(i).getString("id").equals(dep_id)) {
                specializations = departments.getJSONObject(i).getJSONArray("specializations");
                break;
            }
        }
    }
}