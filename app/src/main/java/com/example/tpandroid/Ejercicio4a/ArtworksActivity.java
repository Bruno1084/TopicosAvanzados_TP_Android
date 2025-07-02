package com.example.tpandroid.Ejercicio4a;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tpandroid.Ejercicio4a.Clases.Artista;
import com.example.tpandroid.Ejercicio4a.Clases.Obra;
import com.example.tpandroid.Ejercicio4a.Clases.ObraAdapter;
import com.example.tpandroid.R;
import java.util.List;

public class ArtworksActivity extends AppCompatActivity {

    private RecyclerView rvObras;
    private TextView tvArtista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artworks);

        tvArtista = findViewById(R.id.tvArtista);
        rvObras = findViewById(R.id.rvObras);

        Artista artista = (Artista) getIntent().getSerializableExtra("artista");

        if (artista != null) {
            tvArtista.setText("Obras de " + artista.getNombre());
            List<Obra> obras = artista.getObras();

            ObraAdapter adapter = new ObraAdapter(this, obras, artista);
            rvObras.setLayoutManager(new GridLayoutManager(this, 2));
            rvObras.setAdapter(adapter);
        }
    }
}
