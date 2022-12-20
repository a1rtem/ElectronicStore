package com.example.Products;

public abstract class Product {
    protected String type;
    protected double price;
    protected String title;

    /**
     * Constructor
     * 
     * @param price
     * @param title
     */
    public Product(String type, double price, String title) {
        this.type = type;
        this.price = price;
        this.title = title;
    }

    // Get methods
    public double getPrice() {
        return this.price;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    // String representation of a product
    @Override
    public String toString() {
        return this.title + " " + this.price + "$";
    }

}
