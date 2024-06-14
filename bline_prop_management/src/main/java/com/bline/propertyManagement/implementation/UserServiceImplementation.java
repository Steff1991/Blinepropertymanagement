package com.bline.propertyManagement.implementation;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bline.propertyManagement.entity.User;
import com.bline.propertyManagement.exceptions.NotFoundException;
import com.bline.propertyManagement.repository.UserRepository;
import com.bline.propertyManagement.service.UserService;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService {

	@Autowired
	private UserRepository userRepository;//null

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(String userId) {
		return userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found with id : "+ userId));
	}
}
