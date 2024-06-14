package com.bline.propertyManagement.service;

	
import java.util.List;

import com.bline.propertyManagement.entity.Tour;

public interface TourService {

	public Tour scheduleTour(Tour tour) ;

	public List<Tour> getAllTours() ;

	public Tour getTourById(String tourId) ;

}
