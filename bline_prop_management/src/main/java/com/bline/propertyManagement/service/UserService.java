package com.bline.propertyManagement.service;

import java.util.List;

import com.bline.propertyManagement.entity.User;

public interface UserService {
	

    public User saveUser(User user);

    public List<User> getAllUsers();

    public User getUserById(String userId) ;

}
