package com.example.demoapp.model;

public class Hotels {
    private String title;
    private String description;
    private String time;
    private float rating;
    private int image;

    public Hotels(String title, String description, String time, float rating, int image) {
        this.title = title;
        this.description = description;
        this.time = time;
        this.rating = rating;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTime() {
        return time;
    }

    public float getRating() {
        return rating;
    }

    public int getImage() {
        return image;
    }
}
