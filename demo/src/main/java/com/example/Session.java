package com.example;

import java.util.Scanner;

import com.example.Products.Product;

public class Session {

    private Cart cart;
    private double money;

    public Session(double money) {
        this.cart = new Cart();
        this.money = money;
    }

    public void start() {
        Boolean run = true;
        Scanner scan = new Scanner(System.in);
        System.out.println("Load data: (File | Database)");
        String loadData = scan.nextLine();
        StoreFront sFront = null;
        if (loadData.toLowerCase().equals("file")) {
            sFront = new StoreFront();
        } else {
            System.out.println("Enter your username");
            String username = scan.nextLine();
            System.out.println("Enter your password");
            String password = scan.nextLine();
            try {
                sFront = new StoreFront(username, password);
            } catch (Exception e) {
                sFront = new StoreFront();
            }
        }
        while (run) {
            System.out.println("Sort by: (Price | Title)");
            String sortBy = scan.nextLine();
            System.out.println("Order by: (Ascending | Descending)");
            String orderBy = scan.nextLine();
            sFront.sortProducts(sortBy, orderBy);
            sFront.printStore();

            System.out.println("Which item would you like to purchase?");
            String answer = scan.nextLine();
            int index = -1;
            for (Product product : sFront.getProducts()) {
                if (product.getTitle().toLowerCase().equals(answer.toLowerCase())) {
                    index = sFront.getProducts().indexOf(product);
                }
            }
            if (index == -1) {
                System.out.println("Item does not exist!");
            } else {

                cart.addItem(sFront.getProducts().get(index));
                System.out.println(
                        "Added " + sFront.getProducts().get(index).getTitle() + " - "
                                + sFront.getProducts().get(index).getPrice()
                                + "$ to the cart!");
            }
            System.out.println("Would you like to purchase more items?");
            String repeat = scan.nextLine();
            if (repeat.toLowerCase().equals("no")) {
                run = false;
            }
        }

        sFront.printCoupons();
        for (Product item : cart.getCart()) {
            System.out.println(this.cart.printCartItem(item));
        }
        scan.close();
    }

    public Cart getCart() {
        return this.cart;
    }

}
