package com.example.demo4;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SampleControllerTest
 */
@RestController
public class SampleController {

    @GetMapping("/hello")
    public Resource<Hello> hello() {
        Hello hello = new Hello();
        hello.setPrefix("Hey,");
        hello.setSuffix("Keesun");

        Resource<Hello> helloResource = new Resource<Hello>(hello);
        helloResource.add(linkTo(methodOn(SampleController.class).hello()).withSelfRel());

        return helloResource;
    }
}