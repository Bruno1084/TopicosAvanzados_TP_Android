package com.example.tpandroid.Ejercicio4a.Clases;

import java.io.Serializable;
import java.util.List;

public class Genero implements Serializable {
    private String nombre;
    private List<Artista> artistas;

    public Genero(String nombre, List<Artista> artistas) {
        this.nombre = nombre;
        this.artistas = artistas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<Artista> artistas) {
        this.artistas = artistas;
    }
}
