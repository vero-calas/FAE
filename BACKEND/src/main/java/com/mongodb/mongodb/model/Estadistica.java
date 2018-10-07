package com.mongodb.mongodb.model;

import java.util.List;

public class Estadistica {

    private List<String> categorias;
    private List<Integer> resultados;
    private int mes;
    private int anio;

    public Estadistica(){}

    public Estadistica(List<String> categorias, List<Integer> resultados, int mes, int anio){
        this.categorias = categorias;
        this.resultados = resultados;
        this.anio = anio;
        this.mes = mes;
    }

    public List<String> getCategorias() { return categorias; }

    public void setCategorias(List<String> categorias) { this.categorias = categorias; }

    public List<Integer> getResultados() { return resultados; }

    public void setResultados(List<Integer> resultados) { this.resultados = resultados; }

    public int getMes() { return mes; }

    public void setMes(int mes) { this.mes = mes; }

    public int getAnio() { return anio; }

    public void setAnio(int anio) { this.anio = anio; }
}
