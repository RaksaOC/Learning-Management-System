package utils.controller.manage_entity_controller;

import ui.UI;
import utils.controller.edit_entity_controller.EditClassroomController;
import utils.manager.manage_entity_manager.ManageClassroomManager;

public class ManageClassroomController extends ManageEntityController {
    public ManageClassroomController() {
        super();
    }

    @Override
    public void addEntity() {
        System.out.println(UI.TextColor.addColor(UI.Banner.add, UI.TextColor.YELLOW));
        String groupId = prompt("Enter group ID to add to classroom");
        String newClassroomId = prompt("Enter Classroom ID");
        ManageClassroomManager manageClassroomManager = new ManageClassroomManager();
        manageClassroomManager.manageAddEntity(groupId, newClassroomId);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    }

    @Override
    public void deleteEntity() {
        System.out.println(UI.TextColor.addColor(UI.Banner.delete, UI.TextColor.YELLOW));
        ManageClassroomManager manageClassroomManager = new ManageClassroomManager();
        manageClassroomManager.manageDeleteEntity(prompt("Enter Classroom ID"));

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    }

    @Override
    public void editEntity() {
        System.out.println(UI.TextColor.addColor(UI.Banner.edit, UI.TextColor.YELLOW));
        EditClassroomController editClassroomController = new EditClassroomController();
        editClassroomController.editID();

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    }

    @Override
    public void viewEntity() {
        System.out.println(UI.TextColor.addColor(UI.Banner.view, UI.TextColor.YELLOW));

        ManageClassroomManager manageClassroomManager = new ManageClassroomManager();
        manageClassroomManager.manageViewEntity();

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    }

    public void assignTeacherToClassroom() {
        System.out.println(UI.TextColor.addColor(UI.Banner.assignTeacherToClassroom, UI.TextColor.YELLOW));

        String classroomId = prompt("Enter Classroom ID");
        String teacherID = prompt("Enter Teacher ID");
        ManageClassroomManager manageClassroomManager = new ManageClassroomManager();
        manageClassroomManager.manageAssignTeacherToClassroom(classroomId, teacherID);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    }

    public void assignCourseToClassroom() {

        System.out.println(UI.TextColor.addColor(UI.Banner.assignCourseToClassroom, UI.TextColor.YELLOW));

        String classroomId = prompt("Enter Classroom ID");
        String courseID = prompt("Enter course ID");
        ManageClassroomManager manageClassroomManager = new ManageClassroomManager();
        manageClassroomManager.manageAssignCourseToClassroom(classroomId, courseID);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    }
}