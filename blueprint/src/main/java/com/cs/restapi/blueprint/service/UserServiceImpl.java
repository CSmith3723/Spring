package com.cs.restapi.blueprint.service;

import com.cs.restapi.blueprint.dao.UserDAO;
import com.cs.restapi.blueprint.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService{

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl (UserDAO theUserDAO){
        userDAO = theUserDAO;
    }

    @Override
    public List<User> findAllUsers() {
        return userDAO.findAllUsers();
    }

    @Transactional
    @Override
    public User saveUser(User theUser) {
        return userDAO.saveUser(theUser);
    }

    @Override
    public User findById(int theId) {
       return userDAO.findById(theId);
  }


}
