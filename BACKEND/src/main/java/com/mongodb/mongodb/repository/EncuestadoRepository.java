package com.mongodb.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.mongodb.mongodb.model.Encuestado;

public interface EncuestadoRepository extends MongoRepository<Encuestado, String> {
}
