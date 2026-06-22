package viewctrl;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {

    private static double xOffset;
    private static double yOffset;

    public static void switchScene(ActionEvent event, String fxml, String title) throws IOException {

        Parent root = FXMLLoader.load(SceneManager.class.getResource("/viewctrl/" + fxml));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);
        scene.getStylesheets().add(SceneManager.class.getResource("/viewctrl/style.css").toExternalForm());
        scene.setFill(Color.TRANSPARENT);

        stage.setTitle(title);
        stage.setResizable(false);

        //Zum Draggen
        root.setOnMousePressed((MouseEvent e) -> {
            xOffset = e.getSceneX();
            yOffset = e.getSceneY();
        });

        root.setOnMouseDragged((MouseEvent e) -> {
            stage.setX(e.getScreenX() - xOffset);
            stage.setY(e.getScreenY() - yOffset);
        });

        stage.setScene(scene);
        stage.show();
    }
}