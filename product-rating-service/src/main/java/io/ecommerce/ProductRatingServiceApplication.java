package io.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductRatingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductRatingServiceApplication.class, args);
	}

}
