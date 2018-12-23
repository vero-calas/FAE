package com.mongodb.mongodb.model;

import java.util.Date;

public class Filtro {
    private String categoria_id;
    private String region_id;
    private Integer tipoEncuesta;
    private String variableSD;
    private Date fechaInicial;
    private Date fechaFinal;

    public Filtro(){}

    public Filtro(String categoria_id, String region_id, Integer tipoEncuesta, String variableSD, Date fechaInicial, Date fechaFinal) {
        this.categoria_id = categoria_id;
        this.region_id = region_id;
        this.tipoEncuesta = tipoEncuesta;
        this.variableSD = variableSD;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
    }

    public String getCategoria_id() { return categoria_id;  }

    public void setCategoria_id(String categoria_id) { this.categoria_id = categoria_id; }

    public String getRegion_id() { return region_id; }

    public void setRegion_id(String region_id) { this.region_id = region_id; }

    public Integer getTipoEncuesta() { return tipoEncuesta; }

    public void setTipoEncuesta(Integer tipoEncuesta) { this.tipoEncuesta = tipoEncuesta; }

    public String getVariableSD() { return variableSD; }

    public void setVariableSD(String variableSD) { this.variableSD = variableSD; }

    public Date getFechaInicial() { return fechaInicial; }

    public void setFechaInicial(Date fechaInicial) { this.fechaInicial = fechaInicial; }

    public Date getFechaFinal() { return fechaFinal; }

    public void setFechaFinal(Date fechaFinal) { this.fechaFinal = fechaFinal; }

}
