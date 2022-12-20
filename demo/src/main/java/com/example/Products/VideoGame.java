package com.example.Products;

public abstract class VideoGame extends Game {
    protected String platform;

    /**
     * Constructor for VideoGame
     * 
     * @param type
     * @param price
     * @param title
     * @param requirements
     * @param platform
     */
    public VideoGame(String type, double price, String title, String rating, String platform) {
        super(type, price, title, rating);
        this.platform = platform;
    }

    // Get methods
    /**
     * @return platform
     */
    public String getPlatform() {
        return platform;
    }

    @Override
    public String toString() {
        return this.title + " for " + this.platform + " " + this.price + "$";
    }

}
