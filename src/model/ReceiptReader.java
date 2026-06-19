package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReceiptReader {

    public static void printReceipt() {

        try (BufferedReader reader = new BufferedReader(new FileReader("receipt.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}