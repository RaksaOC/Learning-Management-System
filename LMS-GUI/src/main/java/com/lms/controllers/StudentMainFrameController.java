package main.java.com.lms.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.AppSession;
import main.SceneManager;

import javafx.scene.image.ImageView;
import main.java.com.lms.managers.AuthenticationManager;

import java.util.ArrayList;
import java.util.Optional;

public class StudentMainFrameController {
    @FXML
    private Text nameText;
    @FXML
    private HBox dashboardLink;
    @FXML
    private HBox classroomsLink;
    @FXML
    private HBox assignmentsLink;
    @FXML
    private HBox resourcesLink;
    @FXML
    private HBox quizzesLink;
    @FXML
    private HBox gradeReportLink;
    @FXML
    private HBox settingsLink;
    @FXML
    private HBox logoutLink;
    @FXML
    private HBox switchUserLink;
    @FXML
    private ImageView profile;

    private ArrayList<HBox> links;
    private HBox selectedLink;

    public void initialize() {
        initLinksArray();
        highlightSelectedLink(dashboardLink);
        initHoverEffect();

        dashboardLink.setOnMouseClicked(event -> {
            SceneManager.loadCenterView("studentDashboard", "resources/com/lms/views/studentSide/Dashboard.fxml");
            SceneManager.setCenterView("studentDashboard");
            highlightSelectedLink(dashboardLink);
        });
        classroomsLink.setOnMouseClicked(event -> {
            loadDynamicComponentToCenterView(
                    "studentClassrooms",
                    "studentClassroomCardsWrapper",
                    "resources/com/lms/views/studentSide/Classrooms.fxml",
                    "resources/com/lms/views/studentSide/components/ClassroomCardsWrapper.fxml"
            );

            SceneManager.setCenterView("studentClassrooms");
            highlightSelectedLink(classroomsLink);
        });
        assignmentsLink.setOnMouseClicked(event -> {
            loadDynamicComponentToCenterView(
                    "studentAssignments",
                    "studentAssignmentCardsWrapper",
                    "resources/com/lms/views/studentSide/Assignments.fxml",
                    "resources/com/lms/views/studentSide/components/AssignmentCardsWrapper.fxml"
            );

            SceneManager.setCenterView("studentAssignments");
            highlightSelectedLink(assignmentsLink);
        });
        resourcesLink.setOnMouseClicked(event -> {
            loadDynamicComponentToCenterView(
                    "studentResources",
                    "studentResourceCardsWrapper",
                    "resources/com/lms/views/studentSide/Resources.fxml",
                    "resources/com/lms/views/studentSide/components/ResourceCardsWrapper.fxml"
            );

            SceneManager.setCenterView("studentResources");
            highlightSelectedLink(resourcesLink);
        });
        quizzesLink.setOnMouseClicked(event -> {
            loadDynamicComponentToCenterView(
                    "studentQuizzes",
                    "studentQuizCardsWrapper",
                    "resources/com/lms/views/studentSide/Resources.fxml",
                    "resources/com/lms/views/studentSide/components/QuizCardsWrapper.fxml"
            );

            SceneManager.setCenterView("studentQuizzes");
            highlightSelectedLink(quizzesLink);
        });
        gradeReportLink.setOnMouseClicked(event -> {
            SceneManager.loadCenterView("studentGradeReport", "resources/com/lms/views/studentSide/GradeReport.fxml");
            SceneManager.setCenterView("studentGradeReport");
            highlightSelectedLink(gradeReportLink);
        });
        settingsLink.setOnMouseClicked(event -> {
            SceneManager.loadCenterView("studentProfileSettings", "resources/com/lms/views/studentSide/Profile-Settings.fxml");
            SceneManager.setCenterView("studentProfileSettings");
            highlightSelectedLink(settingsLink);
        });
        logoutLink.setOnMouseClicked(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Logout");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                AuthenticationManager authenticationManager = new AuthenticationManager("student");
                authenticationManager.createNewLogOutSql(AppSession.getInstance().getStudent().getId());

                SceneManager.loadFullView("studentLogIn", "resources/com/lms/views/studentSide/LogIn.fxml");
                SceneManager.setFullView("studentLogIn");
            }
        });

        switchUserLink.setOnMouseClicked(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Logout");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to switch user?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                AppSession.getInstance().setStudent(null);
                AppSession.getInstance().setTeacher(null);
                AppSession.getInstance().setSelectedQuiz(null);
                AppSession.getInstance().setSelectedAssignment(null);
                AppSession.getInstance().setSelectedResources(null);
                AppSession.getInstance().setSelectedClassroom(null);

                SceneManager.loadFullView("userType", "resources/com/lms/views/UserType.fxml");
                SceneManager.setFullView("userType");
            }
        });
        profile.setOnMouseClicked(event -> {
            SceneManager.loadCenterView("studentProfileSettings", "resources/com/lms/views/studentSide/Profile-Settings.fxml");
            SceneManager.setCenterView("studentProfileSettings");
            highlightSelectedLink(settingsLink);
        });
    }

    private void highlightSelectedLink(HBox selectedTab) {
        for (HBox link : links) {
            if (!selectedTab.equals(link)) {
                link.setStyle("-fx-background-color: #2F92BC; -fx-background-radius: 0; -fx-translate-x: -4px");
            }
        }
        selectedTab.setStyle("-fx-background-color: #f4f6fa; -fx-background-radius: 40 0 0 40;  -fx-translate-x: 4px");
        selectedLink = selectedTab;
    }

    private void initHoverEffect() {
        for (HBox link : links) {
            link.setOnMouseEntered(event -> {
                if (!link.equals(selectedLink)) {
                    link.setStyle("-fx-background-color: #D0E8F2; -fx-background-radius: 40 0 0 40; "); // Lighter hover effect
                }
            });

            link.setOnMouseExited(event -> {
                if (!link.equals(selectedLink)) {
                    link.setStyle("-fx-background-color: #2F92BC; -fx-background-radius: 0;");
                }
            });
        }
    }

    private void initLinksArray() {
        links = new ArrayList<>();
        links.add(dashboardLink);
        links.add(classroomsLink);
        links.add(assignmentsLink);
        links.add(resourcesLink);
        links.add(quizzesLink);
        links.add(gradeReportLink);
        links.add(settingsLink);
        links.add(logoutLink);
    }

    public void setNameText(String name) {
        Platform.runLater(() -> nameText.setText(name));
        System.out.println("setNameText method called" + this.nameText);
    }

    private void loadDynamicComponentToCenterView(String centerViewName, String dynamicComponentName, String centerViewFilePath, String dynamicComponentFilePath) {
        SceneManager.loadCenterView(centerViewName, centerViewFilePath);
        SceneManager.loadComponent(dynamicComponentName, dynamicComponentFilePath);

        VBox center = (VBox) SceneManager.getCenterView(centerViewName);
        center.getChildren().add(SceneManager.getComponent(dynamicComponentName));
    }
}
