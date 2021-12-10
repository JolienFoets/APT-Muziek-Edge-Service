package com.example.musicedgeservice.controller;

import com.example.musicedgeservice.model.Album;
import com.example.musicedgeservice.model.AlbumArtist;
import com.example.musicedgeservice.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class AlbumArtistController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${albumservice.baseurl}")
    private String albumServiceBaseUrl;

    @Value("${artistservice.baseurl}")
    private String artistServiceBaseUrl;
    //@GetMapping
    @PostMapping("/streams")
    public AlbumArtist addStream(@RequestParam int artistId, @RequestParam Integer numberstreams){

        Album album =
                restTemplate.postForObject("http://" + albumServiceBaseUrl + "/streams",
                        new Album(artistId, numberstreams),Album.class);

        Artist artist =
                restTemplate.getForObject("http://" + artistServiceBaseUrl + "/artists/{artistId}",
                        Artist.class,artistId);

        return new AlbumArtist(artist, album);
    }
    //@PutMapping
    //@DeleteMapping




}
