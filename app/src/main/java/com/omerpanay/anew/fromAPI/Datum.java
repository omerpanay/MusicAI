package com.omerpanay.anew.fromAPI;

public class Datum {
    private boolean readable;
    private String preview;
    private String md5Image;
    private Artist artist;
    private Album album;
    private String link;
    private long explicitContentCover;
    private String title;
    private String titleVersion;
    private boolean explicitLyrics;
    private DatumType type;
    private String titleShort;
    private long duration;
    private long rank;
    private long id;
    private long explicitContentLyrics;

    public boolean getReadable() { return readable; }
    public void setReadable(boolean value) { this.readable = value; }

    public String getPreview() { return preview; }
    public void setPreview(String value) { this.preview = value; }

    public String getMd5Image() { return md5Image; }
    public void setMd5Image(String value) { this.md5Image = value; }

    public Artist getArtist() { return artist; }
    public void setArtist(Artist value) { this.artist = value; }

    public Album getAlbum() { return album; }
    public void setAlbum(Album value) { this.album = value; }

    public String getLink() { return link; }
    public void setLink(String value) { this.link = value; }

    public long getExplicitContentCover() { return explicitContentCover; }
    public void setExplicitContentCover(long value) { this.explicitContentCover = value; }

    public String getTitle() { return title; }
    public void setTitle(String value) { this.title = value; }

    public String getTitleVersion() { return titleVersion; }
    public void setTitleVersion(String value) { this.titleVersion = value; }

    public boolean getExplicitLyrics() { return explicitLyrics; }
    public void setExplicitLyrics(boolean value) { this.explicitLyrics = value; }

    public DatumType getType() { return type; }
    public void setType(DatumType value) { this.type = value; }

    public String getTitleShort() { return titleShort; }
    public void setTitleShort(String value) { this.titleShort = value; }

    public long getDuration() { return duration; }
    public void setDuration(long value) { this.duration = value; }

    public long getRank() { return rank; }
    public void setRank(long value) { this.rank = value; }

    public long getId() { return id; }
    public void setId(long value) { this.id = value; }

    public long getExplicitContentLyrics() { return explicitContentLyrics; }
    public void setExplicitContentLyrics(long value) { this.explicitContentLyrics = value; }

    @Override
    public String toString() {
        return "Datum{" +
                "readable=" + readable +
                ", preview='" + preview + '\'' +
                ", md5Image='" + md5Image + '\'' +
                ", artist=" + artist +
                ", album=" + album +
                ", link='" + link + '\'' +
                ", explicitContentCover=" + explicitContentCover +
                ", title='" + title + '\'' +
                ", titleVersion='" + titleVersion + '\'' +
                ", explicitLyrics=" + explicitLyrics +
                ", type=" + type +
                ", titleShort='" + titleShort + '\'' +
                ", duration=" + duration +
                ", rank=" + rank +
                ", id=" + id +
                ", explicitContentLyrics=" + explicitContentLyrics +
                '}';
    }
}

