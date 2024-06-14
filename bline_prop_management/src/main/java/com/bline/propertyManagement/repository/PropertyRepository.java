package com.bline.propertyManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bline.propertyManagement.entity.Property;

@Repository
public interface PropertyRepository  extends JpaRepository<Property, String>{

}
