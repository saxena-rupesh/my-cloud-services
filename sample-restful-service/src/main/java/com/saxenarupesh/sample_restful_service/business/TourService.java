package com.saxenarupesh.sample_restful_service.business;

import org.springframework.stereotype.Service;

import com.saxenarupesh.sample_restful_service.model.Difficulty;
import com.saxenarupesh.sample_restful_service.model.Region;
import com.saxenarupesh.sample_restful_service.model.Tour;
import com.saxenarupesh.sample_restful_service.model.TourPackage;
import com.saxenarupesh.sample_restful_service.repo.TourPackageRepository;
import com.saxenarupesh.sample_restful_service.repo.TourRepository;

@Service
public class TourService {
  private TourPackageRepository tourPackageRepository;
  private TourRepository tourRepository;

  public TourService(TourPackageRepository tourPackageRepository, TourRepository tourRepository) {
    this.tourPackageRepository = tourPackageRepository;
    this.tourRepository = tourRepository;
  }

  public Tour createTour(String tourPackageName, String title,
      String description, String blurb, Integer price, String duration,
      String bullets, String keywords, Difficulty difficulty, Region region) {

    TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName)
      .orElseThrow(() -> new RuntimeException("Tour Package not found for id:" + tourPackageName));
    return tourRepository.save(new Tour(title, description, blurb,
        price, duration, bullets, keywords, tourPackage, difficulty, region));
  }

  public long total() {
    return tourRepository.count();
  }
}