package com.omerpanay.anew.fromAPI;

import java.io.IOException;

public enum AlbumType {
    ALBUM;

    public String toValue() {
        switch (this) {
            case ALBUM: return "album";
        }
        return null;
    }

    public static AlbumType forValue(String value) throws IOException {
        if (value.equals("album")) return ALBUM;
        throw new IOException("Cannot deserialize AlbumType");
    }
}