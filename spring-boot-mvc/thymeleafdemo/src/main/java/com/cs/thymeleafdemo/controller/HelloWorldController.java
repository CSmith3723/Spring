package com.cs.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {


    //controller method to show initial HTML form
    @GetMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    //controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    //controller method to read form data and add data to model
    @RequestMapping("/processFormV2")
    public String letsShout(HttpServletRequest request, Model model){

        //read request param from html form
        String theName = request.getParameter("studentName");

        //convert to uppercase
        theName = theName.toUpperCase();

        //create message
        String result = "Yo, " + theName + "!";

        //add message to model using attribute name from form
        model.addAttribute("message", result);

        return "helloworld";
    }

    @PostMapping("/processFormV3")
    public String processFormV3(@RequestParam("studentName") String theName, Model model){

        //convert to uppercase
        theName = theName.toUpperCase();

        //create message
        String result = "Hey, " + theName + ", it's v3!";

        //add message to model using attribute name from form
        model.addAttribute("message", result);

        return "helloworld";
    }



}
