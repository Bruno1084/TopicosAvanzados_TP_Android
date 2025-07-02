package com.example.tpandroid.Ejercicio4a.Clases;

import java.io.Serializable;

public class Obra implements Serializable {
    private String titulo;
    private int anio;
    private String descripcion;
    private double precio;
    private String duenio;
    private int imagenResId;

    public Obra(String titulo, int anio, String descripcion, double precio, String duenio, int imagenResId) {
        this.titulo = titulo;
        this.anio = anio;
        this.descripcion = descripcion;
        this.precio = precio;
        this.duenio = duenio;
        this.imagenResId = imagenResId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDuenio() {
        return duenio;
    }

    public void setDuenio(String duenio) {
        this.duenio = duenio;
    }

    public int getImagenResId() {
        return imagenResId;
    }

    public void setImagenResId(int imagenResId) {
        this.imagenResId = imagenResId;
    }
}
