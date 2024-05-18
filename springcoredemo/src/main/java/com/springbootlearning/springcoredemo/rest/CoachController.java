package com.springbootlearning.springcoredemo.rest;

import com.springbootlearning.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * Constructor injection behind the scenes
 *
 * Coach coach = new CricketCoach(); DemoController demoController = new
 * DemoController(coach);
 *
 * coach is the dependency or helper for the controller
 *
 *
 * Constructor Injection: used for required dependencies, listed as first choice
 *
 * Setter Injection: used for optional dependencies. If dep not provided, the
 * app can provide reasonable default logic
 *
 * Field Injection used to be common, but it is out of favor. Makes code harder
 * to unit test.
 *
 *
 * If you have multiple beans for Autowiring, you can use @Qualifier on
 * constructor injection to tell the program which bean to prioritize
 *
 *
 *
 *
 *
 */
@RestController
public class CoachController {

    //By adding @Autowired to the private field, you can inject it directly. 
    //should be avoided. 
    //private field for dependency injection
    //private Coach anotherCoach;
    private Coach myCoach;

    //constructor for dependency injection
    @Autowired
    public CoachController(
            @Qualifier("aquatic") Coach coach) {
//            @Qualifier("baseballCoach") Coach secondCoach) 

        System.out.println("In Constructor:" + getClass().getSimpleName());
        myCoach = coach;

    }

    //setter method for setter injection
//    @Autowired
//    public void setCoach(Coach coach) {
//        myCoach = coach;
//    }
    //home mapping
    @GetMapping("/")
    public String home() {
        return "Home";
    }

    //method for passing daily workout info to the /dailyworkout
    //endpoint
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

}
