package com.omerpanay.anew.models;

public class MyMusicGallery {
    int image;
    String description;
    String type;
    String name;
    int resourceId; // Müzik dosyasının kaynak kimliği

    public MyMusicGallery(int image, String description, String type, String name, int resourceId) {
        this.image = image;
        this.description = description;
        this.type = type;
        this.name = name;
        this.resourceId = resourceId;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}
