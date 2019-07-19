package com.example.myml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLogTags;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myml.API.API;
import com.example.myml.modelo.Articulo;
import com.example.myml.modelo.Descripcion;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DescriptionActivity extends AppCompatActivity {

    @BindView(R.id.titulo) TextView titulo;
    @BindView(R.id.img) public ImageView img;
    @BindView(R.id.precio_cantidad) public TextView precio;
    @BindView(R.id.garantia) public TextView garantia;
    @BindView(R.id.nuevo_usado) public TextView nuevo_usado;
    @BindView(R.id.cantidad_vendidos) public TextView cantidad_vendidos;
    @BindView(R.id.cantidad_actual) public TextView cantidad_actual;
    @BindView(R.id.cantidad_inicial) public TextView cantidad_inicial;

    @BindView(R.id.descripcion_texto) TextView descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        ButterKnife.bind(this);

        final String id = getIntent().getStringExtra("dato");
        //titulo.setText(id);

        API.getArticulo(id, new Callback<Articulo>() {

            @Override
            public void onResponse(Call<Articulo> call, Response<Articulo> response) {
                if(response.isSuccessful()) {
                    Articulo received = response.body();
                    titulo.setText(received.getTitulo());
                    String foto = received.getPictures().get(0).getUrl();
                    Picasso.with(getApplicationContext()).load(foto).into(img);
                    precio.setText( (received.getPrecio()).toString() );
                    garantia.setText(received.getGarantia());
                    nuevo_usado.setText(received.getCondition());
                    cantidad_inicial.setText(received.getInitial_quantity());
                    cantidad_vendidos.setText(received.getSold_quantity());
                    cantidad_actual.setText(received.getAvailable_quantity());

                }
            }

            @Override
            public void onFailure(Call<Articulo> call, Throwable t) {
                    titulo.setText("item incorrecto");
            }

        });


        API.getArticuloDescription(id, new Callback<Descripcion>() {

            @Override
            public void onResponse(Call<Descripcion> call, Response<Descripcion> response) {
                if(response.isSuccessful()) {
                    Descripcion received = response.body();
                    descripcion.setText(received.getPlain_text());

                }
            }

            @Override
            public void onFailure(Call<Descripcion> call, Throwable t) {
                descripcion.setText("no esta disponible la descripcion");
            }

        });




    }


}
