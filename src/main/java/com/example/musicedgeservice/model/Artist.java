package com.example.musicedgeservice.model;

public class Artist {
    private String id;
    private int artistId;
    private String name;
    private String mbid;

    public Artist() {
    }

    public Artist(String id, int artistId, String name, String mbid) {
        this.id = id;
        this.artistId = artistId;
        this.name = name;
        this.mbid = mbid;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getmbid() {
        return mbid;
    }

    public void setmbid(String mbid) {
        this.mbid = mbid;
    }

}
