package viewctrl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Inventory;
import model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class InventoryController {

    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    private ListView<Product> inventoryList;

    @FXML
    public void initialize(){

        inventoryList.setPlaceholder(new Label("You don't own any products yet."));

        inventoryList.getItems().addAll(Inventory.getInstance().getProducts());

        //showInventoryByCategory();
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

   /* private void showInventoryByCategory() {

        inventoryList.getItems().clear();

        Map<String, List<Product>> categories = new TreeMap<>();

        for (Product product : Inventory.getInstance().getProducts()) {

            categories
                    .computeIfAbsent(product.getCategory(), k -> new ArrayList<>())
                    .add(product);
        }

        for (String category : categories.keySet()) {

            inventoryList.getItems().add(
                    //new Product("========== " + category.toUpperCase() + " ==========", 0, category));

            inventoryList.getItems().addAll(categories.get(category));
        }
    }
*/
}
