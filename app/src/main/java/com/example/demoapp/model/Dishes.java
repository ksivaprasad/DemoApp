package com.example.demoapp.model;

public class Dishes {
    private String name;
    private String price;
    private int image;

    public Dishes(String name, String price, int image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }
}
