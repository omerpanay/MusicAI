package com.omerpanay.anew.fromAPI;

import java.io.IOException;

public enum ArtistType {
    ARTIST;

    public String toValue() {
        switch (this) {
            case ARTIST: return "artist";
        }
        return null;
    }

    public static ArtistType forValue(String value) throws IOException {
        if (value.equals("artist")) return ARTIST;
        throw new IOException("Cannot deserialize ArtistType");
    }
}