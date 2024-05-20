package com.cs.springboot.restcrud.service;

import com.cs.springboot.restcrud.entity.Employee;

import java.util.List;
import java.util.Optional;


//---THIS IS THE APPLICATION LAYER---//




public interface EmployeeService {

    List<Employee> findAll();

    //save OR update

    Employee findById(int theId);


    Employee save(Employee theEmployee);

    public void deleteById(int theId);

}