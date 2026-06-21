package model;

public class Product {
    private String name;
    private double price;
    private String category;
    private String description;
    private String trackList;


    public Product(String name, double price, String category, String description, String trackList) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
        this.trackList = trackList;

    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {return category;}

    public String getDescription() {return description;}

    public String getTrackList() {return trackList;}

    @Override
    public String toString() {
        return name + " - €" + price;
    }
}
