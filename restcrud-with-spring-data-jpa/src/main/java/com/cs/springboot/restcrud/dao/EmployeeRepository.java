package com.cs.springboot.restcrud.dao;

import com.cs.springboot.restcrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


//JpaRepository provides all of the same implementations as the DAO and
//impl classes WITHOUT the need for 2 separate classes and all that code

//entity type and primary key type
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
