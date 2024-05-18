/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springbootlearning.springcoredemo;

import com.springbootlearning.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Chris
 */
@RestController
public class CoachController {

    //private field for dependency injection
    private Coach myCoach;

    //constructor for dependency injection
    @Autowired
    public CoachController(Coach coach) {
        myCoach = coach;
    }

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
