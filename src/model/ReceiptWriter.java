package model;

import java.io.FileWriter;
import java.io.IOException;

public class ReceiptWriter {

    public static void createReceipt(Cart cart) {

        try (FileWriter writer = new FileWriter("receipt.txt")) {
            
            writer.write("====== MUSIC STORE RECEIPT ======\n\n");

            double total = 0;

            for (Product product : cart.getProducts()) {

                writer.write(product.getName()
                        + " - €"
                        + product.getPrice()
                        + "\n");

                total += product.getPrice();
            }

            writer.write("\n----------------------------\n");
            writer.write(String.format("TOTAL: €%.2f", total));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}