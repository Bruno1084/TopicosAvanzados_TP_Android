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

public class Ejercicio4aActivity extends AppCompatActivity {
    private Button btnInfo, btnGenres, btnOffers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ejercicio4a);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnInfo = findViewById(R.id.btnInfo);
        btnGenres = findViewById(R.id.btnGenres);
        btnOffers = findViewById(R.id.btnOffers);

        btnInfo.setOnClickListener(v -> {
            Intent intent = new Intent(Ejercicio4aActivity.this, InfoActivity.class);
            startActivity(intent);
        });

        btnGenres.setOnClickListener(v -> {
            Intent intent = new Intent(Ejercicio4aActivity.this, GenresActivity.class);
            startActivity(intent);
        });

        btnOffers.setOnClickListener(v -> {
            Intent intent = new Intent(Ejercicio4aActivity.this, OffersListActivity.class);
            startActivity(intent);
        });
    }
}