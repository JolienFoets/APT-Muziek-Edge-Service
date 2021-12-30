package com.example.musicedgeservice.model;

public class ArtistStreams {
    //private int artistId;
    private int albumId;
    private int numberStreams;

    public ArtistStreams(int albumId, int numberStreams) {
        //this.artistId = artistId;
        this.albumId = albumId;
        this.numberStreams = numberStreams;
    }

    /*public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }
*/

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
}
