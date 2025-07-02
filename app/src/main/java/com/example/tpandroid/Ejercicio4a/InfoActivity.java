package com.example.tpandroid.Ejercicio4a;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tpandroid.R;

public class InfoActivity extends AppCompatActivity {
    private Button btnVolver, btnIrAGeneros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_info);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnVolver = findViewById(R.id.btnVolver);
        btnIrAGeneros = findViewById(R.id.btnIrAGeneros);

        btnVolver.setOnClickListener(v -> {
            Intent intent = new Intent(InfoActivity.this, Ejercicio4aActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });

        btnIrAGeneros.setOnClickListener(v -> {
            Intent intent = new Intent(InfoActivity.this, GenresActivity.class);
            startActivity(intent);
        });
    }
}