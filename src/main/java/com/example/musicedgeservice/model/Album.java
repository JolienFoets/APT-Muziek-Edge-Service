package com.example.musicedgeservice.model;

public class Album {
    private int id;

    private int albumId;
    private int artistId;

    private String mbid;
    private String title;

    private int numberStreams;


    public Album() {
    }

    public Album(int id, int albumId, int artistId, String mbid, String title, int numberStreams) {
        this.id = id;
        this.albumId = albumId;
        this.artistId = artistId;
        this.mbid = mbid;
        this.title = title;
        this.numberStreams = numberStreams;
    }

    public Album(int artistId, int numberStreams, String title, int albumId) {
        this.artistId = artistId;
        this.numberStreams = numberStreams;
        this.title = title;
        this.albumId = albumId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlbumId() { return albumId; }

    public void setAlbumId(int albumId) { this.albumId = albumId; }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberStreams() {
        return numberStreams;
    }

    public void setNumberStreams(int numberStreams) {
        this.numberStreams = numberStreams;
    }
}
