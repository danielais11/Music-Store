package model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private static final Inventory instance = new Inventory();

    private List<Product> ownedProducts = new ArrayList<>();

    private Inventory(){}

    public static Inventory getInstance(){
        return instance;
    }

    public void addProducts(List<Product> products){
        ownedProducts.addAll(products);
    }

    public List<Product> getProducts(){
        return ownedProducts;
    }
}