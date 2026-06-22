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
import model.*;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CartController implements Initializable {


    @FXML
    private ListView<Product> cartList;

    @FXML
    private Label totalLabel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        cartList.setPlaceholder(new Label("Your cart is currently empty."));
        cartList.getItems().addAll(Cart.getInstance().getProducts());

        updateTotal();
    }


    @FXML
    public void goBack(ActionEvent event) throws IOException {
        SceneManager.switchScene(event, "main.fxml", "Music-Store");
    }


    @FXML
    public void removeProduct() {

        Product selected = cartList.getSelectionModel().getSelectedItem();

        if (selected != null) {
            Cart.getInstance().removeProduct(selected);
            cartList.getItems().remove(selected);

            updateTotal();
        }
    }

    private void updateTotal() {

        double total = 0;

        for (Product product : Cart.getInstance().getProducts()) {
            total += product.getPrice();
        }

        totalLabel.setText(String.format("€ %.2f", total));
    }

    @FXML
    public void checkout() {

        if (Cart.getInstance().getProducts().isEmpty()) {
            return;
        }

        ReceiptWriter.createReceipt(Cart.getInstance());
        ReceiptReader.printReceipt();

        Inventory.getInstance().addProducts(Cart.getInstance().getProducts());

        Cart.getInstance().getProducts().clear();

        cartList.getItems().clear();

        updateTotal();

    }
}
