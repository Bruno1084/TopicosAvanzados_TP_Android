package com.example.tpandroid.Ejercicio4a;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tpandroid.Ejercicio4a.Clases.Oferta;
import com.example.tpandroid.Ejercicio4a.Clases.OfertaAdapter;
import com.example.tpandroid.Ejercicio4a.Clases.OfertaRepository;
import com.example.tpandroid.R;
import java.util.List;

public class OffersListActivity extends AppCompatActivity {

    private RecyclerView rvOfertas;
    private Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers_list);

        rvOfertas = findViewById(R.id.rvOfertas);
        btnVolver = findViewById(R.id.btnVolver);

        List<Oferta> ofertas = OfertaRepository.getOfertas();
        OfertaAdapter adapter = new OfertaAdapter(ofertas);

        rvOfertas.setLayoutManager(new LinearLayoutManager(this));
        rvOfertas.setAdapter(adapter);

        btnVolver.setOnClickListener(v -> finish());
    }
}
