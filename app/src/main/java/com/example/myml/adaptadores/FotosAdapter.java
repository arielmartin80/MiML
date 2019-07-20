package com.example.myml.adaptadores;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myml.DescriptionActivity;
import com.example.myml.R;
import com.example.myml.modelo.Articulo;
import com.example.myml.modelo.Picture;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FotosAdapter extends RecyclerView.Adapter<com.example.myml.adaptadores.FotosAdapter.ViewHolder> {

    private List<Picture> fotos = new ArrayList();

    public FotosAdapter(List<Picture> fotos) { this.fotos = fotos;    }

    @Override
    public FotosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_foto, null);
        return new FotosAdapter.ViewHolder(itemLayoutView);
    }

    @Override
    public int getItemCount() {
        return fotos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img)
        public ImageView img;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    @Override
    public void onBindViewHolder(final FotosAdapter.ViewHolder holder, final int position) {
        final Picture foto = this.fotos.get(position);

        Picasso.with(holder.img.getContext()).load(foto.getSecure_url()).into(holder.img);


    }


}
