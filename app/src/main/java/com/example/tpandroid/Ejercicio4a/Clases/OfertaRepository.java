package com.example.tpandroid.Ejercicio4a.Clases;

import java.util.ArrayList;
import java.util.List;

public class OfertaRepository {
    private static final List<Oferta> listaOfertas = new ArrayList<>();

    public static void agregarOferta(Oferta o) {
        listaOfertas.add(o);
    }

    public static List<Oferta> getOfertas() {
        return new ArrayList<>(listaOfertas);
    }
}
