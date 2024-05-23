package com.omerpanay.anew.fromAPI;

public class Artist {
    private String pictureXl;
    private String tracklist;
    private String pictureBig;
    private String name;
    private String link;
    private String pictureSmall;
    private long id;
    private ArtistType type;
    private String picture;
    private String pictureMedium;

    public String getPictureXl() { return pictureXl; }
    public void setPictureXl(String value) { this.pictureXl = value; }

    public String getTrackList() { return tracklist; }
    public void setTrackList(String value) { this.tracklist = value; }

    public String getPictureBig() { return pictureBig; }
    public void setPictureBig(String value) { this.pictureBig = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getLink() { return link; }
    public void setLink(String value) { this.link = value; }

    public String getPictureSmall() { return pictureSmall; }
    public void setPictureSmall(String value) { this.pictureSmall = value; }

    public long getId() { return id; }
    public void setId(long value) { this.id = value; }

    public ArtistType getType() { return type; }
    public void setType(ArtistType value) { this.type = value; }

    public String getPicture() { return picture; }
    public void setPicture(String value) { this.picture = value; }

    public String getPictureMedium() { return pictureMedium; }
    public void setPictureMedium(String value) { this.pictureMedium = value; }
}