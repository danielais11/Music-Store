package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    //weil nur 1x Warenkorb
    private static final Cart instance = new Cart();

    private List<Product> products = new ArrayList<>();

    private Cart() {
    }

    public void clear() {
        products.clear();
    }

    public static Cart getInstance() {
        return instance;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}