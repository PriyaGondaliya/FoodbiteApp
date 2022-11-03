package com.example.foodbite;

public class PostItem {
    //here you can use string variable to store image url
    //if you want to load image from the internet
    private int image;
    private String title;

    public PostItem(int image,String title) {
        this.image = image;
        this.title = title;
    }

    public int getImage() {
        return image;
    }


    public String getTitle() {
        return title;
    }
}
