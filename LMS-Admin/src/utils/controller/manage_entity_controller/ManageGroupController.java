package utils.controller.manage_entity_controller;

import org.json.JSONObject;
import utils.controller.edit_entity_controller.EditGroupController;
import utils.manager.manage_entity_manager.ManageSpecializationManager;
import utils.manager.manage_entity_manager.ManageGroupManager;
import utils.menu.Menu;

import java.util.ArrayList;

public class ManageGroupController extends ManageEntityController {
    ManageSpecializationManager manageSpecializationManager;

    @Override
    public void addEntity() {
        manageSpecializationManager = new ManageSpecializationManager();
        String specID = inputSpecialiaztionID();
        String genID = prompt("Enter generation ");
        String groupID = prompt("Enter Group ID");

        JSONObject newGroup = new JSONObject();
        newGroup.put("id", groupID);
        ManageGroupManager manageGroupManager = new ManageGroupManager();
        manageGroupManager.manageAddEntity(specID, genID, newGroup);
    }

    @Override
    public void editEntity() {
        Menu menu = new Menu();
        EditGroupController editGroupController = new EditGroupController();
        editGroupController.editID();
    }

    @Override
    public void deleteEntity() {
//        String spec_id = inputSpecialiaztionID();
        ManageGroupManager manageGroupManager = new ManageGroupManager();
        // input the group id by giving spec_id to check
//        String group_id = inputGroupID(spec_id);
        String groupID = prompt("Enter Group ID");

        // given the spec id and group mark the group id as inactive
        manageGroupManager.manageDeleteEntity(groupID);
    }

    @Override
    public void viewEntity() {
        ManageGroupManager manageGroupManager = new ManageGroupManager();
        manageGroupManager.manageViewEntity();
    }

    public void addStudentsToGroup() {
        ManageGroupManager manageGroupManager = new ManageGroupManager();
        int numOfStudentsToAdd = 0;
        ArrayList<String> studentIds = new ArrayList<String>();
        String groupID = prompt("Enter Group ID");
        numOfStudentsToAdd = Integer.parseInt(prompt("Enter number of students to add"));
        for (int i = 0; i < numOfStudentsToAdd; i++) {
            String studentID = prompt("Enter Student ID");
            studentIds.add(studentID);
        }
        manageGroupManager.manageAddStudentToGroup(groupID, studentIds);
    }

    private String inputSpecialiaztionID() {
        boolean isExist = false;
        String id;
        ManageSpecializationManager manageSpecializationManager;
        do {
            id = prompt("Enter Specialization ID");
            manageSpecializationManager = new ManageSpecializationManager();
            if (manageSpecializationManager.isSpecializationExist(id)) {
                isExist = true;
            } else {
                System.out.println("Specialization does not exist");
            }
        } while (!isExist);
        return id;
    }

//    private String inputGroupID(String specID) {
//        boolean isExist = false;
//        String groupID;
//        ManageGroupManager manageGroupManager;
//        do{
//            groupID = prompt("Enter Group ID");
//            manageGroupManager = new ManageGroupManager();
//            if(manageGroupManager.isGroupIDExist(specID, groupID)){
//                isExist = true;
//            }
//            else{
//                System.out.println("Group ID does not exist");
//            }
//        } while (!isExist);
//        return groupID;
//    }
}