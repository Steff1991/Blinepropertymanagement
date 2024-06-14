package com.bline.propertyManagement;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bline.propertyManagement.entity.Tour;
import com.bline.propertyManagement.entity.User;
import com.bline.propertyManagement.exceptions.NotFoundException;
import com.bline.propertyManagement.implementation.TourServiceImplementation;
import com.bline.propertyManagement.repository.TourRepository;

@ExtendWith(MockitoExtension.class)
public class TourServiceTest {

    @Mock
    private TourRepository tourRepository;

    @InjectMocks
    private TourServiceImplementation tourServiceImplementation;

    @Test
    public void testScheduleVirtualTour_Success() {
        String propertyId = UUID.randomUUID().toString();
        User user= new User();
        
        LocalDateTime timeSlot = LocalDateTime.now();

        Tour tour = new Tour();
        tour.setTourId(UUID.randomUUID().toString());
        tour.setPropertyId(propertyId);
        tour.setUser(user);
        tour.setTimeSlot(timeSlot);

        when(tourRepository.save(any(Tour.class))).thenReturn(tour);

        Tour scheduledtour = tourServiceImplementation.scheduleTour(tour);

        assertNotNull(scheduledtour);
        verify(tourRepository, times(1)).save(any(Tour.class));
    }
    
    @Test
    public void testGetTourById_Success() {
    	LocalDateTime localDateTime=LocalDateTime.now();
        Tour tour = new Tour();
        tour.setTourId("1");
        tour.setTimeSlot(localDateTime);

        when(tourRepository.findById("1")).thenReturn(Optional.of(tour));

        Tour foundTour = tourServiceImplementation.getTourById("1");

        assertNotNull(foundTour);
        assertEquals("1", foundTour.getTourId());
        assertEquals(localDateTime, foundTour.getTimeSlot());
        verify(tourRepository, times(1)).findById("1");
    }
    
    @Test
    public void testGetTourById_NotFound() {
    	when(tourRepository.findById("1")).thenReturn(Optional.empty());
    	assertThrows(NotFoundException.class, () -> tourServiceImplementation.getTourById("1"));
   
    }
}
