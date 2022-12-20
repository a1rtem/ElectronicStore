package com.example.Products;

public class BoardGame extends Game {
    private int numberOfPieces;

    /**
     * Constructor for BoardGame
     * 
     * @param type
     * @param price
     * @param title
     * @param rating
     * @param numberOfPieces
     */
    public BoardGame(String type, double price, String title, String rating, int numberOfPieces) {
        super(type, price, title, rating);
        this.numberOfPieces = numberOfPieces;
    }

    /**
     * @return numberOfPieces
     */
    public int getNumberOfPieces() {
        return numberOfPieces;
    }

    @Override
    public String toString() {
        return "Name: " + super.getTitle() +
                "\nPieces: " + this.numberOfPieces +
                "\nRating: " + super.getRating() +
                "\nPrice: " + super.getPrice() + "$";
    }
}
