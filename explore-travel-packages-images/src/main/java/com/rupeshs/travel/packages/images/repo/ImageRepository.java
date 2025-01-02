package com.rupeshs.travel.packages.images.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rupeshs.travel.packages.images.model.IdName;
import com.rupeshs.travel.packages.images.model.Image;

public interface ImageRepository  extends MongoRepository<Image, String> {
  Optional<Image> findByFileName(String name);
  
  List<IdName> findIdNameBy();
}
