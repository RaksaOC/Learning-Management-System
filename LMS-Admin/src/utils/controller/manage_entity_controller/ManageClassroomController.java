package utils.controller.manage_entity_controller;

import ui.UI;
import utils.controller.edit_entity_controller.EditClassroomController;
import utils.manager.manage_entity_manager.ManageClassroomManager;
import utils.manager.manage_entity_manager.ManageDepartmentManager;
import utils.manager.manage_entity_manager.ManageGroupManager;
import utils.manager.manage_entity_manager.ManageTeacherManager;

public class ManageClassroomController extends ManageEntityController {
    public ManageClassroomController() {
        super();
    }

    @Override
    public void addEntity() {
        System.out.println(UI.TextColor.addColor(UI.Banner.add, UI.TextColor.YELLOW));

        String groupId;
        ManageGroupManager gm = new ManageGroupManager();
        boolean isExist = false;
        do {
            groupId = prompt("Enter group ID to add to classroom");
            if (gm.isGroupIDExist(groupId)) isExist = true;
            else System.out.println(UI.TextColor.addColor("\nInvalid Group ID\n", UI.TextColor.RED));
        } while (!isExist);

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
        String classroomId;
        do {
            classroomId = prompt("Enter Classroom ID");
            if (manageClassroomManager.isClassroomIDExist(classroomId)) break;
            else System.out.println(UI.TextColor.addColor("\nInvalid Classroom ID\n", UI.TextColor.RED));
        } while (!manageClassroomManager.isClassroomIDExist(classroomId));
        manageClassroomManager.manageDeleteEntity(classroomId);

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

        String classroomId;
        ManageClassroomManager manageClassroomManager = new ManageClassroomManager();
        do {
            classroomId = prompt("Enter Classroom ID");
            if (manageClassroomManager.isClassroomIDExist(classroomId)) break;
            else System.out.println(UI.TextColor.addColor("\nInvalid Classroom ID\n", UI.TextColor.RED));
        } while (!manageClassroomManager.isClassroomIDExist(classroomId));
        String teacherID;
        ManageTeacherManager manageTeacherManager = new ManageTeacherManager();
        do {
            teacherID = prompt("Enter Teacher ID");
            if (manageTeacherManager.isTeacherIdExist(teacherID)) break;
            else System.out.println(UI.TextColor.addColor("\nInvalid Teacher ID\n", UI.TextColor.RED));
        } while (!manageTeacherManager.isTeacherIdExist(teacherID));

        manageClassroomManager.manageAssignTeacherToClassroom(classroomId, teacherID);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    }

    public void assignCourseToClassroom() {

        System.out.println(UI.TextColor.addColor(UI.Banner.assignCourseToClassroom, UI.TextColor.YELLOW));
        String classroomId;
        ManageClassroomManager manageClassroomManager = new ManageClassroomManager();
        do {
            classroomId = prompt("Enter Classroom ID");
            if (manageClassroomManager.isClassroomIDExist(classroomId)) break;
            else System.out.println(UI.TextColor.addColor("\nInvalid Generation ID\n", UI.TextColor.RED));
        } while (!manageClassroomManager.isClassroomIDExist(classroomId));

        String courseID;
        // course id validation lives in department manager
        ManageDepartmentManager manageDepartmentManager = new ManageDepartmentManager();
        do {
            courseID = prompt("Enter course ID");
            if (manageDepartmentManager.isCourseIdExist(courseID)) break;
            else System.out.println(UI.TextColor.addColor("\nInvalid Generation ID\n", UI.TextColor.RED));
        } while (!manageDepartmentManager.isCourseIdExist(courseID));
        manageClassroomManager.manageAssignCourseToClassroom(classroomId, courseID);

        String successBanner = UI.TextColor.addColor(UI.Banner.success, UI.TextColor.GREEN);
        System.out.println(successBanner);
    }
}