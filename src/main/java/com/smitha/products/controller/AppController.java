package com.smitha.products.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/")
    public String intro(){

        return("Hello! Welcome to Disney shop!");
    }
}
