package com.shaw.service;

import com.shaw.pojo.User;

import java.util.List;

public interface UserService {

    public User findUserByName(String name);

    public List<User> findAll();

    public User findUserWithLogin(User user);
}
