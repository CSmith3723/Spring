package com.cs.springboot.restcrud.dao;

import com.cs.springboot.restcrud.entity.Employee;
import java.util.List;

//---THIS IS THE DATA LAYER---//

public interface EmployeeDAO {

    List<Employee> findAll();
    //save OR update
    public Employee save(Employee theEmployee);

    public Employee findById(int theId);

    public void deleteById(int theId);



}
