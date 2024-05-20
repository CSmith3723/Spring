package com.cs.restapi.blueprint.service;

import com.cs.restapi.blueprint.entity.User;

import java.util.List;


public interface UserService {

    List<User> findAllUsers();

    public User saveUser(User theUser);

    public User findById(int theId);

}
