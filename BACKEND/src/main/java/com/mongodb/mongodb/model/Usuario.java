package com.mongodb.mongodb.model;

import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.annotation.Id;

public class Usuario {

    @Id
    public String ID;

    @Field("nombre")
    public String nombre;

    @Field("correo")
    public String correo;

    @Field("contrasena")
    public String contrasena;

    @Field("activo")
    public Boolean activo;

    @Field("rol")
    public Integer rol; //1 = admin y 2 = empresa

    @Field("telefono")
    public String telefono;

    public Usuario(){}

    public Usuario(String ID, String nombre, String correo, String contrasena, Boolean activo, Integer rol, String telefono) {
        this.ID = ID;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.activo = activo;
        this.rol = rol;
        this.telefono = telefono;
    }

    public String getID() { return ID; }

    public void setID(String ID) { this.ID = ID; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }

    public void setCorreo(String correo) { this.correo = correo; }

    public String getContrasena() { return contrasena; }

    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public Boolean getActivo() { return activo; }

    public void setActivo(Boolean activo) { this.activo = activo; }

    public Integer getRol() { return rol; }

    public void setRol(Integer rol) { this.rol = rol; }

    public String getTelefono() { return telefono; }

    public void setTelefono(String telefono) { this.telefono = telefono; }
}
