package com.cs.restcrud.rest;

import com.cs.restcrud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    //PostConstruct to load student data only once
    @PostConstruct
    public void loadStudentData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Chris", "Smith"));
        theStudents.add(new Student("Madeline", "Gangnes"));
        theStudents.add(new Student("Kirsten", "Holt"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    @GetMapping("/student/{studentId}")
    //the parameter must match the endpoint variable
    public Student getStudent(@PathVariable int studentId){

        if((studentId >= theStudents.size()) || (studentId < 0)){

            //throws exception and the ExceptionHandler is called to deal with it
    throw new StudentNotFoundException("Student id not found: "
            + studentId);
        }
        return theStudents.get(studentId);
    }


}
