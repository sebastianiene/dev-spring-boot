package com.example.springbootconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GreetingController {
    @Value("${my.greeting: default value}")
    private String greetingMessage;

    @Value("some static message")
    private String staticMessage;

    @Value("${my.list.values}")
    private List<String> listValues;

    @Autowired
    private DbSettings dbSettings;  //to use autowired annotation

//    @Value("#{${dbValues}}")
//    private Map<String,String> dbValues;  //getting them from application.properties the old way


    @GetMapping("/greeting")
    public String greeting(){
//        return greetingMessage+staticMessage+listValues+dbValues;
        return dbSettings.getConnection()+ dbSettings.getHost();
    }
}
