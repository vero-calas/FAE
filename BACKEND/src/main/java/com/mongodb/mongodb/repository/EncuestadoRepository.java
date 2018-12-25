package com.mongodb.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.mongodb.mongodb.model.Encuestado;

import java.util.Date;
import java.util.List;

public interface EncuestadoRepository extends MongoRepository<Encuestado, String> {

    List<Encuestado> findAllByIdregionAndTipoEncuestaAndFechaBetween(String idRegion, Integer tipoEncuesta, Date fechaInicial, Date fechaFinal);
    List<Encuestado> findAllByIdregionAndTipoEncuestaAndNivelDeEstudioAndFechaBetween(String idRegion, Integer tipoEncuesta, String nivelEstudio, Date fechaInicial, Date fechaFinal);
    List<Encuestado> findAllByIdregionAndTipoEncuestaAndSituacionLaboralAndFechaBetween(String idRegion, Integer tipoEncuesta, String situacionLaboral, Date fechaInicial, Date fechaFinal);
    List<Encuestado> findAllByIdregionAndTipoEncuestaAndNivelDeIngresoAndFechaBetween(String idRegion, Integer tipoEncuesta, String nivelIngreso, Date fechaInicial, Date fechaFinal);
    List<Encuestado> findAllByIdregionAndTipoEncuestaAndSexoAndFechaBetween(String idRegion, Integer tipoEncuesta, String genero, Date fechaInicial, Date fechaFinal);
    List<Encuestado> findAllByIdregionAndTipoEncuestaAndEstadoCivilAndFechaBetween(String idRegion, Integer tipoEncuesta, String estadoCivil, Date fechaInicial, Date fechaFinal);
    List<Encuestado> findAllByIdregionAndTipoEncuestaAndRangoDeEdadAndFechaBetween(String idRegion, Integer tipoEncuesta, String edad, Date fechaInicial, Date fechaFinal);
}
