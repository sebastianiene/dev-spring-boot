package io.javabrains.moviecatalogservice.resources;

import io.javabrains.moviecatalogservice.models.CatalogItem;
import io.javabrains.moviecatalogservice.models.Movie;
import io.javabrains.moviecatalogservice.models.Rating;
import io.javabrains.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
       // RestTemplate restTemplate = new RestTemplate();

       UserRating ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/"+userId, UserRating.class);

        return ratings.getUserRating().stream().map(rating -> {
            // For each movie ID, call movie info service and get details
             Movie movie= restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(), Movie.class);
            // Put them all together
            return new CatalogItem(movie.getName(), "Description", rating.getRating());
        })
        .collect(Collectors.toList());





    }
}



/* Movie movie = webClientBuilder.build()
                     .get()
                     .uri("http://localhost:8082/movies/" + rating.getMovieId())
                     .retrieve()  //do the fetch
                     .bodyToMono(Movie.class) //whatever body you get, convert it to Movie.class, where Mono is a reactive way of promise that you will get it asynchronous eventually
                     .block(); //blocking execution until Mono is fulfilled
*/