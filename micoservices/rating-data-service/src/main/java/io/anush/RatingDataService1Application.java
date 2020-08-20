package io.anush;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RatingDataService1Application {

	public static void main(String[] args) {
		SpringApplication.run(RatingDataService1Application.class, args);
	}

}

