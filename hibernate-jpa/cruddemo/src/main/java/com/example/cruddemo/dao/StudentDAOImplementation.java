package com.example.cruddemo.dao;

//Implementation for the DAO Interface
import com.example.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository //component scanning for repositories
public class StudentDAOImplementation implements StudentDAO {

    //define field for Entity Manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    //when we call the constructor, we'll pass in a new entity manager object
    //and assign
    @Autowired
    public StudentDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional //performing an update to the database
    public void save(Student theStudent) {
        entityManager.persist(theStudent); // this is how we save the student object
        //to the database
    }

    @Override //no need for transactional because we're not updating the db
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        //Student is NOT the name of the table, it's the name of the JPA entity, the class name
        //Here we are creating our query such that the query "FROM Student" pulls from the Student class
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        return theQuery.getResultList();
    }

    public List<Student> findByLastName(String theLastName) {

        TypedQuery<Student> theQuery = entityManager
                //JPQL named params prefixed with a : and theData is a placeholder 
                .createQuery("FROM Student WHERE lastName=:theData", Student.class);

        //we update theData to be theLastName
        theQuery.setParameter("theData", theLastName);
        return theQuery.getResultList();
    }

    @Transactional //updating database
    @Override
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Transactional
    @Override
    public void delete(Integer id) {

        //retrieve student
        Student theStudent = entityManager.find(Student.class, id);
        //delete student
        entityManager.remove(theStudent);
    }

    @Transactional
    @Override
    public int deleteAllStudents() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }

}
