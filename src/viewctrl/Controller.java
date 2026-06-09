package viewctrl;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import model.Product;
import model.ProductCatalog;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ListView<Product> productList;

    @FXML
    private ProductCatalog catalog;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        catalog = new ProductCatalog();

        productList.getItems().addAll(catalog.getProducts());

    }
}
