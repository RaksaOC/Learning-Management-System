package utils.manager.manage_entity_manager;

public class ManageStudentManager extends ManageEntityManager{
    public ManageStudentManager() {
        setEntityFilePath("shared/data/student.json");
        loadEntity();
        this.baseID = "S000000";
    }
}