package com.example.tpandroid.Ejercicio3;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.io.File;
import java.util.ArrayList;
import com.example.tpandroid.R;

public class Ejercicio3Activity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 200;
    private ArrayList<String> imageUris;
    private RecyclerView recyclerView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ejercicio3);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imageUris = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerViewEj3);

        requestPermissions();
//        prepareRecyclerView();
    }

    private boolean checkPermission() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            return ContextCompat.checkSelfPermission(this, Manifest.permission.READ_MEDIA_IMAGES)
                    == PackageManager.PERMISSION_GRANTED;
        } else {
            return ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED;
        }
    }

    private void requestPermissions() {
        if (checkPermission()) {
            Toast.makeText(this, "Permissions granted.", Toast.LENGTH_SHORT).show();
            fetchImagePaths();
            prepareRecyclerView();
            fetchImagePaths();
        } else {
            requestPermission();
        }
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(
                this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                PERMISSION_REQUEST_CODE
        );
    }

    private void prepareRecyclerView() {
        if (imageUris == null || imageUris.isEmpty()) {
            Toast.makeText(this, "No se encontraron imágenes", Toast.LENGTH_SHORT).show();
            return;
        }

        Adapter adapter = new Adapter(this, imageUris);
        GridLayoutManager manager = new GridLayoutManager(this, 4);

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }


    private void fetchImagePaths() {
        boolean isSDPresent = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);

        if (isSDPresent) {
            String[] columns = {MediaStore.Images.Media.DATA, MediaStore.Images.Media._ID};
            String orderBy = MediaStore.Images.Media._ID;

            Cursor cursor = getContentResolver().query(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    columns,
                    null,
                    null,
                    orderBy
            );

            if (cursor != null) {
                int dataColumnIndex = cursor.getColumnIndex(MediaStore.Images.Media.DATA);
                while (cursor.moveToNext()) {
                    String path = cursor.getString(dataColumnIndex);
                    if (new File(path).exists()) {
                        imageUris.add(path);
                    }
                }
                cursor.close();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode,
            @NonNull String[] permissions,
            @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permissions Granted.", Toast.LENGTH_SHORT).show();
                fetchImagePaths();
                prepareRecyclerView();
            } else {
                Toast.makeText(this, "Permission denied. App needs access to images.",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

}