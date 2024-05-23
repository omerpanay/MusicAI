package com.omerpanay.anew.models;

public class HomeHorizontalModel {
    int image;
    String name;

    public HomeHorizontalModel(String name,int image) {
        this.name = name;
        this.image=image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
