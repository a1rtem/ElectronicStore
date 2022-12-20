package com.example.DataLoading;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.example.Coupons.*;
import com.example.Products.*;

public class FileLoader implements DataLoader {
    private String file;

    public FileLoader(String file) {
        this.file = file;
    }

    /**
     * Reads data from a given file and stores it inside a list
     * 
     * @return a list of products
     */
    @Override
    public List<Product> loadProductData() {
        List<Product> products = new ArrayList<Product>();
        Path path = Paths.get(this.file);

        try {

            List<String> lines = Files.readAllLines(path);

            for (String line : lines) {
                String[] items = line.split(",");

                // Looking at the first value of each line for the type of product
                switch (items[0]) {
                    case "board":
                        products.add(new BoardGame(items[0], Double.parseDouble(items[1]), items[2], items[3],
                                Integer.parseInt(items[4])));
                        break;

                    case "disk":
                        products.add(
                                new DiskGame(items[0], Double.parseDouble(items[1]), items[2], items[3], items[4],
                                        items[5]));
                        break;

                    case "digital":
                        products.add(
                                new DigitalCopy(items[0], Double.parseDouble(items[1]), items[2], items[3], items[4],
                                        Double.parseDouble(items[5])));
                        break;

                    case "pc":
                        products.add(
                                new PC(items[0], Double.parseDouble(items[1]), items[2], Double.parseDouble(items[3]),
                                        Integer.parseInt(items[4])));
                        break;

                    case "console":
                        products.add(new Console(items[0], Double.parseDouble(items[1]), items[2]));
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println("Error: could not read the file!");
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Coupon> loadCouponData() {
        List<Coupon> coupons = new ArrayList<Coupon>();
        Path path = Paths.get(this.file);

        try {
            List<String> lines = Files.readAllLines(path);

            for (String line : lines) {
                String[] items = line.split(",");

                // Looking at the first value of each line for the type of product
                switch (items[0]) {
                    case "discount":
                        coupons.add(new Discount(items[0], Integer.parseInt(items[1]), items[2]));
                        break;

                    case "credit":
                        coupons.add(new Credit(items[0], Double.parseDouble(items[1])));
                        break;

                    case "gamekey":
                        coupons.add(new GameKey(items[0], items[1]));
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println("Error: could not read the file!");
            e.printStackTrace();
        }

        return coupons;
    }
}
