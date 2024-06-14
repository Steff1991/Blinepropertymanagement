package com.bline.propertyManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bline.propertyManagement.entity.Tour;

@Repository
public interface TourRepository extends JpaRepository<Tour, String> {

}
