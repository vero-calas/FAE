package com.mongodb.mongodb.model;


import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Encuestado {

    @Field("correo")
    public String correo;

    @Field("nivel_de_estudio")
    public String nivelDeEstudio;

    @Field("situacion_laboral")
    public String situacionLaboral;

    @Field("nivel_de_ingreso")
    public String nivelDeIngreso;

    @Field("sexo")
    public String sexo;

    @Field("estado_civil")
    public String estadoCivil;  //DUDA

    @Field("rango_de_edad")
    public String rangoDeEdad; //DUDA

    @Field("telefono")
    public String telefono;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    public Date fecha = new Date();

    @Field("resultados")
    public List<Resultado> resultados;

    @Field("idregion")
    public String idregion;

    public Encuestado(){}

    public Encuestado(String correo, String nivelDeEstudio, String situacionLaboral, String nivelDeIngreso, String sexo, String estadoCivil, String rangoDeEdad, String telefono, Date fecha, List<Resultado> resultados, String idregion) {
        this.correo = correo;
        this.nivelDeEstudio = nivelDeEstudio;
        this.situacionLaboral = situacionLaboral;
        this.nivelDeIngreso = nivelDeIngreso;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.rangoDeEdad = rangoDeEdad;
        this.telefono = telefono;
        this.fecha = fecha;
        this.resultados = resultados;
        this.idregion = idregion;
    }

    public String getIdregion() { return idregion; }

    public void setIdregion(String idregion) { this.idregion = idregion; }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNivelDeEstudio() {
        return nivelDeEstudio;
    }

    public void setNivelDeEstudio(String nivelDeEstudio) {
        this.nivelDeEstudio = nivelDeEstudio;
    }

    public String getSituacionLaboral() {
        return situacionLaboral;
    }

    public void setSituacionLaboral(String situacionLaboral) {
        this.situacionLaboral = situacionLaboral;
    }

    public String getNivelDeIngreso() {
        return nivelDeIngreso;
    }

    public void setNivelDeIngreso(String nivelDeIngreso) {
        this.nivelDeIngreso = nivelDeIngreso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getRangoDeEdad() {
        return rangoDeEdad;
    }

    public void setRangoDeEdad(String rangoDeEdad) {
        this.rangoDeEdad = rangoDeEdad;
    }

    public String getTelefono() { return telefono; }

    public void setTelefono(String telefono) { this.telefono = telefono; }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Resultado> getResultados() {
        return resultados;
    }

    public void setResultados(List<Resultado> resultados) {
        this.resultados = resultados;
    }
}


