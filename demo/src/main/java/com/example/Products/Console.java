package com.example.Products;

public class Console extends Electronics {

    public Console(String type, double price, String name) {
        super(type, price, name);
    }

    @Override
    public String toString() {
        return "Name: " + super.getTitle() +
                "\nPrice: " + super.getPrice() + "$";
    }
}
