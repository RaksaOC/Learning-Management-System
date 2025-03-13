package main.java.com.lms.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import main.SceneManager;
import main.java.com.lms.managers.AuthenticationManager;

import java.util.ArrayList;
import java.util.Optional;

public class TeacherMainFrameController {
    @FXML
    private Text nameText;
    @FXML
    private HBox dashboardLink;
    @FXML
    private HBox classroomsLink;
    @FXML
    private HBox settingsLink;
    @FXML
    private HBox logoutLink;
    @FXML
    private ImageView profileImage;

    private ArrayList<HBox> links;
    private HBox selectedLink;

    public void initialize() {
        initLinksArray();
        highlightSelectedLink(dashboardLink);
        initHoverEffect();

        dashboardLink.setOnMouseClicked(event -> {
            SceneManager.loadCenterView("teacherDashboard", "resources/com/lms/views/teacherSide/Dashboard.fxml");
            SceneManager.setCenterView("teacherDashboard");
            highlightSelectedLink(dashboardLink);
        });

        classroomsLink.setOnMouseClicked(event -> {
            SceneManager.loadCenterView("teacherClassrooms", "resources/com/lms/views/teacherSide/Classrooms.fxml");
            SceneManager.setCenterView("teacherClassrooms");

            highlightSelectedLink(classroomsLink);
        });

        settingsLink.setOnMouseClicked(event -> {
            SceneManager.loadCenterView("teacherProfileSettings", "resources/com/lms/views/teacherSide/Profile-Settings.fxml");
            SceneManager.setCenterView("teacherProfileSettings");
            highlightSelectedLink(settingsLink);
        });
        logoutLink.setOnMouseClicked(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Logout");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                AuthenticationManager authenticationManager = new AuthenticationManager();
                authenticationManager.markLastLoggedOut("teacher");
                SceneManager.loadCenterView("teacherLogIn", "resource/com/lms/views/teacherSide/LogIn.fxml");
                SceneManager.setCenterView("teacherLogIn");
            }
        });
        profileImage.setOnMouseClicked(event -> {
            SceneManager.loadCenterView("teacherProfileSettings", "resources/com/lms/views/teacherSide/Profile-Settings.fxml");
            SceneManager.setCenterView("teacherProfileSettings");
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
        links.add(settingsLink);
        links.add(logoutLink);
    }

    public void setNameText(String name) {
        Platform.runLater(() -> {
            this.nameText.setText(name);
        });
    }
}
