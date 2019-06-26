package com.example.myml;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.squareup.picasso.Picasso;


public class SerchActivity extends AppCompatActivity {

    //private EditText et1;

    @BindView(R.id.et_buscar)
    public EditText et1;

    @BindView(R.id.imageViewML)
    public ImageView imageViewML;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ButterKnife.bind(this);

        //et1 = (EditText)findViewById(R.id.et_buscar);

        Picasso.with(this).load("https://seeklogo.com/images/M/mercado-libre-logo-15D357DA7B-seeklogo.com.png").into(imageViewML);

    }

    //Metodo para el boton buscar
    public void Buscar(View view){
        Intent i = new Intent(this, ListActivity.class);
        i.putExtra("dato", et1.getText().toString());
        startActivity(i);
    }

}
