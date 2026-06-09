package model;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
    private List<Product> products = new ArrayList<>();

    public ProductCatalog() {
        products.add(new Product(
                "Abbey Road Vinyl",
                29.99,
                "Vinyl"));

        products.add(new Product(
                "Ride the Lightning CD",
                12.99,
                "CD"));

        products.add(new Product(
                "Guitar Picks",
                4.99,
                "Accessory"));

        products.add(new Product(
                "Studio Headphones",
                79.99,
                "Accessory"));

    }

    public List<Product> getProducts() {
        return products;
    }
}
