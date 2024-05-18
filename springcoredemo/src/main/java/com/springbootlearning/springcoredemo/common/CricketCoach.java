package com.springbootlearning.springcoredemo.common;

import org.springframework.stereotype.Component;

//@Lazy //Lazy Initialization means that the bean is ONLY initialized when it's explictly
//requested or needed for injection
//faster startup time if large number of components, but with web related controllers
// like RestController, it can be slow. Might not discover config issues until too
//late, and may cause memory issues
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In Constructor:" + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice bowling for 30 minutes";
    }
}
