package com.springbootlearning.springcoredemo;

import com.springbootlearning.springcoredemo.common.Coach;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice bowling for 30 minutes";
    }
}
