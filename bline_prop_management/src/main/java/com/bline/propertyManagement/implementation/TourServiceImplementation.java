package com.bline.propertyManagement.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.bline.propertyManagement.entity.Tour;
import com.bline.propertyManagement.exceptions.NotFoundException;
import com.bline.propertyManagement.repository.TourRepository;
import com.bline.propertyManagement.service.TourService;

@Service
public class TourServiceImplementation implements TourService{
	
    @Autowired
    private TourRepository tourRepository;
    
	public Tour scheduleTour(Tour tour) {
	        return tourRepository.save(tour);
	    }

	    public List<Tour> getAllTours() {
	        return tourRepository.findAll();
	    }

	    public Tour getTourById(String tourId) {
	        
				return tourRepository.findById(tourId).orElseThrow(() -> new NotFoundException("Tour not found with id : "+ tourId));
			
	    }

	   
}
