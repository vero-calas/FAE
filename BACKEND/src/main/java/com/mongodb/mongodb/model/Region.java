package com.mongodb.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "regiones")
public class Region {

    @Id
    public String ID;

    @Field("nombre")
    public String nombre;

    public Region(){}

    public Region(String ID, String nombre) {
        this.ID = ID;
        this.nombre = nombre;
    }

    public String getID() { return ID; }

    public void setID(String ID) { this.ID = ID; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

}
