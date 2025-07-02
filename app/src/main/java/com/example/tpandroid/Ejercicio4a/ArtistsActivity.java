package com.example.tpandroid.Ejercicio4a;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.tpandroid.Ejercicio4a.Clases.Artista;
import com.example.tpandroid.Ejercicio4a.Clases.Genero;
import com.example.tpandroid.R;
import java.util.List;

public class ArtistsActivity extends AppCompatActivity {

    private LinearLayout artistContainer;
    private TextView tvGeneroSeleccionado;
    private Genero generoRecibido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);

        artistContainer = findViewById(R.id.artistContainer);
        tvGeneroSeleccionado = findViewById(R.id.tvGeneroSeleccionado);

        generoRecibido = (Genero) getIntent().getSerializableExtra("genero");

        if (generoRecibido != null) {
            tvGeneroSeleccionado.setText("Artistas de " + generoRecibido.getNombre());

            List<Artista> artistas = generoRecibido.getArtistas();

            for (Artista artista : artistas) {
                Button btn = new Button(this);
                btn.setText(artista.getNombre());
                btn.setOnClickListener(v -> {
                    Intent intent = new Intent(this, ArtworksActivity.class);
                    intent.putExtra("artista", artista);
                    startActivity(intent);
                });
                artistContainer.addView(btn);
            }
        }
    }
}
