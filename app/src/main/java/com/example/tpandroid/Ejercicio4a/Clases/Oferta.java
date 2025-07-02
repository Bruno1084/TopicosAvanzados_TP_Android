package com.example.tpandroid.Ejercicio4a.Clases;

import java.io.Serializable;

public class Oferta implements Serializable {
    private final String nombre;
    private final String email;
    private final String telefono;
    private final double monto;
    private final Obra obra;

    public Oferta(String nombre, String email, String telefono, double monto, Obra obra) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.monto = monto;
        this.obra = obra;
    }

    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }
    public double getMonto() { return monto; }
    public Obra getObra() { return obra; }
}
