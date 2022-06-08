package com.ecommerce.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableMongoRepositories
@EnableSwagger2
@EnableEurekaClient
@SpringBootApplication
public class ProductcategoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductcategoryApplication.class, args);
	}

}
