package com.example.Coupons;

import com.example.Products.Product;

public interface Coupon {
    public double applyCoupon(Product p);

    public String getType();
}
