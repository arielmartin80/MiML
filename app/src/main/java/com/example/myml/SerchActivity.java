package com.example.myml;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class SerchActivity extends AppCompatActivity {

    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        et1 = (EditText)findViewById(R.id.et_buscar);
    }

    //Metodo para el boton buscar
    public void Buscar(View view){
        Intent i = new Intent(this, ListActivity.class);
        i.putExtra("dato", et1.getText().toString());
        startActivity(i);
    }

}
