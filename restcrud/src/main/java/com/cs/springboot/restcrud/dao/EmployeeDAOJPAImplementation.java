package com.cs.springboot.restcrud.dao;

import com.cs.springboot.restcrud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJPAImplementation implements EmployeeDAO{

    //define field for entitymanager
    private EntityManager entityManager;

    //set up constructor injection --
    //Constructor injection simply tells my Implementation class that it should look to
    //the Entity Manager for its dependencies. For example, see below, we are calling the createQuery
    //method from EntityManager because we have passed it as a dependency
    @Autowired
    public EmployeeDAOJPAImplementation (EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    //we are returning a type List of Employee
    public List<Employee> findAll() {

        //Here we are querying the Employee class from the Employee entity tagged in our Employee Java class
        //we are passing that query to the TypedQuery object of theQuery
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        //we create an Employee List using theQuery object to get the results
        List<Employee> employees = theQuery.getResultList();

        //returning the list
        return employees;


    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmployee = entityManager.merge(theEmployee);
        return dbEmployee;
    }

    @Override
    public Employee findById(int theId) {
        Employee theEmployee = entityManager.find(Employee.class, theId);
        return theEmployee;
    }

    @Override
    public void deleteById(int theId) {
        Employee theEmployee = entityManager.find(Employee.class,theId);
        entityManager.remove(theEmployee);
    }


}
