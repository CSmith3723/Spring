package com.springbootlearning.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier
//@Primary // ONLY ONE primary is allowed -- Qualifier has a higher priority

//Qualifier is generally suggested, more specific, higher priority
public class BaseballCoach implements Coach {

    public BaseballCoach() {
        System.out.println("In Constructor:" + getClass().getSimpleName());
    }

    //Define init
    @PostConstruct
    public void doMyStartup() {
        System.out.println("Running startup in: " + getClass().getSimpleName());
    }

    //Define destroy
    @PreDestroy
    public void doMyCleanup() {
        System.out.println("Running cleanup in: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes in batting practice.";
    }
}
