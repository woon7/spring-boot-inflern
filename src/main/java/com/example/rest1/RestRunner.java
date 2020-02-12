package com.example.rest1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

/**
 * RestRunner
 */
@Component
public class RestRunner implements ApplicationRunner {

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @Autowired
    WebClient.Builder builder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // sync();
        async();
    }

    // Blocking
    public void sync() {
        RestTemplate restTemplate = restTemplateBuilder.build();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        String helloResult = restTemplate.getForObject("http://localhost:8080/hello", String.class);
        System.out.println("sync: " + helloResult);

        String worldResult = restTemplate.getForObject("http://localhost:8080/world", String.class);
        System.out.println("sync: " + worldResult);

        stopWatch.stop();
        System.out.println("sync: " + stopWatch.prettyPrint());
    }

    // Webflux
    // Non-Blocking
    public void async() {
        WebClient webClient = builder
                                // .baseUrl("http://localhost:8080") // Local Customizing
                                .build();

        StopWatch helloStopWatch = new StopWatch();
        helloStopWatch.start();

        StopWatch worldStopWatch = new StopWatch();
        worldStopWatch.start();

        Mono<String> helloMono = webClient.get().uri("/hello")
                                    .retrieve()
                                    .bodyToMono(String.class);
        helloMono.subscribe(s -> {
            System.out.println("async: " + s);
            helloStopWatch.stop();
            System.out.println("async: " + helloStopWatch.prettyPrint());
        });

        Mono<String> worldMono = webClient.get().uri("/world")
                                    .retrieve()
                                    .bodyToMono(String.class);
        worldMono.subscribe(s -> {
            System.out.println("async: " + s);
            worldStopWatch.stop();
            System.out.println("async: " + worldStopWatch.prettyPrint());
        });   
    }

}