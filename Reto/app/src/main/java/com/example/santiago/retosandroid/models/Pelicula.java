package com.example.santiago.retosandroid.models;

/**
 * Created by Santiago on 11/10/2017.
 */

public class Pelicula {

    private String titulo, descripcion, anio, imagen;

    public Pelicula(String titulo, String descripcion, String anio, String imagen){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.anio = anio;
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        return cadena.append("Pelicula{ ").append("Titulo:").append(titulo).append("Description: ").
                append(descripcion).append("Año: ").append(anio).append(" }").toString();
    }
}
