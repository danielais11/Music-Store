package viewctrl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Cart;
import model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CartController implements Initializable {

    private double xOffset = 0;
    private double yOffset = 0;


    @FXML
    private ListView<Product> cartList;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        cartList.getItems().addAll(Cart.getInstance().getProducts());

        cartList.setPlaceholder(new Label("Your cart is currently empty."));
    }

    @FXML
    public void goBack(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        scene.setFill(Color.TRANSPARENT);


        stage.setTitle("Music-Store");
        stage.setResizable(false);


        //Zum Draggen
        root.setOnMousePressed((MouseEvent event2) -> {
            xOffset = event2.getSceneX();
            yOffset = event2.getSceneY();
        });

        // 3. Drag the stage on mouse drag
        root.setOnMouseDragged((MouseEvent event2) -> {
            stage.setX(event2.getScreenX() - xOffset);
            stage.setY(event2.getScreenY() - yOffset);
        });

        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void removeProduct() {

        Product selected = cartList.getSelectionModel().getSelectedItem();

        if (selected != null) {
            Cart.getInstance().removeProduct(selected);
            cartList.getItems().remove(selected);
        }

    }

}
