package com.bline.propertyManagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bline.propertyManagement.entity.Property;
import com.bline.propertyManagement.exceptions.NotFoundException;
import com.bline.propertyManagement.implementation.PropertyServiceImplementation;
import com.bline.propertyManagement.repository.PropertyRepository;

public class PropertyServiceTest {
	@Mock
    private PropertyRepository propertyRepository;

    @InjectMocks
    private PropertyServiceImplementation propertyService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveProperty_Success() {
        Property property = new Property();
        property.setAddress("123 Main St");
        property.setDescription("Beautiful house");

        when(propertyRepository.save(property)).thenReturn(property);

        Property savedProperty = propertyService.saveProperty(property);

        assertNotNull(savedProperty);
        assertEquals("123 Main St", savedProperty.getAddress());
        assertEquals("Beautiful house", savedProperty.getDescription());
        verify(propertyRepository, times(1)).save(property);
    }

    @Test
    public void testGetPropertyById_Success() {
        Property property = new Property();
        property.setPropertyId("1");
        property.setAddress("123 Main St");

        when(propertyRepository.findById("1")).thenReturn(Optional.of(property));

        Property foundProperty = propertyService.getPropertyById("1");

        assertNotNull(foundProperty);
        assertEquals("1", foundProperty.getPropertyId());
        assertEquals("123 Main St", foundProperty.getAddress());
        verify(propertyRepository, times(1)).findById("1");
    }

    @Test
    public void testGetPropertyById_NotFound() {
    	when(propertyRepository.findById("1")).thenReturn(Optional.empty());
    	assertThrows(NotFoundException.class, () -> propertyService.getPropertyById("1"));
    }
}
