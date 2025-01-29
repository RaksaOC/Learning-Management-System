package utils.manager.edit_entity_manager;

public class EditAdminManager extends EditEntityManager {

    public EditAdminManager(String idToEdit) {
        super(idToEdit);
        setFilePath("shared/data/admin.json");
        this.baseId = "A000";
        setEntityID(idToEdit);
        getEntityData();

    }

}