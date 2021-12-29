package com.example.musicedgeservice.model;

public class Artist {
    private String id;
    private int artistId;
    private String name;
    private String artistMBID;
    //private int numberStreams;

    public Artist() {
    }

    public Artist(String id, int artistId, String name, String artistMBID) {
        this.id = id;
        this.artistId = artistId;
        this.name = name;
        this.artistMBID = artistMBID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getartistMBID() {
        return artistMBID;
    }

    public void setartistMBID(String artistMBID) {
        this.artistMBID = artistMBID;
    }

    /*public int getNumberStreams() {
        return numberStreams;
    }

    public void setNumberStreams(int numberStreams) {
        this.numberStreams = numberStreams;
    }
    */
}
