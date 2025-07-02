package com.example.tpandroid.Ejercicio4a.Clases;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.tpandroid.R;
import java.util.List;

public class ArtworkPagerAdapter extends RecyclerView.Adapter<ArtworkPagerAdapter.ViewHolder> {

    private final Context context;
    private final List<Obra> obras;

    public ArtworkPagerAdapter(Context context, List<Obra> obras) {
        this.context = context;
        this.obras = obras;
    }

    @NonNull
    @Override
    public ArtworkPagerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_artwork_pager, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtworkPagerAdapter.ViewHolder holder, int position) {
        Obra obra = obras.get(position);

        Glide.with(context).load(obra.getImagenResId()).into(holder.imageObra);

        holder.imageObra.setOnClickListener(v -> {
        });
    }

    @Override
    public int getItemCount() {
        return obras.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageObra;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageObra = itemView.findViewById(R.id.imageObraPager);
        }
    }
}
