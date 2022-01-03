package com.example.musicedgeservice;

import com.example.musicedgeservice.model.Album;
import com.example.musicedgeservice.model.Artist;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class MusicEdgeServiceControllerUnitTests {
    @Value("${albumservice.baseurl}")
    private String albumServiceBaseUrl;

    @Value("${artistservice.baseurl}")
    private String artistServiceBaseUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MockMvc mockMvc;

    private MockRestServiceServer mockServer;
    private ObjectMapper mapper = new ObjectMapper();

    private Artist artist1 = new Artist("1",1,"artist1", "123456789");
    private Artist artist2 = new Artist("2",2,"artist2", "987654321");

    private Album album1artist1 = new Album(21, 21, 1, "123654789","album1", 45);
    private Album album2artist1 = new Album(22, 22, 1, "9876546321","album2", 26);
    private Album album3artist2 = new Album(23, 23, 2, "654987321","album3", 38);

    private List<Album> allAlbums = Arrays.asList(album1artist1, album2artist1, album3artist2);
    private List<Album> allAlbumsForArtist1 = Arrays.asList(album1artist1, album2artist1);
    private List<Album> allAlbumsForArtist2 = Arrays.asList(album3artist2);
    private List<Artist> allArtists = Arrays.asList(artist1, artist2);

    @BeforeEach
    public void initializeMockserver() throws URISyntaxException, JsonProcessingException {
        mockServer = MockRestServiceServer.createServer(restTemplate);

//        // GET review from User 1 of Book 1
//        mockServer.expect(ExpectedCount.once(),
//                requestTo(new URI("http://" + reviewServiceBaseUrl + "/reviews/user/1/book/ISBN1")))
//                .andExpect(method(HttpMethod.GET))
//                .andRespond(withStatus(HttpStatus.OK)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .body(mapper.writeValueAsString(reviewUser1Book1))
//                );

//        // GET all reviews from User 1
//        mockServer.expect(ExpectedCount.once(),
//                requestTo(new URI("http://" + reviewServiceBaseUrl + "/reviews/user/1")))
//                .andExpect(method(HttpMethod.GET))
//                .andRespond(withStatus(HttpStatus.OK)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .body(mapper.writeValueAsString(allReviewsFromUser1))
//                );

        // GET all albums for Artist 1
/*        mockServer.expect(ExpectedCount.once(),
                requestTo(new URI("http://" + albumServiceBaseUrl + "/albums/artist/1")))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapper.writeValueAsString(allAlbumsForArtist1))
                );
*/
        // GET all albums for Artist 2
/*        mockServer.expect(ExpectedCount.once(),
                requestTo(new URI("http://" + albumServiceBaseUrl + "/albums/artist/1")))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapper.writeValueAsString(allAlbumsForArtist2))
                );
*/
//        // GET Book 1 info
//        mockServer.expect(ExpectedCount.once(),
//                requestTo(new URI("http://" + bookInfoServiceBaseUrl + "/books/ISBN1")))
//                .andExpect(method(HttpMethod.GET))
//                .andRespond(withStatus(HttpStatus.OK)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .body(mapper.writeValueAsString(book1))
//                );

//        // GET Book 2 info
//        mockServer.expect(ExpectedCount.once(),
//                requestTo(new URI("http://" + bookInfoServiceBaseUrl + "/books/ISBN2")))
//                .andExpect(method(HttpMethod.GET))
//                .andRespond(withStatus(HttpStatus.OK)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .body(mapper.writeValueAsString(book2))
//                );

//        // GET Books by Title 'Book'
//        mockServer.expect(ExpectedCount.once(),
//                requestTo(new URI("http://" + bookInfoServiceBaseUrl + "/books/title/Book")))
//                .andExpect(method(HttpMethod.GET))
//                .andRespond(withStatus(HttpStatus.OK)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .body(mapper.writeValueAsString(allBooks))
//                );

//        // POST review for Book 1 from User 3
//        mockServer.expect(ExpectedCount.once(),
//                requestTo(new URI("http://" + reviewServiceBaseUrl + "/reviews")))
//                .andExpect(method(HttpMethod.POST))
//                .andRespond(withStatus(HttpStatus.OK)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .body(mapper.writeValueAsString(reviewUser3Book1))
//                );

//        // PUT review from User 1 for Book 1 with new score 5
//        mockServer.expect(ExpectedCount.once(),
//                requestTo(new URI("http://" + reviewServiceBaseUrl + "/reviews")))
//                .andExpect(method(HttpMethod.PUT))
//                .andRespond(withStatus(HttpStatus.OK)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .body(mapper.writeValueAsString(updatedReviewUser1Book1))
//                );

//        // DELETE review from User 999 of Book with ISBN9 as ISBN
//        mockServer.expect(ExpectedCount.once(),
//                requestTo(new URI("http://" + reviewServiceBaseUrl + "/reviews/user/999/book/ISBN9")))
//                .andExpect(method(HttpMethod.DELETE))
//                .andRespond(withStatus(HttpStatus.OK)
//                );
    }

    //get all streams
    @Test
    public void whenGetStreams_thenReturnFilledAlbumArtistsJson() throws Exception {

        // GET all albums
        mockServer.expect(ExpectedCount.once(),
                requestTo(new URI("http://" + albumServiceBaseUrl + "/api/albums")))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapper.writeValueAsString(allAlbums))
                );

        // GET Artist 1 info
        mockServer.expect(ExpectedCount.once(),
                requestTo(new URI("http://" + artistServiceBaseUrl + "/api/artists/1")))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapper.writeValueAsString(artist1))
                );


        // GET Artist 2 info
       /* mockServer.expect(ExpectedCount.once(),
                requestTo(new URI("http://" + artistServiceBaseUrl + "/api/artists/2")))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapper.writeValueAsString(artist2))
                );*/

        mockMvc.perform(get("/streams/{artistId}", 1))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].artistName", is("artist1")))
                .andExpect(jsonPath("$[0].artistMbid", is("123456789")))
                .andExpect(jsonPath("$[0].artistStreams[0].albumId", is(21)))
                .andExpect(jsonPath("$[0].artistStreams[0].numberStreams", is(45)))
                .andExpect(jsonPath("$[1].artistName", is("artist1")))
                .andExpect(jsonPath("$[1].artistMbid", is("123456789")))
                .andExpect(jsonPath("$[1].artistStreams[0].albumId", is(22)))
                .andExpect(jsonPath("$[1].artistStreams[0].numberStreams", is(26)))
               /* .andExpect(jsonPath("$[2].artistName", is("artist2")))
                .andExpect(jsonPath("$[2].artistMbid", is("987654321")))
                .andExpect(jsonPath("$[2].artistStreams[0].albumId", is(23)))
                .andExpect(jsonPath("$[2].artistStreams[0].numberStreams", is(38)))*/;

    }

}
