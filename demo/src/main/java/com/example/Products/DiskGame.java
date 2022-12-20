package com.example.Products;

public class DiskGame extends VideoGame {
    private String publisher;

    /**
     * Constructor for Disk video games
     * 
     * @param type
     * @param price
     * @param title
     * @param requirements
     * @param platform
     * @param publisher
     */
    public DiskGame(String type, double price, String title, String rating, String platform, String publisher) {
        super(type, price, title, rating, platform);
        this.publisher = publisher;
    }

    /**
     * @return publisher
     */
    public String getPublisher() {
        return publisher;
    }

    @Override
    public String toString() {
        return "Name: " + super.getTitle() +
                "\nPlatform: " + super.getPlatform() +
                "\nPublisher: " + this.publisher +
                "\nRating: " + super.getRating() +
                "\nPrice: " + super.getPrice() + "$";
    }
}
