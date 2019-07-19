package com.example.myml.adaptadores;

import android.content.Context;
import android.graphics.Color;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myml.DescriptionActivity;
import com.example.myml.ListActivity;
import com.example.myml.R;
import com.example.myml.modelo.Articulo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.support.v4.content.ContextCompat.startActivity;

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

        public Articulo articulo;
        @BindView(R.id.titulo)
        TextView titulo;

        @BindView(R.id.precio)
        TextView precio;

        @BindView(R.id.img)
        public ImageView img;

        @BindView(R.id.item)
        public View item;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Articulo articulo = this.articulos.get(position);
        holder.titulo.setText(articulo.getTitulo());
        holder.precio.setText(articulo.getPrecio().toString());

        Picasso.with(holder.img.getContext()).load(articulo.getFoto()).into(holder.img);

        if (position%2  == 0) {
            holder.item.setBackgroundColor(Color.parseColor("#dccac6"));
        } else {
            holder.item.setBackgroundColor(Color.parseColor("#eddddd"));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(), DescriptionActivity.class);
                i.putExtra("dato", articulo.getId());
                v.getContext().startActivity(i);

                //String dato = articulo.getId();
                //Toast.makeText(v.getContext(),dato, Toast.LENGTH_LONG).show();
            }
        });

    }


}
