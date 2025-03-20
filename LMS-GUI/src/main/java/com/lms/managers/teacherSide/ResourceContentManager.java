package main.java.com.lms.managers.teacherSide;

import main.AppSession;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ResourceContentManager extends ClassroomContentManager {

    public ResourceContentManager(String classIdToEdit) {
        super(classIdToEdit);
    }

    // ========================================
    // SQL-RELATED METHODS
    // ========================================


    // TODO: sql equivalent methods goes here, method name should have the same name but with Sql at the end. Ex: manageDoQuiz -> manageDoQuizSql





































    // ========================================
    // JSON-RELATED METHODS
    // ========================================
    // load all resource

    private JSONArray loadResource() {
        try {
            String contents = new String(Files.readAllBytes(Paths.get("shared/data/resource.json")));
            JSONArray allResource = new JSONArray(contents);
            return allResource;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Resource Manager
    public void manageAddResource(int selectedWeek, String title, String description) {
//        int selectedWeek = Integer.parseInt(selectWeek()) - 1;
//        String title = Menu.prompt("Enter Resource Title: ");
//        String description = Menu.prompt("Enter Resource Description: ");

        JSONArray resources = new JSONArray();
        JSONObject resourceObject = new JSONObject();
        String resourceId = idGenerator(loadResource(), "R0000");
        resourceObject.put("resourceId", resourceId);
        resourceObject.put("status", "active");
        JSONArray allWeekResource = new JSONArray();
        JSONObject week = new JSONObject();
        String weekId = idGenerator(loadResource(), "Week00");
        week.put("id", weekId);
        JSONArray contents = new JSONArray();
        JSONObject content = new JSONObject();
        JSONArray weekResources = getAllResource();
        JSONArray aWeekContents = null;
        for (int i = 0; i < weekResources.length(); i++) {
            if (i == selectedWeek) {
                aWeekContents = weekResources.getJSONObject(i).getJSONArray("contents");
                break;
            }
        }
        String contentId = idGenerator(aWeekContents, "C0000");
        content.put("id", contentId);
        content.put("title", title);
        content.put("description", description);
        content.put("status", "active");

    }

    public void manageEditResource() {

    }

    public void manageDeleteResource() {

    }

    public void manageViewResource() {

    }

    // display each week and select and input
//    private String selectWeek() {
//        for (int i = 0; i < 10; i++) {
//            System.out.println("Week0" + i+1);
//        }
//        return Menu.prompt("Select a Week: ");
//    }

    // get Resource array (all weeks) from resource.json only
    private JSONArray getAllResource() {
        JSONArray allResource = loadResource();
        String classroomId = getClassroomId();
        for (int i = 0; i < allResource.length(); i++) {
            if (classroomId.equals(allResource.getJSONObject(i).getString("classroomId"))) {
                return allResource.getJSONObject(i).getJSONArray("resources");
            }
        }
        return null;
    }
}