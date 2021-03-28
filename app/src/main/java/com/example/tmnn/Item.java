package com.example.tmnn;

import java.io.Serializable;

public class Item implements Serializable {
    private int id;
    private String foodName, foodLink, foodLocation, foodDetails;
    private int foodImage;
    private int price;
    private boolean isSelected;

    public Item(){}

    public Item(int id, String foodName, String foodLink, String foodLocation, int foodImage, String foodDetails, int price){
        this.id = id;
        this.foodName = foodName;
        this.foodLink = foodLink;
        this.foodLocation = foodLocation;
        this.foodImage = foodImage;
        this.foodDetails = foodDetails;
        this.price = price;
    }

    public int getId() { return id; }

    public String getFoodName() {
        return this.foodName;
    }

    public String getFoodLink(){
        return this.foodLink;
    }

    public String getFoodLocation() {
        return this.foodLocation;
    }

    public int getFoodImage() {
        return this.foodImage;
    }

    public String getFoodDetails(){ return this.foodDetails; }

    public int getPrice() { return this.price; }

    public void setId(int id) { this.id = id; }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setFoodLink(String foodLink) {
        this.foodLink = foodLink;
    }

    public void setFoodLocation(String foodLocation) {
        this.foodLocation = foodLocation;
    }

    public void setFoodImage(int foodImage) {
        this.foodImage = foodImage;
    }

    public void setFoodDetails(String foodDetails) { this.foodDetails = foodDetails; }

    public void setPrice(int price) { this.price = price; }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
