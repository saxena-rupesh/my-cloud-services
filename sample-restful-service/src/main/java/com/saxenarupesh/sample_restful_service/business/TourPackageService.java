package com.saxenarupesh.sample_restful_service.business;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saxenarupesh.sample_restful_service.model.TourPackage;
import com.saxenarupesh.sample_restful_service.repo.TourPackageRepository;

@Service
public class TourPackageService {
  private TourPackageRepository tourPackageRepository;

  public TourPackageService(TourPackageRepository tourPackageRepository) {
    this.tourPackageRepository = tourPackageRepository;
  }

  public TourPackage createTourPackage(String code, String name) {
    return tourPackageRepository.findById(code)
        .orElse(tourPackageRepository.save(new TourPackage(code, name)));
  }

  public List<TourPackage> lookupAll() {
    return tourPackageRepository.findAll();
  }

  public long total() {
    return tourPackageRepository.count();
  }
}