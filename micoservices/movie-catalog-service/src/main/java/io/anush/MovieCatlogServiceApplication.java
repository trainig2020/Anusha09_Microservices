package io.anush;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrixDashboard
public class MovieCatlogServiceApplication {
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		/*
		 * HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new
		 * HttpComponentsClientHttpRequestFactory();
		 * clientHttpRequestFactory.setConnectTimeout(30000); return new
		 * RestTemplate(clientHttpRequestFactory);
		 */
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieCatlogServiceApplication.class, args);
	}

}
