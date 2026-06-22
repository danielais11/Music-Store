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
        SceneManager.switchScene(event,"main.fxml","Music-Store");
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
