package com.cs.thymeleafdemo.controller;
import com.cs.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {

    //this is how to inject a set of values from the application properties
    //file into a list that can be passed to the dropdown
    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${systems}")
    private List<String> systems;

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel){

        //create student object
        Student theStudent = new Student();

        //add student object to the model. This is going to use the getter and setter methods to save the
        //data from the form to the model
        theModel.addAttribute("student", theStudent);

        //add list of countries
        theModel.addAttribute("countries", countries);

        theModel.addAttribute("languages", languages);
        theModel.addAttribute("systems", systems);

        return "student-form";
    }


    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent){

        System.out.println(theStudent.getFirstName() + " " + theStudent.getLastName());

        return "student-confirmation";
    }


}
