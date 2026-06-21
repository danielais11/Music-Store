package viewctrl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Product;

import java.io.IOException;

public class ProductDetailsController {

    private static Product selectedProduct;

    private double xOffset = 0;
    private double yOffset = 0;

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

        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        scene.setFill(Color.TRANSPARENT);

        stage.setTitle("Music Store");
        stage.setResizable(false);

        // Fenster verschieben
        root.setOnMousePressed((MouseEvent event1) -> {
            xOffset = event1.getSceneX();
            yOffset = event1.getSceneY();
        });

        root.setOnMouseDragged((MouseEvent event1) -> {
            stage.setX(event1.getScreenX() - xOffset);
            stage.setY(event1.getScreenY() - yOffset);
        });

        stage.setScene(scene);
        stage.show();
    }
}