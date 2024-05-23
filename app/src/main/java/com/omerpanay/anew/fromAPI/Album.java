package com.omerpanay.anew.fromAPI;

public class Album {
    private String cover;
    private String md5Image;
    private String tracklist;
    private String coverXl;
    private String coverMedium;
    private String coverSmall;
    private long id;
    private String title;
    private AlbumType type;
    private String coverBig;

    public String getCover() { return cover; }
    public void setCover(String value) { this.cover = value; }

    public String getMd5Image() { return md5Image; }
    public void setMd5Image(String value) { this.md5Image = value; }

    public String getTrackList() { return tracklist; }
    public void setTrackList(String value) { this.tracklist = value; }

    public String getCoverXl() { return coverXl; }
    public void setCoverXl(String value) { this.coverXl = value; }

    public String getCoverMedium() { return coverMedium; }
    public void setCoverMedium(String value) { this.coverMedium = value; }

    public String getCoverSmall() { return coverSmall; }
    public void setCoverSmall(String value) { this.coverSmall = value; }

    public long getId() { return id; }
    public void setId(long value) { this.id = value; }

    public String getTitle() { return title; }
    public void setTitle(String value) { this.title = value; }

    public AlbumType getType() { return type; }
    public void setType(AlbumType value) { this.type = value; }

    public String getCoverBig() { return coverBig; }
    public void setCoverBig(String value) { this.coverBig = value; }
}
