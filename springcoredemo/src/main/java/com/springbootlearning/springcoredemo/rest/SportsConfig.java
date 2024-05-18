package com.springbootlearning.springcoredemo.rest;

import com.springbootlearning.springcoredemo.common.Coach;
import com.springbootlearning.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportsConfig {

    /*
    Bean annotation may be good when you need to make a 3rd party class available
    to the Spring framework and don't have access to the source code. 
    
    For example, if you wanted to use AWS S3 as a bean in your code, you can't modify
    the AWS code, so you can't just add @Component. It can, however, be annotated as 
    a bean.
     */
    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }

}
