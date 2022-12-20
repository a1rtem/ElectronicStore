package com.example.DataLoading;

import java.util.List;

import com.example.Coupons.Coupon;
import com.example.Products.Product;

public interface DataLoader {
    public List<Product> loadProductData();

    public List<Coupon> loadCouponData();
}
