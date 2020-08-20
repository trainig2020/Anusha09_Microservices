package io.anush.moviecatalogservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.anush.moviecatalogservice.models.CatalogItem;
import io.anush.moviecatalogservice.models.Movie;
import io.anush.moviecatalogservice.models.Rating;
import io.anush.moviecatalogservice.models.UserRating;
import io.anush.moviecatalogservice.services.MovieInfo;
import io.anush.moviecatalogservice.services.UserRatingInfo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	WebClient.Builder webClientBuilder;

	@Autowired
	MovieInfo movieInfo;

	@Autowired
	UserRatingInfo userRatingInfo;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

		UserRating userRating = userRatingInfo.getUserRating(userId);

		return userRating.getRatings().stream().map(rating -> movieInfo.getCatalogItem(rating))

				.collect(Collectors.toList());

	}

}
