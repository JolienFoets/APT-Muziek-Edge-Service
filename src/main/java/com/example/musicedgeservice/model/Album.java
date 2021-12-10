package com.example.musicedgeservice.model;

public class Album {
    private int id;

    private int albumId;

    private String mbid;
    private String title;
/*
    public Album() {
    }

    public Album(int id, int albumId, String mbid, String title) {
        this.id = id;
        this.albumId = albumId;
        this.mbid = mbid;
        this.title = title;
    }
*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlbumId() { return albumId; }

    public void setAlbumId(int albumId) { this.albumId = albumId; }

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
}
