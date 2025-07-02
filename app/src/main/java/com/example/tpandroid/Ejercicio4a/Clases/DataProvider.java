package com.example.tpandroid.Ejercicio4a.Clases;

import com.example.tpandroid.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataProvider {

    public static List<Genero> getGeneros() {
        List<Genero> generos = new ArrayList<>();

        List<Artista> artistasPintura = Arrays.asList(
                new Artista("Vincent van Gogh", Arrays.asList(
                        new Obra("La noche estrellada", 1889, "Óleo sobre lienzo", 1000000, "Museo MoMA", R.drawable.starry_night),
                        new Obra("Los girasoles", 1888, "Naturaleza muerta", 800000, "Galería Nacional", R.drawable.sunflowers),
                        new Obra("Autorretrato", 1889, "Retrato", 500000, "Museo Van Gogh", R.drawable.self_portrait)
                )),
                new Artista("Claude Monet", Arrays.asList(
                        new Obra("Impresión, sol naciente", 1872, "Paisaje", 1100000, "Museo Marmottan", R.drawable.sunrise),
                        new Obra("Nenúfares", 1906, "Naturaleza", 950000, "Orangerie", R.drawable.water_lilies)
                )),
                new Artista("Pablo Picasso", Arrays.asList(
                        new Obra("Las señoritas de Avignon", 1907, "Cubismo", 1300000, "MoMA", R.drawable.les_demoiselles),
                        new Obra("La vida", 1903, "Simbólica", 1000000, "Cleveland Museum of Art", R.drawable.la_vie)
                ))
        );
        generos.add(new Genero("Pintura", artistasPintura));

        List<Artista> artistasEscultura = Arrays.asList(
                new Artista("Auguste Rodin", Arrays.asList(
                        new Obra("El pensador", 1904, "Bronce", 1500000, "Museo Rodin", R.drawable.thinker),
                        new Obra("La puerta del infierno", 1917, "Bronce", 1800000, "Museo Rodin", R.drawable.gates_of_hell)
                )),
                new Artista("Michelangelo", Arrays.asList(
                        new Obra("David", 1504, "Mármol", 3000000, "Galería de la Academia", R.drawable.david),
                        new Obra("Cristo Redentor", 1519, "Cristiana", 2000000, "Santa Maria sopra Minerva", R.drawable.christ_the_redeemer)
                ))

        );
        generos.add(new Genero("Escultura", artistasEscultura));

        List<Artista> artistasAbstracto = Arrays.asList(
                new Artista("Wassily Kandinsky", Arrays.asList(
                        new Obra("Improvisación 28", 1912, "Abstracto lírico", 870000, "Museo Guggenheim", R.drawable.improvisation_28)
                )),
                new Artista("Jackson Pollock", Arrays.asList(
                        new Obra("Convergencia", 1952, "Action painting", 1000000, "Albright-Knox", R.drawable.convergence),
                        new Obra("Lavender Mist", 1950, "Expresionismo", 940000, "National Gallery of Art", R.drawable.lavender_mist)
                ))
        );
        generos.add(new Genero("Arte Abstracto", artistasAbstracto));

        return generos;
    }
}
