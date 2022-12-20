package com.example.Products;

public abstract class Electronics extends Product {

    /**
     * Constructor for all electronics
     * 
     * @param type
     * @param price
     * @param title
     */
    public Electronics(String type, double price, String title) {
        super(type, price, title);

    }

    public void turnOn() {

    }

    public void applyDiscount() {

    }

}
