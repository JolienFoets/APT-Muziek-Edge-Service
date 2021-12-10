package com.example.musicedgeservice.model;

public class ArtistStreams {
    private int artistId;
    private int numberStreams;

    public ArtistStreams(int artistId, int numberStreams) {
        this.artistId = artistId;
        this.numberStreams = numberStreams;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public int getNumberStreams() {
        return numberStreams;
    }

    public void setNumberStreams(int numberStreams) {
        this.numberStreams = numberStreams;
    }
}