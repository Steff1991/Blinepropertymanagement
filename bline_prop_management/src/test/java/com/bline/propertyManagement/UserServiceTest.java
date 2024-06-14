package com.bline.propertyManagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bline.propertyManagement.entity.Tour;
import com.bline.propertyManagement.entity.User;
import com.bline.propertyManagement.implementation.UserServiceImplementation;
import com.bline.propertyManagement.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks 
	private UserServiceImplementation userServiceImplementation;

	@Test
	public void testGetScheduledToursForAdmin() {
		String userId = UUID.randomUUID().toString();

		User user = new User();
		user.setEmail("testEmail");
		user.setName("testName");
		user.setRole("admin");
		user.setUserId(userId);

		Tour tour =new Tour();
		tour.setPropertyId(UUID.randomUUID().toString());
		tour.setTourId(UUID.randomUUID().toString());
		
		Tour tour2 =new Tour();
		tour2.setPropertyId(UUID.randomUUID().toString());
		tour2.setTourId(UUID.randomUUID().toString());

		List<Tour> tourList=new ArrayList<Tour>();
		tourList.add(tour);
		tourList.add(tour2);
		user.setTours(tourList);

		when(userRepository.findById(userId)).thenReturn(Optional.of(user));

		User userAdmin= userServiceImplementation.getUserById(userId);
		assertNotNull(userAdmin);

		assertEquals("admin", userAdmin.getRole());
		assertEquals(2, userAdmin.getTours().size());
	}



}
