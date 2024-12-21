package com.saxenarupesh.sample_restful_service.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saxenarupesh.sample_restful_service.model.TourPackage;


public interface TourPackageRepository extends JpaRepository<TourPackage, String> {
  Optional<TourPackage> findByName(String name);
}