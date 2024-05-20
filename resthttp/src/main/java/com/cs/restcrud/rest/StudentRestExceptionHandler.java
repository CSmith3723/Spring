package com.cs.restcrud.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//ControllerAdvice sets global exception handling for large projects.
@ControllerAdvice
public class StudentRestExceptionHandler {


    //Exception Handler to handle thrown exception
    //1. exception handler method (ResponseEntity)
    //2. type of response body
    //3. type of exception it handles (StudentNotFoundException)
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){

        //create StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        //set status, message, and current time.
        error.setStatus(HttpStatus.NOT_FOUND.value());
        //The following is the message with the id not found from above
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        //return ResponseEntity -- passing the error object from StudentErrorResponse and the status
        //and returning it

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

    //Generic Exceptions to handle other issues
    //These in-controller exception handlers are not as good because they are only for the specific controllers,
    //and on large projects there are too many controllers for tihs to be effective. That's why they are
    //set up here in the ControllerAdvice global handler

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){

        //create StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        //set status, message, and current time.

        //the setStatus method is retrieving the value of the "BAD_REQUEST" status
        //and setting it to the error object
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        //The following is the message with the id not found from above
        //setting the output message to the message provided
        error.setMessage(exc.getMessage());
        //timestamp
        error.setTimestamp(System.currentTimeMillis());

        //return ResponseEntity -- passing the error object from StudentErrorResponse and the status
        //and returning it
        //We are returning the whole error object, which contains all 3 values, and the status code.
        //ResponseEntity takes entity body and status code as params
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
