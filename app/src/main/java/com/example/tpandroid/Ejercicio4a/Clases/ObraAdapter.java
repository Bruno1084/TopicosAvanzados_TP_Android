package com.example.tpandroid.Ejercicio4a.Clases;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tpandroid.Ejercicio4a.ArtworkDetailActivity;
import com.example.tpandroid.R;
import com.bumptech.glide.Glide;
import java.util.List;

public class ObraAdapter extends RecyclerView.Adapter<ObraAdapter.ObraViewHolder> {

    private final Context context;
    private final List<Obra> obras;
    private final Artista artista;

    public ObraAdapter(Context context, List<Obra> obras, Artista artista) {
        this.context = context;
        this.obras = obras;
        this.artista = artista;
    }

    @NonNull
    @Override
    public ObraViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_obra, parent, false);
        return new ObraViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ObraViewHolder holder, int position) {
        Obra obra = obras.get(position);
        Glide.with(context).load(obra.getImagenResId()).into(holder.image);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ArtworkDetailActivity.class);
            intent.putExtra("obras", (java.io.Serializable) obras);
            intent.putExtra("position", position);
            intent.putExtra("artista", artista);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return obras.size();
    }

    static class ObraViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        public ObraViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.ivObra);
        }
    }
}
