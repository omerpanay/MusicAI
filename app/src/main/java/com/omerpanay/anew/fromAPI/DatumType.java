package com.omerpanay.anew.fromAPI;

import java.io.IOException;

public enum DatumType {
    TRACK;

    public String toValue() {
        switch (this) {
            case TRACK: return "track";
        }
        return null;
    }

    public static DatumType forValue(String value) throws IOException {
        if (value.equals("track")) return TRACK;
        throw new IOException("Cannot deserialize DatumType");
    }
}
