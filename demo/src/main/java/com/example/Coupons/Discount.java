package com.example.Coupons;

import com.example.Products.Product;

public class Discount implements Coupon {
    private String type;
    private int discountPercentage;
    private String title;

    /**
     * Constructor for the discount
     * 
     * @param type
     * @param discountPercentage
     * @param title
     */
    public Discount(String type, int discountPercentage, String title) {
        this.type = type;
        this.discountPercentage = discountPercentage;
        this.title = title;
    }

    /**
     * Adds a negative number to the cart
     * 
     * @return double
     */
    public double applyCoupon(Product p) {
        return -(p.getPrice() * discountPercentage / 100);
    }

    /**
     * Getter for the discount percentage
     * 
     * @return current discount percentage
     */
    public int getPercentage() {
        return this.discountPercentage;
    }

    /**
     * Getter for the title of the discounted product
     * 
     * @return product title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Getter for the type of coupon
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
        return discountPercentage + "% discount";
    }
}
