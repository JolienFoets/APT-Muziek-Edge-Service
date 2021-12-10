package com.example.musicedgeservice.model;

import java.util.ArrayList;
import java.util.List;

public class AlbumArtist {
    //Info van BRITT
    private String albumTitle;
    private String mbid;

    private List<ArtistStreams> artistStreams;

    public AlbumArtist(Album album, List<Artist> artists) {
        //Info van BRITT
        setAlbumTitle(album.getTitle());
        setMbid(album.getMbid());

        artistStreams = new ArrayList<>();
        artists.forEach(artist -> {
            artistStreams.add(new ArtistStreams(artist.getArtistId(), artist.getNumberStreams()));
        });
        setArtistStreams(artistStreams);
    }
}
