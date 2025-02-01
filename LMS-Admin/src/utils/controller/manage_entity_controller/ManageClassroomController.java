package utils.controller.manage_entity_controller;

import utils.controller.edit_entity_controller.EditClassroomController;
import utils.manager.manage_entity_manager.ManageClassroomManager;

public class ManageClassroomController extends ManageEntityController {
    public ManageClassroomController() {
        super();
    }

    @Override
    public void addEntity() {
        String groupId = prompt("Enter group ID to add to classroom");
        String newClassroomId = prompt("Enter Classroom ID");
        ManageClassroomManager manageClassroomManager = new ManageClassroomManager();
        manageClassroomManager.manageAddEntity(groupId, newClassroomId);
    }

    @Override
    public void deleteEntity() {
        ManageClassroomManager manageClassroomManager = new ManageClassroomManager();
        manageClassroomManager.manageDeleteEntity(prompt("Enter Classroom ID"));
    }

    @Override
    public void editEntity() {
        EditClassroomController editClassroomController = new EditClassroomController();
        editClassroomController.editID();
    }

    @Override
    public void viewEntity() {
        ManageClassroomManager manageClassroomManager = new ManageClassroomManager();
        manageClassroomManager.manageViewEntity();
    }

    public void assignTeacherToClassroom() {
        String classroomId = prompt("Enter Classroom ID");
        String teacherID = prompt("Enter Teacher ID");
        ManageClassroomManager manageClassroomManager = new ManageClassroomManager();
        manageClassroomManager.manageAssignTeacherToClassroom(classroomId, teacherID);

    }

    public void assignCourseToClassroom() {
        String classroomId = prompt("Enter Classroom ID");
        String courseID = prompt("Enter course ID");
        ManageClassroomManager manageClassroomManager = new ManageClassroomManager();
        manageClassroomManager.manageAssignCourseToClassroom(classroomId, courseID);
    }
}