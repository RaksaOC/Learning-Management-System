package utils.manager.edit_entity_manager;

public class EditClassroomManager extends EditEntityManager {
    public EditClassroomManager(String classroomID) {
        super(classroomID);
        setFilePath("shared/data/classroom.json");
        setEntityID(classroomID); // entuty id to search for is the old groupID
        getEntityData();

    }

    public void setNewID(String newID) {
        this.entityDataToEdit.put("id", newID);
        super.saveEntityData();
    }
}