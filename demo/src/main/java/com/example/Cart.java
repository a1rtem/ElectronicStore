package com.example;

import java.util.ArrayList;
import java.util.List;

import com.example.Coupons.Coupon;
import com.example.Products.Product;

public class Cart {
    private ArrayList<Product> cartArray;

    public Cart() {
        this.cartArray = new ArrayList<Product>();
    }

    /**
     * Adds a product to the cart array
     * 
     * @param item to add
     */
    public void addItem(Product item) {
        this.cartArray.add(item);
    }

    /**
     * Removes a product from the cart
     * 
     * @param item to remove
     * @return boolean
     */
    public void removeItem(Product item) {
        this.cartArray.remove(item);
    }

    /**
     * Prints the cart
     * 
     */
    public String printCartItem(Product product) {
        return product.getTitle() + " | " + product.getPrice() + "$";
    }

    /**
     * Getter for the cart ArrayList
     * 
     * @return cart
     */
    public ArrayList<Product> getCart() {
        return cartArray;
    }

    /**
     * Calculates the total of the cart
     * 
     * @return sum
     */
    public double calculateTotal(List<Coupon> selectedCoupons) {

        double sum = 0;
        for (Product item : cartArray) {
            sum = sum + item.getPrice();
            for (Coupon coupon : selectedCoupons) {
                sum = sum + coupon.applyCoupon(item);
            }
        }
        return Math.round(sum * 100) / 100;
    }
}
