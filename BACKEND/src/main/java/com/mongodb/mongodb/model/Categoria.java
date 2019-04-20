package com.mongodb.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.List;

@Document(collection = "categorias")
public class Categoria {

    @Id
    public String ID;

    @Field("nombre")
    public String nombre;

    @Field("descripcion")
    public String descripcion;

    @Field("preguntas")
    public List<Pregunta> preguntas;

    @Field("empresa")
    public String empresa;

    public Categoria(){}

    public Categoria(String id, String nombre, String descripcion, List<Pregunta> preguntas, String empresa) {
        this.ID = ID;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.preguntas = preguntas;
        this.empresa = empresa;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public String getEmpresa() { return empresa; }

    public void setEmpresa(String empresa) { this.empresa = empresa; }
}
