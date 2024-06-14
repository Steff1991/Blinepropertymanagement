package com.bline.propertyManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bline.propertyManagement.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	


}
