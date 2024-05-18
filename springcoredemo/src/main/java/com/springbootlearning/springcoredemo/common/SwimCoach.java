package com.springbootlearning.springcoredemo.common;

public class SwimCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Swim for 30 minutes.";
    }
}
