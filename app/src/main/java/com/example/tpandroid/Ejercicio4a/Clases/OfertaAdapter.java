package com.example.tpandroid.Ejercicio4a.Clases;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tpandroid.R;
import java.util.List;

public class OfertaAdapter extends RecyclerView.Adapter<OfertaAdapter.ViewHolder> {

    private final List<Oferta> lista;

    public OfertaAdapter(List<Oferta> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public OfertaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_oferta, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OfertaAdapter.ViewHolder holder, int position) {
        Oferta oferta = lista.get(position);
        holder.tvObra.setText("Obra: " + oferta.getObra().getTitulo());
        holder.tvNombre.setText("Ofertante: " + oferta.getNombre());
        holder.tvMonto.setText("Oferta: $" + oferta.getMonto());
        holder.tvContacto.setText("Email: " + oferta.getEmail() + " | Tel: " + oferta.getTelefono());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvObra, tvNombre, tvMonto, tvContacto;

        ViewHolder(View itemView) {
            super(itemView);
            tvObra = itemView.findViewById(R.id.tvObra);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvMonto = itemView.findViewById(R.id.tvMonto);
            tvContacto = itemView.findViewById(R.id.tvContacto);
        }
    }
}
