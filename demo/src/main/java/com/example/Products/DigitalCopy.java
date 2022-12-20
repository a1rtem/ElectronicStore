package com.example.Products;

public class DigitalCopy extends VideoGame {
    private double size;

    /**
     * Constructor for DigitalCopy video games
     * 
     * @param type
     * @param price
     * @param title
     * @param requirements
     * @param platform
     * @param size
     */
    public DigitalCopy(String type, double price, String title, String rating, String platform, double size) {
        super(type, price, title, rating, platform);
        this.size = size;
    }

    /**
     * @return size
     */
    public double getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Name: " + super.getTitle() +
                "\nPlatform: " + super.getPlatform() +
                "\nSize: " + this.size + "GB" +
                "\nRating: " + super.getRating() +
                "\nPrice: " + super.getPrice() + "$";
    }
}
