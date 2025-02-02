package utils.manager.manage_entity_manager;

public class ManageTeacherManager extends ManageEntityManager {
    public ManageTeacherManager() {
        setEntityFilePath("shared/data/teacher.json");
        loadEntity();
        this.baseID = "T0000";
    }

    public boolean isTeacherIdExist(String teacherId) {
        for (int i = 0; i < entityData.length(); i++) {
            if (entityData.getJSONObject(i).getString("id").equals(teacherId)) {
                return true;
            }
        }
        return false;
    }


}