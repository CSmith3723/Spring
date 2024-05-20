package com.cs.restapi.blueprint.dao;


import com.cs.restapi.blueprint.entity.User;

import java.util.List;


public interface UserDAO {


    List<User> findAllUsers();

    public User saveUser(User theUser);

    public User findById(int theId);


}
