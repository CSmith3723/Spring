package com.cs.springboot.restcrud.rest;

import com.cs.springboot.restcrud.dao.EmployeeDAO;
import com.cs.springboot.restcrud.dao.EmployeeDAOJPAImplementation;
import com.cs.springboot.restcrud.entity.Employee;
import com.cs.springboot.restcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//---THIS IS THE PRESENTATION LAYER---//
//---COMMUNICATES WITH SERVICE LAYER---//


@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    //inject employee DAO to tell our Rest Controller to use the
    //DAO dependency

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }


    //expose /employees endpoint to return list
    //
    //We are implementing the findAll() here and using the employeeDAO findAll() method to
    //return the data to the /employees endpoint.

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    //we are passing the employeeId to the path
    //finding the employee by id using the employee service
    //checking if null and throwing exception if so
    //then returning the employee if found

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee (@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null){
            throw new RuntimeException("Employee id not found:" + employeeId);
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee tempEmployee = employeeService.findById(employeeId);

        if(tempEmployee == null){
            throw new RuntimeException("Employee id not found: " + employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted employee id: " + employeeId;
    }

}
