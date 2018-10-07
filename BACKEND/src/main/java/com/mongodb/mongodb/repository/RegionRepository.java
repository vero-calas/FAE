package com.mongodb.mongodb.repository;

import com.mongodb.mongodb.model.Region;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegionRepository extends MongoRepository<Region, String>{
}
