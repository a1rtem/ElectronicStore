package com.example.Products;

public class PC extends Electronics {
    private double storage;
    private String[] components;
    private int ram;

    /**
     * Constructor for pc
     * 
     * @param type
     * @param price
     * @param title
     * @param storage
     * @param ram
     */
    public PC(String type, double price, String title, double storage, int ram) {
        super(type, price, title);
        this.storage = storage;
        this.ram = ram;
    }

    /**
     * @return storage
     */
    public double getStorage() {
        return this.storage;
    }

    /**
     * @return ram
     */
    public int getRam() {
        return this.ram;
    }

    /**
     * @return components
     */
    public String[] getComponents() {
        return this.components;
    }

    @Override
    public String toString() {
        return "Name: " + super.getTitle() +
                "\nStorage: " + this.storage + "TB" +
                "\nRAM: " + this.ram + "MB" +
                "\nPrice: " + super.getPrice() + "$";
    }
}
