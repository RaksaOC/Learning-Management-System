package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Labeled;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import main.java.com.lms.controllers.studentSide.StudentClassroomsController;
import ui.UI;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;

public class SceneManager extends Application {
    private static Stage primaryStage;
    private static HashMap<String, Scene> fullViews = new HashMap<>();
    private static HashMap<String, Parent> centerViews = new HashMap<>();
    private static HashMap<String, Object> centerViewsControllers = new HashMap<>();
    private static HashMap<String, Parent> components = new HashMap<>();


    private static BorderPane mainLayout; // Stores the BorderPane layout

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        loadFullView("userType", "resources/com/lms/views/UserType.fxml");
        setFullView("userType");
    }

    /**
     * Loads a full-screen view into the HashMap.
     */
    public static void loadFullView(String name, String fxmlPath) {
        try {
            URL resource = SceneManager.class.getResource(fxmlPath);
            if (resource == null) throw new IOException("FXML file not found: " + fxmlPath);

            FXMLLoader loader = new FXMLLoader(resource);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            fullViews.put(name, scene);
        } catch (IOException e) {
            System.err.println("Error loading scene: " + fxmlPath);
            e.printStackTrace();
        }
    }

    /**
     * Sets a full-screen view (used for login, splash screens, etc.).
     */
    public static void setFullView(String name) {
        Scene scene = fullViews.get(name);
        if (scene != null) {
            Rectangle2D screenBounds = Screen.getPrimary().getBounds();
            primaryStage.setScene(scene);
            primaryStage.setWidth(screenBounds.getWidth());
            primaryStage.setHeight(screenBounds.getHeight());
            System.out.println("Switched to full view: " + name);
            primaryStage.setTitle("CADT Learning Management System");
            primaryStage.show();
        } else {
            System.err.println("Full view '" + name + "' not found!");
        }
    }

    /**
     * Loads the main layout (BorderPane) and sets it as the root scene.
     */
    public static <T> T loadMainFrame(String userType) {
        try {
            String fxmlPath = "resources/com/lms/views/" + (userType.equalsIgnoreCase("student") ? "StudentMainFrame.fxml" : "TeacherMainFrame.fxml");

            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource(fxmlPath));
            mainLayout = loader.load();
            Scene scene = new Scene(mainLayout);

            Rectangle2D screenBounds = Screen.getPrimary().getBounds();
            primaryStage.setScene(scene);
            primaryStage.setWidth(screenBounds.getWidth());
            primaryStage.setHeight(screenBounds.getHeight());
            System.out.println(userType + " main layout loaded");
            return loader.getController();
        } catch (IOException e) {
            System.err.println("Error loading " + userType + " MainFrame.fxml");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Loads center content views (like Dashboard, Classrooms, etc.).
     */
    public static void loadCenterView(String name, String fxmlPath) {
        try {
            URL resource = SceneManager.class.getResource(fxmlPath);
            if (resource == null) throw new IOException("FXML file not found: " + fxmlPath);

            FXMLLoader loader = new FXMLLoader(resource);
            Parent view = loader.load();
            centerViews.put(name, view);
            centerViewsControllers.put(name, loader.getController());
            System.out.println("Loaded center view: " + name + " fxml: " + fxmlPath);
            System.out.println("center view after loaded:" + centerViews);
        } catch (IOException e) {
            System.err.println("Error loading center view: " + fxmlPath);
            e.printStackTrace();
        }
    }

    /**
     * Sets the center content inside the BorderPane.
     */
    public static void setCenterView(String name) {
        if (mainLayout != null) {
            // Get the center VBox (which contains the fake top part)
            System.out.println("trying to set center view: " + name);
            VBox contentLessVBox = (VBox) mainLayout.getCenter();
            System.out.println("got the center of the border pane");
            // Get the second VBox (after the top part)
            System.out.println(centerViews);
            System.out.println("center view to get " + centerViews.get(name));
            VBox contentVBox = (VBox) centerViews.get(name);

            contentVBox.setMaxWidth(Double.MAX_VALUE);
            contentVBox.setMaxHeight(Double.MAX_VALUE);
            contentVBox.setMinWidth(0);
            contentVBox.setMinHeight(0);

            // Clear only the content after the fake top part (i.e., clear all except the first child)
            if (contentLessVBox.getChildren().size() > 1) {
                contentLessVBox.getChildren().remove(1, contentLessVBox.getChildren().size());
            }

            // Add the new content VBox to the layout
            contentLessVBox.getChildren().add(contentVBox);

            System.out.println("Set center view: " + name);
            primaryStage.setTitle("CADT Learning Management System");
            primaryStage.show();
        } else {
            System.err.println("Center view '" + name + "' not found!");
        }
    }

    public static void loadComponent(String name, String fxmlPath) {
        try {
            URL resource = SceneManager.class.getResource(fxmlPath);
            if (resource == null) throw new IOException("FXML file not found: " + fxmlPath);
            System.out.println(components);
            FXMLLoader loader = new FXMLLoader(resource);
            Parent root = loader.load();
            components.put(name, root);
            System.out.println(UI.TextColor.addColor(components.toString(), UI.TextColor.YELLOW));
        } catch (IOException e) {
            System.err.println("Error loading scene: " + fxmlPath);
            e.printStackTrace();
        }
    }

//    public static void toggleDarkThemeOn(Parent root) {
//        for (Node node : root.getChildrenUnmodifiable()) {
//            applyDarkTheme(node);
//
//            if (node instanceof Parent) { // Recursively check deeper levels
//                toggleDarkThemeOn((Parent) node);
//            }
//        }
//    }
//
//    public static void toggleDarkThemeOff(Parent root) {
//        for (Node node : root.getChildrenUnmodifiable()) {
//            applyLightTheme(node);
//
//            if (node instanceof Parent) { // Recursively check deeper levels
//                toggleDarkThemeOff((Parent) node);
//            }
//        }
//    }
//
//    // Helper methods to apply styles
//    private static void applyDarkTheme(Node node) {
//        if (node instanceof Region) {
//            node.setStyle("-fx-background-color: #2E2E2E;");
//        }
//        if (node instanceof Labeled) {
//            ((Labeled) node).setStyle("-fx-text-fill: white;");
//        }
//        if (node instanceof Text) {
//            ((Text) node).setFill(Color.WHITE);
//        }
//    }
//
//    private static void applyLightTheme(Node node) {
//        if (node instanceof Region) {
//            node.setStyle("-fx-background-color: white;");
//        }
//        if (node instanceof Labeled) {
//            ((Labeled) node).setStyle("-fx-text-fill: black;");
//        }
//        if (node instanceof Text) {
//            ((Text) node).setFill(Color.BLACK);
//        }
//    }


    public static Parent getCenterView(String name) {
        return centerViews.get(name);
    }

    public static Scene getFullView(String name) {
        return fullViews.get(name);
    }

    public static Object getCenterViewController(String name) {
        return centerViewsControllers.get(name);
    }

    public static void setCenterViewController(String name, Object controller) {
        centerViewsControllers.put(name, controller);
    }

    public static BorderPane getMainLayout() {
        return mainLayout;
    }

    public static Parent getComponent(String name) {
        return components.get(name);
    }


}
