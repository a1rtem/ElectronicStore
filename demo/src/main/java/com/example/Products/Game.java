package com.example.Products;

public class Game extends Product {
    protected String rating;

    /**
     * Constructor for game
     * 
     * @param type
     * @param price
     * @param title
     * @param rating
     */
    public Game(String type, double price, String title, String rating) {
        super(type, price, title);
        this.rating = rating;
    }

    /**
     * @return rating
     */
    public String getRating() {
        return this.rating;
    }

    @Override
    public String toString() {
        return "Name: " + super.getTitle() +
                "\nRating: " + this.rating +
                "\nPrice: " + super.getPrice() + "$";
    }
}
