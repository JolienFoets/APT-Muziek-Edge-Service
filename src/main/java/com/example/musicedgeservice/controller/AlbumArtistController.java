package com.example.musicedgeservice.controller;

import com.example.musicedgeservice.model.Album;
import com.example.musicedgeservice.model.AlbumArtist;
import com.example.musicedgeservice.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AlbumArtistController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${albumservice.baseurl}")
    private String albumServiceBaseUrl;

    @Value("${artistservice.baseurl}")
    private String artistServiceBaseUrl;

    //Get

    //Get 1: get all streams
    @GetMapping("/streams")
    public List<AlbumArtist> getStreams(){

        List<AlbumArtist> returnList= new ArrayList();

        ResponseEntity<List<Album>> responseEntityAlbums =
                restTemplate.exchange("http://" + albumServiceBaseUrl + "/albums",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Album>>() {
                        });

        List<Album> albums = responseEntityAlbums.getBody();

        for (Album album:
                albums) {
            Artist artist =
                    restTemplate.getForObject("http://" + artistServiceBaseUrl + "/artists/{artistId}",
                            Artist.class, album.getArtistId());

            returnList.add(new AlbumArtist(artist, album));
        }

        return returnList;
    }

    //Get 2: get streams by artist name
    @GetMapping("/streams/artist/name/{name}")
    public List<AlbumArtist> getStreamsByName(@PathVariable String name){

        List<AlbumArtist> returnList= new ArrayList();

        ResponseEntity<List<Artist>> responseEntityArtists =
                restTemplate.exchange("http://" + artistServiceBaseUrl + "/artists/name/{name}",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Artist>>() {
                        }, name);

        List<Artist> artists = responseEntityArtists.getBody();

        for (Artist artist:
                artists) {
            ResponseEntity<List<Album>> responseEntityAlbums =
                    restTemplate.exchange("http://" + albumServiceBaseUrl + "/reviews/{artistId}",
                            HttpMethod.GET, null, new ParameterizedTypeReference<List<Album>>() {
                            }, artist.getArtistId());

            returnList.add(new AlbumArtist(artist,responseEntityAlbums.getBody()));
        }

        return returnList;
    }

    //Get 3: get streams by artist Id
    @GetMapping("/streams/artist/{artistId}")
    public AlbumArtist getStreamsByArtistId(@PathVariable int artistId){

        Artist artist =
                restTemplate.getForObject("http://" + artistServiceBaseUrl + "/artists/{artistId}",
                        Artist.class, artistId);

        ResponseEntity<List<Album>> responseEntityAlbums =
                restTemplate.exchange("http://" + albumServiceBaseUrl + "/albums/{artistId}",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Album>>() {
                        }, artistId);

        return new AlbumArtist(artist,responseEntityAlbums.getBody());
    }

    //Get 4: get streams by artist Mbid
    @GetMapping("/streams/artist/{artistMbid}")
    public AlbumArtist getStreamsArtistMBID(@PathVariable String artistMbid){

        Artist artist =
                restTemplate.getForObject("http://" + artistServiceBaseUrl + "/artists/{artistMbid}",
                        Artist.class, artistMbid);

        Album album =
                restTemplate.getForObject("http://" + albumServiceBaseUrl + "/albums/" + "artist/" + artistMbid, //OF +artist.getId()
                        Album.class);

        return new AlbumArtist(artist, album);
    }




    //Post
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

    //Put
    @PutMapping("/streams")
    public AlbumArtist updateStream(@RequestParam int artistId, @RequestParam Integer numberstreams){

        Album album =
                restTemplate.getForObject("http://" + albumServiceBaseUrl + "/streams/" + "/album/" + artistId,
                        Album.class);
        album.setNumberStreams(numberstreams);

        ResponseEntity<Album> responseEntityAlbum =
                restTemplate.exchange("http://" + albumServiceBaseUrl + "/ablums",
                        HttpMethod.PUT, new HttpEntity<>(album), Album.class);

        Album retrievedAlbum = responseEntityAlbum.getBody();

        Artist artist =
                restTemplate.getForObject("http://" + artistServiceBaseUrl + "/artists/{artistId}",
                        Artist.class,artistId);

        return new AlbumArtist(artist, retrievedAlbum);
    }
    //Delete
    @DeleteMapping("/streams/artist/{artistId}")
    public ResponseEntity deleteStreams(@PathVariable int artistId){

        restTemplate.delete("http://" + albumServiceBaseUrl + "/albums/" + "/artist/" + artistId);

        return ResponseEntity.ok().build();
    }


}
