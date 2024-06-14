package com.bline.propertyManagement.service;


import com.bline.propertyManagement.entity.Property;

import java.util.List;

public interface PropertyService {
	
	 

	    public Property saveProperty(Property property);

	    public List<Property> getAllProperties() ;

	    public Property getPropertyById(String propertyId) ;
}
