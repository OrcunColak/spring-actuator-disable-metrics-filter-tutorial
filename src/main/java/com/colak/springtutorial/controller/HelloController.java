package com.colak.springtutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hello")
public class HelloController {

    // The controller still runs on port 8080
    // http://localhost:8080/hello
    @GetMapping
    String hello() {
        return "Hello";
    }
}
