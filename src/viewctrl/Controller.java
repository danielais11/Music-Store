package viewctrl;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Product;
import model.ProductCatalog;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    private ListView<Product> productList;


    private ProductCatalog catalog;

    @FXML
    private Button closeButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        catalog = new ProductCatalog();

        productList.getItems().addAll(catalog.getProducts());

    }

    @FXML
    private void closeWindow() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void openShoppingCart() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../viewctrl/shopping-cart.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        scene.setFill(Color.TRANSPARENT);
        scene.getStylesheets().add(getClass().getResource("../viewctrl/style.css").toExternalForm());


        stage.setTitle("Shopping-Cart");
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT);



        root.setOnMousePressed((MouseEvent event) -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        // 3. Drag the stage on mouse drag
        root.setOnMouseDragged((MouseEvent event) -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });

        stage.setScene(scene);
        stage.show();
    }


}
