package com.example.myml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myml.API.API;
import com.example.myml.modelo.Articulo;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DescriptionActivity extends AppCompatActivity {

    @BindView(R.id.titulo) TextView titulo;
    @BindView(R.id.img) public ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        ButterKnife.bind(this);

        //final String id = getIntent().getStringExtra("dato");

        API.getArticle("MLA793622581", new Callback<Articulo>() {

            @Override
            public void onResponse(Call<Articulo> call, Response<Articulo> response) {
                if(response.isSuccessful()) {
                    Articulo received = response.body();
                    titulo.setText(received.getTitulo());
                    //titulo.setText(received.getFoto());

                    Picasso.with(getApplicationContext()).load(received.getFoto()).into(img);
                }
            }

            @Override
            public void onFailure(Call<Articulo> call, Throwable t) {
                    titulo.setText("item incorrecto");
            }

        });




    }


}
