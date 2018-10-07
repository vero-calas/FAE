package com.mongodb.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.mongodb.mongodb.model.Usuario;

import java.util.List;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    List<Usuario> findAllByNombreContaining(String nombre);
    Usuario findByCorreo(String correo);
}
