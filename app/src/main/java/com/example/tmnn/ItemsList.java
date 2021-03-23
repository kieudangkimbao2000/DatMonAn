package com.example.tmnn;

public class ItemsList {
    private String foodName, foodLink, foodLocation, foodDetails;
    private int foodImage;

    public ItemsList(){}

    public ItemsList(String foodName, String foodLink, String foodLocation, int foodImage, String foodDetails){
        this.foodName = foodName;
        this.foodLink = foodLink;
        this.foodLocation = foodLocation;
        this.foodImage = foodImage;
        this.foodDetails = foodDetails;
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

    public String getFoodDetails(){ return this.foodDetails; }

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
}
