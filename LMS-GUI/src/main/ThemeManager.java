package main;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import java.util.HashMap;
import java.util.Map;

public class ThemeManager {
    private static boolean isDarkMode = false;
    private static final Map<Node, String> originalStyles = new HashMap<>();

    public static void toggleTheme(Parent root) {
        if (isDarkMode) {
            restoreDefaultTheme(root); // Switch back to default light theme
        } else {
            applyDarkTheme(root); // Apply dark theme
        }
        isDarkMode = !isDarkMode;
    }

    private static void applyDarkTheme(Parent root) {
        for (Node node : root.getChildrenUnmodifiable()) {
            // Store original styles only ONCE
            if (!originalStyles.containsKey(node)) {
                originalStyles.put(node, node.getStyle());
            }

            if (node instanceof Pane || node instanceof ScrollPane) {
                node.setStyle("-fx-background-color: #2E2E2E;");
            }
            else if (node instanceof Button) {
                node.setStyle("-fx-background-color: #444; -fx-text-fill: white;");
            }
            else if (node instanceof Label || node instanceof Text) {
                node.setStyle("-fx-text-fill: white;");
            }
            else if (node instanceof TextField || node instanceof TextArea) {
                node.setStyle("-fx-control-inner-background: #444; -fx-text-fill: white;");
            }


            // Recursively apply to nested elements
            if (node instanceof Parent) {
                applyDarkTheme((Parent) node);
            }
        }
    }

    private static void restoreDefaultTheme(Parent root) {
        for (Node node : root.getChildrenUnmodifiable()) {
            // Restore original styles
            if (originalStyles.containsKey(node)) {
                node.setStyle(originalStyles.get(node));
            }

            // Recursively restore for nested elements
            if (node instanceof Parent) {
                restoreDefaultTheme((Parent) node);
            }
        }
    }
}
