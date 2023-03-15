package ru.car.server.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestContoller {
// http://localhost:8080/webjars/swagger-ui/index.html#/
    @GetMapping
    public String test() {
        return "test";
    }
}
