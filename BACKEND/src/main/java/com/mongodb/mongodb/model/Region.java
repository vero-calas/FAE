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

    @Field("estadisticas")
    public List<Estadistica> estadisticas;

    public Region(){}

    public Region(String ID, String nombre, List<Estadistica> estadisticas) {
        this.ID = ID;
        this.nombre = nombre;
        this.estadisticas = estadisticas;
    }

    public String getID() { return ID; }

    public void setID(String ID) { this.ID = ID; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<Estadistica> getEstadisticas() { return estadisticas; }

    public void setEstadisticas(List<Estadistica> estadisticas) { this.estadisticas = estadisticas; }
}
