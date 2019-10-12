package com.example.tiedafragment.Entidades;

public class Categorias {
    int id;
    String descripcion;
    String imagen_baner;
    String imagen_cuadrada;

    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setImagen_baner(String imagen_baner) {
        this.imagen_baner = imagen_baner;
    }

    public void setImagen_cuadrada(String imagen_cuadrada) {
        this.imagen_cuadrada = imagen_cuadrada;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getImagen_baner() {
        return imagen_baner;
    }

    public String getImagen_cuadrada() {
        return imagen_cuadrada;
    }
}
