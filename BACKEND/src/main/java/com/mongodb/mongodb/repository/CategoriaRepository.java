package com.mongodb.mongodb.repository;

import com.mongodb.mongodb.model.Categoria;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoriaRepository extends MongoRepository<Categoria, String> {
}
