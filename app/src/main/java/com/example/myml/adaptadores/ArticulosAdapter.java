package com.example.myml.adaptadores;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myml.R;
import com.example.myml.modelo.Articulo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticulosAdapter extends RecyclerView.Adapter<ArticulosAdapter.ViewHolder> {

    private List<Articulo> articulos = new ArrayList();

    public ArticulosAdapter(List<Articulo> articulos) {
        this.articulos = articulos;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_articulo, null);
        return new ArticulosAdapter.ViewHolder(itemLayoutView);
    }

    @Override
    public int getItemCount() {
        return articulos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.titulo)
        TextView titulo;

        @BindView(R.id.precio)
        TextView precio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Articulo articulo = this.articulos.get(position);
        holder.titulo.setText(articulo.getTitulo());
        holder.precio.setText(articulo.getPrecio().toString());
    }


}
