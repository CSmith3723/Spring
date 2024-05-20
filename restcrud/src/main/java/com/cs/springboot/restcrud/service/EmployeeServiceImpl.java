package com.cs.springboot.restcrud.service;

import com.cs.springboot.restcrud.dao.EmployeeDAO;
import com.cs.springboot.restcrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//---THIS SERVICE DELEGATES THE CALLS TO THE DAO---//
//---THIS IS A LAYER BETWEEN CONTROLLER AND DAO---//
//---Best practice is to apply transactional boundaries at the Service layer, not the DAO layer---//

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
        employeeDAO = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }


    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
    employeeDAO.deleteById(theId);
    }




}
