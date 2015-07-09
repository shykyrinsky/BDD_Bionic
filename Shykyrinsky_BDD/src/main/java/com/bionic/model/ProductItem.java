package com.bionic.model;

/**
 * Created by Illya on 06.07.2015.
 */
public class ProductItem {

    private final String name;
    private final double price;

    public ProductItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "ProductItem {name='"+name+"', price='"+price+"'}";
    }
}
