package com.saxenarupesh.sample_restful_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saxenarupesh.sample_restful_service.model.Tour;

public interface TourRepository extends JpaRepository<Tour, Integer> {

}	