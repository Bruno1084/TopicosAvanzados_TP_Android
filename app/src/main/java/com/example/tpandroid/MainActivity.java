package com.example.tpandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.tpandroid.Ejercicio1.Ejercicio1Activity;
import com.example.tpandroid.Ejercicio2.Ejercicio2Activity;
import com.example.tpandroid.Ejercicio3.Ejercicio3Activity;
import com.example.tpandroid.Ejercicio4a.Ejercicio4aActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Btn Ejercicio1
        Button btnEj1 = findViewById(R.id.btnEj1);
        btnEj1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ir al ejercicio 1
                Intent intent = new Intent(MainActivity.this, Ejercicio1Activity.class);
                startActivity(intent);
            }
        });

        //Btn Ejercicio2
        Button btnEj2 = findViewById(R.id.btnEj2);
        btnEj2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ir al ejercicio 2
                Intent intent = new Intent(MainActivity.this, Ejercicio2Activity.class);
                startActivity(intent);
            }
        });

        //Btn Ejercicio3
        Button btnEj3 = findViewById(R.id.btnEj3);
        btnEj3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ir al ejercicio 2
                Intent intent = new Intent(MainActivity.this, Ejercicio3Activity.class);
                startActivity(intent);
            }
        });

        //Btn Ejercicio4a
        Button btnEj4a = findViewById(R.id.btnEj4a);
        btnEj4a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ir al ejercicio 4a
                Intent intent = new Intent(MainActivity.this, Ejercicio4aActivity.class);
                startActivity(intent);
            }
        });
    }
}