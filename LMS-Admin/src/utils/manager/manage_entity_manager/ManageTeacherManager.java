package utils.manager.manage_entity_manager;

public class ManageTeacherManager extends ManageEntityManager{
    public ManageTeacherManager() {
        setEntityFilePath("shared/data/teacher.json");
        loadEntity();
        this.baseID = "T0000";
    }

    public void manageAssignToClassroom(String id, String classId){
        // to be implemented
    }
}