package com.mongodb.mongodb.model;

public class Resultado {

    private String IDCategoria;
    private String IDPregunta;
    private Integer respuesta; //Numero

    public Resultado(){}

    public Resultado(String IDCategoria, String IDPregunta, Integer respuesta) {
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

    public String getIDPregunta() {
        return IDPregunta;
    }

    public void setIDPregunta(String IDPregunta) {
        this.IDPregunta = IDPregunta;
    }

    public Integer getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Integer respuesta) {
        this.respuesta = respuesta;
    }
}
