package com.bline.propertyManagement.controller;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bline.propertyManagement.entity.Tour;
import com.bline.propertyManagement.entity.User;
import com.bline.propertyManagement.service.TourService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tours")
public class TourController {
	@Autowired
	private TourService tourService;

	@PostMapping
	public Tour scheduleTour(@RequestBody Tour tour) {
		return tourService.scheduleTour(tour);
	}

	@GetMapping
	public List<Tour> getAllTours() {
		return tourService.getAllTours();
	}

	@GetMapping("/{tourId}")
	public Tour getTourById(@PathVariable String tourId) {
		return tourService.getTourById(tourId);
	}

	
}
