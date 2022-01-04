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
@RequestMapping("/api")
public class AlbumArtistController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${albumservice.baseurl}")
    private String albumServiceBaseUrl;

    @Value("${artistservice.baseurl}")
    private String artistServiceBaseUrl;

    //Get

    //Get1
    @GetMapping("/streams/artists")
    public List<Artist> getAllArtists(){
        List<Artist> returnList = new ArrayList<>();

        ResponseEntity<List<Artist>> responseEntityArtists =
                restTemplate.exchange("http://" + artistServiceBaseUrl + "/api/artists",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Artist>>() {
                        });
        returnList = responseEntityArtists.getBody();
        return returnList;
    }

    //Get2
    @GetMapping("/streams/albums")
    public List<Album> getAllAlbums(){
        List<Album> returnList = new ArrayList<>();

        ResponseEntity<List<Album>> responseEntityAlbums =
                restTemplate.exchange("http://" + albumServiceBaseUrl + "/api/albums",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Album>>() {
                        });
        returnList = responseEntityAlbums.getBody();
        return returnList;
    }

    //Get3
    @GetMapping("/streams/artists/{artistId}")
    public List<AlbumArtist> getStreamsByArtistId(@PathVariable Integer artistId){
        List<AlbumArtist> returnList= new ArrayList();

        ResponseEntity<List<Album>> responseEntityAlbums =
                restTemplate.exchange("http://" + albumServiceBaseUrl + "/api/albums/artist/{artistId}",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Album>>(){}, artistId);

        List<Album> albums = responseEntityAlbums.getBody();

        for (Album album : albums){
            Artist artist =
                    restTemplate.getForObject("http://" + artistServiceBaseUrl + "/api/artists/{artistId}",
                            Artist.class, album.getArtistId());

            returnList.add(new AlbumArtist(artist, album));
        }
        return returnList;
    }

    //Get4
    @GetMapping("/streams/albums/{albumId}")
    public Album getAlbumByAlbumId(@PathVariable Integer albumId){
        Album returnAlbum = new Album();

        ResponseEntity<Album> responseEntityAlbum =
                restTemplate.exchange("http://" + albumServiceBaseUrl + "/api/albums/{albumId}",
                        HttpMethod.GET, null, new ParameterizedTypeReference<Album>() {
                        }, albumId);
        returnAlbum = responseEntityAlbum.getBody();
        return returnAlbum;
    }


    //Post
    @PostMapping("/streams/albums")
    public AlbumArtist addStream(@RequestParam Integer artistId, @RequestParam Integer numberstreams, @RequestParam String title, @RequestParam Integer albumId){

        Album album =
                restTemplate.postForObject("http://" + albumServiceBaseUrl + "/api/albums",
                        new Album(artistId, numberstreams, title, albumId),Album.class);

        Artist artist =
                restTemplate.getForObject("http://" + artistServiceBaseUrl + "/api/artists/{artistId}",
                        Artist.class,artistId);

        return new AlbumArtist(artist, album);
    }

    //Put
    @PutMapping("/streams/albums/{albumId}")
    public Album updateStream(@RequestBody Album album, @PathVariable Integer albumId){

        /*Album album =
                restTemplate.getForObject("http://" + albumServiceBaseUrl + "/api/albums/" + albumId ,
                        Album.class);
        album.setNumberStreams(numberStreams);*/

        ResponseEntity<Album> responseEntityAlbum =
                restTemplate.exchange("http://" + albumServiceBaseUrl + "/api/albums/{albumId}",
                        HttpMethod.PUT, new HttpEntity<>(album), Album.class, albumId);

        //Album retrievedAlbum =

        return responseEntityAlbum.getBody();

        /*Artist artist =
                restTemplate.getForObject("http://" + artistServiceBaseUrl + "/api/artists/{artistId}",
                        Artist.class,artistId);

        return new AlbumArtist(artist, retrievedAlbum);*/
    }

    //Delete
    @DeleteMapping("/streams/albums/{albumId}")
    public ResponseEntity deleteStreams(@PathVariable Integer albumId){

        restTemplate.delete("http://" + albumServiceBaseUrl + "/api/albums/" + albumId);

        return ResponseEntity.ok().build();
    }


}
