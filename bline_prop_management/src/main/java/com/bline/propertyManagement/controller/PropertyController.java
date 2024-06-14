package com.bline.propertyManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bline.propertyManagement.entity.Property;
import com.bline.propertyManagement.service.PropertyService;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/properties")
public class PropertyController {

	@Autowired
	private PropertyService propertyService;

	@PostMapping
	public Property createProperty(@RequestBody Property property) {
		return propertyService.saveProperty(property);
	}

	@GetMapping
	public List<Property> getAllProperties() {
		return propertyService.getAllProperties();
	}

	@GetMapping("/{propertyId}")
	public Property getPropertyById(@PathVariable String propertyId) {
		return propertyService.getPropertyById(propertyId);
	}
}



