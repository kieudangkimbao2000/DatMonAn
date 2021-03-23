package com.example.tmnn;

public class ItemsList {
    private String foodName, foodLink, foodLocation;
    private int foodImage;

    public ItemsList(){}

    public ItemsList(String foodName, String foodLink, String foodLocation, int foodImage){
        this.foodName = foodName;
        this.foodLink = foodLink;
        this.foodLocation = foodLocation;
        this.foodImage = foodImage;
    }

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
}
