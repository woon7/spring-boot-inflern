package com.example.rest1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// Global Customizing
	@Bean
	public WebClientCustomizer webClientCustomizer() {
		return webClientBuilder -> webClientBuilder.baseUrl("http://localhost:8080");
	}

	@Bean
	public RestTemplateCustomizer restTemplateCustomizer() {
		return restTemplate -> restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
	}
	
}