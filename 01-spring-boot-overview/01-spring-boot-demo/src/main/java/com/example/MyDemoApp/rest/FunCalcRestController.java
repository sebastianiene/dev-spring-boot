package com.example.MyDemoApp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunCalcRestController {
    @GetMapping("/")
    public String SayHello(){
        return "Hello World";
    }

}
