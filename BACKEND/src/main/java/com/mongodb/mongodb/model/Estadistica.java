package com.mongodb.mongodb.model;

import java.util.List;

public class Estadistica {

    private List<String> categorias;
    private List<Integer> resultados;
    private List<String> fecha;

    public Estadistica(){}

    public Estadistica(List<String> categorias, List<Integer> resultados, List<String> fecha){
        this.categorias = categorias;
        this.resultados = resultados;
        this.fecha = fecha;
    }

    public List<String> getCategorias() { return categorias; }

    public void setCategorias(List<String> categorias) { this.categorias = categorias; }

    public List<Integer> getResultados() { return resultados; }

    public void setResultados(List<Integer> resultados) { this.resultados = resultados; }

    public List<String> getFecha() { return fecha; }

    public void setFecha(List<String> fecha) { this.fecha = fecha; }
}
