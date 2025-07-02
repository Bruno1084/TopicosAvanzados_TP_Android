package com.example.tpandroid.Ejercicio4a;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.tpandroid.Ejercicio4a.Clases.Obra;
import com.example.tpandroid.Ejercicio4a.Clases.Oferta;
import com.example.tpandroid.Ejercicio4a.Clases.OfertaRepository;
import com.example.tpandroid.R;

public class OfferActivity extends AppCompatActivity {

    private TextView tvObraSeleccionada;
    private EditText etNombre, etEmail, etTelefono, etOferta;
    private Button btnGuardar, btnCancelar;
    private Obra obraSeleccionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer);

        tvObraSeleccionada = findViewById(R.id.tvObraSeleccionada);
        etNombre = findViewById(R.id.etNombre);
        etEmail = findViewById(R.id.etEmail);
        etTelefono = findViewById(R.id.etTelefono);
        etOferta = findViewById(R.id.etOferta);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnCancelar = findViewById(R.id.btnCancelar);

        obraSeleccionada = (Obra) getIntent().getSerializableExtra("obra");

        if (obraSeleccionada != null) {
            tvObraSeleccionada.setText("Ofertar por: " + obraSeleccionada.getTitulo());
        } else {
            Toast.makeText(this, "Error: No se recibió la obra", Toast.LENGTH_SHORT).show();
            finish();
        }

        btnGuardar.setOnClickListener(v -> guardarOferta());

        btnCancelar.setOnClickListener(v -> finish());
    }

    private void guardarOferta() {
        String nombre = etNombre.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String telefono = etTelefono.getText().toString().trim();
        String montoStr = etOferta.getText().toString().trim();

        if (nombre.isEmpty() || email.isEmpty() || telefono.isEmpty() || montoStr.isEmpty()) {
            Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
            return;
        }

        double monto;
        try {
            monto = Double.parseDouble(montoStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "El monto debe ser un número válido", Toast.LENGTH_SHORT).show();
            return;
        }

        Oferta nuevaOferta = new Oferta(nombre, email, telefono, monto, obraSeleccionada);
        OfertaRepository.agregarOferta(nuevaOferta);

        Toast.makeText(this, "Oferta guardada con éxito", Toast.LENGTH_SHORT).show();
        finish();
    }
}
