package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    //command line runner, code to be implemented after beans are loaded
    @Bean
    //provide reference to the StudentDAO and Spring will inject it
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

        //Java lambda expression
        return runner -> {

            //createStudent(studentDAO);
            createMultipleStudents(studentDAO);
            //readStudent(studentDAO);
            //queryForStudents(studentDAO);
            //queryForStudentsByLastName(studentDAO);
            //updateStudent(studentDAO);
            //deleteStudent(studentDAO);
            //deleteAllStudents(studentDAO);

        };

    }

    private void createStudent(StudentDAO studentDAO) {

        //create student object
        System.out.println("Creating new Student object...");
        Student tempStudent = new Student("Chris", "Smith", "csmith3723@computer.com");

        //save student object
        System.out.println("Saving the Student...");
        studentDAO.save(tempStudent);

        //display id of saved student
        System.out.println("Saved student. Generated ID: " + tempStudent.getId());

    }

    private void createMultipleStudents(StudentDAO studentDAO) {

        //create student object
        System.out.println("Creating 3 Student objects...");
        Student tempStudent1 = new Student("Chris", "S", "CS@computer.com");
        Student tempStudent2 = new Student("Madeline", "G", "MG@computer.com");
        Student tempStudent3 = new Student("Matt", "M", "MM@computer.com");

        System.out.println("Saving students...");

        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

    }

    private void readStudent(StudentDAO studentDAO) {
        //create student object
        System.out.println("Creating new student...");
        Student tempStudent = new Student("Daffy", "Duck", "daffy@computer.com");

        //save student
        System.out.println("Saving student...");
        studentDAO.save(tempStudent);

        //display ID of student
        int theId = tempStudent.getId();
        System.out.println("Student saved. Student id: " + theId);

        //retrieve student based on id
        System.out.println("Retriving student by id...");
        System.out.println("Student for id " + theId + " : " + studentDAO.findById(theId));

    }

    private void queryForStudents(StudentDAO studentDAO) {

        List<Student> theStudents = studentDAO.findAll();

        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        //here you are passing in the String you're searching for. 
        List<Student> theStudents = studentDAO.findByLastName("M");

        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void updateStudent(StudentDAO studentDAO) {

        //retrieve student by id
        int studentId = 1;
        System.out.println("Getting student with id: " + studentId);
        Student myStudent = studentDAO.findById(studentId);

        //change name
        System.out.println("Updating student...");
        myStudent.setFirstName("Chris");

        //update
        studentDAO.update(myStudent);

        //display updated student
        System.out.println("Updated student: " + myStudent);

    }

    private void deleteStudent(StudentDAO studentDAO) {

        int studentId = 3;
        System.out.println("Deleting student id: " + studentId);
        studentDAO.delete(studentId);

    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println("Deleting all students...");
        int numRowsDeleted = studentDAO.deleteAllStudents();
        System.out.println(numRowsDeleted + " students deleted.");
    }
}


/*







 */
//Entity Class -- Java class mapped to a table. We map it this way using JPA 
//Marked with @Entity
//must have public/protected no-arg constructor at minimum. 
//
//Map class to table, then map data to fields
//Best to use @Column/@Table notation because if you don't, and change the column or tablenames,
//it won't update
//
//Primary key - unique value, no null values, can be set to auto-increment. 
//
//Different GenerationType for generating ids. Typically start with GenerationType.IDENTITY
//IF you need to, you can generate your own custom generation strategy by overriding the
//appropriate method
//
//CRUD -- Create, Read, Update, Delete
//
//DAO -- Data Access Object - Responsible for interfacing with the database. 
//like a helper class to handle the data
//JPA entity manager is the main component for saving/retrieving
//JPA EM needs a Data Source
//Data Source defines a database connection info
//JPA EM and Data Source are auto created by Spring Boot
//We can autowire/inject JPA EM into our Student DAO
//
//
//JpaRepository v. EM -- Knowing both will help on future projects. 
//low-level control -- EM ... high level abstraction -- JpaRepository
//EM is good for custom queries and working directly with JPA entities. good for 
//handling requests that are not easily handled by higher level stuff
//
//JpaRepository is better for out of the box issues and reducing code, comes with additional
//features, and can generate queries either custom with @Query or by method name
//
//Choice depends on the needs of the application, but both can be used togeher. 
//EM better to learn first, and then JpaRepository later
//
//
//@Transactional annotation -- Spring will automatically start and stop the transaction
//
//
//@Repository -- Spring annotation 'sub'-annotation of @Component. Meant for DAOs
//Spring auto registers the DAO implementations
//provides translation of any JDBC related exceptions
//
//JPAQL -- Query language for retrieving objects. Similar to SQL, 
//but bsaed on entity names and fields
//
//select clause required for strict JPQL, but not required for HQL(hibernate query language)
//"slect s FROM Student s WHERE s.email LIKE '%computer.com'"
//
//
//Hibernate will allow you to use Java to create / manipulate tables
//be careful using 'update' with hibernate. It's best only for small projects
//also, do NOT NOT NOT use auto create on production data, because it will DROP all data and 
//create the table from scratch. Do NOT want to lose data. 
//
//for production, have DBAs run SQL scripts
//
//auto-gen table creation can be good for small hobby projects, but generally SQL scripts are much better
//and safer/more reliable. 
//
//
