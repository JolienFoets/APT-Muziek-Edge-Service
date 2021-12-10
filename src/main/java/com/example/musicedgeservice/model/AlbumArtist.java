package com.example.musicedgeservice.model;

import java.util.ArrayList;
import java.util.List;

public class AlbumArtist {
    //Info van BRITT
    private String artistName;
    private String artistMbid;

    private List<ArtistStreams> artistStreams;

    public AlbumArtist(Artist artist, List<Album> albums) {
        //Info van BRITT
        setArtistName(artist.getName());
        setArtistMbid(artist.getartistMBID());

        artistStreams = new ArrayList<>();
        albums.forEach(album -> {
            artistStreams.add(new ArtistStreams(album.getAlbumId(), album.getNumberStreams()));
        });
        setArtistStreams(artistStreams);
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistMbid() {
        return artistMbid;
    }

    public void setArtistMbid(String artistMbid) {
        this.artistMbid = artistMbid;
    }

    public List<ArtistStreams> getArtistStreams() {
        return artistStreams;
    }

    public void setArtistStreams(List<ArtistStreams> artistStreams) {
        this.artistStreams = artistStreams;
    }
}
