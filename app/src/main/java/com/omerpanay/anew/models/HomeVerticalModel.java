package com.omerpanay.anew.models;

public class HomeVerticalModel {
    int image;
    String timing;
    String artist;
    String rating;
    String name;

    public HomeVerticalModel(int image, String timing, String artist, String rating, String name) {
        this.image = image;
        this.timing = timing;
        this.artist = artist;
        this.rating = rating;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
