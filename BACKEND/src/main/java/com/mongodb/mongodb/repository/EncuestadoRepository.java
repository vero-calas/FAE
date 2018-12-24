package com.mongodb.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.mongodb.mongodb.model.Encuestado;

import java.util.Date;
import java.util.List;

public interface EncuestadoRepository extends MongoRepository<Encuestado, String> {

    List<Encuestado> findAllByIdregionAndTipoEncuestaAndFechaBetween(String idRegion, Integer tipoEncuesta, Date fechaInicial, Date fechaFinal);
    List<Encuestado> findAllByIdregionAndTipoEncuestaAndNivelDeEstudioAndFechaBetween(String idRegion, Integer tipoEncuesta, String nivelEstudio, Date fechaInicial, Date fechaFinal);
}
