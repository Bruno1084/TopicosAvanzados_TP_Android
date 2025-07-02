package com.example.tpandroid.Ejercicio3;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.example.tpandroid.R;
import java.io.File;
import java.util.ArrayList;

public class ImageDetailActivity extends AppCompatActivity {
    private ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_image_detail);
        viewPager2 = findViewById(R.id.viewPager);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ArrayList<String> imagePaths = getIntent().getStringArrayListExtra("imageList");
        int initialPosition = getIntent().getIntExtra("position", 0);

        if (imagePaths != null) {
            ImagePagerAdapter adapter = new ImagePagerAdapter(this, imagePaths);
            viewPager2.setAdapter(adapter);
            viewPager2.setCurrentItem(initialPosition, false);
        }
    }
}