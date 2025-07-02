package com.example.tpandroid.Ejercicio4a;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.tpandroid.Ejercicio4a.Clases.DataProvider;
import com.example.tpandroid.Ejercicio4a.Clases.Genero;
import com.example.tpandroid.R;
import java.util.List;

public class GenresActivity extends AppCompatActivity {

    private LinearLayout genreContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genres);

        genreContainer = findViewById(R.id.genreContainer);

        List<Genero> generos = DataProvider.getGeneros();

        for (Genero genero : generos) {
            Button btn = new Button(this);
            btn.setText(genero.getNombre());
            btn.setOnClickListener(v -> {
                Intent intent = new Intent(this, ArtistsActivity.class);
                intent.putExtra("genero", genero);
                startActivity(intent);
            });
            genreContainer.addView(btn);
        }
    }
}
