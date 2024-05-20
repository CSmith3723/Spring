package com.cs.springboot.restcrud.service;

import com.cs.springboot.restcrud.dao.EmployeeRepository;
import com.cs.springboot.restcrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//---THIS SERVICE DELEGATES THE CALLS TO THE DAO---//
//---THIS IS A LAYER BETWEEN CONTROLLER AND DAO---//
//---Best practice is to apply transactional boundaries at the Service layer, not the DAO layer---//

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        //Optional pattern replaces need to check for nulls

        Employee theEmployee = null;

        if(result.isPresent()){
            theEmployee = result.get();
        }else{
            throw new RuntimeException("Did not find employee id: " + theId);
        }
        return theEmployee;
    }


    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    //Transactional not needed with JpaRepository. Provided automatically
    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }




}
