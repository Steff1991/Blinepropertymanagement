package com.bline.propertyManagement.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bline.propertyManagement.entity.Property;
import com.bline.propertyManagement.exceptions.NotFoundException;
import com.bline.propertyManagement.repository.PropertyRepository;
import com.bline.propertyManagement.service.PropertyService;

@Service
public class PropertyServiceImplementation implements PropertyService{

	@Autowired
	private PropertyRepository propertyRepository;

	public Property saveProperty(Property property) {
		return propertyRepository.save(property);
	}

	public List<Property> getAllProperties() {
		return propertyRepository.findAll();
	}

	public Property getPropertyById(String propertyId) {
		return propertyRepository.findById(propertyId).orElseThrow(() -> new NotFoundException("Property not found with id : "+ propertyId));
	}

}
