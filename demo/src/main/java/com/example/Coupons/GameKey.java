package com.example.Coupons;

import com.example.Products.Product;

public class GameKey implements Coupon {
    private String type;
    private String title;

    /**
     * Constructor for the GameKey
     * 
     * @param type
     * @param title
     */
    public GameKey(String type, String title) {
        this.type = type;
        this.title = title;
    }

    /**
     * Adds a negative number to the cart
     * 
     * @return double
     */
    public double applyCoupon(Product p) {
        return -p.getPrice();
    }

    /**
     * Getter for the title
     * 
     * @return current credit amount
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Getter for the type
     * 
     * @return type
     */
    public String getType() {
        return this.type;
    }

    /**
     * Overriding toString
     * 
     * @return String
     */
    @Override
    public String toString() {
        return title + " game code";
    }
}
