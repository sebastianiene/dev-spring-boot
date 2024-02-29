package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // defined a private field for the dependency
    private Coach myCoach;

   @Autowired //as autowired, it could have any name-----setter injection
   public void setCoach(Coach theCoach){

       myCoach = theCoach;
   }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){

       return myCoach.getDailyWorkout();
    }
}
