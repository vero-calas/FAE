package com.mongodb.mongodb.model;

import java.util.List;

public class Resultado {

    private String IDCategoria;
    private List<String> IDPregunta;
    private List<Integer> respuesta;

    public Resultado(){}

    public Resultado(String IDCategoria, List<String> IDPregunta, List<Integer> respuesta) {
        this.IDCategoria = IDCategoria;
        this.IDPregunta = IDPregunta;
        this.respuesta = respuesta;
    }

    public String getIDCategoria() {
        return IDCategoria;
    }

    public void setIDCategoria(String IDCategoria) {
        this.IDCategoria = IDCategoria;
    }

    public List<String> getIDPregunta() {
        return IDPregunta;
    }

    public void setIDPregunta(List<String> IDPregunta) {
        this.IDPregunta = IDPregunta;
    }

    public List<Integer> getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(List<Integer> respuesta) {
        this.respuesta = respuesta;
    }
}
