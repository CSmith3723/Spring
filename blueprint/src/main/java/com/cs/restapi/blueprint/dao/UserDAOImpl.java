package com.cs.restapi.blueprint.dao;

import com.cs.restapi.blueprint.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

   private EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<User> findAllUsers() {
        TypedQuery<User> theQuery = entityManager.createQuery("from User", User.class);
        List<User> theUsers = theQuery.getResultList();
        return theUsers;
    }

    @Override
    public User saveUser(User theUser) {
        User dbUser = entityManager.merge(theUser);
        return dbUser;
    }

    @Override
    public User findById(int theId) {
      User userId =  entityManager.find(User.class, theId);
        return userId;
    }
}
