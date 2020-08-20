package io.anush.moviecatalogservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.anush.moviecatalogservice.models.CatalogItem;
import io.anush.moviecatalogservice.models.Movie;
import io.anush.moviecatalogservice.models.Rating;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfo {
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
	public CatalogItem getCatalogItem(Rating rating) {
		Movie movie = restTemplate.getForObject("http://movie-Info-service/movies/" + rating.getMovieId(), Movie.class);
		// put them all together
		return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
	}

	public CatalogItem getFallbackCatalogItem(Rating rating) {
		return new CatalogItem("Movie name not found ", "", rating.getRating());

	}

}
