package com.example;

import java.util.Comparator;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.Coupons.Coupon;
import com.example.DataLoading.*;
import com.example.Products.*;

public class StoreFront {

    private DataLoader loader;
    private List<Product> products;
    private List<Coupon> coupons;

    public StoreFront() {
        this.loader = new FileLoader("..\\file_data.txt");
        this.products = loader.loadProductData();
        this.coupons = loader.loadCouponData();
    }

    public StoreFront(String username, String password) throws SQLException {
        this.loader = new DatabaseLoader(DatabaseUtilities.getConnection(username, password));
        this.products = loader.loadProductData();
        this.coupons = loader.loadCouponData();
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public List<Coupon> getCoupons() {
        return this.coupons;
    }

    /**
     * Gets a list of products for a given category
     * 
     * @param category
     * @return list of products
     */
    public List<Product> getCategory(String category) {
        List<Product> categoryProducts = new ArrayList<Product>();
        if (category.toLowerCase().equals("all")) {
            return products;
        }
        for (Product product : products) {
            if (product.getType().toLowerCase().equals(category)) {
                categoryProducts.add(product);
            }
        }
        return categoryProducts;
    }

    /**
     * Prints all the available items
     */
    public void printStore() {
        System.out.println("---List of products---");
        for (Product product : products) {
            System.out.println(product.getTitle() + " - " + product.getPrice() + "$");
            if (product.getType().toLowerCase().equals("pc")) {
                System.out.println(product);
            }
            ;
        }
        System.out.println("----------------------");

    }

    /**
     * Prints all the available coupons
     */
    public void printCoupons() {
        System.out.println("---List of coupons---");
        for (Coupon coupon : coupons) {
            System.out.println(coupon);
        }
        System.out.println("----------------------");
    }

    /**
     * Sorting products by category
     * 
     * @param category
     */
    public void sortProducts(String category, String order) {
        switch (category.toLowerCase()) {
            case "price":
                Collections.sort(products, new Comparator<Product>() {
                    @Override
                    public int compare(Product p, Product p1) {
                        return Double.compare(p.getPrice(), p1.getPrice());
                    }
                });
                break;

            case "title":
                Collections.sort(products, new Comparator<Product>() {
                    @Override
                    public int compare(Product p, Product p1) {
                        return p.getTitle().compareTo(p1.getTitle());
                    }
                });

            default:
                System.out.println("Category does not exist");
                break;
        }
        // Descending order
        if (order.toLowerCase().equals("descending")) {
            Collections.reverse(products);
        }
    }
}
