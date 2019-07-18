package com.example.myml;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myml.API.API;
import com.example.myml.adaptadores.ArticulosAdapter;
import com.example.myml.modelo.Articulo;
import com.example.myml.modelo.ResultadoBusqueda;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivity extends AppCompatActivity {

    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    private ArticulosAdapter adapter;

    @BindView (R.id.tv_resultado) TextView tv_resultado;
    //@BindView (R.id.titulo_list) TextView titulo_list;
    //@BindView(R.id.img) public ImageView img;
    //@BindView (R.id.precio_list) TextView precio_list;

    Articulo articulo ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);

        ResultadoBusqueda lista = new ResultadoBusqueda();

        String dato = getIntent().getStringExtra("dato");
        tv_resultado.setText(dato);

        //resultados de la API
        API.searchArticulos(dato, new Callback<ResultadoBusqueda>() {

            @Override
            public void onResponse(Call<ResultadoBusqueda> call, Response<ResultadoBusqueda> response) {
                if(response.isSuccessful()) {
                    ResultadoBusqueda received = response.body();

                    if (!received.getResults().isEmpty()) {
                        //articulo = received.getResults().get(0);
                        //titulo_list.setText( articulo.getTitulo() );
                        //Picasso.with(getApplicationContext()).load(articulo.getFoto()).into(img);
                        //precio_list.setText(articulo.getPrecio().toString());

                        configurarRecyclerView(received.getResults());


                    } else {
                        
                    }



                }
            }

            @Override
            public void onFailure(Call<ResultadoBusqueda> call, Throwable t) {
                //tv_resultado.setText("item incorrecto");
            }

        });


    }

    //metodo para ir a la descripcion
    //@OnClick(R.id.item1)
    //public void IrADescripcion(View view){
    //   Intent i = new Intent(this, DescriptionActivity.class);
    //   i.putExtra("dato", articulo.getId());
    //   startActivity(i);
    //}


    private void configurarRecyclerView(List<Articulo> articulos) {

        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lm);

        adapter = new ArticulosAdapter(articulos);
        recyclerView.setAdapter(adapter);
    }


}
