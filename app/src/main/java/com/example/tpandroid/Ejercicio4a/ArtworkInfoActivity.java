package com.example.tpandroid.Ejercicio4a;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.example.tpandroid.Ejercicio4a.Clases.Obra;
import com.example.tpandroid.R;

public class ArtworkInfoActivity extends AppCompatActivity {

    private ImageView imageObra;
    private TextView tvTitulo, tvAnio, tvDescripcion, tvPrecio, tvDueno;
    private Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artwork_info);

        imageObra = findViewById(R.id.imageObra);
        tvTitulo = findViewById(R.id.tvTitulo);
        tvAnio = findViewById(R.id.tvAnio);
        tvDescripcion = findViewById(R.id.tvDescripcion);
        tvPrecio = findViewById(R.id.tvPrecio);
        tvDueno = findViewById(R.id.tvDueno);
        btnVolver = findViewById(R.id.btnVolver);

        Obra obra = (Obra) getIntent().getSerializableExtra("obra");

        if (obra != null) {
            Glide.with(this).load(obra.getImagenResId()).into(imageObra);
            tvTitulo.setText("Título: " + obra.getTitulo());
            tvAnio.setText("Año: " + obra.getAnio());
            tvDescripcion.setText("Descripción: " + obra.getDescripcion());
            tvPrecio.setText("Precio estimado: $" + obra.getPrecio());
            tvDueno.setText("Dueño actual: " + obra.getDuenio());
        }

        btnVolver.setOnClickListener(v -> finish());
    }
}
