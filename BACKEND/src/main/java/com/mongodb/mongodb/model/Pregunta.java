package com.mongodb.mongodb.model;

import java.util.List;

public class Pregunta {

    private String idpregunta;
    private String pregunta;
    private List<String> opciones;
    private List<Integer> escala;

    public Pregunta(){}

    public Pregunta(String idpregunta, String pregunta, List<Integer> escala, List<String> opciones) {
        this.idpregunta = idpregunta;
        this.pregunta = pregunta;
        this.escala = escala;
        this.opciones=opciones;
    }

    public String getIdpregunta() { return idpregunta; }

    public void setIdpregunta(String idpregunta) { this.idpregunta = idpregunta; }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public List<Integer> getEscala() {
        return escala;
    }

    public void setEscala(List<Integer> escala) { this.escala = escala; }

    public List<String> getOpciones() { return opciones; }

    public void setOpciones(List<String> opciones) { this.opciones = opciones; }
}


