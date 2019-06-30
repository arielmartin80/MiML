package com.example.myml;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myml.API.API;
import com.example.myml.modelo.Articulo;
import com.example.myml.modelo.ResultadoBusqueda;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivity extends AppCompatActivity {

    @BindView (R.id.tv_resultado)
    TextView tv_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ButterKnife.bind(this);

        String dato = getIntent().getStringExtra("dato");
        tv_resultado.setText(dato);

        //resultados de la API
        API.searchArticulos(dato, new Callback<ResultadoBusqueda>() {

            @Override
            public void onResponse(Call<ResultadoBusqueda> call, Response<ResultadoBusqueda> response) {
                if(response.isSuccessful()) {
                    ResultadoBusqueda received = response.body();


                }
            }

            @Override
            public void onFailure(Call<ResultadoBusqueda> call, Throwable t) {
                tv_resultado.setText("item incorrecto");
            }

        });



    }

    //metodo para ir a la descripcion
    @OnClick(R.id.item1)
    public void IrADescripcion(View view){
        Intent i = new Intent(this, DescriptionActivity.class);
        i.putExtra("dato", tv_resultado.getText().toString());
        startActivity(i);
    }


}
