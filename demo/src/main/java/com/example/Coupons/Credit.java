package com.example.Coupons;

import com.example.Products.Product;

public class Credit implements Coupon {
    private String type;
    private double creditAmount;

    /**
     * Constructor for the Credit
     * 
     * @param type
     * @param creditAmount
     */
    public Credit(String type, double creditAmount) {
        this.type = type;
        this.creditAmount = creditAmount;
    }

    /**
     * Adds a negative number to the cart
     * 
     * @return double
     */
    public double applyCoupon(Product p) {
        return -creditAmount;
    }

    /**
     * Getter for the credit amount
     * 
     * @return current credit amount
     */
    public double getAmount() {
        return this.creditAmount;
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
        return creditAmount + "$ credit";
    }
}
