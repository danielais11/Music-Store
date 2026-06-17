package viewctrl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Cart;
import model.Product;
import model.ProductCatalog;

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
    public void openShoppingCart(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("shopping-cart.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        scene.setFill(Color.TRANSPARENT);


        stage.setTitle("Shopping-Cart");
        stage.setResizable(false);


        root.setOnMousePressed((MouseEvent event1) -> {
            xOffset = event1.getSceneX();
            yOffset = event1.getSceneY();
        });

        // 3. Drag the stage on mouse drag
        root.setOnMouseDragged((MouseEvent event1) -> {
            stage.setX(event1.getScreenX() - xOffset);
            stage.setY(event1.getScreenY() - yOffset);
        });

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void addToCart() {

        Product selected = productList.getSelectionModel().getSelectedItem();


        if (selected != null) {

            Cart.getInstance().addProduct(selected);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Added to Cart");
            alert.setHeaderText(null);
            alert.initStyle(StageStyle.TRANSPARENT);
            alert.setContentText(selected.getName() + " was added to your shopping cart.");


            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

            dialogPane.getStyleClass().add("myDialog");

            dialogPane.getScene().setFill(Color.TRANSPARENT);

            alert.showAndWait();
        }
    }


}
