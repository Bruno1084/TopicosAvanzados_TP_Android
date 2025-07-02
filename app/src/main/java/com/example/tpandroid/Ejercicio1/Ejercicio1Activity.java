package com.example.tpandroid.Ejercicio1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.tpandroid.R;

public class Ejercicio1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ejercicio1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Btn Formulario
        Button btnFormulario = findViewById(R.id.btnFormulario);
        btnFormulario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ir al formulario
                Intent intent = new Intent(Ejercicio1Activity.this, FormularioActivity.class);
                startActivity(intent);
            }
        });

        //Btn Tabla
        Button btnTabla = findViewById(R.id.btnTabla);
        btnTabla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ir al tabla
                Intent intent = new Intent(Ejercicio1Activity.this, TablaActivity.class);
                startActivity(intent);
            }
        });

        //Btn Lista
        Button btnLista = findViewById(R.id.btnLista);
        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ir a lista
                Intent intent = new Intent(Ejercicio1Activity.this, ListaActivity.class);
                startActivity(intent);
            }
        });
    }
}