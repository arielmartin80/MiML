package com.example.myml;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {

    private TextView tv_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        tv_resultado = (TextView)findViewById(R.id.tv_resultado);

        String dato = getIntent().getStringExtra("dato");
        tv_resultado.setText(dato);

    }

    //metodo para ir a la descripcion
    public void IrADescripcion(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }


}
