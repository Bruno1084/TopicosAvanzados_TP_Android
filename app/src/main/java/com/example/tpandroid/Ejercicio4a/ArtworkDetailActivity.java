package com.example.tpandroid.Ejercicio4a;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.example.tpandroid.Ejercicio4a.Clases.Artista;
import com.example.tpandroid.Ejercicio4a.Clases.ArtworkPagerAdapter;
import com.example.tpandroid.Ejercicio4a.Clases.Obra;
import com.example.tpandroid.R;
import java.util.List;

public class ArtworkDetailActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private Button btnInfo, btnOfertar;
    private List<Obra> obras;
    private Artista artista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artwork_detail);

        viewPager = findViewById(R.id.viewPager);
        btnInfo = findViewById(R.id.btnInfo);
        btnOfertar = findViewById(R.id.btnOfertar);

        obras = (List<Obra>) getIntent().getSerializableExtra("obras");
        int position = getIntent().getIntExtra("position", 0);
        artista = (Artista) getIntent().getSerializableExtra("artista");

        ArtworkPagerAdapter adapter = new ArtworkPagerAdapter(this, obras);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(position, false);

        btnInfo.setOnClickListener(v -> {
            Obra obraActual = obras.get(viewPager.getCurrentItem());
            Intent intent = new Intent(this, ArtworkInfoActivity.class);
            intent.putExtra("obra", obraActual);
            startActivity(intent);
        });

        btnOfertar.setOnClickListener(v -> {
            Obra obraActual = obras.get(viewPager.getCurrentItem());
            Intent intent = new Intent(this, OfferActivity.class);
            intent.putExtra("obra", obraActual);
            startActivity(intent);
        });
    }
}
