package com.example.musicedgeservice.model;

public class ArtistStreams {
    private int albumId;
    private String title;
    private int numberStreams;

    public ArtistStreams(int albumId, int numberStreams, String title) {
        this.albumId = albumId;
        this.title = title;

        this.numberStreams = numberStreams;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getNumberStreams() {
        return numberStreams;
    }

    public void setNumberStreams(int numberStreams) {
        this.numberStreams = numberStreams;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
