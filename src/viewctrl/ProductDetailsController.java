package viewctrl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import model.Product;

import java.io.IOException;

public class ProductDetailsController {

    private static Product selectedProduct;


    @FXML
    private Label nameLabel;

    @FXML
    private Label categoryLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private TextArea descriptionArea;

    @FXML
    private TextArea trackListArea;

    public static void setSelectedProduct(Product product) {
        selectedProduct = product;
    }

    @FXML
    public void initialize() {

        if (selectedProduct != null) {
            nameLabel.setText(selectedProduct.getName());
            categoryLabel.setText("Category: " + selectedProduct.getCategory());
            priceLabel.setText(String.format("Price: € %.2f", selectedProduct.getPrice()));
            descriptionArea.setText(selectedProduct.getDescription());
            trackListArea.setText(selectedProduct.getTrackList());
        }
    }

    @FXML
    public void goBack(ActionEvent event) throws IOException {
        SceneManager.switchScene(event,"main.fxml","Music-Store");

    }
}