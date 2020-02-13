package com.example.actuator1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class DemoApplication {

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	};

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
