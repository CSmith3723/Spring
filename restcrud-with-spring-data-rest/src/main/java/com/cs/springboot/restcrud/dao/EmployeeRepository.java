package com.cs.springboot.restcrud.dao;

import com.cs.springboot.restcrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


//JpaRepository provides all of the same implementations as the DAO and
//impl classes WITHOUT the need for 2 separate classes and all that code

//entity type and primary key type

@RepositoryRestResource(path="members") //This is how we manually modify path names for complex plurals or when we don't want to
//use the one that is automatically generated for us by Spring
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
