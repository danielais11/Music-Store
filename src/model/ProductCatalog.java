package model;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
    private List<Product> products = new ArrayList<>();

    public ProductCatalog() {

        products.add(new Product(
                "Master of Puppets (Vinyl)",
                39.99,
                "Vinyl",
                "Metallica's legendary third studio album released in 1986.",
                "1. Battery\n" +
                        "2. Master of Puppets\n" +
                        "3. The Thing That Should Not Be\n" +
                        "4. Welcome Home (Sanitarium)\n" +
                        "5. Disposable Heroes\n" +
                        "6. Leper Messiah\n" +
                        "7. Orion\n" +
                        "8. Damage, Inc."
        ));

        products.add(new Product(
                "The Number of the Beast (CD)",
                14.99,
                "CD",
                "One of Iron Maiden's most iconic albums.",
                "1. Invaders\n" +
                        "2. Children of the Damned\n" +
                        "3. The Prisoner\n" +
                        "4. 22 Acacia Avenue\n" +
                        "5. The Number of the Beast\n" +
                        "6. Run to the Hills\n" +
                        "7. Gangland\n" +
                        "8. Hallowed Be Thy Name"
        ));

        products.add(new Product(
                "Ride the Lightning T-Shirt",
                24.99,
                "Clothing",
                "Official Metallica Ride the Lightning T-Shirt.\n100% cotton, available in multiple sizes.",
                "No tracklist available."
        ));

        products.add(new Product(
                "Guitar Picks (Pack of 10)",
                5.99,
                "Accessories",
                "Durable nylon guitar picks with Music Store logo.",
                "No tracklist available."
        ));

        products.add(new Product(
                "Marshall Guitar Cable",
                19.99,
                "Accessories",
                "3-meter high quality instrument cable with gold-plated connectors.",
                "No tracklist available."
        ));

        products.add(new Product(
                "Black Sabbath Hoodie",
                49.99,
                "Clothing",
                "Official Black Sabbath hoodie featuring the classic band logo.",
                "No tracklist available."
        ));

        products.add(new Product(
                "Paranoid (Vinyl)",
                34.99,
                "Vinyl",
                "Black Sabbath's groundbreaking second studio album.",
                "1. War Pigs\n" +
                        "2. Paranoid\n" +
                        "3. Planet Caravan\n" +
                        "4. Iron Man\n" +
                        "5. Electric Funeral\n" +
                        "6. Hand of Doom\n" +
                        "7. Rat Salad\n" +
                        "8. Fairies Wear Boots"
        ));

        products.add(new Product(
                "Slipknot Beanie",
                18.99,
                "Clothing",
                "Warm knitted beanie with embroidered Slipknot logo.",
                "No tracklist available."
        ));
    }

    public List<Product> getProducts() {
        return products;
    }
}
