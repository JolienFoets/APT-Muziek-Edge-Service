package com.example.musicedgeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class AlbumArtistController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${artistservice.baseurl}")
    private String artistServiceBaseUrl;

    @Value("${albumservice.baseurl}")
    private String albumServiceBaseUrl;

    //@GetMapping
    //@PostMapping
    //@PutMapping
    //@DeleteMapping




}
