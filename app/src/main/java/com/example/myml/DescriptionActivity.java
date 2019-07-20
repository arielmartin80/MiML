package com.example.myml;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myml.API.API;
import com.example.myml.adaptadores.ArticulosAdapter;
import com.example.myml.adaptadores.FotosAdapter;
import com.example.myml.modelo.Articulo;
import com.example.myml.modelo.Descripcion;
import com.example.myml.modelo.Picture;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DescriptionActivity extends AppCompatActivity {

    private FotosAdapter adapter;

    @BindView(R.id.recyclerHorizontal)
    RecyclerView recyclerView;

    @BindView(R.id.titulo) TextView titulo;
    @BindView(R.id.img) public ImageView img;
    @BindView(R.id.precio_cantidad) public TextView precio;
    @BindView(R.id.garantia) public TextView garantia;
    @BindView(R.id.nuevo_usado) public TextView nuevo_usado;
    @BindView(R.id.cantidad_vendidos) public TextView cantidad_vendidos;
    @BindView(R.id.cantidad_actual) public TextView cantidad_actual;
    @BindView(R.id.zona) TextView zona;

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
                    String estado = received.getCondition();

                    if(estado.equals("new")) {
                        nuevo_usado.setText("NUEVO");
                    }else{
                        nuevo_usado.setText("USADO");
                    }
                    cantidad_vendidos.setText(received.getSold_quantity());
                    cantidad_actual.setText(received.getAvailable_quantity());
                    zona.setText(received.getSeller_address().getZona());

                    configurarRecyclerView(received.getPictures());

                    /*  Variables de Testing
                    String lista = new Gson().toJson(received.getPictures().toString());
                    String lista2 = received.getSeller_address().toString();
                    String message = lista;
                    new AlertDialog.Builder(DescriptionActivity.this).setTitle("Testing, OK para continuar").setMessage(message).setPositiveButton("ok", null).show();
                    */
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


    private void configurarRecyclerView(List<Picture> fotos) {

        RecyclerView.LayoutManager lm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(lm);

        adapter = new FotosAdapter(fotos);
        recyclerView.setAdapter(adapter);
    }


}
